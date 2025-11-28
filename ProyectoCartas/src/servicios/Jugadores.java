package servicios;
import entidades.*;
import java.util.ArrayList;

public class Jugadores {
    private ArrayList<String> jugadores;

    // Constructor
    public Jugadores() {
        this.jugadores = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }

    //Método para agregar un jugador
    public void agregarJugador(String jugador) {
        jugadores.add(jugador);
    }

    //Método para jugar
    public void jugar() {
        // Crear ArrayList de tipo String de jugadores
        ArrayList<String> listaJugadores = new ArrayList<>();
        listaJugadores.add("Jugador1");
        listaJugadores.add("Jugador2");
        listaJugadores.add("Jugador3");
        
        // Asignar la lista al atributo jugadores
        this.setJugadores(listaJugadores);
        
        // Crear un objeto de la clase Juego con el parámetro jugadores
        Juego juego = new Juego(listaJugadores);
        
        // Pasarle el método entregar cartas con un valor de 5
        juego.entregarCartas(5);
        
        // Mostrar los resultados a través de un for que recorra por el tamaño de los jugadores
        System.out.println("=== RESULTADOS DEL JUEGO ===");
        for (int i = 0; i < listaJugadores.size(); i++) {
            // Obtener las cartas del jugador actual
            ArrayList<Carta> cartasJugador = juego.getCartasJugadores().get(i);
            
            // Calcular el total del recorrido (suma de valores de las cartas)
            int total = 0;
            for (Carta carta : cartasJugador) {
                total += carta.getNumero().getValor();
            }
            
            // Imprimir el número del jugador y el total
            System.out.println("Jugador " + (i + 1) + " (" + listaJugadores.get(i) + "): " + 
                             total + " puntos");
        }
        
        // Crear una variable ganador y llamar al método determinarGanador
        String ganador = determinarGanador(juego);
        
        // Imprimir el ganador
        System.out.println("\n=== GANADOR ===");
        System.out.println("¡" + ganador + "!");
    }

    //Método para determinar el ganador
    private String determinarGanador(Juego juego) {
        ArrayList<ArrayList<Carta>> cartasJugadores = juego.getCartasJugadores();
        int maxPuntos = 0;
        String ganador = "";
        
        for (int i = 0; i < cartasJugadores.size(); i++) {
            int totalJugador = 0;
            ArrayList<Carta> cartas = cartasJugadores.get(i);
            
            // Calcular total de puntos del jugador
            for (Carta carta : cartas) {
                totalJugador += carta.getNumero().getValor();
            }
            
            // Verificar si es el máximo
            if (totalJugador > maxPuntos) {
                maxPuntos = totalJugador;
                ganador = "Jugador " + (i + 1) + " (" + jugadores.get(i) + ") con " + maxPuntos + " puntos";
            } else if (totalJugador == maxPuntos && maxPuntos > 0) {
                // En caso de empate
                ganador += " y Jugador " + (i + 1) + " (" + jugadores.get(i) + ") con " + maxPuntos + " puntos";
            }
        }
        
        return ganador;
    }
}
