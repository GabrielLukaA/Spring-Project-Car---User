package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_carro")
public class Carro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String placa;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    @OneToOne(mappedBy = "veiculo")
    private Seguro seguro;


    @Override
    public String toString(){
        return marca + " - " + modelo + "("+placa+")";
    }

}
