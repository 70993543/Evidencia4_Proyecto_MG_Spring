package pe.com.mg.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import pe.com.mg.model.ClienteEntity;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ClienteExporterPDF {
    private List<ClienteEntity> listaClientes;

    public ClienteExporterPDF(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla){
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.black);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.white);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Apellido", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Telefono", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Sexo", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Dirección", fuente));
        tabla.addCell(celda);
    }
    private void escribirDatosDeLaTabla(PdfPTable tabla){
        for (ClienteEntity cliente: listaClientes){
            tabla.addCell(String.valueOf(cliente.getCodigo()));
            tabla.addCell(cliente.getNombre());
            tabla.addCell(cliente.getApellido());
            tabla.addCell(cliente.getCelular());
            tabla.addCell(cliente.getSexo());
            tabla.addCell(cliente.getDireccion());
        }
    }
    public void exportar(HttpServletResponse response) throws IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.black);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Clientes", fuente );
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(6);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] {1f, 2.3f, 4f,2.9f, 3.5f, 4f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
