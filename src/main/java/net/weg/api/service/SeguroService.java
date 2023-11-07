package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(SeguroCadastroDTO seguroCadastroDTO){
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO, seguro);
        seguroRepository.save(seguro);
    }

    public void deletar(Integer seguroId, Integer seguradoraId) {

        seguroRepository.deleteById(new SeguroId(seguroId, seguradoraId));
    }

    public Seguro buscar(Integer seguroId, Integer seguradoraId) {
        return seguroRepository.findById(new SeguroId(seguroId, seguradoraId)).get();
    }

    public List<Seguro> buscar() {
        return seguroRepository.findAll();
    }
}
