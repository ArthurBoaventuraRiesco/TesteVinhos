package org.example.demo.dao;

import org.example.demo.config.ConnectionFactory;
import org.example.demo.model.Vinho;

import java.sql.*;

public class VinhoDAO implements iVinhoDAO {

    @Override
    public Vinho create(Vinho vinho) {
        try (Connection connection
                     = ConnectionFactory.getConnection()) {

            String query = "INSERT INTO vinhos " +
                    "(nome, tipo, safra, preco)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement ps =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vinho.getNome());
            ps.setString(2, vinho.getTipo());
            ps.setInt(3, vinho.getSafra());
            ps.setInt(4, (int) vinho.getPreco());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                vinho.setId((long) id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vinho;
    }
}