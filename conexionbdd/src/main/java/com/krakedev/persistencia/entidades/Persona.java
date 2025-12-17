package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    private EstadoCivil estadoCivil;
    private Double estatura;
    private Date fechaNacimiento;
    private Time horaNacimiento;
    private BigDecimal cantidadAhorrada;
    private int numeroHijos;
    
    // Constructor 
    public Persona() {}
    
    // Constructor 
    public Persona(String cedula, String nombre, String apellido, EstadoCivil estadoCivil, Double estatura,
            Date fechaNacimiento, Time horaNacimiento, BigDecimal cantidadAhorrada, int numeroHijos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.estatura = estatura;
        this.fechaNacimiento = fechaNacimiento;
        this.horaNacimiento = horaNacimiento;
        this.cantidadAhorrada = cantidadAhorrada;
        this.numeroHijos = numeroHijos;
    }
    
    // Constructor 
    public Persona(String cedula, String nombre, String apellido, EstadoCivil estadoCivil, Date fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Getters y Setters
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public Double getEstatura() {
        return estatura;
    }
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Time getHoraNacimiento() {
        return horaNacimiento;
    }
    
    public void setHoraNacimiento(Time horaNacimiento) {
        this.horaNacimiento = horaNacimiento;
    }
    
   
    public void setHoraNacimientoDate(Date horaNacimiento) {
        if (horaNacimiento != null) {
            this.horaNacimiento = new Time(horaNacimiento.getTime());
        } else {
            this.horaNacimiento = null;
        }
    }
    
    public BigDecimal getCantidadAhorrada() {
        return cantidadAhorrada;
    }
    public void setCantidadAhorrada(BigDecimal cantidadAhorrada) {
        this.cantidadAhorrada = cantidadAhorrada;
    }
    
    public int getNumeroHijos() {
        return numeroHijos;
    }
    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }
    
    @Override
    public String toString() {
        return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", estadoCivil="
                + estadoCivil + ", estatura=" + estatura + ", fechaNacimiento=" + fechaNacimiento
                + ", horaNacimiento=" + horaNacimiento + ", cantidadAhorrada=" + cantidadAhorrada + ", numeroHijos="
                + numeroHijos + "]";
    }
}
