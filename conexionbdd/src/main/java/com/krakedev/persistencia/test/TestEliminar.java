package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestEliminar {
    public static void main(String[] args) {
        try {
            // Cédula de la persona a eliminar
            String cedulaAEliminar = "0150560813";
            
            System.out.println("Intentando eliminar persona con cédula: " + cedulaAEliminar);
            
            // Llamar al método eliminar
            AdminPersonas.eliminar(cedulaAEliminar);
            
            System.out.println("Operación de eliminación completada");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}