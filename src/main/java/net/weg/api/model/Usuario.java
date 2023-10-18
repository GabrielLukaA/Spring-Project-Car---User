package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Getter
//@Setter
//@ToString


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        this.idade = resultSet.getInt("idade");
        int idCarro = resultSet.getInt("id_carro");
        if (idCarro != 0) {
            this.carro = new Carro(idCarro);
        }
    }

}
