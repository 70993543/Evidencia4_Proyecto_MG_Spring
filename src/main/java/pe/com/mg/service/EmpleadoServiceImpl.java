package pe.com.mg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.mg.dto.EmpleadoRegistroDTO;
import pe.com.mg.model.EmpleadoEntity;
import pe.com.mg.model.RolEntity;
import pe.com.mg.repository.EmpleadoRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;
    @Autowired
    private EmpleadoRepository empleadorepositorio;

    @Override
    public EmpleadoEntity add(EmpleadoRegistroDTO e) {
        EmpleadoEntity objempleado = new EmpleadoEntity();
        objempleado.setNombre(e.getNombre());
        objempleado.setApellido(e.getApellido());
        objempleado.setEmail(e.getEmail());
        objempleado.setClave(PasswordEncoder.encode(e.getClave()));
        objempleado.setRol(List.of(new RolEntity("ROLE_USER")));
        return empleadorepositorio.save(objempleado);
    }

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadorepositorio.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmpleadoEntity objempleado = empleadorepositorio.findByEmail(username);
        if (objempleado == null){
            throw new UsernameNotFoundException("Usuario o Clave no válido");

        }
        return new User(objempleado.getEmail(), objempleado.getClave(), mapearAutoridadRol(objempleado.getRol()));
    }
    public Collection<? extends GrantedAuthority> mapearAutoridadRol(Collection<RolEntity>roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}
