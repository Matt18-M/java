package com.krakedev.test;
import com.krakedev.Rectangulo;

public class TestRectangulo {

	public static void main(String[] args) {

		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo();
		int area1;
		int area2; 
		
		r1.setBase(10);
		r1.setAltura(5);
		
		r2.setBase(8);
		r2.setAltura(2);
		
		area1 = r1.calcularArea();
		area2 = r2.calcularArea();
		System.out.println("Area de r1 es: " + area1);
		System.out.println("Area de r2 es: " + area2);
		System.out.println("--------------------------------------");
		
		double perimetro1 = r1.calcularPerimetro();
		double perimetro2 = r2.calcularPerimetro();
		System.out.println("El perimetro de r1 es: " + perimetro1);
		System.out.println("El perimetro de r2 es: " + perimetro2);
	}

}
