package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mg.model.ClienteEntity;
import pe.com.mg.model.DistritoEntity;
import pe.com.mg.model.ProductoEntity;
import pe.com.mg.service.ClienteService;
import pe.com.mg.service.DistritoService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteservicio;
    @Autowired
    private DistritoService distritoservicio;

    @GetMapping("/listarcliente")
    public String PaginaListarCliente(Model modelo, @Param("palabraclave") String palabraclave){
        modelo.addAttribute("palabraclave", palabraclave);
        modelo.addAttribute("clientes", clienteservicio.findAllCustom(palabraclave));
        return "listarcliente";
    }
    @GetMapping("/registrocliente")
    public String MostrarFormularioRegistro(Model modelo){
        modelo.addAttribute("distritos", distritoservicio.findAll());
        return "registrocliente";
    }
    @ModelAttribute("cliente")
    public ClienteEntity RegistroCliente(){
        return new ClienteEntity();
    }
    @PostMapping("/registrocliente")
    public String RegistroClienteNuevo(@ModelAttribute("cliente") ClienteEntity c){
        clienteservicio.add(c);
        return "redirect:/listarcliente?correcto";
    }
    @GetMapping("/actualizarcliente/{id}")
    public String MostrarFormularioActualizar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("distritos", distritoservicio.findAll());
        modelo.addAttribute("clientes", clienteservicio.findById(id));
        return "actualizarcliente";
    }
    @PostMapping("/actualizarcliente/{id}")
    public String ActualizarCliente(@PathVariable Long id, @ModelAttribute("distrito") ClienteEntity c){
        clienteservicio.update(c);
        return "redirect:/listarcliente?actualizo";
    }
    @GetMapping("/eliminarcliente/{id}")
    public String EliminarCliente(@PathVariable Long id, Model modelo){
        ClienteEntity objcliente = clienteservicio.findById(id);
        clienteservicio.delete(objcliente);
        return "redirect:/listarcliente?elimino";

    }
    @GetMapping("/habilitarcliente")
    public String PaginaHabilitarCliente(Model modelo){

        modelo.addAttribute("clientes", clienteservicio.findAll());
        return "habilitarcliente";
    }
    @GetMapping("/habilitarcliente/{id}")
    public String HabilitarCliente(@PathVariable Long id, Model modelo){
        ClienteEntity objcliente = clienteservicio.findById(id);
        clienteservicio.enable(objcliente);
        return "redirect:/listarcliente?habilito";
    }

}
