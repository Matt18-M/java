package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestBusquedaPorCedula {
	public static void main(String[] args) {
        try {
            Persona persona = AdminPersonas.buscarPorCedula("0150560811");
            System.out.println(persona);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
