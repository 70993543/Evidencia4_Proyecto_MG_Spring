package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mg.model.ProductoEntity;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    @Query("select c from ProductoEntity c where c.estado=1")
    List<ProductoEntity> findAllCustom();
}

