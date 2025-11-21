package clearminds.cuentas;

public class Cuenta {
	private String id;
	private String tipo;
	private double saldo;
	
	
	//constructores
	public Cuenta(String id) {
		this.id=id;
		this.tipo="A";
	}
	
	
	public Cuenta (String id,String tipo,double saldo) {
		this.id=id;
		this.tipo=tipo;
		this.saldo=saldo;
}

	//metodo get y set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Otros metodos
	public void imprimir() {
	    System.out.println("********************");
	    System.out.println("CUENTA");
	    System.out.println("********************");
	    System.out.println("Número de Cuenta: " + getId());
	    System.out.println("Tipo: " + getTipo());
	    System.out.println("Saldo: USD " + getSaldo());
	    System.out.println("********************");
	}
	
	public void imprimirConMiEstilo() {
	System.out.println("=============================================");
	System.out.println(">>> DATOS DE MI CUENTA <<<");
	System.out.println("=============================================");
	System.out.println("|°Número de Cuenta: " + getId());
	System.out.println("|°Tipo: " + getTipo());
	System.out.println("|°Saldo: USD " + getSaldo());
	System.out.println("=============================================");
	}
}
	