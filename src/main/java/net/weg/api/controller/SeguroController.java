package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
