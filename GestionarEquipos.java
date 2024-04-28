import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GestionarEquipos {
    //Creamos una lista de tipo Equipo Futbol
    private List<EquipoFutbol> equipos;

    public GestionarEquipos() {
        //Aca definimos que la lista va a ser Ede tipo ArrayList
        equipos = new ArrayList<>();
    }

    //Esta funcion recibe una clase seguido de eso nos damos cuenta de que se esta iterando sobre ella 
    //para ver si hay un equipo y numero de jugador repetido si esa asi entoces se retorna para que deje de
    //iterar y si no encunetra ninguna parecida entonces la agrega
    public void anadirEquipos(EquipoFutbol equipo) {
        for (EquipoFutbol e : equipos) {
            if (e.getEquipo().equals(equipo.getEquipo()) && e.getNumeroJugador() == equipo.getNumeroJugador()){
                System.out.println("El número del jugador está repetido");
                return; // Termina el método si encuentra un jugador con el mismo número
            }
        }
        equipos.add(equipo);
    }

/**
 * Muestra la información de todos los equipos de fútbol en la lista de equipos.
 */
public void mostrarEquipos() {
    // Itera sobre la lista de equipos de fútbol
    for (EquipoFutbol e : equipos) {
        // Imprime la información del equipo
        System.out.println(e);
    }
}

//esta fincion recibe el nombre de equipo a modificar y el numero jugador, tambien el equipo y numero nuevo
//itera sobre el arraylist llamado equipos, y en el if si el equipo que enviamos es igual al que se esta 
//iterado en ese momento y el numero de jugador tambien entonces entra setteamos con los nuevos datos
//y crrramos el ciclo
    public void modificarEquipos(int numju, String equi,int nuevoNumeroju, String nuevoEqui) {
        for (EquipoFutbol equipo : equipos) {
            if (equipo.getEquipo().equals(equi) && equipo.getNumeroJugador() == numju) {
                equipo.setNumeroJugador(nuevoNumeroju);
                equipo.setEquipo(nuevoEqui);
                break; // Rompe el bucle una vez que se han modificado los datos del equipo
            }
        }
    }


/**
 * Elimina un equipo de fútbol de la lista de equipos según el número de jugador y el nombre del equipo proporcionados.
 *
 * numju El número de jugador del equipo que se desea eliminar.
 *  equi El nombre del equipo que se desea eliminar.
 */
public void eliminarEquipos(int numju, String equi) {
    // Se crea un iterador sobre la lista de equipos de fútbol.
    Iterator<EquipoFutbol> iterator = equipos.iterator();
    // Se recorre la lista utilizando el iterador.
    while (iterator.hasNext()) {
        // Se obtiene el próximo equipo de fútbol en la lista.
        EquipoFutbol equipoFutbol = iterator.next();
        // Se verifica si el número de jugador y el nombre del equipo coinciden con los proporcionados.
        if (equipoFutbol.getNumeroJugador() == numju && equipoFutbol.getEquipo().equals(equi)) {
            // Si coinciden, se elimina el equipo de la lista.
            iterator.remove();
        }
    }
}

/**
 * Muestra la información de un equipo de fútbol específico que coincide con el número de jugador y el nombre del equipo dados.
 *
 * parametro numJu, El número de jugador del equipo que se desea mostrar.
 * parametro nomEqui, El nombre del equipo al que pertenece el jugador que se desea mostrar.
 */
public void mostrarEquipoEspecifico(int numJu, String nomEqui) {
    // Itera sobre la lista de equipos de fútbol
    for (EquipoFutbol e : equipos) {
        // Comprueba si el nombre del equipo y el número de jugador coinciden con los proporcionados
        if (nomEqui.equals(e.getEquipo()) && numJu == e.getNumeroJugador()) {
            // Si coinciden, imprime la información del equipo
            System.out.println(e);
        }
    }
}


//para empezar notamos que le llega la clase EquipoGenerico pero esta trae consigo un comodin que extiende
// de EquipoFutbol, ademas recibe una variable booleana b
//pregunta si b == true, y aca nos devolvenos a equipo generico para ser mas especifico agregarEquipoGnerico
//la cual nos retornaba false si el jugador estaba repetido 
//entonces si el jugador no esta repetido me retorna true y entra en el if, aca le decimos que al arralist
//de la clase gestionar le agregue equipo generico, y lo que hace la funcion obtenerListaEquipo es retornarme
//el arraylist de equipogenerico con los datos que ingrese si no me muestra un mensaje 
    public void agregarEquiposDesdeGenerico(EquipoGenerico<? extends EquipoFutbol> equipoGenerico,boolean b) {
        if (b == true) {
            equipos.addAll(equipoGenerico.obtenerListaEquipos());
        }else{
            System.out.println("esta lista esta repetida");
        }
        
    }

//Esta funcion recibe nombreEquipo yel numero de jugador
//itera sobre el arraylist llamado equipos
//en el if si cumple con la condicion de que si el nombre que le enviamos es igual al que esta en ese 
//momento es igual y el numero tambien, entonces entra y nos retorna true, si no false 
    public boolean repetido( String equi, int numeroJugador) {
        for (EquipoFutbol equipoFutbol : equipos) {
            if (equipoFutbol.getEquipo().equals(equi) && equipoFutbol.getNumeroJugador() == numeroJugador) {
                return true; // Jugador repetido encontrado
            }
        }
        return false; // No se encontró jugador repetido
    }   

}
