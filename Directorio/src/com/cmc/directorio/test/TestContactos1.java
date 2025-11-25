package com.cmc.directorio.test;
import com.cmc.directorio.entidades.*;

public class TestContactos1 {

	public static void main(String[] args) {
		
        Telefono telef1 = new Telefono("movi", "0991234567", 10);
        Contacto contacto1 = new Contacto("Jose", "García", telef1, 68.5);
         
        Telefono telef2 = new Telefono("movi", "0987654321", 20);
        Contacto contacto2 = new Contacto("Roberto", "Martínez", telef2, 75.2);
        
        // Crear objeto AdminContactos
        AdminContactos adminContactos = new AdminContactos();
        
        // Invocar al método buscarMasPesado
        System.out.println("=== CONTACTO MÁS PESADO ===");
        Contacto masPesado = adminContactos.buscarMasPesado(contacto1, contacto2);
        System.out.println("Datos del contacto más pesado:");
        System.out.println("Nombre: " + masPesado.getNombre());
        System.out.println("Apellido: " + masPesado.getApellido());
        System.out.println("Peso: " + masPesado.getPeso() + " kg");
        System.out.println("Operadora: " + masPesado.getTelefono().getOperadora());
        System.out.println("Número: " + masPesado.getTelefono().getNumero());
        System.out.println("Activo: " + masPesado.isActivo());
        
        // Invocar al método compararOperadoras
        System.out.println("=== COMPARACIÓN DE OPERADORAS ===");
        boolean mismaOperadora = adminContactos.compararOperadoras(contacto1, contacto2);
        System.out.println("Los contactos tienen la misma operadora: " + mismaOperadora);
        
      }

}
