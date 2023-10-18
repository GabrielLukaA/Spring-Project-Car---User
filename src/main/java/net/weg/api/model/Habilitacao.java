package net.weg.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_habilitacao")
public class Habilitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Long registro, cpf;
    private String orgaoEmissor;
}
