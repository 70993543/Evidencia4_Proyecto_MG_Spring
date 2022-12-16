package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.mg.service.EmpleadoService;

@Controller
public class RegistroController {
    @Autowired
    EmpleadoService empleadoservicio;

    @GetMapping("/login")
    public String IniciarSesion(){
        return "login";
    }
    @GetMapping("/")
    public String PaginaInicio(){
        return "index";
    }
    @GetMapping("/listarempleado")
    public String PaginaListarEmpleado(Model modelo){
        modelo.addAttribute("empleados", empleadoservicio.findAll());
        return "listarempleado";
    }
}
