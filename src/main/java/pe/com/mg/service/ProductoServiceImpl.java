package pe.com.mg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mg.model.ProductoEntity;
import pe.com.mg.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productorepositorio;

    @Override
    public List<ProductoEntity> findAll() {
        return productorepositorio.findAll();
    }

    @Override
    public ProductoEntity findById(Long id) {
        return productorepositorio.findById(id).get();
    }

    @Override
    public ProductoEntity add(ProductoEntity p) {
        return productorepositorio.save(p);
    }

    @Override
    public ProductoEntity update(ProductoEntity p) {
        ProductoEntity objproducto = productorepositorio.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objproducto);
        return productorepositorio.save(objproducto);
    }

    @Override
    public ProductoEntity delete(ProductoEntity p) {
        ProductoEntity objproducto = productorepositorio.getById(p.getCodigo());
        objproducto.setEstado(false);
        return productorepositorio.save(objproducto);
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return productorepositorio.findAllCustom();
    }

    @Override
    public ProductoEntity enable(ProductoEntity p) {
        ProductoEntity objproducto = productorepositorio.getById(p.getCodigo());
        objproducto.setEstado(true);
        return productorepositorio.save(objproducto);
    }
}
