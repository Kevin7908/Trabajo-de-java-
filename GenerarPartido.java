import java.util.Random;

public class GenerarPartido {

    // Atributos de la clase GenerarPartido
    private String nombre;
    private String posicion;
    private String nombreEquipoLocal;
    private String nombreEquipoVisitantes;
    private int numeroGoles;

    // Decalaramos un objeto de Ramdon como statica para utilizarla donde queramos
    public static final Random random = new Random();

    /* 
     Esta funcion recibe como parametra una funcion un equipoLocal y equipoVisitante y retorna un vector int
     itera 6  y en el bloque de try y catch por cada iteracion espera 5 segundos
     nos crea un booleano ramdom en el cual si es true entra y obtiene el nombre del jugador del equipo local
     y muestra pues un mensajito, si el booleano generado aleatoriamente es false entonces se va para el else
     y obtiene el nombre del jugador y muestra un mensajito
     Por ultimo cuando acaba la ejecucion del ciclo sale y las variables goles se las envio al vector y las retorno
     recordemos que este vector es el encargado de mostrar cuantos goles hizo cada jugador 
    */
    public int[] imprimirPartido(GenerarPartido equipoLocal, GenerarPartido equipoVisitante) {
        // Creamos dos variables para ir sumando los goles 
        int golesLocal = 0, golesVisitante = 0;
        for (int i = 0; i < 6; i++) {

            try {
                Thread.sleep(5000); // Esperar 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Simulamos un evento de gol
            if (random.nextBoolean()) {
                System.out.println(
                        "¡GOL! " + equipoLocal.getNombre() + " del equipo " + equipoLocal.getNombreEquipoLocal() +
                                " anota un gol en la posición " + equipoLocal.getPosicion());
                // Sumamos un gol si entra aca
                golesLocal += 1;
            } else {
                System.out.println("¡GOL! " + equipoVisitante.getNombre() + " del equipo "
                        + equipoVisitante.getNombreEquipoVisitantes() +
                        " anota un gol en la posición " + equipoVisitante.getPosicion());
                // Sumamos un gol si entra aca
                golesVisitante += 1;
            }
        }
        //Retornamos el vector
        int vec[] = { golesLocal, golesVisitante };
        return vec;

    }

    /*
     Esta funcion recibe como parametra una funcion un equipoLocal, equipoVisitante y un vector que guarda
     el numero de goles de cada jugador, imprimer unas cositas obteniendo una informacioncon get
     golesEquipos[0] es el numero de goles hecho por el equipo local y golesEquipos[1] los goles del 
     equipo visitante
     */
    public void ResumenPartido(GenerarPartido equipoLocal, GenerarPartido equipoVisitante, int[] golesEquipos) {
        // Imprimimos el resumen
        System.out.println("------ RESUMEN DEL PARTIDO ------");
        System.out.println("Goles anotados por " + equipoLocal.getNombreEquipoVisitantes() + ": " + golesEquipos[0]);
        System.out.println(
                "Goles anotados por " + equipoVisitante.getNombreEquipoVisitantes() + ": " + golesEquipos[1]);
        System.out.println("Marcador final: " + equipoLocal.getNombreEquipoLocal() + " " + golesEquipos[0] + " - "
                + golesEquipos[1] + " " + equipoVisitante.getNombreEquipoVisitantes());
    }
// Creamos un constructor con todos los parametros
    public GenerarPartido(String nombre, String posicion, String nombreEquipoLocal, String nombreEquipoVisitantes,
            int numeroGoles) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitantes = nombreEquipoVisitantes;
        this.numeroGoles = numeroGoles;
    }
    // Creamos un constructor vacio
    public GenerarPartido() {
    }
    // Getters and Setters
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }

    public void setNombreEquipoLocal(String nombreEquipoLocal) {
        this.nombreEquipoLocal = nombreEquipoLocal;
    }

    public String getNombreEquipoVisitantes() {
        return nombreEquipoVisitantes;
    }

    public void setNombreEquipoVisitantes(String nombreEquipoVisitantes) {
        this.nombreEquipoVisitantes = nombreEquipoVisitantes;
    }

    public int getNumeroGoles() {
        return numeroGoles;
    }

    public void setNumeroGoles(int numeroGoles) {
        this.numeroGoles = numeroGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
