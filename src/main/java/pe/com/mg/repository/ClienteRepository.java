package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mg.model.ClienteEntity;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    @Query("select c from ClienteEntity c where c.estado=1"+" and c.nombre LIKE %?1%" + " or c.apellido like %?1%" + " or c.distrito.nombre like %?1%")
    List<ClienteEntity> findAllCustom(String palabraclave);
}

