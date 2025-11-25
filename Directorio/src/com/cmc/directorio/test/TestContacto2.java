package com.cmc.directorio.test;
import com.cmc.directorio.entidades.*;

public class TestContacto2 {

	public static void main(String[] args) {
		
        Telefono telef1 = new Telefono("claro", "0991111111", 15);
        Contacto contacto1 = new Contacto("María", "Fernández", telef1, 55.8);
        
        Telefono telef2 = new Telefono("movi", "0982222222", 25);
        Contacto contacto2 = new Contacto("Carlos", "López", telef2, 82.3);
        
        AdminContactos adminContactos = new AdminContactos();
        
        System.out.println("=== CONTACTO MÁS PESADO ===");
        Contacto masPesado = adminContactos.buscarMasPesado(contacto1, contacto2);
        System.out.println("Datos del contacto más pesado:");
        System.out.println("Nombre: " + masPesado.getNombre());
        System.out.println("Apellido: " + masPesado.getApellido());
        System.out.println("Peso: " + masPesado.getPeso() + " kg");
        System.out.println("Operadora: " + masPesado.getTelefono().getOperadora());
        System.out.println("Número: " + masPesado.getTelefono().getNumero());
        System.out.println("Activo: " + masPesado.isActivo());
        
        System.out.println("=== COMPARACIÓN DE OPERADORAS ===");
        boolean mismaOperadora = adminContactos.compararOperadoras(contacto1, contacto2);
        System.out.println("Los contactos tienen la misma operadora: " + mismaOperadora);
		
	}

}
