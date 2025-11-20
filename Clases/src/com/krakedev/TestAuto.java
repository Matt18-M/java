package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		
	auto1.setMarca("toyota");
	auto1.setAnio (2019);
	auto1.setPrecio (7.599);
	
	System.out.println("La marca del auto 1 es: "+ auto1.getMarca());
	System.out.println("El año del auto 1 es: "+ auto1.getAnio());
	System.out.println("El precio del auto 1 es: "+ auto1.getPrecio());
	System.out.println("----------------------------");


	auto2.setMarca ("Chevrolet");
	auto2.setAnio (2021);
	auto2.setPrecio (9.899);
	
	System.out.println("La marca del auto 2 es: "+ auto2.getMarca());
	System.out.println("El año del auto 2 es: "+ auto2.getAnio());
	System.out.println("El precio del auto 2 es: "+ auto2.getPrecio());
	System.out.println("----------------------------");
	
		

	}

}
