/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.user2310214.controller;
import com.user2310214.model.Gastos; 
import com.user2310214.repository.GastoRepository; 
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author tracy
 */
public class Main {
 public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/gastos_personales";
        String user = "root";
        String password = "Tracy997570268";

        GastoRepository repository = new GastoRepository(url, user, password);

        // Crear y guardar gasto
        Gastos gasto1 = new Gastos.GastorBuilder()
                .setDescripcion("Comida de la semana")
                .setCategoria("Alimentos")
                .setMonto(200)
                .setFecha("12/03/24")
                .build();

             Gastos gasto2 = new Gastos.GastorBuilder()
                .setDescripcion("Accidente de Tommy")
                .setCategoria("Salud")
                .setMonto(300)
                .setFecha("12/03/24")
                .build();

//        repository.save(book1);
//        repository.save(book2);
        
        // Eliminar el registro 
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingresa gasto a eliminar: ");
            int id = scanner.nextInt();  
            repository.delete(id);
            System.out.println("Libro Eliminado...");
            } catch (Exception e) {
                System.out.print("Error al eliminar el Libro.");
            }


        // Consultar libros
        System.out.println("gastos by categoria 'Salud':");
        List<Gastos> findByCategoria = repository.findByCategoria("Salud");
        findByCategoria.forEach(System.out::println);

        System.out.println("Gastos with description containing 'Comida de la semana':");
        List<Gastos> booksByTitle = repository.findByDescription("Comida de la semana");
        booksByTitle.forEach(System.out::println);
    }
}