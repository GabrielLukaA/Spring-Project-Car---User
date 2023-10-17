package net.weg.api.service;

import net.weg.api.controller.UsuarioController;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private CarroDAO carroDAO;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAO();
        this.carroDAO = new CarroDAO();
    }

    public void inserir(Usuario usuario) {

        try {
            carroDAO.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroDAO.inserir(usuario.getCarro());
        } catch (NullPointerException ignore) {

        }

        usuarioDAO.inserir(usuario);
    }

    public Usuario buscarUsuario(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(new CarroDAO().buscarUm(usuario.getCarro().getId()));
        } catch (NullPointerException ignore) {

        }
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (Usuario usuario : usuarios) {
            try {
                usuario.setCarro(new CarroDAO().buscarUm(usuario.getCarro().getId()));
            } catch (NullPointerException ignore) {

            }

        }
        return usuarios;
    }
}
