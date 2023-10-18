package net.weg.api.service;

import net.weg.api.model.Usuario;

import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private CarroService carroService;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAO();
        this.carroService = new CarroService();
    }

    public void inserir(Usuario usuario) {

        try {
            carroService.buscarCarro(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserirCarro(usuario.getCarro());
        } catch (NullPointerException ignore) {

        }

        usuarioDAO.inserir(usuario);
    }

    public void deletar(Integer id) {
        usuarioDAO.deletar(id);
    }

    public void atualizar(Usuario usuario) {
        try {
            carroService.buscarCarro(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserirCarro(usuario.getCarro());
        } catch (NullPointerException ignore) {

        }
        usuarioDAO.atualizar(usuario);
    }

    public Usuario buscarUsuario(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(new CarroService().buscarCarro(usuario.getCarro().getId()));
        } catch (NullPointerException ignore) {

        }
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (Usuario usuario : usuarios) {
            try {
                usuario.setCarro(new CarroService().buscarCarro(usuario.getCarro().getId()));
            } catch (NullPointerException ignore) {

            }

        }
        return usuarios;
    }
}
