package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;

import net.weg.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarUsuario(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
