package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.Estudiante;
import com.krakedev.persistencia.entidades.Profesor;
import com.krakedev.persistencia.servicios.AdminEstudiantes;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminEstudiantes {
    public static void main(String[] args) {
        testInsertarEstudiante();
        testActualizarEstudiante();
        testEliminarEstudiante();
    }

    public static void testInsertarEstudiante() {
        System.out.println("Insertar Estudiante");
        
        try {
            Date fechaNac = Convertidor.convertirFecha("2002/12/30");
            
            Estudiante e = new Estudiante();
            e.setCedula("0150560861");
            e.setNombre("Mateo");
            e.setApellido("Molina");
            e.setEmail("mateo.molina@email.com");
            e.setFechaNacimiento(fechaNac);
            
            AdminEstudiantes.insertar(e);
            System.out.println("Estudiante insertado exitosamente");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testActualizarEstudiante() {
        
        try {
            Date fechaNac = Convertidor.convertirFecha("2000/08/20");
            
            Profesor profesor = new Profesor(102, "María Fernández");
            
            Estudiante e = new Estudiante();
            e.setCedula("0150560861"); 
            e.setNombre("Mateo Andrés"); 
            e.setApellido("Molina Pérez"); 
            e.setEmail("mateo.actualizado@email.com"); 
            e.setFechaNacimiento(fechaNac);
            e.setProfesor(profesor);
            
            AdminEstudiantes.actualizar(e);
            System.out.println("Estudiante actualizado exitosamente");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testEliminarEstudiante() {
        System.out.println("Eliminar Estudiante por Cédula");
        
        try {
            // Eliminar estudiante
            String cedulaAEliminar = "0155554444";
            AdminEstudiantes.eliminar(cedulaAEliminar);
            System.out.println("Estudiante con cédula " + cedulaAEliminar + " eliminado exitosamente");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}