package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mg.model.DistritoEntity;

import java.util.List;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {
    @Query("select d from DistritoEntity d where d.estado=1")
    List<DistritoEntity>findAllCustom();
}

