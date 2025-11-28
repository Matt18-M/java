package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {
    
    public static double calcularCuota(Prestamo prestamo) {
        double monto = prestamo.getMonto();
        double tasaInteresMensual = prestamo.getInteres() / 100 / 12;
        int numeroPagos = prestamo.getPlazo();
        
        double factor = Math.pow(1 + tasaInteresMensual, numeroPagos);
        double cuota = (monto * tasaInteresMensual * factor) / (factor - 1);
        
        return cuota;
    }
    
    public static void generarTabla(Prestamo prestamo) {
        double cuotaConstante = calcularCuota(prestamo);
        
        for (int i = 0; i < prestamo.getPlazo(); i++) {
            Cuota cuota = new Cuota(i + 1);
            cuota.setCuota(cuotaConstante);
            prestamo.getCuotas()[i] = cuota;
        }
        
        prestamo.getCuotas()[0].setInicio(prestamo.getMonto());
        
        for (int i = 0; i < prestamo.getPlazo(); i++) {
            Cuota cuotaActual = prestamo.getCuotas()[i];
            Cuota cuotaSiguiente = (i < prestamo.getPlazo() - 1) ? prestamo.getCuotas()[i + 1] : null;
            calcularValoresCuota(prestamo.getInteres(), cuotaActual, cuotaSiguiente);
        }
        
        ajustarUltimaCuota(prestamo.getCuotas()[prestamo.getPlazo() - 1]);
    }
    
    private static void calcularValoresCuota(double interesAnual, Cuota cuotaActual, Cuota cuotaSiguiente) {
        double tasaInteresMensual = interesAnual / 100 / 12;
        
        double interes = cuotaActual.getInicio() * tasaInteresMensual;
        cuotaActual.setInteres(interes);
        
        double abonoCapital = cuotaActual.getCuota() - interes;
        cuotaActual.setAbonoCapital(abonoCapital);
        
        double saldo = cuotaActual.getInicio() - abonoCapital;
        cuotaActual.setSaldo(saldo);
        
        if (cuotaSiguiente != null) {
            cuotaSiguiente.setInicio(saldo);
        }
    }
    
    private static void ajustarUltimaCuota(Cuota ultimaCuota) {
        double diferencia = ultimaCuota.getSaldo();
        if (Math.abs(diferencia) > 0.01) {
            double nuevaCuota = ultimaCuota.getCuota() + diferencia;
            ultimaCuota.setCuota(nuevaCuota);
            
            double nuevoAbonoCapital = ultimaCuota.getAbonoCapital() + diferencia;
            ultimaCuota.setAbonoCapital(nuevoAbonoCapital);
            
            ultimaCuota.setSaldo(0.0);
        }
    }
    
    public static void mostrarTabla(Prestamo prestamo) {
        System.out.println("Nº | Cuota | Inicio | Interés | Abono Capital | Saldo");
        System.out.println("------------------------------------------------------");
        
        for (Cuota cuota : prestamo.getCuotas()) {
            cuota.mostrarPrestamo();
        }
    }
}