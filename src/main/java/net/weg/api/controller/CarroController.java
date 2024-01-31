package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarUm(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(carroService.buscarUm(id));
            // return new ResponseEntity<>(carroService.buscarUm(id),HttpStatus.OK);
            // return new ResponseEntity<>(carroService.buscarUm(id),200);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/s/{id}")
    public ResponseEntity< Collection<Carro>> buscarCarrosSeguradora(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity(carroService.buscarCarrosSeguradora(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/m")
    public ResponseEntity<Collection<Carro>> buscarCarrosSeguradora(@RequestParam String marca) {
        return new ResponseEntity<>(carroService.buscarCarrosMarca(marca), HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<Collection<Carro>> buscarTodos() {
        return new ResponseEntity<>(carroService.buscarTodos(), HttpStatus.OK);
    }

    @DeleteMapping
    public void deletarCarro(@RequestParam(value = "id") Integer id) {
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody CarroCadastroDTO carroDTO) {
        try {
           carroService.cadastrar(carroDTO);
            return new ResponseEntity( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping
    public ResponseEntity<Carro> editar(@RequestBody CarroEdicaoDTO carroDTO) {
        try {
            carroService.editar(carroDTO);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}