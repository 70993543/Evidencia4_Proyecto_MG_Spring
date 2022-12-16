package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mg.model.CategoriaEntity;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    @Query("select c from CategoriaEntiry c where c.estado=1")
    List<CategoriaEntity> findAllCustom();
}
