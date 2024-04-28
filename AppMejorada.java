
import java.util.Scanner;

public class AppMejorada {

    public static void main(String[] args) {
        //Hago una instancia de la funcion menu
        menu();
    }

    public static void menu() {
        EquipoStream equipoStream =  new EquipoStream();
        //creo un objeto de tipo Scanner para ingresar datos
        Scanner t = new Scanner(System.in);
        //creo un objeto tipo Equipo Generico para ingresar datos
        EquipoGenerico<EquipoFutbol> equipoGenerico = new EquipoGenerico<>();
        //creo un objeto de tipo Gestionar Equipos para ingresar datos
        GestionarEquipos gestionar = new GestionarEquipos();
        //variable que inizializo en true para el ciclo 
        boolean continuar = true;
// Ciclo while que se ejecutará mientras la variable continuar sea verdadera.
        while (continuar) {
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║         Bienvenido al menu            ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║  1. Agregar jugador                   ║");
            System.out.println("║  2. Borrar jugador                    ║");
            System.out.println("║  3. Mostrar jugador                   ║");
            System.out.println("║  4. Modificar jugador                 ║");
            System.out.println("║  5. Mostrar todo                      ║");
            System.out.println("║  6. Interfaces funcionales            ║");
            System.out.println("║  7. Salir                             ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("Selecciona una opción: ");
            // Lectura de la opción ingresada por el usuario.
            int opc = t.nextInt();
// Creo un swtch para la evaluación de la opción ingresada por el usuario en este caso opc.
            switch (opc) {
                //Si el usuario digito 1 entra a este case 
                case 1:
                //Despliego otro menu
                    System.out.println("╔═══════════════════════════════════╗");
                    System.out.println("║       Donde desea agregarlo       ║");
                    System.out.println("╠═══════════════════════════════════╣");
                    System.out.println("║  1. Arquero                       ║");
                    System.out.println("║  2. Delantero                     ║");
                    System.out.println("║  3. Defensa                       ║");
                    System.out.println("╚═══════════════════════════════════╝");
                    System.out.print("Selecciona una opción: ");
                    int agregar = t.nextInt();
                // Lectura de la opción para agregar jugador.

                // Impresión de la solicitud para que el usuario ingrese datos del jugador.
                //Tambien hay una lectura de los datos ingresados por la persona.
                    System.out.println("Ingrese el nombre del equipo: ");
                //NombreEquipo es una clase tipo enumerador a la cual le creo una instancia llamada 
                //nombreEquipito al lado derecho del igual MostrarGenericos esta es una clase la cual tiene 
                //unas funciones staticas en este caso lo que hace es mostrar lo equipos que tiene el enum
                //te va a mostrar numeritos eliges el numero y dependiendo del numero te lo retorna en la 
                //instancia nombreEquipito la cual es la que va a hacia el constructor
                    NombreEquipo nombreEquipito = MostrarGenericos.mostrarEquipos();
                //En la siguiente linea creo un String de nombreEquipito
                    String nombreEquipitoString = nombreEquipito.getnom();
                    System.out.println("Ingrese el numero del jugador ");
                    int numeroJugador = t.nextInt();
                    System.out.println("Ingrese el numero de goles del jugador ");
                    int numeroGoles = t.nextInt();
                    System.out.println("Ingrese el numero de pases del jugador ");
                    int numeroPases = t.nextInt();
                    System.out.println("Ingrese el numero de autogoles del jugador ");
                    int numeroAutoGoles = t.nextInt();
                    System.out.println("Ingrese el salario del jugador ");
                    double salarioJugador = t.nextDouble();
                
                    //Creacion de un if para que dependiendo de la opcion entre y pida unos datos extras
                    //Este caso pide los datos de un arquero y tambien lo lee 
                    if (agregar == 1) {
                        //cre una variable quemada para enviar al constructor, sigue pidiendo datos
                        String posicion = "Arquero";
                        System.out.println("Ingrese el numero de balones tapados del jugador ");
                        int golesTapados = t.nextInt();
                        System.out.println("      Ingrese la aguilidad de manos con el balon del jugador");
                    //En la linea siguiente creo una instacia de CalidadJugador llamada agilidadManosArquero
                    //MostrarGenerico es una clase la cual tiene dos metodos estaticos este en este caso
                    //muestra la calidad del jugador con numeritos y dependiendo de la opcion ingresa me
                    //retorna una enumeracion
                        CalidadJugador agilidadManosArquero = MostrarGenericos.mostrarCalidad();
                        System.out.println(" Ingrese la salida en falso del jugador");
                    //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador salidaFalsoArquero = MostrarGenericos.mostrarCalidad();
                        System.out.println(" Ingrese el juego aereo defensivo del jugador");
                    //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador juegoAereoDefensivoArquero = MostrarGenericos.mostrarCalidad();
                    
                    //Creo un obejeto de tipo equipoFutbol en este caso extiende de la clase Arquero
                    //despues de hacer le envio los datos capturados anterirormente(envio en construto)
                        EquipoFutbol arquero = new Arquero(nombreEquipitoString, posicion, nombreEquipito,
                                numeroJugador, numeroGoles, numeroPases, numeroAutoGoles, salarioJugador, golesTapados,
                                agilidadManosArquero, salidaFalsoArquero, juegoAereoDefensivoArquero);
                //Creo una variable booleana llamada b posterior a eso llamo a la instancia de EquipoGenerico
                    // y llamo a la funcion agregarEquipoGenerico le envio en constructor de la clase arquero
                    //con todos los datos
                        boolean b = equipoGenerico.agregarEquipoGenerico(arquero);
                    //Llamo a la instancia de GestionarEquipo y ejecuto la siguiente funcion mandandole 
                    //como parametro b que es muy importante en esta parte
                        gestionar.agregarEquiposDesdeGenerico(equipoGenerico, b);
                    //Llamo la instancia de GestionarEquipos y la funcion mostrar quelo que hace es mostrar
                    //el equipo que cumpla con ciertas caracteristicas
                        gestionar.mostrarEquipoEspecifico(numeroJugador, nombreEquipitoString);

                    } else if (agregar == 2) {
                    //cre una variable quemada para enviar al constructor y sigue pidiendo datos
                        String posicion = "Delantero";
                        System.out.println("   Ingrese la habilidad de desmarque del jugador");
                    //En la linea siguiente creo una instacia de CalidadJugador llamada habilidadDesmarque
                    //MostrarGenerico es una clase la cual tiene dos metodos estaticos este en este caso
                    //muestra la calidad del jugador con numeritos y dependiendo de la opcion ingresa me
                    //retorna una enumeracion
                        CalidadJugador habilidadDesmarque = MostrarGenericos.mostrarCalidad();
                        System.out.println("    Ingrese el remate de primera del jugador");
                    //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador rematePrimera = MostrarGenericos.mostrarCalidad();
                        System.out.println("Ingrese el numero de goles por partido del jugador");
                        int numeroGolesPartido = t.nextInt();
                        System.out.println("  Ingrese la presicion de los tiros del jugador");
                    //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador presicionTiros = MostrarGenericos.mostrarCalidad();
                     //Creo un obejeto de tipo equipoFutbol en este caso extiende de la clase Delantero
                    //despues de hacer le envio los datos capturados anterirormente(envio en construtor)
                        EquipoFutbol delantero = new Delantero(nombreEquipitoString, posicion, nombreEquipito,
                                numeroJugador, numeroGoles, numeroPases, numeroAutoGoles, salarioJugador,
                                habilidadDesmarque, rematePrimera, numeroGolesPartido, presicionTiros);
                //Creo una variable booleana llamada b, posterior a eso llamo a la instancia de EquipoGenerico
                    //y llamo a la funcion agregarEquipoGenerico le envio en constructor de la clase delantero
                    //con todos los datos
                        boolean b = equipoGenerico.agregarEquipoGenerico(delantero);
                    //Llamo a la instancia de GestionarEquipo y ejecuto la siguiente funcion mandandole 
                    //como parametro b que es muy importante en esta parte
                        gestionar.agregarEquiposDesdeGenerico(equipoGenerico, b);
                    //Llamo la instancia de GestionarEquipos y la funcion mostrar quelo que hace es mostrar
                    //el equipo que cumpla con ciertas caracteristicas
                        gestionar.mostrarEquipoEspecifico(numeroJugador, nombreEquipitoString );

                    } else if (agregar == 3) {
                    //creo una variable quemada para enviar al constructor y sigue pidiendo datos
                        String posicion = "Defensa";
                        System.out.println("Ingrese el liderazgo defensivo del jugador:");
                    //En la linea siguiente creo una instacia de CalidadJugador llamada liderazgoDefensivo
                    //MostrarGenerico es una clase la cual tiene dos metodos estaticos este en este caso
                    //muestra la calidad del jugador con numeritos y dependiendo de la opcion ingresa me
                    //retorna una enumeracion
                        CalidadJugador liderazgoDefensivo = MostrarGenericos.mostrarCalidad();
                        System.out.println("Ingrese la posicion del defensa: ");
                        System.out.println("1.Defensa central, 2.Defensa lateral");
                        String posicionDefensa = t.nextLine();
                    //En esta linea utilizo un operador terneario para decidir si la variable va a tener
                    //como informacion defensa central o defensa lateral
                        String tipoDefensa = (posicionDefensa.equals("1")) ? "Defensa central" : "Defensa lateral";
                        System.out.println("Ingrese el tackle del jugador: ");
                        //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador tackleDefensa = MostrarGenericos.mostrarCalidad();
                        System.out.println("Ingrese el marcaje al hombre del jugador: ");
                        //aca lo mismo que explique ahorita solo que el nombre de la instancia es diferente
                        CalidadJugador marcajeHombre = MostrarGenericos.mostrarCalidad();
                    //Creo un obejeto de tipo equipoFutbol en este caso extiende de la clase Defensa
                    //despues de hacer le envio los datos capturados anterirormente(envio en construtor)
                        EquipoFutbol defensa = new Defensa(nombreEquipitoString, posicion, nombreEquipito,
                                numeroJugador, numeroGoles, numeroPases, numeroAutoGoles, salarioJugador,
                                liderazgoDefensivo, tipoDefensa, tackleDefensa, marcajeHombre);

                //Creo una variable booleana llamada b, posterior a eso llamo a la instancia de EquipoGenerico
                    //y llamo a la funcion agregarEquipoGenerico le envio en constructor de la clase defensa
                    //con todos los datos
                        boolean b = equipoGenerico.agregarEquipoGenerico(defensa);
                    //Llamo a la instancia de GestionarEquipo y ejecuto la siguiente funcion mandandole 
                    //como parametro b que es muy importante en esta parte
                        gestionar.agregarEquiposDesdeGenerico(equipoGenerico, b);
                    //Llamo la instancia de GestionarEquipos y la funcion mostrar quelo que hace es mostrar
                    //el equipo que cumpla con ciertas caracteristicas
                        gestionar.mostrarEquipoEspecifico(numeroJugador, nombreEquipitoString);
                    }else{
                        //Si el usuario no ingreso una opcion valida imprime esto
                        System.out.println("Ingrese una opcion valida");
                    } // fin if agregar
                    break;
                case 2:
                    //Pido el numero del jugador a borrar y lo leo
                    System.out.println("Ingrese el numero del jugador a borrar: ");
                    int numeroJugadorBorrar = t.nextInt();
                    //Pido que ingrese el equipo a eliminar y lo leo
                    System.out.println("Ingrese el nombre del equipo del jugador a borrar: ");
                    //Aca esta enumeracion ya la explicamos
                    NombreEquipo nombreEquipitoBorrar = MostrarGenericos.mostrarEquipos();
                    //Convierto la enumeracion a string
                    String nombreEquipitoBorrarString = nombreEquipitoBorrar.getnom();
                    //Envio los datos a eliminar
                    gestionar.eliminarEquipos(numeroJugadorBorrar, nombreEquipitoBorrarString);
                    break;

                case 3:
                     //Pido el numero del jugador a buscar y lo leo
                    System.out.println("Ingrese el numero del jugador a buscar");
                    int numeroJugadorBuscar = t.nextInt();
                    //Pido que ingrese el equipo a buscar y lo leo
                    System.out.println("Ingrese el nombre del equipo del jugador a borrar: ");
                    //Aca esta enumeracion ya la explicamos
                    NombreEquipo nombreEquipitoBuscar = MostrarGenericos.mostrarEquipos();
                    //Convierto la enumeracion a string
                    String nombreEquipitoBuscarString = nombreEquipitoBuscar.getnom();
                    //Llamo la instancia de GestionarEquipos y la funcion mostrar quelo que hace es mostrar
                    //el equipo que cumpla con ciertas caracteristicas
                    gestionar.mostrarEquipoEspecifico(numeroJugadorBuscar,nombreEquipitoBuscarString);

                    break;
                case 4: 
                    //Pido el numero del jugador a modifcar y lo leo
                    System.out.println("Ingrese el numero del jugador a modificar: ");
                    int numeroJugadorModificar = t.nextInt();
                    //Pido que ingrese el equipo a modificar y lo leo
                    System.out.println("Ingrese el nombre del equipo del jugador a modificar: ");
                    //Aca esta enumeracion ya la explicamos con anterioridad
                    NombreEquipo nombreEquipitoModificar = MostrarGenericos.mostrarEquipos();
                    //Convierto la enumeracion a string
                    String nombreEquipitoModificarString = nombreEquipitoModificar.getnom();
                    //Los datos los voy enviar a una funcion de GestionarEquipos llamada repetido la cual
                    //va a mirar si en la lista que tenemos los datos que enviarios osea si hay ese numero
                    // de jugador en el equipo si si esta nos retorna true sino false
                    boolean repe = gestionar.repetido( nombreEquipitoModificarString, numeroJugadorModificar);
                    //si nos retorna true es que si esta ese jugador y ya enviamos los nuevos datos
                    if (repe == true) {
                        //pedimos el nuevo numero y lo leemos
                        System.out.println("Ingrese el nuevo numero: ");
                        int nuevoNum = t.nextInt();
                        //preguntamos el nuevo equipo y lo leemos
                        System.out.println("Ingrese el nombre del equipo del jugador a borrar: ");
                        //creo que esto ya sabes que es, creamos una variable de tipo NombreEquipo y mostramos
                        //los equipos que hay y se escoge uno                        
                        NombreEquipo nuevoEqui = MostrarGenericos.mostrarEquipos();
                        //hacemos un string de la variable tipo CalidadJugador
                        String nuevoEquiString = nuevoEqui.getnom();
                        //y enviamos a la funcion modificar equipo
                        gestionar.modificarEquipos(numeroJugadorModificar, nombreEquipitoModificarString, nuevoNum, nuevoEquiString);
                    }else{
                        System.out.println("No encontre nada ");
                    }

                    break;

                case 5:
                    //Aca solo se muestra todos lo equipos que hay en el momento
                    gestionar.mostrarEquipos();
                    
                    break;

                case 6:
                    
                    int opcion = mostrarOpcionStream();

                    if (opcion == 1) {
                        equipoStream.agregarEquipoStream(equipoStream.generarEquipoAleatorio.get());
                        equipoStream.mostrarEquipoStream();

                    }
                    break;

                case 7:

                continuar = false;
                    break;

                default:
                    break;
            }// fin swicht

        } // fin while
        t.close();//crerramos el Scanner para que no nos aparesca en amarrillo una linea 
    }// fin funcion

    @SuppressWarnings("resource")
    public static int mostrarOpcionStream(){
        Scanner t = new Scanner(System.in);
        System.out.println();
        System.out.println("Ingrese que desea ver: ");
        System.out.println("1. Generar un equipo aleatoriamente");
        System.out.println("2. Simulacion de una partido");

        int opc = t.nextInt();

        return opc;
    }

}
