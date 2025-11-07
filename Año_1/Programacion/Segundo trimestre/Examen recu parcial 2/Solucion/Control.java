import atletismo.*;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

import java.util.*;

public class Control {

    Scanner escaner=new Scanner(System.in);

    Datos datos = new Datos();

    public Carrera crearCarrera() {

        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Escriba el nombre de la carrera:");

        String nombreCarrera=escaner.nextLine();

        System.out.println("Dime la fecha y hora de la carrera (dd-MM-yyyy hh:mm):");

        String fechaHoraCarrera=escaner.nextLine();

        LocalDateTime fechaRealizacion=LocalDateTime.parse(fechaHoraCarrera, formatoFecha);

        System.out.println("Número máximo de participnates:");

        int numeroMaximoParticipnates= escaner.nextInt();

        escaner.nextLine();

        System.out.println("Edad mínima para participar:");

        int edadMinimaParticipante= escaner.nextInt();

        escaner.nextLine();

        Carrera carrera=new Carrera(nombreCarrera, fechaRealizacion, numeroMaximoParticipnates, edadMinimaParticipante);

        return carrera;

    }

    public void insertarParticipantesManual(Carrera carrera){

        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DateTimeFormatter formatoTiempo=DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Escribe el nombre del participante:");

        String nombre=escaner.nextLine();

        System.out.println("Escribe el primer apellido del participante:");

        String apellido1=escaner.nextLine();

        System.out.println("Escribe el segundo apellido del participante:");

        String apellido2=escaner.nextLine();

        System.out.println("Escribe el DNI del participante:");

        String DNI=escaner.nextLine();

        System.out.println("Escribe la fecha de nacimiento (dia-mes-año) del participante:");

        String fechaNacimientoStr=escaner.nextLine();

        System.out.println("Escribe la marca personal del participante (horas:minutos:segundos): ");

        String marcaPersonalStr = escaner.nextLine();

        LocalTime marcaPersonal = LocalTime.parse(marcaPersonalStr,formatoTiempo);

        Atleta atleta=new Atleta(DNI, nombre, apellido1, apellido2, fechaNacimientoStr);

        atleta.setMarcaPersonal(marcaPersonal);

        carrera.addParticipantes(atleta);

    }

    public void insertarCarreraAutamitico(Carrera carrera) {

        try {

            System.out.println("Cuantos participantes quieres poner: ");

            int numeroParticipantes=escaner.nextInt();

            escaner.nextLine();

            if(numeroParticipantes <= carrera.getNumeroMaximodeparticipantes()) {

                ArrayList<Atleta> AtletasAleatorios = datos.getRandomAtletas(numeroParticipantes);

                carrera.setParticipantes(AtletasAleatorios);

            }

            else {

                throw new NumeroMaximoException("No se puede superar el número máximo de participantes.");

            }

        } catch(NumeroMaximoException e) {

            System.out.println(e.getMessage());

        }

    }

    public void simularCarrera(Carrera carrera) {

        for(int i=0; i <= carrera.getParticipantes().size(); i++) {

            LocalTime marca=Herramientas.getTiempoCarrera();

            carrera.getParticipantes().get(i).setMarcaPersonal(marca);

        }

    }

    public void resultadosOrdenados(Carrera carrera) {

        System.out.println("ANTES DE ORDENAR");

        for (int i = 0; i < carrera.getParticipantes().size(); i++) {

            System.out.println(carrera.getParticipantes().get(i).toString() + " " + carrera.getParticipantes().get(i).getMarcaPersonal());

        }

        Collections.sort(carrera.getParticipantes(), new Comparator<Atleta>() {

            @Override
            public int compare(Atleta atelta1, Atleta atleta2) {

                return atelta1.getMarcaPersonal().compareTo(atleta2.getMarcaPersonal());

            }

        });

        System.out.println("DESPUES DE ORDENAR");

        for (int i = 0; i < carrera.getParticipantes().size(); i++) {

            System.out.println(carrera.getParticipantes().get(i).toString() + " " + carrera.getParticipantes().get(i).getMarcaPersonal());

        }

    }

    public  void menu() {

        int opcion=0;

        Carrera carrera = null;

        do {

            System.out.println("1. Crear carrera.");

            System.out.println("2. Insertar participantes.");

            System.out.println("3. Simular la carrera.");

            System.out.println("4. Mostrar los resultados ordenados.");

            System.out.println("5. Salir.");

            System.out.print("Elige una opción: ");

            opcion=escaner.nextInt();

            escaner.nextLine();


            switch (opcion){

                case 1:

                    if(carrera==null) {

                        carrera=crearCarrera();

                    }

                    else {

                        System.out.println("Ya has creado una carrera.");

                    }

                break;

                case 2:

                    System.out.println("1. Manualmente.");

                    System.out.println("2. Automaticamente");

                    int opcionParticipante= escaner.nextInt();

                    escaner.nextLine();

                    if(opcionParticipante==1) {

                        insertarParticipantesManual(carrera);

                    }

                    else if(opcionParticipante==2) {

                        insertarCarreraAutamitico(carrera);

                    }

                    else {

                        System.out.println("Opción no válida.");

                    }

                    break;

                case 4:

                    resultadosOrdenados(carrera);

                break;

                case 5:

                    System.out.println("Hasta luego.");

                break;

            }

        } while(opcion!=5);

        escaner.close();

    }

}
