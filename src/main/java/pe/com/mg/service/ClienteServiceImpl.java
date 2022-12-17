package pe.com.mg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mg.model.ClienteEntity;
import pe.com.mg.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienterepositorio;

    @Override
    public List<ClienteEntity> findAll() {
        return clienterepositorio.findAll();
    }

    @Override
    public ClienteEntity findById(Long id) {
        return clienterepositorio.findById(id).get();
    }

    @Override
    public ClienteEntity add(ClienteEntity c) {
        return clienterepositorio.save(c);
    }

    @Override
    public ClienteEntity update(ClienteEntity c) {
        ClienteEntity objcliente = clienterepositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcliente);
        return clienterepositorio.save(objcliente);
    }

    @Override
    public ClienteEntity delete(ClienteEntity c) {
        ClienteEntity objcliente = clienterepositorio.getById(c.getCodigo());
        objcliente.setEstado(false);
        return clienterepositorio.save(objcliente);
    }

    @Override
    public List<ClienteEntity> findAllCustom(String palabraclave) {
        if (palabraclave != null){
            return clienterepositorio.findAllCustom(palabraclave);
        }
        return clienterepositorio.findAllCustom(palabraclave);
    }

    @Override
    public ClienteEntity enable(ClienteEntity c) {
        ClienteEntity objcliente = clienterepositorio.getById(c.getCodigo());
        objcliente.setEstado(true);
        return clienterepositorio.save(objcliente);
    }
}
