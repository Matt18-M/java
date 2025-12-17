package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
    
    private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
    
    public static void insertar(Persona persona) throws Exception {
        Connection con = null; 
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método insertar");
        
        try {
            LOGGER.debug("Conectando a la base de datos...");
            con = ConexionBDD.conectar();
            
            String sql = "insert into personas (cedula, nombre, apellido, estado_civil_codigo, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            LOGGER.debug("Preparando consulta SQL");
            ps = con.prepareStatement(sql);
            
            ps.setString(1, persona.getCedula());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getEstadoCivil().getCodigo());  
            
            if (persona.getEstatura() != null) {
                ps.setDouble(5, persona.getEstatura());
            } else {
                ps.setNull(5, java.sql.Types.DECIMAL);
            }
            
            ps.setDate(6, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            ps.setTime(7, persona.getHoraNacimiento());
            ps.setBigDecimal(8, persona.getCantidadAhorrada());
            ps.setInt(9, persona.getNumeroHijos());
            
            LOGGER.debug("Ejecutando inserción");
            ps.executeUpdate();
            
            System.out.println("Insert realizado");
            
        } catch (Exception e) {
            LOGGER.error("ERROR al insertar persona", e);
            throw new Exception("ERROR al insertar");
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar conexión", e);
                throw new Exception("ERROR con la base de datos");
            }
        }
    }
    
    //metodo actualizar datos de una persona 
    public static void actualizar(Persona persona) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método actualizar");
        
        try {
            LOGGER.debug("Conectando a la base de datos para actualizar");
            con = ConexionBDD.conectar();
            
            String sql = "UPDATE personas SET " +
                        "nombre = ?, " +
                        "apellido = ?, " +
                        "estado_civil_codigo = ?, " +
                        "estatura = ?, " +
                        "fecha_nacimiento = ?, " +
                        "hora_nacimiento = ?, " +
                        "cantidad_ahorrada = ?, " +
                        "numero_hijos = ? " +
                        "WHERE cedula = ?";
            
            LOGGER.debug("Preparando consulta UPDATE");
            ps = con.prepareStatement(sql);
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEstadoCivil().getCodigo());
            
            if (persona.getEstatura() != null) {
                ps.setDouble(4, persona.getEstatura());
            } else {
                ps.setNull(4, java.sql.Types.DECIMAL);
            }
            
            ps.setDate(5, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            
            if (persona.getHoraNacimiento() != null) {
                ps.setTime(6, persona.getHoraNacimiento());
            } else {
                ps.setNull(6, java.sql.Types.TIME);
            }
            
            if (persona.getCantidadAhorrada() != null) {
                ps.setBigDecimal(7, persona.getCantidadAhorrada());
            } else {
                ps.setNull(7, java.sql.Types.DECIMAL);
            }
            
            ps.setInt(8, persona.getNumeroHijos());
            ps.setString(9, persona.getCedula());
            
            LOGGER.debug("Ejecutando actualización para cédula: " + persona.getCedula());
            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Actualización realizada. Filas afectadas: " + filasActualizadas);
            } else {
                LOGGER.debug("No se encontró ninguna persona con la cédula: " + persona.getCedula());
                System.out.println("No se encontró ninguna persona con la cédula: " + persona.getCedula());
            }
            
        } catch (Exception e) {
            LOGGER.error("ERROR al actualizar persona con cédula: " + persona.getCedula(), e);
            throw new Exception("ERROR al actualizar: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar recursos", e);
                throw new Exception("ERROR al cerrar conexión");
            }
        }
    }
    
    //Método para eliminar una persona de la base de datos
    
    public static void eliminar(String cedula) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método eliminar");
        
        try {
            // Validar que la cédula no sea null o vacía
            if (cedula == null || cedula.trim().isEmpty()) {
                LOGGER.error("La cédula no puede ser null o vacía");
                throw new Exception("La cédula es obligatoria");
            }
            
            LOGGER.debug("Conectando a la base de datos para eliminar");
            con = ConexionBDD.conectar();
            
            String sql = "DELETE FROM personas WHERE cedula = ?";
            
            LOGGER.debug("Preparando consulta DELETE para cédula: " + cedula);
            ps = con.prepareStatement(sql);
            
            // Establecer el parámetro
            ps.setString(1, cedula);
            
            LOGGER.debug("Ejecutando eliminación");
            int filasEliminadas = ps.executeUpdate();
            
            if (filasEliminadas > 0) {
                System.out.println("Eliminación realizada. Filas afectadas: " + filasEliminadas);
            } else {
                LOGGER.debug("No se encontró ninguna persona con la cédula: " + cedula);
                System.out.println("No se encontró ninguna persona con la cédula: " + cedula);
            }
            
        } catch (Exception e) {
            LOGGER.error("ERROR al eliminar persona con cédula: " + cedula, e);
            throw new Exception("ERROR al eliminar: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar recursos", e);
                throw new Exception("ERROR al cerrar conexión");
            }
        }
    }
}