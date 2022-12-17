package pe.com.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mg.model.ClienteEntity;
import pe.com.mg.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteservice;
    // @GetMapping sirve para obtener valores
    @GetMapping
    public List<ClienteEntity> findAll(){
        return clienteservice.findAll();
    }
    @GetMapping("/custom")
    public List<ClienteEntity>findAllCustom(){
        return clienteservice.findAllCustom();
    }

    @GetMapping("/{id}")
    public ClienteEntity findById(@PathVariable long id){
        return clienteservice.findById(id);
    }
    // @Postmapping permite enviar(registrar) valores
    @PostMapping
    public ClienteEntity add(@RequestBody ClienteEntity c){
        return clienteservice.add(c);
    }
    // @Putmapping permite actualizar
    @PutMapping("/{id}")
    public ClienteEntity update(@PathVariable Long id, @RequestBody ClienteEntity c){
        c.setCodigo(id);
        return clienteservice.update(c);
    }
    // @DeleteMapping permite eliminar
    @DeleteMapping("/{id}")
    public ClienteEntity delete(@PathVariable Long id){
        ClienteEntity objcliente = new ClienteEntity();
        objcliente.setEstado(false);
        return clienteservice.delete(ClienteEntity.builder().codigo(id).build());
    }
}
