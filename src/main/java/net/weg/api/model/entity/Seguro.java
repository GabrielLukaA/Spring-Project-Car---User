package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
@Table(name = "tb_plano")
@IdClass(SeguroIdClass.class)
public class Seguro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    private Integer id;


//    @EmbeddedId
//    private SeguroId id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
    @Id
    private Integer seguradoraId;


    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veiculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
