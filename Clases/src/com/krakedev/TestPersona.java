package com.krakedev;
/*
 * varias lineas
 * */

public class TestPersona {

	public static void main(String[] args) {
		// al crear una clase, tambien es un tipo de dato
		Persona p; // 1.declaro la variable de tipo persona
		Persona p2 = new Persona();
		p = new Persona(); // 2.Instanciar un objeto Persona, referenciar a objeto p

		// 3.accediendo a los atributos en consola
		p.nombre = "Mateo";
		p.edad = 22;
		p.estatura = 1.64;
		System.out.println("---------------------");
		System.out.println("Nombre: " + p.nombre);
		System.out.println("Edad: " + p.edad);
		System.out.println("Estatura: " + p.estatura);
		System.out.println("---------------------");

		p2.nombre = "Roberto";
		p2.edad = 23;
		p2.estatura = 1.67;
		System.out.println("Nombre: " + p2.nombre);
		System.out.println("Edad: " + p2.edad);
		System.out.println("Estatura: " + p2.estatura);

		// 4.modificar los atributos
		p.nombre = "Esteban";
		p.edad = 45;
		p.estatura = 1.56;
		System.out.println("---------------------");
		System.out.println("Nombre: " + p.nombre);
		System.out.println("Edad: " + p.edad);
		System.out.println("Estatura: " + p.estatura);
		System.out.println("---------------------");

	}

}
