package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mg.model.CategoriaEntity;
import pe.com.mg.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaservicio;

    @GetMapping
    public List<CategoriaEntity> findAll(){
        return categoriaservicio.findAll();
    }

    @GetMapping("/custom")
    public List<CategoriaEntity>findAllCustom(){
        return categoriaservicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public CategoriaEntity findById(@PathVariable long id){
        return categoriaservicio.findById(id);
    }

    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c){
        return categoriaservicio.add(c);
    }

    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c){
        c.setCodigo(id);
        return categoriaservicio.update(c);
    }

    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable Long id){
        CategoriaEntity objcliente = new CategoriaEntity();
        objcliente.setEstado(false);
        return categoriaservicio.delete(CategoriaEntity.builder().codigo(id).build());
    }
}
