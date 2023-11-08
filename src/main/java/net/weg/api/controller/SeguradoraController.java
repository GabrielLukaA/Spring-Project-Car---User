package net.weg.api.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguradoraCadastroDTO;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }

    @GetMapping("/{id}")
    public Seguradora buscarUm( @PathVariable Integer id){
        return seguradoraService.buscarUm(id);
    }

    @GetMapping()
    public List<Seguradora> buscarTodos() {
        return seguradoraService.buscarTodos();
    }
    @PostMapping
    public void cadastrar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.cadastrar(seguradora);
    }

    @PutMapping
    public void editar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.editar(seguradora);
    }
}
