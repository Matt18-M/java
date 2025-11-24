package com.cmc.repaso.test;
import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {

		System.out.println("=== PRIMER PRODUCTO ===");
        Item producto1 = new Item();
        producto1.setNombre("Laptop");
        producto1.setProductosActuales(20);
        producto1.setProductosVendidos(0);
        producto1.setProductosDevueltos(0);
        
        System.out.println("Estado inicial:");
        producto1.imprimir();
        
        System.out.println("\n--- Vendiendo 5 productos ---");
        producto1.vender(5);
        producto1.imprimir();
        
        System.out.println("\n--- Devolviendo 2 productos ---");
        producto1.devolver(2);
        producto1.imprimir();
        
        System.out.println("\n--- Vendiendo 3 productos más ---");
        producto1.vender(3);
        producto1.imprimir();
        
        System.out.println("\n--- Devolviendo 1 producto ---");
        producto1.devolver(1);
        producto1.imprimir();

        // Crear segundo producto
        System.out.println("\n\n=== SEGUNDO PRODUCTO ===");
        Item producto2 = new Item();
        producto2.setNombre("Mouse");
        producto2.setProductosActuales(15);
        producto2.setProductosVendidos(0);
        producto2.setProductosDevueltos(0);
        
        System.out.println("Estado inicial:");
        producto2.imprimir();
        
        System.out.println("\n--- Vendiendo 8 productos ---");
        producto2.vender(8);
        producto2.imprimir();
        
        System.out.println("\n--- Devolviendo 3 productos ---");
        producto2.devolver(3);
        producto2.imprimir();
    }
}
