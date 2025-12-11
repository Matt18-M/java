package com.krakedev.estaticos;

public class Calculos {
	
	//para crear una constante es usar el modificador final
	private  final double IVA = 12;
	
	public double calcularIVA(double monto) {
		return monto*IVA/100;
	}
	
	
}
