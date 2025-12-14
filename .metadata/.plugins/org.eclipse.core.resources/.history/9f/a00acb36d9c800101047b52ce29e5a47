package com.cmc.repaso.entidades;

public class Item {
    private String nombre;
    private int productosActuales;
    private int productosDevueltos;
    private int productosVendidos;
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProductosActuales() {
        return productosActuales;
    }

    public void setProductosActuales(int productosActuales) {
        this.productosActuales = productosActuales;
    }

    public int getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(int productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }

    public int getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(int productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    // Método vender
    public void vender(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor a 0");
            return;
        }
        
        if (cantidad > this.productosActuales) {
            System.out.println("Error: No hay suficientes productos en stock. Stock actual: " + this.productosActuales);
            return;
        }
        
        this.productosActuales -= cantidad;
        this.productosVendidos += cantidad;
        System.out.println("Vendidos: " + cantidad + " " + this.nombre);
    }

    // Método devolver
    public void devolver(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor a 0");
            return;
        }
        
        if (cantidad > this.productosVendidos) {
            System.out.println("Error: No se pueden devolver más productos de los vendidos. Vendidos: " + this.productosVendidos);
            return;
        }
        
        this.productosActuales += cantidad;
        this.productosVendidos -= cantidad;
        this.productosDevueltos += cantidad;
        System.out.println("Devueltos: " + cantidad + " " + this.nombre);
    }

    // Método imprimir
    public void imprimir() {
        System.out.println("=================Información del Producto=============");
        System.out.println("Nombre del Producto: " + getNombre());
        System.out.println("Productos actuales: " + getProductosActuales());
        System.out.println("Productos Devueltos: " + getProductosDevueltos());
        System.out.println("Productos Vendidos: " + getProductosVendidos());
        System.out.println("======================================================");
    }
}