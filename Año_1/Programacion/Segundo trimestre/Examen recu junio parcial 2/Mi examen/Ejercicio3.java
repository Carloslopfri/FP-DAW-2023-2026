/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author
 */
public class Ejercicio3 {

	public static void añadirEstudiante(ArrayList<Estudiante> estudiantesLista) {
		String nombre = Herramientas.leerString("Nombre: ");
		int edad = Herramientas.leerInt("Edad: ");

		Estudiante e = new Estudiante(nombre, edad);

		estudiantesLista.add(e);
		System.out.println("Estudiante añadido.");
	}

	public static void mostrarEstudiantes(ArrayList<Estudiante> estudiantesLista) {
		for (Estudiante e : estudiantesLista) {
			System.out.println(e);
		}
	}

	public static void buscarEstudiante(ArrayList<Estudiante> estudiantesLista) {
		String nombre = Herramientas.leerString("Nombre de alumno a buscar: ");

		for (Estudiante e : estudiantesLista) {
			if (e.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println(e);
			}
		}
	}

	public static void eliminarEstudiante(ArrayList<Estudiante> estudiantesLista) {
		String nombre = Herramientas.leerString("Nombre de alumno a eliminar: : ");

		Iterator<Estudiante> estudiantesIterator = estudiantesLista.iterator();
		while (estudiantesIterator.hasNext()) {
			if (estudiantesIterator.next().getNombre().equalsIgnoreCase(nombre)) {
				estudiantesIterator.remove();
				System.out.println("Estudiante eliminado.");
			}
		}
	}

	public static void calcularPromedioEdades(ArrayList<Estudiante> estudiantesLista) {
		double suma = 0.0, promedio = 0.0;

		for (Estudiante e : estudiantesLista) {
			suma += e.getEdad();
		}

		promedio = suma / estudiantesLista.size();
		System.out.println("El promedio de edades es " + promedio);
	}

	public static void ejecutar() {

		ArrayList<Estudiante> estudiantesLista = new ArrayList<>();
		int opcion = 0;

		do {
			System.out.println("1 - Añadir estudiante.");
			System.out.println("2 - Mostrar estudiantes.");
			System.out.println("3 - Buscar estudiante.");
			System.out.println("4 - Eliminar estudiante.");
			System.out.println("5 - Ordenar lista.");
			System.out.println("6 - Calcular promedio edades.");
			System.out.println("7 - Salir.");
			opcion = Herramientas.leerInt("Introduce una opción: ");

			switch (opcion) {
				case 1:
					añadirEstudiante(estudiantesLista);
					break;

				case 2:
					mostrarEstudiantes(estudiantesLista);
					break;

				case 3:
					buscarEstudiante(estudiantesLista);
					break;

				case 4:
					eliminarEstudiante(estudiantesLista);
					break;

				case 6:
					calcularPromedioEdades(estudiantesLista);
					break;

				default:
					System.out.println("Opcion no valida.");
			}
		} while (opcion != 7);

	}
}
