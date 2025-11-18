package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
			Calculadora calcu;
			 int resultadoSuma;
			 int resultadoResta;
			 double resultadoMultiplicar;
			 double resultadoDividir;
			 double resultadoPromediar;
			
			calcu = new Calculadora();
			resultadoSuma = calcu.sumar(8, 7);		
			resultadoResta = calcu.restar(11, 22);
			resultadoMultiplicar = calcu.multiplicar(27,5);
			resultadoDividir = calcu.dividir(99, 5);
			resultadoPromediar = calcu.promediar(10, 8, 9);
			
			
			System.out.println("El resultado es: "+ resultadoSuma);
			System.out.println("------------------------------");
			System.out.println("El resultado de la resta es: "+ resultadoResta);
			System.out.println("------------------------------");
			System.out.println("El resultado de la multiplicacion es: " + resultadoMultiplicar);
			System.out.println("------------------------------");
			System.out.println("El resultado de la division es: " + resultadoDividir);
			System.out.println("------------------------------");
			System.out.println("El resultado del promedio es: " + resultadoPromediar);
			System.out.println("------------------------------");

			calcu.mostrarResultado();
	}
}
