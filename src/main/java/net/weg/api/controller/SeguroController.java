package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;

    @DeleteMapping("/{seguroId}/{seguradoraId}")
    public void remover(@PathVariable Integer seguroId, @PathVariable Integer seguradoraId){
        seguroService.deletar(seguroId, seguradoraId);
    }


    @GetMapping("/{seguroId}/{seguradoraId}")
    public Seguro buscar( @PathVariable Integer seguroId, @PathVariable Integer seguradoraId){
        return seguroService.buscar(seguroId, seguradoraId);
    }

    @GetMapping
    public List<Seguro> buscar(){
        return seguroService.buscar();
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguro){
         seguroService.salvar(seguro);
    }

    @PutMapping
    public void atualizar(@RequestBody SeguroCadastroDTO seguro){
        seguroService.salvar(seguro);
    }

}
