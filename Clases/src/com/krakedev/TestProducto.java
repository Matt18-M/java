package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA = new Producto();
		Producto productoB = new Producto();
		Producto productoC = new Producto();
		
productoA.setNombre ("Gasa Estéril Caricia");
productoA.setDescripcion ("Paño de gasa estéril utilizado para cubrir heridas y cortes, protegiéndolos de infecciones.");
productoA.setPrecio (0.99);
productoA.setStockActual (10);

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoA.getNombre());
System.out.println("La descripcion: "+ productoA.getDescripcion());
System.out.println("El precio es:"+ productoA.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoA.getStockActual());

productoB.setNombre ("Alcohol Antiséptico");
productoB.setDescripcion ("Solución antiséptica en base a alcohol para desinfectar la piel y superficies, previniendo infecciones. ");
productoB.setPrecio (2.75);
productoB.setStockActual (19);

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoB.getNombre());
System.out.println("La descripcion: "+ productoB.getDescripcion());
System.out.println("El precio es:"+ productoB.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoB.getStockActual());

productoC.setNombre ("Aspirina 100 mg");
productoC.setDescripcion (" Un medicamento de venta libre utilizado comúnmente para aliviar dolores leves a moderados, como dolores de cabeza o musculares, y para reducir la fiebre.");
productoC.setPrecio (1.36);
productoC.setStockActual (14);

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoC.getNombre());
System.out.println("La descripcion: "+ productoC.getDescripcion());
System.out.println("El precio es:"+ productoC.getPrecio()+"$");
System.out.println("El stock disponilbe es de: "+ productoC.getStockActual());

	}

}
