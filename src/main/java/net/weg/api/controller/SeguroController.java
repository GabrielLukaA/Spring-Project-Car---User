package net.weg.api.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    private SeguradoraService seguradoraService;

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }


    @GetMapping("/{id}")
    public Seguradora buscar( @PathVariable Integer id){
        return seguradoraService.buscar(id);
    }

    @GetMapping
    public List<Seguradora> buscar(){
        return seguradoraService.buscar();
    }

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
         seguradoraService.salvar(seguradora);
    }

    @PutMapping
    public void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

}
