package com.cmc.directorio.entidades;

public class AdminContactos {

	//buscar al mas pesado
	 public Contacto buscarMasPesado(Contacto contacto1, Contacto contacto2) {
	        if (contacto1.getPeso() > contacto2.getPeso()) {
	            return contacto1;
	        } else {
	            return contacto2;
	        }
	    }
	 
	 //comparar operadoras
	 public boolean compararOperadoras(Contacto contacto1, Contacto contacto2) {
	        String operadora1 = contacto1.getTelefono().getOperadora();
	        String operadora2 = contacto2.getTelefono().getOperadora();
	        return operadora1.equals(operadora2);
	    }
	 
	 //activar usuario
	 public void activarUsuario(Contacto contacto) {
	        if (contacto.getTelefono().isTieneWhatsapp()) {
	            contacto.setActivo(true);
	        }
	    }
}
