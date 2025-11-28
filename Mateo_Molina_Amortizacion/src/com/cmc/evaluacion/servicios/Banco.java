package com.cmc.evaluacion.servicios;

import java.util.ArrayList;
import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Cliente> clientes;
    
    // Constructor
    public Banco() {
        this.prestamos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    // Getters
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    // Método buscarCliente
    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }
    
    // Método registrarCliente
    public void registrarCliente(Cliente cliente) {
        Cliente clienteExistente = buscarCliente(cliente.getCedula());
        
        if (clienteExistente == null) {
            clientes.add(cliente);
            System.out.println("Cliente registrado: " + cliente.getNombre() + " " + cliente.getApellido() + 
                              " [cedula=" + cliente.getCedula() + ", nombre=" + cliente.getNombre() + 
                              ", apellido=" + cliente.getApellido() + "]");
        } else {
            System.out.println("Cliente ya existe: " + cliente.getCedula());
        }
    }
   
    
    //Método asignarPrestamo
    public void asignarPrestamo(String cedula, Prestamo prestamo) {
        // 1) Validar si el cliente existe
        Cliente cliente = buscarCliente(cedula);
        
        if (cliente == null) {
            System.out.println("No es cliente del banco");
            return;
        }
        
        // El cliente existe, crear la tabla de amortización
        CalculadoraAmortizacion.generarTabla(prestamo);
        
      
        prestamos.add(prestamo);
         }
    
    //Método buscarPrestamos
    public ArrayList<Prestamo> buscarPrestamos(String cedula) {
        Cliente cliente = buscarCliente(cedula);
        
        if (cliente == null) {
            return new ArrayList<>();
        }
        
        ArrayList<Prestamo> prestamosCliente = new ArrayList<>();
        
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCedulaCliente() != null && prestamo.getCedulaCliente().equals(cedula)) {
                prestamosCliente.add(prestamo);
            }
        }
        
        return prestamosCliente;
    }
}