package pe.com.mg.service;

import pe.com.mg.model.ClienteEntity;

import java.util.List;

public interface ClienteService {
    List<ClienteEntity> findAll();
    ClienteEntity findById(Long id);
    ClienteEntity add(ClienteEntity c);
    ClienteEntity update(ClienteEntity c);
    ClienteEntity delete(ClienteEntity c);
    List<ClienteEntity> findAllCustom(String palabraclave);
    ClienteEntity enable(ClienteEntity c);
}

