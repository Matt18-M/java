package com.krakedev;
/*
 * varias lineas
 * */

public class TestPersona {

	public static void main(String[] args) {
		// al crear una clase, tambien es un tipo de dato
		Persona p; // 1.declaro la variable de tipo persona
		Persona p2 = new Persona();
		
		//se dirige al constructor dependiendo de los parametros
		Persona p3 = new Persona("Pablo",24,1.76);
		
		p = new Persona(); // 2.Instanciar un objeto Persona, referenciar a objeto p

		// 3.accediendo a los atributos en consola
		p.setNombre ("Mateo");
		p.setEdad (22);
		p.setEstatura (1.64);
		System.out.println("---------------------");
		System.out.println("Nombre: " + p.getNombre());
		System.out.println("Edad: " + p.getEdad());
		System.out.println("Estatura: " + p.getEstatura());
		System.out.println("---------------------");

		p2.setNombre ("Roberto");
		p2.setEdad (23);
		p2.setEstatura (1.67);
		System.out.println("Nombre: " + p2.getNombre());
		System.out.println("Edad: " + p2.getEdad());
		System.out.println("Estatura: " + p2.getEstatura());

		// 4.modificar los atributos
		p.setNombre ("Esteban");
		p.setEdad (45);
		p.setEstatura (1.56);
		System.out.println("---------------------");
		System.out.println("Nombre: " + p.getNombre());
		System.out.println("Edad: " + p.getEdad());
		System.out.println("Estatura: " + p.getEstatura());
		System.out.println("---------------------");

		
		System.out.println("Nombre: " + p3.getNombre());
		System.out.println("Edad: " + p3.getEdad());
		System.out.println("Estatura: " + p3.getEstatura());

	}

}
