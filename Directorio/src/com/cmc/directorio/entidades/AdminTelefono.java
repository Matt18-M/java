package com.cmc.directorio.entidades;

public class AdminTelefono {

	public void activarMensajeria(Telefono telefono) {
		if (telefono.getOperadora().equals("movi")) {
            telefono.setTieneWhatsapp(true);
		}
	}
	
	//contador Movi
	public int contarMovi(Telefono telf1, Telefono telf2, Telefono telf3) {
        int contador = 0;
        
        if (telf1.getOperadora().equals("movi")) {
            contador++;
        }
        if (telf2.getOperadora().equals("movi")) {
            contador++;
        }
        if (telf3.getOperadora().equals("movi")) {
            contador++;
        }
        
        return contador;
    }
	
	//contador claro
	public int contarClaro(Telefono telf1, Telefono telf2, Telefono telf3, Telefono telf4) {
        int contador = 0;
        
        if (telf1.getOperadora().equals("claro")) {
            contador++;
        }
        if (telf2.getOperadora().equals("claro")) {
            contador++;
        }
        if (telf3.getOperadora().equals("claro")) {
            contador++;
        }
        if (telf4.getOperadora().equals("claro")) {
            contador++;
        }
        
        return contador;
    }
}
