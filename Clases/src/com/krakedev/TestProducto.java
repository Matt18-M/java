package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA = new Producto();
		Producto productoB = new Producto();
		Producto productoC = new Producto();
		
productoA.nombre = "Gasa Estéril Caricia";
productoA.descripcion = "Paño de gasa estéril utilizado para cubrir heridas y cortes, protegiéndolos de infecciones.";
productoA.precio = 0.99;
productoA.stockActual = 10;

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoA.nombre);
System.out.println("La descripcion: "+ productoA.descripcion);
System.out.println("El precio es:"+ productoA.precio+"$");
System.out.println("El stock disponilbe es de: "+ productoA.stockActual);

productoB.nombre = "Alcohol Antiséptico";
productoB.descripcion = "Solución antiséptica en base a alcohol para desinfectar la piel y superficies, previniendo infecciones. ";
productoB.precio = 2.75;
productoB.stockActual = 19;

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoB.nombre);
System.out.println("La descripcion: "+ productoB.descripcion);
System.out.println("El precio es:"+ productoB.precio+"$");
System.out.println("El stock disponilbe es de: "+ productoB.stockActual);

productoC.nombre = "Aspirina 100 mg";
productoC.descripcion = " Un medicamento de venta libre utilizado comúnmente para aliviar dolores leves a moderados, como dolores de cabeza o musculares, y para reducir la fiebre.";
productoC.precio = 1.36;
productoC.stockActual = 14;

System.out.println("------------------------------");
System.out.println("El porducto es: "+ productoC.nombre);
System.out.println("La descripcion: "+ productoC.descripcion);
System.out.println("El precio es:"+ productoC.precio+"$");
System.out.println("El stock disponilbe es de: "+ productoC.stockActual);

	}

}
