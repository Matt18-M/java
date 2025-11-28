package com.cmc.evaluacion.entidades;

public class Cuota {
    private int numero;
    private double cuota;
    private double capital;
    private double inicio;
    private double interes;
    private double abonoCapital;
    private double saldo;
    
    public Cuota(int numero) {
        this.numero = numero;
    }
    
    // Getters
    public int getNumero() {
        return numero;
    }
    
    public double getCuota() {
        return cuota;
    }
    
    public double getCapital() {
        return capital;
    }
    
    public double getInicio() {
        return inicio;
    }
    
    public double getInteres() {
        return interes;
    }
    
    public double getAbonoCapital() {
        return abonoCapital;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    // Setters
    public void setCuota(double cuota) {
        this.cuota = Utilitario.redondear(cuota);
    }
    
    public void setCapital(double capital) {
        this.capital = Utilitario.redondear(capital);
    }
    
    public void setInicio(double inicio) {
        this.inicio = Utilitario.redondear(inicio);
    }
    
    public void setInteres(double interes) {
        this.interes = Utilitario.redondear(interes);
    }
    
    public void setAbonoCapital(double abonoCapital) {
        this.abonoCapital = Utilitario.redondear(abonoCapital);
    }
    
    public void setSaldo(double saldo) {
        this.saldo = Utilitario.redondear(saldo);
    }
    
    // Método mostrarPrestamo
    public void mostrarPrestamo() {
        System.out.printf("%d | %.2f | %.2f | %.2f | %.2f | %.2f%n",
                numero,
                cuota,
                inicio,        
                interes,
                abonoCapital,
                saldo
        );
    }
}