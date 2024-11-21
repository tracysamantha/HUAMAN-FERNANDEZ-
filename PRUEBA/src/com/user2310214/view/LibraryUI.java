/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user2310214.view;

import com.user2310214.service.GastoService;
import com.user2310214.model.Gastos;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author tracy
 */
public class LibraryUI extends JFrame{
private final GastoService gastoService;

    public LibraryUI(GastoService gastoService) {
        this.gastoService = gastoService;
        initUI();
    }

    private void initUI() {
        setTitle("Library Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña "Agregar gasto"
        tabbedPane.add("Add Expense", createAddBookPanel());

        // Pestaña "Buscar gasto"
        tabbedPane.add("Search Expense", createSearchBooksPanel());
        

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createAddBookPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Campos de entrada
        JTextField descriptionField = new JTextField();
        JTextField categoriaField = new JTextField();
        JTextField montoField = new JTextField();
        JTextField fechaField = new JTextField();

        // Botón para guardar
        JButton saveButton = new JButton("Save Expense");
        JLabel messageLabel = new JLabel("", JLabel.CENTER);

        saveButton.addActionListener(e -> {
            String descripcion = descriptionField.getText();
            String categoria = categoriaField.getText();
            String fecha = fechaField.getText();
             int monto;
            try {
                monto = Integer.parseInt(montoField.getText());
                gastoService.addGasto(descripcion, categoria, monto, fecha);
                messageLabel.setText("expense added successfully!");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Year must be a number!");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
            }
            
        });
      


        // Agregar componentes al panel
        panel.add(new JLabel("Description:"));
        panel.add(categoriaField);
        panel.add(new JLabel("categoria:"));
        panel.add(categoriaField);
        panel.add(new JLabel("monto:"));
        panel.add(montoField);
        panel.add(new JLabel("fecha:"));
        panel.add(fechaField);
        panel.add(saveButton);
        panel.add(messageLabel);

        return panel;
    }

    private JPanel createSearchBooksPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Campos de búsqueda
        JTextField searchField = new JTextField();
        JButton searchByTitleButton = new JButton("Search by Descripcion");
        JButton searchByAuthorButton = new JButton("Search by Categoria");

        // Área de resultados
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Acciones de los botones
        searchByTitleButton.addActionListener(e -> {
            String descripcion = searchField.getText();


            List<Gastos> gastos = gastoService.searchGastosByDescription(descripcion);
            displayBooks(resultArea, gastos);
        });

        searchByAuthorButton.addActionListener(e -> {
            String categoria = searchField.getText();
            List<Gastos> gastos = gastoService.searchGatosByCategoria(categoria);
            displayBooks(resultArea, gastos);
        });

        // Panel de entrada y botones
        JPanel inputPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        inputPanel.add(searchField);
        inputPanel.add(searchByTitleButton);
        inputPanel.add(searchByAuthorButton);

        // Agregar componentes al panel principal
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        return panel;
    }

    private void displayBooks(JTextArea resultArea, List<Gastos> gasto) {
        resultArea.setText("");
        if (gasto.isEmpty()) {
            resultArea.append("No books found.\n");
        } else {
            for (Gastos gastos : gasto) {
                resultArea.append(gastos.toString() + "\n");
            }
        }
    }
}
