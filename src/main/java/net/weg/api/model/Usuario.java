package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String senha;

    private Integer idade;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne
    private Consorcio consorcio;

}
