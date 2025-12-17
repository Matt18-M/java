package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Estudiante;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminEstudiantes {
    
    private static final Logger LOGGER = LogManager.getLogger(AdminEstudiantes.class);
    
    // Método para insertar un estudiante
    public static void insertar(Estudiante estudiante) throws Exception {
        Connection con = null; 
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método insertar estudiante");
        
        try {
            LOGGER.debug("Conectando a la base de datos...");
            con = ConexionBDD.conectar();
            
            String sql = "INSERT INTO estudiantes (cedula, nombre, apellido, email, fecha_nacimiento, codigo_profesor) " +
                        "VALUES(?, ?, ?, ?, ?, ?)";
            
            LOGGER.debug("Preparando consulta SQL");
            ps = con.prepareStatement(sql);
            
            ps.setString(1, estudiante.getCedula());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getEmail());
            
            if (estudiante.getFechaNacimiento() != null) {
                ps.setDate(5, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            
            if (estudiante.getProfesor() != null && estudiante.getProfesor().getCodigo() > 0) {
                ps.setInt(6, estudiante.getProfesor().getCodigo());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }
            
            LOGGER.debug("Ejecutando inserción de estudiante");
            ps.executeUpdate();
            
            System.out.println("Estudiante insertado exitosamente");
            
        } catch (Exception e) {
            LOGGER.error("ERROR al insertar estudiante", e);
            throw new Exception("ERROR al insertar estudiante: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar conexión", e);
                throw new Exception("ERROR con la base de datos");
            }
        }
    }
    
    // Método para actualizar un estudiante
    public static void actualizar(Estudiante estudiante) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método actualizar estudiante");
        
        try {
            LOGGER.debug("Conectando a la base de datos para actualizar");
            con = ConexionBDD.conectar();
            
            String sql = "UPDATE estudiantes SET " +
                        "nombre = ?, " +
                        "apellido = ?, " +
                        "email = ?, " +
                        "fecha_nacimiento = ?, " +
                        "codigo_profesor = ? " +
                        "WHERE cedula = ?";
            
            LOGGER.debug("Preparando consulta UPDATE");
            ps = con.prepareStatement(sql);
            
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getEmail());
            
            if (estudiante.getFechaNacimiento() != null) {
                ps.setDate(4, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            
            if (estudiante.getProfesor() != null && estudiante.getProfesor().getCodigo() > 0) {
                ps.setInt(5, estudiante.getProfesor().getCodigo());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.setString(6, estudiante.getCedula());
            
            LOGGER.debug("Ejecutando actualización para cédula: " + estudiante.getCedula());
            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Estudiante actualizado. Filas afectadas: " + filasActualizadas);
            } else {
                LOGGER.debug("No se encontró ningún estudiante con la cédula: " + estudiante.getCedula());
                System.out.println("No se encontró ningún estudiante con la cédula: " + estudiante.getCedula());
            }
            
        } catch (Exception e) {
            LOGGER.error("ERROR al actualizar estudiante con cédula: " + estudiante.getCedula(), e);
            throw new Exception("ERROR al actualizar estudiante: " + e.getMessage());
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
    
    // Método para eliminar un estudiante
    public static void eliminar(String cedula) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        LOGGER.trace("Iniciando método eliminar estudiante");
        
        try {
            // Validar cédula
            if (cedula == null || cedula.trim().isEmpty()) {
                LOGGER.error("La cédula no puede ser null o vacía");
                throw new Exception("La cédula es obligatoria");
            }
            
            LOGGER.debug("Conectando a la base de datos para eliminar");
            con = ConexionBDD.conectar();
            
            String sql = "DELETE FROM estudiantes WHERE cedula = ?";
            
            LOGGER.debug("Preparando consulta DELETE para cédula: " + cedula);
            ps = con.prepareStatement(sql);
            
            ps.setString(1, cedula);
            
            LOGGER.debug("Ejecutando eliminación");
            int filasEliminadas = ps.executeUpdate();
            
            if (filasEliminadas > 0) {
                System.out.println("Estudiante eliminado. Filas afectadas: " + filasEliminadas);
            } else {
                LOGGER.debug("No se encontró ningún estudiante con la cédula: " + cedula);
                System.out.println("No se encontró ningún estudiante con la cédula: " + cedula);
            }
            
        } catch (Exception e) {
            LOGGER.error("ERROR al eliminar estudiante con cédula: " + cedula, e);
            throw new Exception("ERROR al eliminar estudiante: " + e.getMessage());
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