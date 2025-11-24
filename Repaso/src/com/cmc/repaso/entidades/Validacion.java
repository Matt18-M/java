package com.cmc.repaso.entidades;

public class Validacion {
	public boolean validarMonto(int monto){
		if(monto > 0) {
			System.out.println("Es true");
			return true;
		}else {
			System.out.println("Es false");
			return false;
			
		}
	}
}
