package entidades;

public class Carta {
	  private Numero numero;
	    private String palo;
	    private String estado; 

	    // Constructor con parámetros
	    public Carta(Numero numero, String palo) {
	        this.numero = numero;
	        this.palo = palo;
	        this.estado = "N"; 
	    }

	    // Getters
	    public Numero getNumero() {
	        return numero;
	    }

	    public String getPalo() {
	        return palo;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    // Setters
	    public void setNumero(Numero numero) {
	        this.numero = numero;
	    }

	    public void setPalo(String palo) {
	        this.palo = palo;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    public void mostrarInformacion() {
	        System.out.println(numero.getNumeroCarta() + "-" + palo + " (" + estado + ")");
	    }
	}
