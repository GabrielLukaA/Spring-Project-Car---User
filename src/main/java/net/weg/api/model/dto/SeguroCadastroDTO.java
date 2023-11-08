package net.weg.api.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;

@Data
@AllArgsConstructor
public class SeguroCadastroDTO implements IDTO {

    private Double valor;
//    private String nome;
    private String descricao;
    private Double valorFranquia;

    private Seguradora seguradora;

    private Carro veiculo;

    private Cliente cliente;
}
