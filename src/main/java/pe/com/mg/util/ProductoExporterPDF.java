package pe.com.mg.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import pe.com.mg.model.ProductoEntity;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ProductoExporterPDF {
    private List<ProductoEntity> listaProductos;

    public ProductoExporterPDF(List<ProductoEntity> listaProductos) {
        this.listaProductos = listaProductos;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla){
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.black);
        celda.setPadding(5);

        com.lowagie.text.Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.white);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Marca", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Precio", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Categoria", fuente));
        tabla.addCell(celda);
    }
    private void escribirDatosDeLaTabla(PdfPTable tabla){
        for (ProductoEntity producto: listaProductos){
            tabla.addCell(String.valueOf(producto.getCodigo()));
            tabla.addCell(producto.getNombre());
            tabla.addCell(producto.getMarca());
            tabla.addCell(String.valueOf(producto.getPrecio()));
            tabla.addCell(producto.getCategoria().getNombre());
        }
    }
    public void exportar(HttpServletResponse response) throws IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.black);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Productos", fuente );
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] {1f, 2.3f, 4f,2.9f, 4f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
