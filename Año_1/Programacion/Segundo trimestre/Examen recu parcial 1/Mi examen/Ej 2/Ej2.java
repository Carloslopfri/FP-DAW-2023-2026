/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej2;

/**
 *
 * @author CARLOSLF
 */
public class Ej2 {

    public static void main(String[] args) {

        String[][] notasAlumnos = {
    {"Luis","Programacion","6.75","4","5.8"},
    {"Luis","Sistemas","2.75","6","5.9"},
    {"Luis","Lenguajes de marcas","9","7","6.1","3.85"},
    {"Laura","Programacion","2.75","3","8"},
    {"Laura","Sistemas","2.75","6","3.9"},
    {"Laura","Lenguajes de marcas","1","4.25","5","6.5"},
    {"Alba","Programacion","6","4.5","9.8"},
    {"Alba","Sistemas","8.75","9","7.9"},
    {"Alba","Lenguajes de marcas","9","10","6.1", "7"}
};

for (String[] notasAlumno : notasAlumnos) {
    String nombre = notasAlumno[0];
    String asignatura = notasAlumno[1];
    double suma = 0;
    for (int i = 2; i < notasAlumno.length; i++) {
        suma += Double.parseDouble(notasAlumno[i]);
    }
    double media = suma / (notasAlumno.length - 2);
    System.out.printf("Alumno: %s Materia: %s Media: %f\n", nombre, asignatura, media);
}

    }
}
