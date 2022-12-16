package pe.com.mg.service;

import pe.com.mg.model.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> findAll();
    CategoriaEntity findById(Long id);
    CategoriaEntity add(CategoriaEntity c);
    CategoriaEntity update(CategoriaEntity c);
    CategoriaEntity delete(CategoriaEntity c);
    List<CategoriaEntity> findAllCustom();
    CategoriaEntity enable(CategoriaEntity c);
}

