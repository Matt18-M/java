package com.krakedev.evaluacion;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Directorio {
    private ArrayList<Contacto> contactos;
    private ArrayList<Contacto> correctos;
    private ArrayList<Contacto> incorrectos;
    private Date fechaModificacion;

    // Constructor
    public Directorio() {
        this.contactos = new ArrayList<Contacto>();
        this.correctos = new ArrayList<Contacto>();
        this.incorrectos = new ArrayList<Contacto>();
        this.fechaModificacion = new Date();
    }

    // Getters
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public ArrayList<Contacto> getCorrectos() {
        return correctos;
    }

    public ArrayList<Contacto> getIncorrectos() {
        return incorrectos;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    // Setters
    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
        this.fechaModificacion = new Date();
    }

    public void setCorrectos(ArrayList<Contacto> correctos) {
        this.correctos = correctos;
    }

    public void setIncorrectos(ArrayList<Contacto> incorrectos) {
        this.incorrectos = incorrectos;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    // metodo para agregar un contacto con validación de cédula única
    public boolean agregarContacto(Contacto contacto) {
        
        if (buscarPorCedula(contacto.getCedula()) != null) {
            return false; 
        }
        
        // si no existe, agregar el contacto
        boolean agregado = contactos.add(contacto);
        if (agregado) {
            this.fechaModificacion = new Date(); // Actualizar fecha
        }
        return agregado;
    }

    // metodo para buscar un contacto por cédula 
    public Contacto buscarPorCedula(String cedula) {
        for (Contacto contacto : contactos) {
            if (contacto.getCedula().equals(cedula)) {
                return contacto;
            }
        }
        return null;
    }

    // Método para consultar la última modificación
    public String consultarUltimaModificacion() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formato.format(fechaModificacion);
    }

    // Método para contar contactos sin dirección asignada
    public int contarPerdidos() {
        int contador = 0;
        
        for (Contacto contacto : contactos) {
            if (contacto.getDireccion() == null) {
                contador++;
            }
        }
        
        return contador;
    }

    // Método para contar contactos con teléfono Convencional en estado C
    public int contarFijos() {
        int contador = 0;
        
        for (Contacto contacto : contactos) {
            ArrayList<Telefono> telefonos = contacto.getTelefonos();
            boolean tieneFijoCorrecto = false;
            
            for (Telefono telefono : telefonos) {
                if ("Convencional".equals(telefono.getTipo()) && "C".equals(telefono.getEstado())) {
                    tieneFijoCorrecto = true;
                }
            }
            
            if (tieneFijoCorrecto) {
                contador++;
            }
        }
        
        return contador;
    }

    // Método para saber si el contacto tiene direccon o no
    public void depurar() {
        
        correctos.clear();
        incorrectos.clear();
        
        
        for (Contacto contacto : contactos) {
            if (contacto.getDireccion() != null) {
                correctos.add(contacto); 
            } else {
                incorrectos.add(contacto); // Sin dirección
            }
        }
        
        // Vaciar la lista 
        contactos.clear();
        
        // Actualizar fecha de modificación
        this.fechaModificacion = new Date();
    }
}