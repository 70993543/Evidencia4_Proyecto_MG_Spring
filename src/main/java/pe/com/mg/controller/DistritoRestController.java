package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mg.model.DistritoEntity;
import pe.com.mg.service.DistritoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {
    @Autowired
    private DistritoService distritoservice;

    @GetMapping
    public List<DistritoEntity> findAll(){
        return distritoservice.findAll();
    }
    @GetMapping("/custom")
    public List<DistritoEntity>findAllCustom(){
        return distritoservice.findAllCustom();
    }
    @GetMapping("/{id}")
    public DistritoEntity findById(@PathVariable long id){
        return distritoservice.findById(id);
    }
    // @Postmapping permite enviar(registrar) valores
    @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity c){
        return distritoservice.add(c);
    }
    // @Putmapping permite actualizar
    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable Long id, @RequestBody DistritoEntity c){
        c.setCodigo(id);
        return distritoservice.update(c);
    }
    // @DeleteMapping permite eliminar
    @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable Long id){
        DistritoEntity objcliente = new DistritoEntity();
        objcliente.setEstado(false);
        return distritoservice.delete(DistritoEntity.builder().codigo(id).build());
    }
}
