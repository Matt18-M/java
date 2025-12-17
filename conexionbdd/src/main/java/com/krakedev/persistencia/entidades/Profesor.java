package com.krakedev.persistencia.entidades;

public class Profesor {
    private int codigo;
    private String nombre;
    
    // Constructores
    public Profesor() {
    }
    
    public Profesor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
