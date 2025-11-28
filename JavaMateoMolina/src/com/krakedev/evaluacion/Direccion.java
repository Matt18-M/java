package com.krakedev.evaluacion;

public class Direccion {
	private String callePrincipal;
    private String calleSecundaria;

    // Constructor
    public Direccion(String callePrincipal, String calleSecundaria) {
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
    }

    // Getters
    public String getCallePrincipal() {
        return callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    // Setters
    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }
}
