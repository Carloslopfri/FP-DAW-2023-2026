package examen;

import java.util.Scanner;

public class GestAirport {

    private Control control;

    private Scanner scanner;


    public GestAirport() {

        this.control = new Control();

        this.scanner = new Scanner(System.in);

    }

    public static void main(String[] args) {

        GestAirport gestAirport = new GestAirport();

        gestAirport.run();

    }

    public void run() {

        boolean exit = false;

        while (!exit) {

            System.out.println("1. Mostrar cola de vuelos ordenada");

            System.out.println("2. Dar salida a vuelo");

            System.out.println("3. Actualizar lista de vuelos");

            System.out.println("4. Modificar horarios de un vuelo");

            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            try {

                switch (option) {

                    case 1:

                        control.mostrarColaDeVuelosOrdenada();

                        break;

                    case 2:

                        control.darSalidaAVuelo();

                        break;

                    case 3:

                        control.actualizarListaDeVuelos();

                        break;

                    case 4:

                        System.out.print("Ingrese la cantidad de minutos para modificar el horario del vuelo: ");

                        int minutos = scanner.nextInt();

                        control.modificarHorariosDeVuelo(minutos);

                        break;

                    case 5:

                        exit = true;

                        break;

                    default:

                        System.out.println("Opción no válida.");

                        break;

                }

            } catch (HorarioVueloException e) {

                System.out.println(e.getMessage());

            }

        }

    }

}

