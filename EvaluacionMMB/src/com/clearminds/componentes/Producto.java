package com.clearminds.componentes;

public class Producto {
	
		private String nombre;
	    private double precio;
	    private String codigo;

	    // Constructor
	    public Producto(String nombre, double precio, String codigo) {
	        this.nombre = nombre;
	        this.precio = precio;
	        this.codigo = codigo;
	    }

	    // Método incrementarPrecio
	    public void incrementarPrecio(int porcentaje) {
	        double incremento = this.precio * (porcentaje / 100.0);
	        this.precio += incremento;
	    }

	    // Método disminuirPrecio
	    public void disminuirPrecio(double descuento) {
	        this.precio -= descuento;
	    }

	    // Método getters y setters
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }
	}

