package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(value = "id") Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {
        usuarioService.deletar(id);
    }


    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) {
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }


}
