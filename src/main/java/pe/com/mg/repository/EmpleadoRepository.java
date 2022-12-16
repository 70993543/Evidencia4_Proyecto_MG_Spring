package pe.com.mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.mg.model.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
    public EmpleadoEntity findByEmail(String email);
}

