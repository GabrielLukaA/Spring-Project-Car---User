package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguroService.deletar(id);
    }


    @GetMapping("/{id}")
    public Seguro buscar( @PathVariable Integer id){
        return seguroService.buscar(id);
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
