package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;


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
        usuarioService.salvar(usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
    }


}
