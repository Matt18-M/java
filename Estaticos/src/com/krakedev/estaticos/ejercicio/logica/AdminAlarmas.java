package com.krakedev.estaticos.ejercicio.logica;
import com.krakedev.estaticos.ejercicio.entidades.*;
import java.util.ArrayList;

public class AdminAlarmas {
	private ArrayList<Alarma> alarmas;

    public AdminAlarmas() {
        this.alarmas = new ArrayList<>();
    }

    public void agregarAlarma(Alarma alarma) {
        if (alarma != null) {
            alarmas.add(alarma);
        }
    }

    public ArrayList<Alarma> getAlarmas() {
        return alarmas;
    }
}
