package pe.com.mg.service;

import pe.com.mg.model.DistritoEntity;

import java.util.List;

public interface DistritoService {
    List<DistritoEntity> findAll();
    DistritoEntity findById(Long id);
    DistritoEntity add(DistritoEntity d);
    DistritoEntity update(DistritoEntity d);
    DistritoEntity delete(DistritoEntity d);
    List<DistritoEntity> findAllCustom(String palabraclave);
    DistritoEntity enable(DistritoEntity d);
}
