package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Estudiante> estudiantes = new HashMap<String, Estudiante>();

        //Creamos un estudiante y lo agregamos al mapa.

        Estudiante estudiante1 = new Estudiante("Juan");

        Estudiante estudiante2 = new Estudiante("Maria");

        //Agregamos calificaciones a los estudiantes.

        estudiante1.AgregarCalificacion(10);

        estudiante1.AgregarCalificacion(9);

        estudiante2.AgregarCalificacion(8);

        estudiante2.AgregarCalificacion(7);

        //Lo agregamos al mapa.

        estudiantes.put(estudiante1.getNombre(), estudiante1);

        estudiantes.put(estudiante2.getNombre(), estudiante2);

        //Imprimimos el mapa.

        for(String nombre:estudiantes.keySet()){
            System.out.println("Nombre: "+nombre);
            System.out.println("Calificaciones: "+estudiantes.get(nombre).getCalificaciones());
        }

    }

}
