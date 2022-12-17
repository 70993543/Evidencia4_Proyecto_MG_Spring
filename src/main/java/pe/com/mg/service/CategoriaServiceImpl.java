package pe.com.mg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mg.model.CategoriaEntity;
import pe.com.mg.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriarepositorio;

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriarepositorio.findAll();
    }

    @Override
    public CategoriaEntity findById(Long id) {
        return categoriarepositorio.findById(id).get();
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return categoriarepositorio.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcategoria = categoriarepositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcategoria);
        return categoriarepositorio.save(objcategoria);
    }


    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
        CategoriaEntity objcategoria = categoriarepositorio.getById(c.getCodigo());
        objcategoria.setEstado(false);
        return categoriarepositorio.save(objcategoria);
    }

    @Override
    public List<CategoriaEntity> findAllCustom(String palabraclave) {
        if (palabraclave != null){
            return categoriarepositorio.findAllCustom(palabraclave);
        }
        return categoriarepositorio.findAllCustom(palabraclave);
    }

    @Override
    public CategoriaEntity enable(CategoriaEntity c) {
        CategoriaEntity objcategoria = categoriarepositorio.getById(c.getCodigo());
        objcategoria.setEstado(true);
        return categoriarepositorio.save(objcategoria);
    }

}
