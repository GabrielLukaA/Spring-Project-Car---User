package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;

import net.weg.api.repository.ClienteRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ClienteService implements IService<Cliente, Integer> {

    private ClienteRepository clienteRepository;

    public void cadastrar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        clienteRepository.save(cliente);
    }

    public void editar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        clienteRepository.save(cliente);
    }


    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarUm(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
