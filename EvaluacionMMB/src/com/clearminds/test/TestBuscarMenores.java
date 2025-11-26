package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;
import java.util.ArrayList;

public class TestBuscarMenores {
    public static void main(String[] args) {
        MaquinaDulces maquina = new MaquinaDulces();
        
        // Configurar celdas
        maquina.agregarCelda("A1");
        maquina.agregarCelda("A2");
        maquina.agregarCelda("B1");
        maquina.agregarCelda("B2");
        maquina.agregarCelda("C1");
        maquina.agregarCelda("C2");

        // Cargar productos
        Producto producto1 = new Producto("Papitas", 0.85, "KE34");
        Producto producto2 = new Producto("Doritos", 0.5, "DORT");
        Producto producto3 = new Producto("Jet", 0.25, "JT12");
        Producto producto4 = new Producto("DeTodito", 0.6, "DTDT");
        Producto producto5 = new Producto("Galletas", 2.5, "GLTS"); 
        Producto producto6 = new Producto("Chocolate", 3.0, "CHOC"); 

        maquina.cargarProducto(producto1, "A1", 5);
        maquina.cargarProducto(producto2, "A2", 5);
        maquina.cargarProducto(producto3, "B1", 5);
        maquina.cargarProducto(producto4, "B2", 5);
        maquina.cargarProducto(producto5, "C1", 5);
        maquina.cargarProducto(producto6, "C2", 5);

        // Buscar productos menores 
        ArrayList<Producto> productosMenores = maquina.buscarMenores(1.0);

       
        System.out.println("Productos Menores: " + productosMenores.size());
        for (Producto producto : productosMenores) {
            System.out.println("Nombre:" + producto.getNombre() + " Precio:" + producto.getPrecio());
        }
    }
}