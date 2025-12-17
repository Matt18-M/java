package com.krakedev.conexionbdd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

public class TestFechas {
    public static void main(String[] args) {
        // SimpleDateFormat con formato corregido (tenía //NW/ en la imagen)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String fechaStr = "2020/03/22 10:05:04";
        
        try {
            // Parsear la fecha string a Date
            Date fecha = sdf.parse(fechaStr);
            System.out.println(fecha);
            
            // Obtener el tiempo en milisegundos desde epoch
            long fechaWillis = fecha.getTime();
            System.out.println(fechaWillis);
            
            // Crear un java.sql.Date, partiendo de un java.util.Date
            java.sql.Date fechaSQL = new java.sql.Date(fechaWillis);
            System.out.println(fechaSQL);
            
            // Crear un java.sql.Time
            Time timeSQL = new Time(fechaWillis);
            System.out.println(timeSQL);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}