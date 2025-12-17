package com.krakedev.persistencia.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.EstadoCivil;
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
            
            if (persona.getEstadoCivil() != null && persona.getEstadoCivil().getCodigo() != null) {
                ps.setString(4, persona.getEstadoCivil().getCodigo());
            } else {
                ps.setNull(4, java.sql.Types.CHAR);
            }
            
            if (persona.getEstatura() != null) {
                ps.setDouble(5, persona.getEstatura());
            } else {
                ps.setNull(5, java.sql.Types.DECIMAL);
            }
            
            if (persona.getFechaNacimiento() != null) {
                ps.setDate(6, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }
            
            if (persona.getHoraNacimiento() != null) {
                ps.setTime(7, persona.getHoraNacimiento());
            } else {
                ps.setNull(7, java.sql.Types.TIME);
            }
            
            if (persona.getCantidadAhorrada() != null) {
                ps.setBigDecimal(8, persona.getCantidadAhorrada());
            } else {
                ps.setNull(8, java.sql.Types.DECIMAL);
            }
            
            ps.setInt(9, persona.getNumeroHijos());
            
            LOGGER.debug("Ejecutando inserción");
            ps.executeUpdate();
            
            System.out.println("Insert realizado");
            
        } catch (Exception e) {
            LOGGER.error("ERROR al insertar persona", e);
            throw new Exception("ERROR al insertar: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar conexión", e);
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
            
            if (persona.getEstadoCivil() != null && persona.getEstadoCivil().getCodigo() != null) {
                ps.setString(3, persona.getEstadoCivil().getCodigo());
            } else {
                ps.setNull(3, java.sql.Types.CHAR);
            }
            
            if (persona.getEstatura() != null) {
                ps.setDouble(4, persona.getEstatura());
            } else {
                ps.setNull(4, java.sql.Types.DECIMAL);
            }
            
            if (persona.getFechaNacimiento() != null) {
                ps.setDate(5, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            
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
            }
        }
    }
    
    //metodo busqueda por nombre(agregando los demas datos)
    
    public static ArrayList<Persona> buscarPorNombre(String nombreBusqueda) throws Exception {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement("select * from personas where nombre like ?");
            ps.setString(1, "%" + nombreBusqueda + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                // Obtener todos los campos 
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String estadoCivilCodigo = rs.getString("estado_civil_codigo");
                
                double estatura = 0.0;
                if (rs.getObject("estatura") != null) {
                    estatura = rs.getDouble("estatura");
                }
                
                java.util.Date fechaNacimiento = null;
                java.sql.Date sqlFecha = rs.getDate("fecha_nacimiento");
                if (sqlFecha != null) {
                    fechaNacimiento = new java.util.Date(sqlFecha.getTime());
                }
                
                Time horaNacimiento = rs.getTime("hora_nacimiento");
                
                
                int numeroHijos = rs.getInt("numero_hijos");

                Persona p = new Persona();
                p.setCedula(cedula);
                p.setNombre(nombre);
                p.setApellido(apellido);
                
                
                if (estadoCivilCodigo != null) {
                    EstadoCivil ec = new EstadoCivil();
                    ec.setCodigo(estadoCivilCodigo);
                    p.setEstadoCivil(ec);
                }
                
                p.setEstatura(estatura);
                p.setFechaNacimiento(fechaNacimiento);
                p.setHoraNacimiento(horaNacimiento);
                p.setNumeroHijos(numeroHijos);

                personas.add(p);
            }

        } catch (Exception e) {
            LOGGER.error("ERROR al buscar por nombre: " + nombreBusqueda, e);
            throw new Exception("ERROR al buscar por nombre: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar recursos en buscarPorNombre", e);
            }
        }

        return personas;
    }
    
    //metodo busqueda por cedula
    public static Persona buscarPorCedula(String cedulaBusqueda) throws Exception {
        Persona persona = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement("select * from personas where cedula = ?");
            ps.setString(1, cedulaBusqueda);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Obtener todos los campos
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String estadoCivilCodigo = rs.getString("estado_civil_codigo");
                
                Double estatura = null;
                if (rs.getObject("estatura") != null) {
                    estatura = rs.getDouble("estatura");
                }
                
                java.util.Date fechaNacimiento = null;
                java.sql.Date sqlFecha = rs.getDate("fecha_nacimiento");
                if (sqlFecha != null) {
                    fechaNacimiento = new java.util.Date(sqlFecha.getTime());
                }
                
                Time horaNacimiento = rs.getTime("hora_nacimiento");
                
                int numeroHijos = rs.getInt("numero_hijos");

                persona = new Persona();
                persona.setCedula(cedula);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                
                
                if (estadoCivilCodigo != null) {
                    EstadoCivil ec = new EstadoCivil();
                    ec.setCodigo(estadoCivilCodigo);
                    persona.setEstadoCivil(ec);
                }
                
                persona.setEstatura(estatura);
                persona.setFechaNacimiento(fechaNacimiento);
                persona.setHoraNacimiento(horaNacimiento);
                persona.setNumeroHijos(numeroHijos);
            } else {
                throw new Exception("No se encontró persona con cédula: " + cedulaBusqueda);
            }

        } catch (Exception e) {
            LOGGER.error("ERROR al buscar por cédula: " + cedulaBusqueda, e);
            throw new Exception("ERROR al buscar por cédula: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("ERROR al cerrar recursos en buscarPorCedula", e);
            }
        }

        return persona;
    }
}