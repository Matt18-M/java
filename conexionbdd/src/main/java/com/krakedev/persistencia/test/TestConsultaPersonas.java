package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaPersonas {
		public static void main(String[] args) throws Exception {
			try {
				ArrayList <Persona> personas = AdminPersonas.buscarPorNombre("a");
				System.out.println(personas);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		}			
}

