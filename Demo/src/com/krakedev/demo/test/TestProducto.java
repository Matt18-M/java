package com.krakedev.demo.test;
import com.krakedev.demo.*;

public class TestProducto {

	public static void main(String[] args) {
		
		Producto producto1=new Producto(1234,"Manilla","Accesorio de mano",1.2);
		
		System.out.println("----PRODUCTO----");
		producto1.imprimir();
		
		producto1.setDescripcion("Son detalles para el brazo");
		producto1.setPeso(2.5);
		
		System.out.println("---------------------");
		System.out.println("----PRODUCTO----");
		producto1.imprimir();
	}

}
