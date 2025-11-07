package examen;

import java.util.*;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

import examen240314.*;

public class Control {

    private List<Vuelo> vuelos;

    private List<Usuario> usuarios;

    public Control() {

        this.vuelos = new ArrayList<>();

        this.usuarios = new ArrayList<>();

        inicializarVuelos();

    }

    public void mostrarColaDeVuelosOrdenada() {
        String[][] vuelosData = Datos.getVuelos();

        if (vuelosData.length == 0) {
            System.out.println("No hay vuelos para mostrar.");
        } else {
            Arrays.sort(vuelosData, Comparator.comparing(a -> a[0]));

            for (String[] vueloData : vuelosData) {
                System.out.println("ID: " + vueloData[0] + ", Origen: " + vueloData[1] + ", Destino: " + vueloData[2] + ", Salida: " + vueloData[3] + ", Llegada: " + vueloData[4]);
            }
        }
    }

    public void darSalidaAVuelo() {

        if (!vuelos.isEmpty()) {

            Vuelo vuelo = vuelos.remove(0);

            System.out.println("El vuelo " + vuelo + " ha salido.");

        } else {

            System.out.println("No hay vuelos en la cola.");

        }

    }

    public void actualizarListaDeVuelos() throws HorarioVueloException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el identificador del vuelo: ");

        String id = scanner.nextLine();

        LocalDateTime salida = null;

        while (salida == null) {

            System.out.print("Ingrese la hora de salida del vuelo (formato: yyyy-MM-dd HH:mm): ");

            String salidaStr = scanner.nextLine();

            try {

                salida = LocalDateTime.parse(salidaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            } catch (DateTimeParseException e) {

                throw new HorarioVueloException("Formato de fecha y hora inválido. Por favor, intente de nuevo.");

            }

        }

        LocalDateTime llegada = null;

        while (llegada == null) {

            System.out.print("Ingrese la hora de llegada del vuelo (formato: yyyy-MM-dd HH:mm): ");

            String llegadaStr = scanner.nextLine();

            try {

                llegada = LocalDateTime.parse(llegadaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            } catch (DateTimeParseException e) {

                throw new HorarioVueloException("Formato de fecha y hora inválido. Por favor, intente de nuevo.");

            }

        }

        Vuelo nuevoVuelo = new Vuelo(id, salida, llegada);

        vuelos.add(nuevoVuelo);

        System.out.println("Vuelo agregado exitosamente.");

    }

    public void modificarHorariosDeVuelo(int minutos) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el identificador del vuelo: ");

        String id = scanner.nextLine();

        Vuelo vueloAModificar = null;

        for (Vuelo vuelo : vuelos) {

            if (vuelo.getId().equals(id)) {

                vueloAModificar = vuelo;

                break;

            }

        }

        if (vueloAModificar != null) {

            vueloAModificar.modificarHorario(minutos);

            System.out.println("Horario del vuelo modificado exitosamente.");

        } else {

            System.out.println("No se encontró un vuelo con el identificador proporcionado.");

        }

    }

    private void inicializarVuelos() {

        String[][] vuelosData = Datos.getVuelos();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        for (String[] vueloData : vuelosData) {

            String id = vueloData[0];

            LocalDateTime salida = LocalDateTime.parse(vueloData[3], formatter);

            LocalDateTime llegada = LocalDateTime.parse(vueloData[4], formatter);

            Vuelo vuelo = new Vuelo(id, salida, llegada);

            vuelos.add(vuelo);

        }

        Collections.sort(vuelos);

    }

}
