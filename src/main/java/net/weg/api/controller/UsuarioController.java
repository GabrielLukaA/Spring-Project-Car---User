package net.weg.api.controller;


import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import net.weg.api.repository.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(value = "id") Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable(value = "id") Integer id) {
        usuarioDAO.deletar(id);
    }


    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) {

        usuarioService.inserir(usuario);

    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }


}
