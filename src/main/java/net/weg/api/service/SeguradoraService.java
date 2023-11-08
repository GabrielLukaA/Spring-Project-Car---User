package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.view.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguradoraService implements IService<Seguradora, Integer> {
    private SeguradoraRepository seguradoraRepository;
    public void cadastrar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    public void cadastrar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }
    public void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }
    public Seguradora buscar(Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public List<Seguradora> buscar(){
        return seguradoraRepository.findAll();
    }

}
