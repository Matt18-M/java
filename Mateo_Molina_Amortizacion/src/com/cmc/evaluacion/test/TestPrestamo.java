package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.servicios.Banco;
import java.util.ArrayList;

public class TestPrestamo {
    public static void main(String[] args) {
        Banco banco = new Banco();
        
        // Registrar clientes
        Cliente cliente1 = new Cliente("1234567890", "Juan", "Perez");
        Cliente cliente2 = new Cliente("0987654321", "Maria", "Lopez");
        banco.registrarCliente(cliente1);
        banco.registrarCliente(cliente2);
        
        // Crear y asignar préstamos
        Prestamo prestamo1 = new Prestamo(4000, 12, 16, "1234567890");
        Prestamo prestamo2 = new Prestamo(50000, 10, 11, "1234567890");
        Prestamo prestamo3 = new Prestamo(2000, 8, 14, "0987654321");
        
        banco.asignarPrestamo("1234567890", prestamo1);
        banco.asignarPrestamo("1234567890", prestamo2);
        banco.asignarPrestamo("0987654321", prestamo3);
        
        // Mostrar información dinámicamente
        ArrayList<Prestamo> prestamosJuan = banco.buscarPrestamos("1234567890");
        for (Prestamo p : prestamosJuan) {
            System.out.println("Cliente: Juan Perez");
            p.mostrarPrestamo();
        }
        
        ArrayList<Prestamo> prestamosMaria = banco.buscarPrestamos("0987654321");
        for (Prestamo p : prestamosMaria) {
            System.out.println("Cliente: Maria Lopez");
            p.mostrarPrestamo();
        }
    }
}
