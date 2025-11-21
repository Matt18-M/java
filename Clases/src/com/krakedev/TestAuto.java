package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		
		Auto auto1 = new Auto("Toyota",2019,7.455);
		Auto auto2 = new Auto("Chevrolet",2022,10.599);
		
	
	System.out.println("La marca del auto 1 es: "+ auto1.getMarca());
	System.out.println("El año del auto 1 es: "+ auto1.getAnio());
	System.out.println("El precio del auto 1 es: "+ auto1.getPrecio());
	System.out.println("----------------------------");

	System.out.println("La marca del auto 2 es: "+ auto2.getMarca());
	System.out.println("El año del auto 2 es: "+ auto2.getAnio());
	System.out.println("El precio del auto 2 es: "+ auto2.getPrecio());
	System.out.println("----------------------------");
	
		

	}

}
