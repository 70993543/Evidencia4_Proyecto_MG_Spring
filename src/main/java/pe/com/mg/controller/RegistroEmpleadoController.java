package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.mg.dto.EmpleadoRegistroDTO;
import pe.com.mg.service.EmpleadoService;

@Controller
@RequestMapping("/registroempleado")
public class RegistroEmpleadoController {
    @Autowired
    private EmpleadoService empleadoservicio;

    @ModelAttribute("empleado")
    private EmpleadoRegistroDTO RegistroEmpleadoDTO(){
        return new EmpleadoRegistroDTO();
    }
    @GetMapping
    public String MostrarFormularioRegistro(){
        return "registroempleado";
    }
    @PostMapping
    public String RegistroEmpleadoNuevo(@ModelAttribute("empleado") EmpleadoRegistroDTO udto){
        empleadoservicio.add(udto);
        return "redirect:/registroempleado?correcto";
    }
}
