package com.clearminds.maquina;
import com.clearminds.componentes.*;

public class MaquinaDulces {
    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Celda celda4;
    private double saldo;

    // Constructor
    public MaquinaDulces() {
    }

    // Método configurarMaquina
    public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
        this.celda1 = new Celda(codigo1);
        this.celda2 = new Celda(codigo2);
        this.celda3 = new Celda(codigo3);
        this.celda4 = new Celda(codigo4);
    }

    // Método mostrarConfiguración
    public void mostrarConfiguracion() {
        System.out.println("Configuración de la máquina:");
        System.out.println("Celda 1: " + celda1.getCodigo());
        System.out.println("Celda 2: " + celda2.getCodigo());
        System.out.println("Celda 3: " + celda3.getCodigo());
        System.out.println("Celda 4: " + celda4.getCodigo());
    }

    // Método buscarCelda
    public Celda buscarCelda(String codigoCelda) {
        if (celda1.getCodigo().equals(codigoCelda)) {
            return celda1;
        } else if (celda2.getCodigo().equals(codigoCelda)) {
            return celda2;
        } else if (celda3.getCodigo().equals(codigoCelda)) {
            return celda3;
        } else if (celda4.getCodigo().equals(codigoCelda)) {
            return celda4;
        } else {
            return null;
        }
    }

    // Método cargarProducto
    public void cargarProducto(Producto producto, String codigoCelda, int stockInicial) {
        Celda celdaRecuperada = buscarCelda(codigoCelda);
        if (celdaRecuperada != null) {
            celdaRecuperada.ingresarProducto(producto, stockInicial);
        }
    }

    // Método mostrarProductos CORREGIDO (solo un método)
    public void mostrarProductos() {
        System.out.println("*********CELDA " + celda1.getCodigo());
        imprimirCeldaInfo(celda1);
        
        System.out.println("*********CELDA " + celda2.getCodigo());
        imprimirCeldaInfo(celda2);
        
        System.out.println("*********CELDA " + celda3.getCodigo());
        imprimirCeldaInfo(celda3);
        
        System.out.println("*********CELDA " + celda4.getCodigo());
        imprimirCeldaInfo(celda4);
        
        System.out.println("Saldo: " + this.saldo);
    }

    // Método para imprimir información de una celda
    private void imprimirCeldaInfo(Celda celda) {
        System.out.println("Stock:" + celda.getStock());
        if (celda.getProducto() != null) {
            System.out.println("Nombre Producto:" + celda.getProducto().getNombre());
            System.out.println("Precio Producto:" + celda.getProducto().getPrecio());
            System.out.println("Código Producto:" + celda.getProducto().getCodigo());
        } else {
            System.out.println("La celda no tiene producto!!!");
        }
    }

    // Método buscarProductoEnCelda
    public Producto buscarProductoEnCelda(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getProducto() != null) {
            return celda.getProducto();
        }
        return null;
    }

    // Método consultarPrecio
    public double consultarPrecio(String codigoCelda) {
        Producto producto = buscarProductoEnCelda(codigoCelda);
        if (producto != null) {
            return producto.getPrecio();
        }
        return 0.0;
    }

    // Método buscarCeldaProducto
    public Celda buscarCeldaProducto(String codigoProducto) {
        if (celda1.getProducto() != null && celda1.getProducto().getCodigo().equals(codigoProducto)) {
            return celda1;
        } else if (celda2.getProducto() != null && celda2.getProducto().getCodigo().equals(codigoProducto)) {
            return celda2;
        } else if (celda3.getProducto() != null && celda3.getProducto().getCodigo().equals(codigoProducto)) {
            return celda3;
        } else if (celda4.getProducto() != null && celda4.getProducto().getCodigo().equals(codigoProducto)) {
            return celda4;
        } else {
            return null;
        }
    }

    // Método incrementarProductos
    public void incrementarProductos(String codigoProducto, int cantidadItems) {
        Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
        if (celdaEncontrada != null) {
            int stockActual = celdaEncontrada.getStock();
            celdaEncontrada.setStock(stockActual + cantidadItems);
        }
    }

    // Método vender
    public void vender(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getProducto() != null && celda.getStock() > 0) {
            // Disminuir stock en 1
            celda.setStock(celda.getStock() - 1);
            
            // Sumar precio al saldo
            double precioProducto = celda.getProducto().getPrecio();
            this.saldo += precioProducto;
        }
    }

    // Método venderConCambio
    public double venderConCambio(String codigoCelda, double valorIngresado) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getProducto() != null && celda.getStock() > 0) {
            double precioProducto = celda.getProducto().getPrecio();
            
            if (valorIngresado >= precioProducto) {
                // Disminuir stock en 1
                celda.setStock(celda.getStock() - 1);
                
                // Sumar precio al saldo
                this.saldo += precioProducto;
                
                // Calcular y retornar cambio
                return valorIngresado - precioProducto;
            }
        }
        return valorIngresado;
    }

    // Getters y Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}