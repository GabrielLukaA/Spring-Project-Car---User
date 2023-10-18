package net.weg.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Carro {

    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;


    public Carro(ResultSet resultSet) throws SQLException {
        this.ano = resultSet.getInt("ano");
        this.marca = resultSet.getString("marca");
        this.cor = resultSet.getString("cor");
        this.modelo = resultSet.getString("modelo");
        this.preco = resultSet.getDouble("preco");
        this.id = resultSet.getInt("id");
    }

    public Carro(int idCarro) {
        this.id = idCarro;
    }


}
