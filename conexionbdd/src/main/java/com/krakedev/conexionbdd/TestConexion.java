package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

public class TestConexion {

    public static void main(String[] args) {
        
        Connection connection = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Rm015056");
            System.out.println("conexion exitosa");
            
            connection.setAutoCommit(true);
            
            
            ps = connection.prepareStatement(
                "insert into personas (cedula, nombre, apellido, estado_civil_codigo, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, "0155554444");
            ps.setString(2, "María");
            ps.setString(3, "Gonzalez");
            ps.setString(4, "C");  
            
            ps.setDouble(5, 1.68);
            
            // (Date)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = sdf.parse("1995-03-25");
            ps.setDate(6, new java.sql.Date(fechaNac.getTime()));
            
            // (Time)
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            Date horaNac = sdfTime.parse("10:45:20");
            ps.setTime(7, new Time(horaNac.getTime()));
            
            // Money usando BigDecimal 
            BigDecimal cantidadAhorrada = new BigDecimal("3200.80");
            ps.setBigDecimal(8, cantidadAhorrada);
            
            ps.setInt(9, 1);
            
            ps.executeUpdate();
            System.out.println("Insert realizado");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
        }
    }
