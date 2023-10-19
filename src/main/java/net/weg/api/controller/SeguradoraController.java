package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }

    @GetMapping
    public Seguradora buscar(Integer id){
        return seguradoraService.buscar(id);
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
