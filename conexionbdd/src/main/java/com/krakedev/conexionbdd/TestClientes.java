package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClientes {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rm015056");
			System.out.println("conexion exitosa");
			
			connection.setAutoCommit(true);
			
			ps = connection.prepareStatement(
				"insert into clientes (cedula, nombre, apellido, edad, numero_hijos, estatura, hora, fecha) " +
				"values(?,?,?,?,?,?,?,?)");
			
		
			ps.setString(1,"0144225577");
			ps.setString(2, "Mateo");
			ps.setString(3, "Jhonatan");
			ps.setInt(4, 35);
			ps.setInt(5, 2);
			ps.setDouble(6, 1.72);
			
			// Hora 
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date hora = sdfTime.parse("09:15:30");
			ps.setTime(7, new Time(hora.getTime()));
			
			// Fecha 
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = sdfDate.parse("2024-01-15");
			ps.setDate(8, new java.sql.Date(fecha.getTime()));
			
			ps.executeUpdate();
			System.out.println("Insert realizado");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}