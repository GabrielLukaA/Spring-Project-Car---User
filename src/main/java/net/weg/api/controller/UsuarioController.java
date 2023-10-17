package net.weg.api.controller;


import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import net.weg.api.repository.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private CarroDAO carroDAO = new CarroDAO();

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(value = "id") Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(new CarroDAO().buscarUm(usuario.getCarro().getId()));
        } catch (NullPointerException ignore) {

        }

        return usuario;
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (Usuario usuario:usuarios) {
            try {
                usuario.setCarro(new CarroDAO().buscarUm(usuario.getCarro().getId()));
            } catch (NullPointerException ignore) {

            }

        }
        return usuarios;
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable(value = "id") Integer id) {
        usuarioDAO.deletar(id);
    }


    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) {
        try {
            carroDAO.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroDAO.inserir(usuario.getCarro());
        } catch (NullPointerException ignore) {

        }

        usuarioDAO.inserir(usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }


}
