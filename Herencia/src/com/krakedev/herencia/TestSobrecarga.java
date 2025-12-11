package com.krakedev.herencia;

public class TestSobrecarga {

	public static void main(String[] args) {

		Gato g = new Gato();
        g.maullar();
        System.out.println();
        
        System.out.println("Segundo método maullar:");
        g.maullar("fuertemente");
        }

}
