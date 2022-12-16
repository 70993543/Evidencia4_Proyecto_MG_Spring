package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mg.model.ProductoEntity;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    @Query("select c from ProductoEntity c where c.estado=1"+" and c.nombre LIKE %?1%" + " or c.marca like %?1%" + " or c.categoria.nombre like %?1%" )
    List<ProductoEntity> findAllCustom(String palabraclave);
}

