package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPersona {
	public static void main(String[] args) {
		EstadoCivil ec=new EstadoCivil("U","Union Libre");
		
		Persona p=new Persona();
		try {
			Date fechaNac = Convertidor.convertirFecha("2002/12/30");
			Date horaNac = Convertidor.convertirHora("12:45");
			
			
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimientoDate(horaNac);
			AdminPersonas.insertar(new Persona("015056086","Mateo","Molina",ec,fechaNac));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
