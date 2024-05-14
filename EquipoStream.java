import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EquipoStream {

    private int numeroj;
    private String equipito;
    // private int numeroGoles;

    //Creo unas constantes que me srviran despues
    private static final NombreEquipo[] NOMBREEQUIPO = NombreEquipo.values();
    private static final String[] POSICIONDEFENSA = { "Defesa lateral", "Defensa central" };
    private static final CalidadJugador[] CALIDADJUGADORES = CalidadJugador.values();
    private static final String[] POSICIONES = { "Arquero", "Defensa", "Volante", "Delantero" };
    private static final Random random = new Random();


    /** Lista que almacena los equipos de fútbol. */
    private List<EquipoFutbol> equiposEs;

    /**
     * Constructor de la clase EquipoStream.
     * Inicializa la lista de equipos de fútbol.
     */
    public EquipoStream() {
        equiposEs = new ArrayList<>();
    }

/**
 * Agrega un equipo de fútbol al stream.
 * 
 *  equipo, El equipo de fútbol a agregar.
 *  true si el equipo se agregó exitosamente, false si el número del jugador ya está en uso.
 * Estas dos variables me serviran para despues
 */
public boolean agregarEquipoStream(EquipoFutbol equipo) {
    // Se itera sobre cada equipo existente en la lista
    for (EquipoFutbol e : equiposEs) {
        // Verifica si el nombre del equipo y el número del jugador ya existen
        if (e.getEquipo().equals(equipo.getEquipo()) && e.getNumeroJugador() == equipo.getNumeroJugador()) {
            // Si encuentra una coincidencia, imprime un mensaje y devuelve false
            System.out.println("El número del jugador está repetido");
            return false;
        }
    }
    // Si no se encuentra ninguna coincidencia, agrega el equipo a la lista y devuelve true
    equiposEs.add(equipo);
    return true;
}

/**
 * Imprime en la consola la representación de cadena de cada equipo de fútbol.
 */
public void mostrarEquipoStream() {
    // Itera sobre cada equipo en la lista de equipos
    for (EquipoFutbol e : equiposEs) {
        // Imprime en la consola la representación de cadena del equipo
        System.out.println(e);
    }
}

    public void organizarConStreams() {
        //Si la lista esta vacia entonces imprimo el mensaje sino hace la otra operacion
        if (equiposEs.size() == 0) {
            System.out.println();
            System.out.println("Error, por favor ingrese datos");
            System.out.println("Para ingresar datos selecciones la opcion 1 del menu a continuacion");
            System.out.println("Donde dice generar un equipo aleatoriamnete");
            System.out.println();
        }else{
        // Crear un stream a partir de la lista de equipos
        Stream<EquipoFutbol> equipoStream = equiposEs.stream();
        // En esta linea cogemos el equipoStream el .sorted nos ordena dependiendo del
        // dato en este caso String
        // comparamos con el metodo comparing de la clase Comparator
        // Depues de esto la sguinete linea nos dice que va a comparar segun el
        // getEquipo de la clase EquipoFutbol
        Stream<EquipoFutbol> equiposOrdenados = equipoStream.sorted(Comparator.comparing(EquipoFutbol::getEquipo));

        // Imprimir los equipos ordenados
        equiposOrdenados.forEach(System.out::println);
        }
    }// Fin funcion

/**
 * Filtra los equipos de fútbol en el stream según el número de goles y muestra los que tienen 5 o más goles.
 * Si la lista de equipos está vacía, muestra un mensaje de error indicando que no hay datos disponibles.
 */
public void filtrarMayores5() {
    // Verifica si la lista de equipos está vacía
    if (equiposEs.size() == 0) {
        // Si está vacía, muestra un mensaje de error y las instrucciones para ingresar datos
        System.out.println();
        System.out.println("Error, por favor ingrese datos");
        System.out.println("Para ingresar datos seleccione la opción 1 del menú a continuación");
        System.out.println("Donde dice generar un equipo aleatoriamente");
        System.out.println();
    } else {
        // Si la lista de equipos no está vacía, filtra los equipos con 5 o más goles
        Stream<EquipoFutbol> equipoStream = equiposEs.stream();
        List<EquipoFutbol> filtrarMayores5 = equipoStream
                                .filter(equipo -> equipo.getNumeroGoles() >= 5)
                                .collect(Collectors.toList());

        // Imprime los equipos que cumplen con el criterio
        System.out.println("Equipos que cumplen:");
        filtrarMayores5.forEach(System.out::println);
    }
}

/**
 * Supplier que genera un equipo de fútbol aleatorio.
 * 
 * Retorna Un objeto EquipoFutbol que representa un equipo de fútbol generado aleatoriamente.
 */
Supplier<EquipoFutbol> generarEquipoAleatorio = () -> {
    // Selecciona aleatoriamente un nombre de equipo, una posición, y una calidad de jugador
    NombreEquipo nombreEquipo = NOMBREEQUIPO[random.nextInt(NOMBREEQUIPO.length)];
    String posiciones = POSICIONES[random.nextInt(POSICIONES.length)];
    CalidadJugador calidadJugadores = CALIDADJUGADORES[random.nextInt(CALIDADJUGADORES.length)];
    String posicionDefensa = POSICIONDEFENSA[random.nextInt(POSICIONDEFENSA.length)];

    // Genera valores aleatorios para los atributos del equipo de fútbol
    String nombreEquipitoString = nombreEquipo.getnom();
    int numeroJugador = random.nextInt(50) + 1;
    int numeroGoles = random.nextInt(10) + 1;
    int numeroPases = random.nextInt(31) + 1;
    int numeroAutoGoles = random.nextInt(2) + 1;
    double salarioJugador = Math.round((random.nextDouble() * 1000000 + 500000) * 100.0) / 100.0;

    // Atributos para la clase Arquero
    int golesTapadosArquero = random.nextInt(21) + 1;
    CalidadJugador agilidadManos = calidadJugadores;
    CalidadJugador salidaEnFalso = calidadJugadores;
    CalidadJugador juegoAereoDefensivo = calidadJugadores;

    // Atributos para la clase Defensa
    CalidadJugador liderazgoDefensivo = calidadJugadores;
    CalidadJugador tackle = calidadJugadores;
    CalidadJugador marcajeAlHombre = calidadJugadores;

    // Atributos para la clase Delantero
    CalidadJugador desmarque = calidadJugadores;
    CalidadJugador rematePrimera = calidadJugadores;
    int golesAnotadosPartido = random.nextInt(8) + 1;
    CalidadJugador presicionTiros = calidadJugadores;

    // Selecciona aleatoriamente el tipo de clase para el equipo
    int definirClase = random.nextInt(3) + 1;

    // Crea un objeto EquipoFutbol según el tipo de clase seleccionado
    EquipoFutbol equipoFutbol = null;
    switch (definirClase) {
        case 1:
            equipoFutbol = new Arquero(nombreEquipitoString, posiciones, nombreEquipo, numeroJugador,
                    numeroGoles, numeroPases, numeroAutoGoles, salarioJugador, golesTapadosArquero,
                    agilidadManos, salidaEnFalso, juegoAereoDefensivo);
            break;
        case 2:
            equipoFutbol = new Defensa(nombreEquipitoString, posiciones, nombreEquipo, numeroJugador,
                    numeroGoles, numeroPases, numeroAutoGoles, salarioJugador, liderazgoDefensivo,
                    posicionDefensa, tackle, marcajeAlHombre);
            break;
        case 3:
            equipoFutbol = new Delantero(nombreEquipitoString, posiciones, nombreEquipo, numeroJugador,
                    numeroGoles, numeroPases, numeroAutoGoles, salarioJugador, desmarque,
                    rematePrimera, golesAnotadosPartido, presicionTiros);
            break;
    }
    // Nos retorna un tipo EquipoFutbol
    return equipoFutbol;
};

/**
 * Supplier que genera un partido de fútbol entre dos equipos.
 * 
 * Retorna un objeto GenerarPartido que representa un partido de fútbol generado aleatoriamente.
 */
Supplier<GenerarPartido> partidoEntreEquipos = () -> {
    // Arrays de posiciones, nombres de jugadores y nombres de equipos
    String[] POSICIONES = { "Arquero", "Defensa", "Delantero" };
    String[] NOMBRES_JUGADORES = { "Kevin Quintero", "Adrian Lopez", "Gloria Lora", "Juan Pablo", "Bertulio Perez" };
    String[] NOMBRES_EQUIPOS_LOCAL = { "Atletico Nacional", "Medellin", "Millonarios" };
    String[] NOMBRES_EQUIPOS_VISITANTE = { "Junior", "Once Caldas", "Deportivo Cali" };
    // Número máximo de goles que pueden anotar en el partido
    int NUMERO_MAXIMO_GOLES = 3;
    // Objeto Random para generar valores aleatorios
    Random random = new Random();

    // Selecciona aleatoriamente un nombre de jugador, una posición, y un número de goles
    String nombreJugador = NOMBRES_JUGADORES[random.nextInt(NOMBRES_JUGADORES.length)];
    String posicion = POSICIONES[random.nextInt(POSICIONES.length)];
    // En la linea de abajo le digo que me va a generar numero entre el 1 y 3
    int numeroGoles = random.nextInt(NUMERO_MAXIMO_GOLES) + 1;
    // Selecciona aleatoriamente nombres de equipos locales y visitantes
    String nombreEquipoLocal = NOMBRES_EQUIPOS_LOCAL[random.nextInt(NOMBRES_EQUIPOS_LOCAL.length)];
    String nombreEquipoVisitante = NOMBRES_EQUIPOS_VISITANTE[random.nextInt(NOMBRES_EQUIPOS_VISITANTE.length)];

    // Crea un objeto GenerarPartido con los valores generados aleatoriamente
    GenerarPartido generar = new GenerarPartido(nombreJugador, posicion, nombreEquipoLocal, nombreEquipoVisitante,numeroGoles);
        // Retorno un tipo GenerarPartido
    return generar;
};

/**
 * Consumer que calcula y muestra el número total de goles anotados por todos los equipos en el stream.
 * 
 * Recibe equipoStream El stream de equipos de fútbol.
 */
Consumer<EquipoStream> SumarGolesEquipoStream =  (equipoStream) -> {
    // Verifica si la lista de equipos está vacía
    if (equiposEs.size() == 0) {
        // Si está vacía, muestra un mensaje de error y las instrucciones para ingresar datos
        System.out.println();
        System.out.println("Ingrese datos para utilizar esta opción");
        System.out.println("Para ingresar datos, seleccione la opción 1 de este menú");
        System.out.println("Donde dice generar un equipo aleatoriamente");
        System.out.println();
    } else {
        // Si la lista de equipos no está vacía, calcula el total de goles
        int totalGoles = 0;
        // Itera sobre el ArrayList y obtiene la cantidad de goles anotados
        for (EquipoFutbol e : equiposEs) {
            totalGoles += e.getNumeroGoles(); 
        }
        // Muestra el número total de goles
        System.out.println("El número total de goles es: " + totalGoles);
    }
};


    /////////////////////////////////////////////////
    // getter and setters
    public int getNumeroj() {
        return numeroj;
    }

    public void setNumeroj(int numeroj) {
        this.numeroj = numeroj;
    }

    public String getEquipito() {
        return equipito;
    }

    public void setEquipito(String equipito) {
        this.equipito = equipito;
    }


}