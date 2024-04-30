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

    private static final NombreEquipo[] NOMBREEQUIPO = NombreEquipo.values();
    private static final String[] POSICIONDEFENSA = { "Defesa lateral", "Defensa central" };
    private static final CalidadJugador[] CALIDADJUGADORES = CalidadJugador.values();
    private static final String[] POSICIONES = { "Arquero", "Defensa", "Volante", "Delantero" };
    private static final Random random = new Random();

    List<EquipoFutbol> equiposEs;

    public EquipoStream() {
        equiposEs = new ArrayList<>();
    }

    public boolean agregarEquipoStream(EquipoFutbol equipo) {
        for (EquipoFutbol e : equiposEs) {
            if (e.getEquipo().equals(equipo.getEquipo()) && e.getNumeroJugador() == equipo.getNumeroJugador()) {
                System.out.println("El número del jugador está repetido");
                return false; // Termina el método si encuentra un jugador con el mismo número
            }
        }
        equiposEs.add(equipo);
        return true;
    }

    public void mostrarEquipoStream() {
        for (EquipoFutbol e : equiposEs) {
            System.out.println(e);
        }
    }

    public void organizarConStreams() {
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

    public void filtrarMayores5(){
        if (equiposEs.size() == 0) {
            System.out.println();
            System.out.println("Error, por favor ingrese datos");
            System.out.println("Para ingresar datos selecciones la opcion 1 del menu a continuacion");
            System.out.println("Donde dice generar un equipo aleatoriamnete");
            System.out.println();
        }else{
            Stream<EquipoFutbol> equipoStream = equiposEs.stream();
        List<EquipoFutbol> filtrarMayores5 = equipoStream
                                .filter(equipo -> equipo.getNumeroGoles() >= 5)
                                .collect(Collectors.toList());

        System.out.println("Equipos que cumplen");
        filtrarMayores5.forEach(System.out::println);

        }
    }

    Supplier<EquipoFutbol> generarEquipoAleatorio = () -> {

        NombreEquipo nombreEquipo = NOMBREEQUIPO[random.nextInt(NOMBREEQUIPO.length)];
        String posiciones = POSICIONES[random.nextInt(POSICIONES.length)];
        CalidadJugador calidadJugadores = CALIDADJUGADORES[random.nextInt(CALIDADJUGADORES.length)];
        String posicionDefensa = POSICIONDEFENSA[random.nextInt(POSICIONDEFENSA.length)];

        String nombreEquipitoString = nombreEquipo.getnom();
        this.setEquipito(nombreEquipitoString);
        int numeroJugador = random.nextInt(50) + 1;
        this.setNumeroj(numeroJugador);
        int numeroGoles = random.nextInt(10) + 1;
        int numeroPases = random.nextInt(31) + 1;
        int numeroAutoGoles = random.nextInt(2) + 1;
        double salarioJugador = Math.round((random.nextDouble() * 1000000 + 500000) * 100.0) / 100.0;
        // para arquero
        int golesTapadosArquero = random.nextInt(21) + 1;
        CalidadJugador agilidadManos = calidadJugadores;
        CalidadJugador salidaEnFalso = calidadJugadores;
        CalidadJugador juegoAereoDefensivo = calidadJugadores;
        // para defensa
        CalidadJugador liderazgoDefensivo = calidadJugadores;
        // aca va la posicion que esta arriba
        CalidadJugador tackle = calidadJugadores;
        CalidadJugador marcajeAlHombre = calidadJugadores;
        // para delantero
        CalidadJugador desmarque = calidadJugadores;
        CalidadJugador rematePrimera = calidadJugadores;
        int golesAnotadosPartido = random.nextInt(8) + 1;
        CalidadJugador presicionTiros = calidadJugadores;
        // definir clase
        int definirClase = random.nextInt(3) + 1;

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

        return equipoFutbol;
    };// Fin funcion

    ///////////////////////////////////////////////////////////////
    Supplier<GenerarPartido> partidoEntreEquipos = () -> {
        Random random = new Random();
        String[] POSICIONES = { "Arquero", "Defensa", "Delantero" };
        String[] NOMBRES_JUGADORES = { "Kevin Quintero", "Adrian Lopez", "Gloria Lora", "Juan Pablo",
                "Bertulio Perez" };
        String[] NOMBRES_EQUIPOS_LOCAL = { "Atletico Nacional", "Medellin", "Millonarios" };
        String[] NOMBRES_EQUIPOS_VISITANTE = { "Junior", "Once Caldas", "Deportivo Cali" };
        int NUMERO_MAXIMO_GOLES = 2;

        String nombreJugador = NOMBRES_JUGADORES[random.nextInt(NOMBRES_JUGADORES.length)];
        String posicion = POSICIONES[random.nextInt(POSICIONES.length)];
        int numeroGoles = random.nextInt(NUMERO_MAXIMO_GOLES) + 1;
        String nombreEquipoLocal = NOMBRES_EQUIPOS_LOCAL[random.nextInt(NOMBRES_EQUIPOS_LOCAL.length)];
        String nombreEquipoVisitante = NOMBRES_EQUIPOS_VISITANTE[random.nextInt(NOMBRES_EQUIPOS_VISITANTE.length)];

        GenerarPartido generar = new GenerarPartido(nombreJugador, posicion, nombreEquipoLocal, nombreEquipoVisitante,
                numeroGoles);
        return generar;

    };// Fin funcion

    Consumer<EquipoStream> SumarGolesEquipoStream =  (equipoStream) ->{
        if (equiposEs.size() == 0) {
            System.out.println();
            System.out.println("Ingrese datos para utilizar esta opcion");
            System.out.println("Para ingresar datos solo ponga la opcion 1 de este menu");
            System.out.println("Donde dice generar un equipo aleatoriamnete");
            System.out.println();
        }else{
            int totalGoles = 0;
            for (EquipoFutbol e : equiposEs) {
                totalGoles += e.getNumeroGoles(); 
            }
            System.out.println("El numero total de goles es: "+totalGoles);
        }
    };//Fin funcion


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