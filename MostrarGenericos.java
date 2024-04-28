import java.util.Scanner;

public class MostrarGenericos {
    //volvemos statico el Scanner para utilizarlo donde queramos
    static Scanner teclado = new Scanner(System.in);
    //Lo mismo con esta funcion se vuelve statica y va a retornar algo de tipo NombreEquipo
    static NombreEquipo mostrarEquipos() {
        // Mostrar la lista de equipos
        System.out.println();
        int c = 1;
        for (NombreEquipo nombreEquipo : NombreEquipo.values()) {
            System.out.println(c + ". " + nombreEquipo.getnom());
            c++;
        }

        // Capturar el número del equipo
        System.out.println("Ingrese el número del equipo:");
        int numeroEquipo;
        try {
            // Intenta convertir la entrada del usuario en un número entero
            numeroEquipo = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            // Si ocurre un error durante la conversión, se ejecuta este bloque de código
            // Se imprime un mensaje de error en la consola
            System.out.println("Error: Por favor ingrese un número válido.");
            // Se devuelve null para indicar que no se pudo obtener un número válido
            return null;
        }

        // Verificar si el número de equipo está dentro del rango válido
        if (numeroEquipo >= 1 && numeroEquipo <= NombreEquipo.values().length) {
            // Obtener el nombre del equipo correspondiente al número ingresado
            //Se retorna algo de tipo NombreEquipo el .values() nos devuelve un array que contiene todos
            //los valores de la enumeración, [numeroEquipo - 1] esta es la varible con el numero que elijio
            //el usuario y -1 para que no no salge el error de index bounds 
            //y asi nos retorna una enumeracion dependiendo del numero que elijio el usuario
            return NombreEquipo.values()[numeroEquipo - 1];
        } else {
            System.out.println("Número de equipo fuera de rango.");
            return null; // Devolver null si el número está fuera de rango
        }

    }//fin funcion
//Lo mismo con esta funcion se vuelve statica y va a retornar algo de tipo NombreEquipo
    static CalidadJugador mostrarCalidad(){
        // Mostrar la lista de equipos
        int c = 1;
        for (CalidadJugador calidad : CalidadJugador.values()) {
            System.out.println(c + ". " + calidad);
            c++;
        }
        //pedimos y leeamos el numero que se ingreso 
        System.out.println("Ingrese el número correspondiente: ");
        int numeroCalidad = 0;

        try {
            // Intenta convertir la entrada del usuario en un número entero
            numeroCalidad = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            // Si ocurre un error durante la conversión, se ejecuta este bloque de código
            // Se imprime un mensaje de error en la consola
            System.out.println("Error: Por favor ingrese un número válido.");
            // Se devuelve null para indicar que no se pudo obtener un número válido
            return null; // Devolver null si se produce un error
        }

        // Verificar si el número de calidad está dentro del rango válido
        if (numeroCalidad >= 1 && numeroCalidad <= CalidadJugador.values().length) {
            // Obtener la calidad del jugador correspondiente al número ingresado
            return CalidadJugador.values()[numeroCalidad - 1];
        } else {
            System.out.println("Número de calidad fuera de rango.");
            return null; // Devolver null si el número está fuera de rango
        }
    }//fin funcion

}
