import java.util.ArrayList;
import java.util.List;

//Como vemos la clase va a ser generico y su generico va a extender de EquipoFutbol
public class EquipoGenerico<T extends EquipoFutbol> {
    // Creamos una lista generica llamada equiposge
    private List<T> equiposge;

    public EquipoGenerico() {
        // Su constructor en donde decimos que la lista va a ser de tipo ArrayList
        equiposge = new ArrayList<>();
    }

    /**
     * Agrega un equipo genérico a la lista de equipos genéricos si no existe otro
     * equipo con el mismo número de jugador.
     *
     * parametro e, El equipo genérico que se desea agregar a la lista.
     * return true, si el equipo se agregó con éxito, false si el número de jugador
     * está repetido y el equipo no se agregó.
     */
    public boolean agregarEquipoGenerico(T e) {
        // Itera sobre la lista de equipos genéricos
        for (T equipo : equiposge) {
            // Verifica si hay otro equipo con el mismo número de jugador
            if (equipo.getEquipo().equals(e.getEquipo()) && equipo.getNumeroJugador() == e.getNumeroJugador()) {
                // Si encuentra un jugador con el mismo número, imprime un mensaje y devuelve
                // false
                System.out.println("El número del jugador está repetido");
                return false;
            }
        }
        // Si no se encuentra otro equipo con el mismo número de jugador, agrega el
        // equipo a la lista
        equiposge.add(e);
        return true; // Devuelve true indicando que el equipo se agregó con éxito
    }

    // Me retorna la lista
    public List<T> obtenerListaEquipos() {
        return equiposge;
    }

    public void mostrarEquipoGenerico(String equi, int num) {
        for (T equipo : equiposge) {
            if (equipo.getEquipo().equals(equi) && equipo.getNumeroJugador() == num) {
                System.out.println(equipo);
                return;
            }
        }
    }

}
