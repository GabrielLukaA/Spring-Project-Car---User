package net.weg.api.controller;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroService carroService = new CarroService();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Integer id) {
        return carroService.buscarCarro(id);
    }


    @GetMapping()
    public Collection<Carro> buscarTodos() {
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletarCarro(@RequestParam(value = "id") Integer id) {
        carroService.deletarCarro(id);
    }

    @PostMapping
    public void inserirCarro(@RequestBody Carro carro) {
        carroService.inserirCarro(carro);
    }

    @PutMapping
    public void atualizarCarro(@RequestBody Carro carro) {
        carroService.atualizarCarro(carro);
    }

}