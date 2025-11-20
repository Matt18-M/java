package com.krakedev;

public class TestFecha {

	public static void main(String[] args) {
			fecha fecha1 = new fecha() ;
			
			//metodo set para modificar
			fecha1.setAnio(2002);
			fecha1.setMes(12);
			fecha1.setDia(30);
			
			//metodo get para consultar
			System.out.println("Naciste el dia " + fecha1.getDia() + " del mes " + fecha1.getMes() + " del año " + fecha1.getAnio());
	}

}
