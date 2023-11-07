package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
@Table(name = "tb_plano")
//@IdClass(SeguroIdClass.class)
public class Seguro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    private Integer id;


    @EmbeddedId
    private SeguroId id = new SeguroId();

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer seguroId;
//    @Id
//    private Integer seguradoraId;


    private Double valor;
//    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
//    @JoinColumn(name = "seguradoraId")
    @MapsId("seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veiculoId")
    @EqualsAndHashCode.Exclude
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
