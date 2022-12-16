package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mg.model.CategoriaEntity;
import pe.com.mg.service.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaservicio;

    @GetMapping("/listarcategoria")
    public String PaginaListarCategoria(Model modelo){
        modelo.addAttribute("categorias", categoriaservicio.findAllCustom());
        return "listarcategoria";

    }
    @GetMapping("/registrocategoria")
    public String MostrarFormularioRegistro(){
        return "registrocategoria";
    }
    @ModelAttribute("categoria")
    public CategoriaEntity RegistroCategoria(){
        return new CategoriaEntity();
    }
    @PostMapping("/registrocategoria")
    public String RegistroCategoriaNueva(
            @ModelAttribute("categoria") CategoriaEntity c
    ){
        categoriaservicio.add(c);
        return "redirect:/listarcategoria?correcto";
    }

    @GetMapping("/actualizarcategoria/{id}")
    public String MostrarFormularioActualizar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("categorias", categoriaservicio.findById(id));
        return "actualizarcategoria";
    }
    @PostMapping("/actualizarcategoria/{id}")
    public String ActualizarCategoria(@PathVariable Long id, @ModelAttribute("categoria") CategoriaEntity c ){
        categoriaservicio.update(c);
        return "redirect:/listarcategoria?actualizo";
    }

    @GetMapping("/eliminarcategoria/{id}")
    public String EliminarCategoria(@PathVariable Long id, Model modelo){
        CategoriaEntity objcategoria = categoriaservicio.findById(id);
        categoriaservicio.delete(objcategoria);
        return "redirect:/listarcategoria?elimino";
    }
    @GetMapping("/habilitarcategoria")
    public String PaginaHabilitarCategoria(Model modelo){
        modelo.addAttribute("categorias", categoriaservicio.findAll());
        return "habilitarcategoria";
    }
    @GetMapping("/habilitarcategoria/{id}")
    public String HabilitarCategoria(@PathVariable Long id, Model modelo){
        CategoriaEntity objcategoria = categoriaservicio.findById(id);
        categoriaservicio.enable(objcategoria);
        return "redirect:/listarcategoria?habilito";
    }
}
