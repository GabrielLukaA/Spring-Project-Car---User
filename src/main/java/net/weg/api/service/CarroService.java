package net.weg.api.service;

import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Service
public class CarroService {

    public CarroService() {
        this.carroDAO = new CarroDAO();
    }

    private CarroDAO carroDAO = new CarroDAO();


    public Carro buscarCarro(Integer id) {
        return carroDAO.buscarUm(id);
    }


    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }


    public void deletarCarro(Integer id) {
        carroDAO.deletar(id);
    }


    public void inserirCarro(Carro carro) {
        carroDAO.inserir(carro);
    }


    public void atualizarCarro(Carro carro) {
        carroDAO.atualizar(carro);
    }

}
