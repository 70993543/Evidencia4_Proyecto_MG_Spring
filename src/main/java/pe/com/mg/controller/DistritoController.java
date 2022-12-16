package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mg.model.DistritoEntity;
import pe.com.mg.service.DistritoService;

@Controller
public class DistritoController {

    @Autowired
    private DistritoService distritoservicio;

    @GetMapping("/listardistrito")
    public String PaginaListarDistrito(Model modelo){
        modelo.addAttribute("distritos", distritoservicio.findAllCustom());
        return "listardistrito";
    }
    @GetMapping("/registrodistrito")
    public String MostrarFormularioRegistro(){
        return "registrodistrito";
    }
    @ModelAttribute("distrito")
    public DistritoEntity RegistroDistrito(){
        return new DistritoEntity();
    }
    @PostMapping("/registrodistrito")
    public String RegistroDistritoNuevo(
            @ModelAttribute("distrito") DistritoEntity d
    ){
        distritoservicio.add(d);
        return "redirect:/listardistrito?correcto";
    }
    @GetMapping("/actualizardistrito/{id}")
    public String MostrarFormularioActualizar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("distritos", distritoservicio.findById(id));
        return "actualizardistrito";
    }
    @PostMapping("/actualizardistrito/{id}")
    public String ActualizarDistrito(@PathVariable Long id, @ModelAttribute("distrito") DistritoEntity d){
        distritoservicio.update(d);
        return "redirect:/listardistrito?actualizo";
    }
    @GetMapping("/eliminardistrito/{id}")
    public String EliminarDistrito(@PathVariable Long id, Model modelo){
        DistritoEntity objdistrito = distritoservicio.findById(id);
        distritoservicio.delete(objdistrito);
        return "redirect:/listardistrito?elimino";
    }
    @GetMapping("/habilitardistrito")
    public String PaginaHabilitarDistrito(Model modelo){
        modelo.addAttribute("distritos", distritoservicio.findAll());
        return "habilitardistrito";
    }
    @GetMapping("/habilitardistrito/{id}")
    public String HabilitarDistrito(@PathVariable Long id, Model modelo){
        DistritoEntity objdistrito = distritoservicio.findById(id);
        distritoservicio.enable(objdistrito);
        return "redirect:/listardistrito?habilito";
    }

}
