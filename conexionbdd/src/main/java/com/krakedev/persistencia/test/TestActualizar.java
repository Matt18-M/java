package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestActualizar {
    public static void main(String[] args) {
        try {
            // Crear un EstadoCivil
            EstadoCivil ec = new EstadoCivil("C", "Casado");
            
            // Crear fechas
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
            
            Date fechaNacimiento = sdf.parse("1992-08-25");
            Time horaNacimiento = new Time(sdfHora.parse("15:30:00").getTime());
            
            // Crear una persona para actualizar
            Persona personaActualizar = new Persona();
            personaActualizar.setCedula("0150560813"); 
            personaActualizar.setNombre("Mateo Actualizado");
            personaActualizar.setApellido("Molina Modificado");
            personaActualizar.setEstadoCivil(ec);
            personaActualizar.setEstatura(1.80); // Cambio de estatura
            personaActualizar.setFechaNacimiento(fechaNacimiento);
            personaActualizar.setHoraNacimiento(horaNacimiento);
            personaActualizar.setCantidadAhorrada(new BigDecimal("5000.00")); 
            personaActualizar.setNumeroHijos(2); 
            
            // Llamar al método actualizar
            AdminPersonas.actualizar(personaActualizar);
            
            System.out.println("Persona actualizada exitosamente");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}