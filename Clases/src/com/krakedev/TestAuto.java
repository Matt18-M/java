package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		
	auto1.marca = "toyota";
	auto1.anio = 2019;
	auto1.precio = 7.599;
	
	System.out.println("La marca del auto 1 es: "+ auto1.marca);
	System.out.println("El año del auto 1 es: "+ auto1.anio);
	System.out.println("El precio del auto 1 es: "+ auto1.precio);
	System.out.println("----------------------------");


	auto2.marca = "Chevrolet";
	auto2.anio = 2021;
	auto2.precio = 9.899;
	
	System.out.println("La marca del auto 2 es: "+ auto2.marca);
	System.out.println("El año del auto 2 es: "+ auto2.anio);
	System.out.println("El precio del auto 2 es: "+ auto2.precio);
	System.out.println("----------------------------");
	
		

	}

}
