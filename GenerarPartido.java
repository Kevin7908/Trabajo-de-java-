import java.util.Random;

public class GenerarPartido {

    private String nombre;
    private String posicion;
    private String nombreEquipoLocal;
    private String nombreEquipoVisitantes;
    private int numeroGoles;

    public static final Random random = new Random();

    public int[] imprimirPartido(GenerarPartido equipoLocal, GenerarPartido equipoVisitante) {
        int golesLocal = 0, golesVisitante = 0;
        for (int i = 0; i < 4; i++) {

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
                golesLocal += 1;
            } else {
                System.out.println("¡GOL! " + equipoVisitante.getNombre() + " del equipo "
                        + equipoVisitante.getNombreEquipoVisitantes() +
                        " anota un gol en la posición " + equipoVisitante.getPosicion());
                golesVisitante += 1;
            }
        }
        int vec[] = { golesLocal, golesVisitante };
        return vec;

    }

    public void ResumenPartido(GenerarPartido equipoLocal, GenerarPartido equipoVisitante, int[] golesEquipos) {
        // Imprimimos el resumen
        System.out.println("------ RESUMEN DEL PARTIDO ------");
        System.out.println("Goles anotados por " + equipoLocal.getNombreEquipoVisitantes() + ": " + golesEquipos[0]);
        System.out.println(
                "Goles anotados por " + equipoVisitante.getNombreEquipoVisitantes() + ": " + golesEquipos[1]);
        System.out.println("Marcador final: " + equipoLocal.getNombreEquipoLocal() + " " + golesEquipos[0] + " - "
                + golesEquipos[1] + " " + equipoVisitante.getNombreEquipoVisitantes());
    }

    public GenerarPartido(String nombre, String posicion, String nombreEquipoLocal, String nombreEquipoVisitantes,
            int numeroGoles) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitantes = nombreEquipoVisitantes;
        this.numeroGoles = numeroGoles;
    }

    public GenerarPartido() {
    }

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
