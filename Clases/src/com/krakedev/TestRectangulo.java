package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {

		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo();
		int area1;
		int area2; 
		
		r1.base=10;
		r1.altura=5;
		
		r2.base=8;
		r2.altura=2;
		
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
