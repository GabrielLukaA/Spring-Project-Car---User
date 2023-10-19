package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_plano")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    private Seguradora seguradora;
    @OneToOne
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
