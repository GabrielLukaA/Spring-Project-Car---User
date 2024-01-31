package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguroService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {


    private SeguroService seguroService;

    @DeleteMapping("/{seguroId}/{seguradoraId}")
    public void deletar(@PathVariable Integer seguroId, @PathVariable Integer seguradoraId){
        seguroService.deletar(new SeguroId(seguroId, seguradoraId));
    }


    @GetMapping("/{seguroId}/{seguradoraId}")
    public Seguro buscarUm( @PathVariable Integer seguroId, @PathVariable Integer seguradoraId){
        return seguroService.buscarUm(new SeguroId(seguroId, seguradoraId));
    }

    @GetMapping
    public List<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

    @PostMapping
    public void cadastrar(@RequestBody SeguroCadastroDTO seguro){
         seguroService.cadastrar(seguro);
    }

    @PutMapping
    public void editar(@RequestBody SeguroCadastroDTO seguro, @PathVariable Integer seguroId){
        ModelMapper mapper = new ModelMapper();
        Seguro seguroOld = seguroService.buscarUm(new SeguroId(seguroId, seguro.getSeguradora().getId()));
        mapper.map(seguro, seguroOld);
        seguroService.editar(seguro);
    }

}
