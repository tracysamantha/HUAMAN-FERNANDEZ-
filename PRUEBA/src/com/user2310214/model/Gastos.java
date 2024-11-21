package com.user2310214.model;

import java.awt.print.Book;

public class Gastos {

    private int id;
    private String descripcion;
    private String categoria;
    private int monto;
    private String fecha;

    private Gastos(GastorBuilder builder) {
        this.id = builder.id;
        this.descripcion = builder.descripcion;
        this.categoria = builder.categoria;
        this.monto = builder.monto;
        this.fecha = builder.fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }




    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", descripcion='" + descripcion + '\''
                + ", categoria='" + categoria + '\'' + ", monto='" + monto + '\'' + ", fecha=" + fecha + '}';
    }



    public static class GastorBuilder {
        private int id;
        private String descripcion;
        private String categoria;
        private int monto;
        private String fecha;

        public GastorBuilder setId(int id) {
            this.id = id;
            return this;
        }
        

        public GastorBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public GastorBuilder setCategoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public GastorBuilder setMonto(int monto) {
            this.monto = monto;
            return this;
        }

        public GastorBuilder setFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Gastos build() {
            return new Gastos(this);
        }
    }
}