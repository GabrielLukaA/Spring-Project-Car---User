package net.weg.api.repository;

import net.weg.api.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO extends DAOPadrao<Carro, Integer> {

    @Override
    public Carro converter(ResultSet resultSet) throws SQLException {
        return new Carro(resultSet);
    }

    public CarroDAO() {
        super("carro");
    }


    @Override
    public void inserir(Carro obj) {
        conectar();
        comandoSQL = "INSERT INTO carro values(?,?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getMarca());
            statement.setString(3, obj.getModelo());
            statement.setInt(4, obj.getAno());
            statement.setString(5, obj.getCor());
            statement.setDouble(6, obj.getPreco());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void atualizar(Carro obj) {
        conectar();
        comandoSQL = "UPDATE carro SET preco=?, modelo=?, marca=?, ano=?, cor=? where id=?";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setDouble(1, obj.getPreco());
            statement.setString(2, obj.getModelo());
            statement.setString(3, obj.getMarca());
            statement.setInt(4, obj.getAno());
            statement.setString(5, obj.getCor());
            statement.setInt(6, obj.getId());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
