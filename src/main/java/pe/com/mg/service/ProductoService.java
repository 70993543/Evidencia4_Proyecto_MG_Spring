package pe.com.mg.service;

import pe.com.mg.model.ProductoEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductoService {
    List<ProductoEntity> findAll();
    ProductoEntity findById(Long id);
    ProductoEntity add(ProductoEntity p);
    ProductoEntity update(ProductoEntity p);
    ProductoEntity delete(ProductoEntity p);
    List<ProductoEntity> findAllCustom(String palaabraclave);
    ProductoEntity enable(ProductoEntity p);
}
