package examenresuelto;

import java.util.*;

public class ExamenResuelto {

public static void main(String[] args) {
    GestAirport gestAirport = new GestAirport();
    Scanner scanner = new Scanner(System.in);

    List<Runnable> acciones = new ArrayList<>();
    acciones.add(gestAirport::mostrarColaDeVuelos);
    // Aquí debes agregar las otras acciones del menú

    System.out.println("1. Mostrar cola de vuelos ordenada");
    System.out.println("2. Añadir un nuevo vuelo a la cola");
    System.out.println("3. Eliminar un vuelo de la cola");
    System.out.println("4. Dar salida a un vuelo");
    System.out.println("5. Actualizar lista de vuelos");
    System.out.println("6. Modificar horarios de un vuelo");
    System.out.println("7. Salir");
    System.out.print("Elige una opción: ");
    int opcion = scanner.nextInt();

    if (opcion >= 1 && opcion <= acciones.size()) {
        acciones.get(opcion - 1).run();
    } else {
        System.out.println("Opción no válida. Por favor, elige una opción del 1 al 7.");
    }
}
    
}
