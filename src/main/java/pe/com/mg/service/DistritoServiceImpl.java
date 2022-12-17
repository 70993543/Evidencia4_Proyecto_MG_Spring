package pe.com.mg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mg.model.DistritoEntity;
import pe.com.mg.repository.DistritoRepository;


import java.util.List;


@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private DistritoRepository distritorepositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return distritorepositorio.findAll();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return distritorepositorio.findById(id).get();
    }

    @Override
    public DistritoEntity add(DistritoEntity d) {
        return distritorepositorio.save(d);
    }

    @Override
    public DistritoEntity update(DistritoEntity d) {
        DistritoEntity objdistrito = distritorepositorio.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objdistrito);
        return distritorepositorio.save(objdistrito);
    }


    @Override
    public DistritoEntity delete(DistritoEntity d) {
        DistritoEntity objdistrito = distritorepositorio.getById(d.getCodigo());
        objdistrito.setEstado(false);
        return distritorepositorio.save(objdistrito);
    }

    @Override
    public List<DistritoEntity> findAllCustom(String palabraclave) {
        if (palabraclave != null){
            return distritorepositorio.findAllCustom(palabraclave);
        }
        return distritorepositorio.findAllCustom(palabraclave);
    }

    @Override
    public DistritoEntity enable(DistritoEntity d) {
        DistritoEntity objdistrito = distritorepositorio.getById(d.getCodigo());
        objdistrito.setEstado(true);
        return distritorepositorio.save(objdistrito);
    }

}
