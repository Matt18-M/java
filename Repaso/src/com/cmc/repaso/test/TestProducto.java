package com.cmc.repaso.test;
import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		
		Producto producto1 = new Producto("Reloj",-520);
		
		
		System.out.println("=== Producto 1 ===");
        System.out.println("Nombre: " + producto1.getNombre());
        System.out.println("Precio: $" + producto1.getPrecio());
        System.out.println("Precio con 20% descuento: $" + producto1.calcularPrecioPromo(20));

		
	}

}
