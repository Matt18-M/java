package com.krakedev.herencia;

//herencia 
public class Perro extends Animal{
	public Perro() {
		System.out.println("EJECUTA CONSTRUCTOR DE PERRO");
	}
	
	public void ladrar() {
		System.out.println("WOAOOOOOOOO");
	}
	
	@Override 
	public void dormir() {
		super.dormir();
		System.out.println("PERRO DURMIENDO");
	}
}
