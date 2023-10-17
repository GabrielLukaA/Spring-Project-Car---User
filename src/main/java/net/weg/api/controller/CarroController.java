package net.weg.api.controller;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroDAO carroDAO = new CarroDAO();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Integer id) {
        return carroDAO.buscarUm(id);
    }


    @GetMapping()
    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarCarro(@PathVariable(value = "id") Integer id) {
        carroDAO.deletar(id);
    }

    @PostMapping
    public void inserirCarro(@RequestBody Carro carro) {
        carroDAO.inserir(carro);
    }

    @PutMapping
    public void atualizarCarro(@RequestBody Carro carro) {
        carroDAO.atualizar(carro);
    }

}