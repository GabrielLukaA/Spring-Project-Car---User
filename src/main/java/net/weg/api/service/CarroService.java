package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.repository.CarroRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CarroService implements IService<Carro, Integer> {


    private CarroRepository carroRepository;


    public Carro buscarUm(Integer id) {

        return carroRepository.findById(id).get();
    }


    public Collection<Carro> buscarTodos() {
        return carroRepository.findAll();
    }
    public Collection<Carro> buscarCarrosSeguradora(Integer id) {
        return carroRepository.findBySeguro_Seguradora_Id(id);
    }

    public Collection<Carro> buscarCarrosMarca(String marca) {
        return carroRepository.findByMarca(marca);
    }


    public void deletar(Integer id) {
        carroRepository.deleteById(id);
    }


    public void cadastrar(IDTO dto) throws Exception {
        CarroCadastroDTO carroDTO = (CarroCadastroDTO) dto;
        if (carroRepository.existsByPlaca(carroDTO.getPlaca())) {
            throw  new Exception("Há um carro com a placa "+carroDTO.getPlaca()+" cadastrado.");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);

         carroRepository.save(carro);

    }

    public void editar(IDTO dto) throws Exception {
        CarroEdicaoDTO carroDTO = (CarroEdicaoDTO) dto;
        if (!carroRepository.existsById(carroDTO.getId())){
            throw new Exception("Não foi encontrado nenhum carro com o id"+carroDTO.getId());
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);
         carroRepository.save(carro);
    }



}
