package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;


    @GetMapping("/{id}")
    public Cliente buscarUm(@PathVariable(value = "id") Integer id) {
        return clienteService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id) {
        clienteService.deletar(id);
    }


    @PostMapping
    public void cadastrar(@RequestBody UsuarioCadastroDTO cliente) {
        clienteService.cadastrar(cliente);
    }

    @PutMapping
    public void editar(@RequestBody UsuarioCadastroDTO cliente) {
        clienteService.editar(cliente);
    }


}
