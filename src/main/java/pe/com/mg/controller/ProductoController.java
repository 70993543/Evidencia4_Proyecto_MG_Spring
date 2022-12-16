package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.mg.model.ProductoEntity;
import pe.com.mg.service.CategoriaService;
import pe.com.mg.service.ProductoService;
import pe.com.mg.util.PageRender;

import java.awt.print.Pageable;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoservicio;

    @Autowired
    private CategoriaService categoriaservicio;

    @GetMapping("/listarproducto")
    public String PaginaListarProducto(Model modelo, @Param("palabraclave") String palabraclave){
        modelo.addAttribute("palabraclave", palabraclave);
        modelo.addAttribute("productos", productoservicio.findAllCustom(palabraclave));
        return "listarproducto";

    }

    @GetMapping("/registroproducto")
    public String MostrarFormularioRegistro(Model modelo){
        modelo.addAttribute("categorias", categoriaservicio.findAll());
        return "registroproducto";
    }

    @ModelAttribute("producto")
    public ProductoEntity RegistroProducto(){
        return new ProductoEntity();
    }

    @PostMapping("/registroproducto")
    public String RegistroProductoNuevo(@ModelAttribute("producto") ProductoEntity p){
        productoservicio.add(p);
        return "redirect:/listarproducto?correcto";
    }

    @GetMapping("/actualizarproducto/{id}")
    public String MostrarFormularioActualizar(@PathVariable long id, Model modelo){
        modelo.addAttribute("categorias", categoriaservicio.findAll());
        modelo.addAttribute("productos", productoservicio.findById(id));
        return "actualizarproducto";
    }
    @PostMapping("/actualizarproducto/{id}")
    public String ActualizarProducto(@PathVariable Long id, @ModelAttribute("producto")ProductoEntity p){
        productoservicio.update(p);
        return "redirect:/listarproducto?actualizo";
    }
    @GetMapping("/eliminarproducto/{id}")
    public String EliminarProducto(@PathVariable Long id, Model modelo){
        ProductoEntity objproducto = productoservicio.findById(id);
        productoservicio.delete(objproducto);
        return "redirect:/listarproducto?elimino";
    }
    @GetMapping("/habilitarproducto")
    public String PaginaHabilitarProducto(Model modelo){
        modelo.addAttribute("productos", productoservicio.findAll());
        return "habilitarproducto";
    }
    @GetMapping("/habilitarproducto/{id}")
    public String HabilitarProducto(@PathVariable Long id, Model modelo){
        ProductoEntity objproducto = productoservicio.findById(id);
        productoservicio.enable(objproducto);
        return "redirect:/listarproducto?habilito";
    }

}
