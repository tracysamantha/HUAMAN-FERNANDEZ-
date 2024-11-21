/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user2310214.repository;
import java.sql.*;
import com.user2310214.model.Gastos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tracy
 */
public class GastoRepository {
    private final String url;
    private final String user;
    private final String password;

    public GastoRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void save(Gastos gastos) {
        String sql = "INSERT INTO books (descripcion, categoria, monto, fecha) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gastos.getDescripcion());
            statement.setString(2, gastos.getCategoria());
            statement.setInt(3, gastos.getMonto());
            statement.setString(4, gastos.getFecha());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving expense", e);
        }
    }

    
    public List<Gastos> findByDescription( String descripcion) {
        List<Gastos> gastos = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                gastos.add(new Gastos.GastorBuilder()
                        .setId(resultSet.getInt("id"))
                        .setDescripcion(resultSet.getString("description"))
                        .setCategoria(resultSet.getString("author"))
                        .setMonto(resultSet.getInt("monto"))
                        .setFecha(resultSet.getString("fecha"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving books", e);
        }
        return gastos;
    }
    
    public List<Gastos> findByCategoria( String categoria) {
        List<Gastos> gastos = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                gastos.add(new Gastos.GastorBuilder()
                        .setId(resultSet.getInt("id"))
                        .setDescripcion(resultSet.getString("descripcion"))
                        .setCategoria(resultSet.getString("categoria"))
                        .setMonto(resultSet.getInt("monto"))
                        .setFecha(resultSet.getString("fecha"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving books", e);
        }
        return gastos;
    }
            
    public List<Gastos> findAll() {
        List<Gastos> gastos = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                gastos.add(new Gastos.GastorBuilder()
                        .setId(resultSet.getInt("id"))
                        .setDescripcion(resultSet.getString("descripcion"))
                        .setCategoria(resultSet.getString("categoria"))
                        .setMonto(resultSet.getInt("monto"))
                        .setFecha(resultSet.getString("fecha"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving expenses", e);
        }
        return gastos;
    }

    public void update(Gastos gastos) {
        String sql = "UPDATE expenses SET description = ?, category = ?, monto = ?, date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gastos.getDescripcion());
            statement.setString(2, gastos.getCategoria());
            statement.setInt(3, gastos.getMonto());
            statement.setString(4, gastos.getFecha());
            statement.setInt(5, gastos.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating expenses", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting expenses", e);
        }
    }
}