package com.krakedev.test;
import com.krakedev.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA = new Producto("Gasa Estéril Caricia",
				"Paño de gasa estéril utilizado para cubrir heridas y cortes, protegiéndolos de infecciones.",0.99,10);
		
		Producto productoB = new Producto("Alcohol Antiséptico",
				"Solución antiséptica en base a alcohol para desinfectar la piel y superficies, previniendo infecciones. ", 2.75, 19);
		
		Producto productoC = new Producto("Aspirina 100 mg", 
				"Un medicamento de venta libre utilizado comúnmente para aliviar dolores leves a moderados, como dolores de cabeza o musculares, y para reducir la fiebre.", 1.36, 26);
		
System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoA.getNombre());
System.out.println("La descripcion: "+ productoA.getDescripcion());
System.out.println("El precio es:"+ productoA.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoA.getStockActual());

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoB.getNombre());
System.out.println("La descripcion: "+ productoB.getDescripcion());
System.out.println("El precio es:"+ productoB.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoB.getStockActual());

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoC.getNombre());
System.out.println("La descripcion: "+ productoC.getDescripcion());
System.out.println("El precio es:"+ productoC.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoC.getStockActual());

	}

}
