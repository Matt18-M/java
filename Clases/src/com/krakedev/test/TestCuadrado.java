package com.krakedev.test;
import com.krakedev.Cuadrado;

public class TestCuadrado {

	public static void main(String[] args) {
		Cuadrado c1 = new Cuadrado(5);
		Cuadrado c2 = new Cuadrado(6);
		Cuadrado c3 = new Cuadrado(8);
		
		double areaC1;
		double perimetroC1;

		double areaC2;
		double perimetroC2;
		
		double areaC3;
		double perimetroC3;
		
		
		areaC1 = c1.calcularArea();
		perimetroC1 = c1.calcularPerimetro();
		areaC2 = c2.calcularArea();
		perimetroC2 = c2.calcularPerimetro();
		areaC3 = c3.calcularArea();
		perimetroC3 = c3.calcularPerimetro();
		
		
		
		System.out.println("El area de C1 es: " + areaC1);
		System.out.println("El perimetro de C1 es: " + perimetroC1);
		System.out.println("--------------------------------------");
		
		System.out.println("El area de C2 es: " + areaC2);
		System.out.println("El perimetro de C2 es: " + perimetroC2);
		System.out.println("--------------------------------------");
		
		System.out.println("El area de C3 es: " + areaC3);
		System.out.println("El perimetro de C3 es: " + perimetroC3);
		System.out.println("--------------------------------------");
		
	}

}
