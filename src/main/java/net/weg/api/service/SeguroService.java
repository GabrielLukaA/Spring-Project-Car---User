package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService implements IService<Seguro, SeguroId>  {
    private SeguroRepository seguroRepository ;

    public void cadastrar(IDTO dto){
        SeguroCadastroDTO seguroCadastroDTO = (SeguroCadastroDTO) dto;
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO, seguro);
        seguroRepository.save(seguro);
    }

    public void editar(IDTO dto){
        SeguroCadastroDTO seguroCadastroDTO = (SeguroCadastroDTO) dto;
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO, seguro);
        seguroRepository.save(seguro);
    }

    public void deletar(SeguroId id) {

        seguroRepository.deleteById(id);
    }

    public Seguro buscarUm(SeguroId id) {
        return seguroRepository.findById(id).get();
    }

    public List<Seguro> buscarTodos() {
        return seguroRepository.findAll();
    }
}
