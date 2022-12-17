package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pe.com.mg.model.ProductoEntity;
import pe.com.mg.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
    @Autowired
    private ProductoService productoservice;

    @GetMapping
    public List<ProductoEntity> findAll(){
        return productoservice.findAll();
    }
    @GetMapping("/custom")
    public List<ProductoEntity>findAllCustom(){
        return productoservice.findAllCustom(null);
    }
    @GetMapping("/{id}")
    public ProductoEntity findById(@PathVariable long id){
        return productoservice.findById(id);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p){
        return productoservice.add(p);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity c){
        c.setCodigo(id);
        return productoservice.update(c);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable Long id){
        ProductoEntity objcliente = new ProductoEntity();
        objcliente.setEstado(false);
        return productoservice.delete(ProductoEntity.builder().codigo(id).build());
    }
}
