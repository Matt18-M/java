package servicios;
import entidades.*;
import java.util.ArrayList;

public class Juego {
    private Naipe naipe;
    private ArrayList<ArrayList<Carta>> cartasJugadores;
    private ArrayList<Carta> naipeBarajado;
    private ArrayList<String> idsJugadores;

    public Juego(ArrayList<String> idsJugadores) {
        this.naipe = new Naipe();
        this.cartasJugadores = new ArrayList<>();
        this.idsJugadores = new ArrayList<>(idsJugadores);
        this.naipeBarajado = naipe.barajar();
        
        for (int i = 0; i < idsJugadores.size(); i++) {
            ArrayList<Carta> cartasJugador = new ArrayList<>();
            cartasJugadores.add(cartasJugador);
        }
    }

    // Getters
    public Naipe getNaipe() {
        return naipe;
    }

    public ArrayList<ArrayList<Carta>> getCartasJugadores() {
        return cartasJugadores;
    }
    
    public ArrayList<Carta> getNaipeBarajado() {
        return naipeBarajado;
    }
    
    public ArrayList<String> getIdsJugadores() {
        return idsJugadores;
    }

    public void entregarCartas(int cartasPorJugador) {
        int totalJugadores = cartasJugadores.size();
        int cartaActual = 0;
        
        for (int ronda = 0; ronda < cartasPorJugador; ronda++) {
            for (int jugador = 0; jugador < totalJugadores; jugador++) {
                if (cartaActual < naipeBarajado.size()) {
                    Carta carta = naipeBarajado.get(cartaActual);
                    cartasJugadores.get(jugador).add(carta);
                    cartaActual++;
                } else {
                    System.out.println("¡No hay más cartas en el naipe!");
                    return;
                }
            }
        }
    }

    //Método devolverTotal
    
    public int devolverTotal(int indiceJugador) {
        if (indiceJugador < 0 || indiceJugador >= cartasJugadores.size()) {
            System.out.println("Error: Índice de jugador " + indiceJugador + " no válido.");
            return -1;
        }
        
        ArrayList<Carta> cartasJugador = cartasJugadores.get(indiceJugador);
        int total = 0;
        for (Carta carta : cartasJugador) {
            total += carta.getNumero().getValor();
        }
        
        return total;
    }

    //Método devolverTotal original que recibe ID del jugador
    
    public int devolverTotal(String idJugador) {
        int indiceJugador = idsJugadores.indexOf(idJugador);
        if (indiceJugador == -1) {
            System.out.println("Error: Jugador '" + idJugador + "' no encontrado.");
            return -1;
        }
        return devolverTotal(indiceJugador);
    }

    //Método determinarGanador 
    public String determinarGanador() {
        if (idsJugadores.isEmpty()) {
            System.out.println("No hay jugadores en el juego.");
            return null;
        }
        
        String idGanador = idsJugadores.get(0);
        int sumaGanador = devolverTotal(0);
        
        for (int i = 1; i < idsJugadores.size(); i++) {
            int sumaActual = devolverTotal(i);
            if (sumaActual >= sumaGanador) {
                idGanador = idsJugadores.get(i);
                sumaGanador = sumaActual;
            }
        }
        
        return idGanador;
    }

    public void mostrarInformacionJuego() {
        System.out.println("=== INFORMACIÓN DEL JUEGO ===");
        System.out.println("Total de jugadores: " + cartasJugadores.size());
        System.out.println("Cartas en naipe barajado: " + naipeBarajado.size());
        
        for (int i = 0; i < cartasJugadores.size(); i++) {
            String idJugador = idsJugadores.get(i);
            int total = devolverTotal(i);
            System.out.println("Jugador " + (i + 1) + " (" + idJugador + "): " + 
                             cartasJugadores.get(i).size() + " cartas, " +
                             "Total: " + total + " puntos");
        }
    }
    
    public void mostrarCartasJugadores() {
        System.out.println("=== CARTAS DE LOS JUGADORES ===");
        for (int i = 0; i < cartasJugadores.size(); i++) {
            String idJugador = idsJugadores.get(i);
            int total = devolverTotal(i);
            
            System.out.println("Jugador " + (i + 1) + " (" + idJugador + ") - Total: " + total + " puntos:");
            ArrayList<Carta> cartas = cartasJugadores.get(i);
            if (cartas.isEmpty()) {
                System.out.println("  No tiene cartas");
            } else {
                for (Carta carta : cartas) {
                    System.out.print("  ");
                    carta.mostrarInformacion();
                }
            }
            System.out.println();
        }
    }
}