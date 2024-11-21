/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user2310214.service;

import com.user2310214.repository.GastoRepository;
import com.user2310214.model.Gastos;
import java.util.List;
/**
 *
 * @author tracy
 */
public class GastoService {
    private final GastoRepository gastoRepository;

    public GastoService(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    public void addGasto(String descripcion, String categoria, int monto, String fecha) {
        Gastos gastos = new Gastos.GastorBuilder()
                .setDescripcion(descripcion)
                .setCategoria(categoria)
                .setMonto(monto)
                .setFecha(fecha)
                .build();
        gastoRepository.save(gastos);
    }

    
    public List<Gastos> getAllGastos() {
        return gastoRepository.findAll();
    }
        
        
    public List<Gastos> searchGastosByDescription(String descripcion ) {
        return gastoRepository.findByDescription(descripcion);
    }
    public List<Gastos> searchGatosByCategoria(String categoria) {
        return gastoRepository.findByCategoria(categoria);
    }

    public void updateGastos(int id, String descripcion, String categoria, int monto, String fecha) {
        Gastos updatedGasto = new Gastos.GastorBuilder()
              //  .setId(id)
                //.setDescripcion(descripcion)
                .setCategoria(categoria)
                .setMonto(monto)
                .setFecha(fecha)
                .build();
        gastoRepository.update(updatedGasto);
    }

    public void deleteGasto(int id ) {
        gastoRepository.delete(id);
    }
}

 