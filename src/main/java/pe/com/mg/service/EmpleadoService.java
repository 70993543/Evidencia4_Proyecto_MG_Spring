package pe.com.mg.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pe.com.mg.dto.EmpleadoRegistroDTO;
import pe.com.mg.model.EmpleadoEntity;

import java.util.List;

public interface EmpleadoService extends UserDetailsService {
    EmpleadoEntity add(EmpleadoRegistroDTO e);

    List<EmpleadoEntity> findAll();
}

