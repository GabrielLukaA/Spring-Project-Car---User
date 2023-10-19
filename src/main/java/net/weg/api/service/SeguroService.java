package net.weg.api.service;

import net.weg.api.model.Seguradora;
import net.weg.api.model.*;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(Seguro seguro) {
        seguroRepository.save(seguro);
    }

    public void deletar(Integer id) {
        seguroRepository.deleteById(id);
    }

    public Seguro buscar(Integer id) {
        return seguroRepository.findById(id).get();
    }

    public List<Seguro> buscar() {
        return seguroRepository.findAll();
    }
}
