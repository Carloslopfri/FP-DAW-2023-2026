package org.example;

import java.util.*;

public class Estudiante {
    private String nombre;

    private List<Integer> calificaciones;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void AgregarCalificacion(int calificacion) {
        calificaciones.add(calificacion);
    }

}