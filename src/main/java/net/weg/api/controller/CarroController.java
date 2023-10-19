package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Integer id) {
        return carroService.buscarUm(id);
    }


    @GetMapping()
    public Collection<Carro> buscarTodos() {
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletarCarro(@RequestParam(value = "id") Integer id) {
        carroService.deletar(id);
    }

    @PostMapping
    public void inserirCarro(@RequestBody Carro carro) {
        carroService.salvar(carro);
    }

    @PutMapping
    public void atualizarCarro(@RequestBody Carro carro) {
        carroService.salvar(carro);
    }

}