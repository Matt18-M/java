package com.krakedev.evaluacion;

public class Telefono {
	 private String numero;
	    private String tipo;
	    private String estado;

	    // Constructor
	    public Telefono(String numero, String tipo) {
	        this.numero = numero;
	        this.tipo = tipo;
	        this.estado = validarTelefono(numero, tipo);
	    }

	    // Método para validar el teléfono
	    private String validarTelefono(String numero, String tipo) {
	      
	        if (numero == null || tipo == null) {
	            return "E";
	        }
	        
	        // Validar el tipo
	        if (!tipo.equals("Movil") && !tipo.equals("Convencional")) {
	            return "E";
	        }
	        
	        // Validar longitud según el tipo
	        if (tipo.equals("Movil")) {
	            if (numero.length() != 10) {
	                return "E";
	            }
	        } else if (tipo.equals("Convencional")) {
	            if (numero.length() != 7) {
	                return "E";
	            }
	        }
	        
	        return "C";
	    }

	    // Getters
	    public String getNumero() {
	        return numero;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public String getEstado() {
	        return estado;
	    }
	}
