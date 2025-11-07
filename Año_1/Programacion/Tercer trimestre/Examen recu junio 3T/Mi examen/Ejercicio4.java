/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author
 */
public class Ejercicio4 {

	static List<Actor> actores = new ArrayList<Actor>();
	static Connection c;

	public static void ejecutar() {

		String url = "jdbc:mysql://172.21.29.50:3306/sakila";

		String user = "userDAW";

		String pass = "Java";

		try {

			c = DriverManager.getConnection(url, user, pass);

			cargarDatos();
			menu();
			actualizarDatos();

		} catch (SQLException e) {

			System.out.println(e);

		}

	}

	private static void menu() {
		byte option;
		int id = 0;

		do {
			System.out.println("**************************");
			System.out.println("*** Ejercicio 4 - MENÚ ***");
			System.out.println("**************************");

			System.out.println("\t(1) Mostrar actores.");
			System.out.println("\t(2) Modificar un actor.");
			System.out.println("\t(3) Añadir nuevo actor.");
			System.out.println("\t(4) Elminar actor.");
			System.out.println("\t(0) Salir.");
			option = Herramientas.validarOpcion(0, 4);
			switch (option) {
				case 1:
					mostrarActores();
					break;
				case 2:
					modificarActor();
					break;
				case 3:
					addActor();
					break;
				case 4:
					eliminarActor();
					break;
			}
		} while (option != 0);

	}

	private static void mostrarActores() {
		Iterator it = actores.iterator();
		Actor act;
		System.out.println("*** Listado de actores ***");

		while (it.hasNext()) {
			act = (Actor) it.next();
			if (!act.isEliminado()) {
				System.out.println(act);
			}
		}

		System.out.println("");
	}

	private static void modificarActor() {
		Actor actor;
		boolean realizado = false;
		int id = Herramientas.leerInt("Introduce el id del actor: ");
		for (Actor act : actores) {
			if (act.getId() == id) {
				actor = act;
				System.out.println("Datos originales del actor: ");
				System.out.println(act);
				System.out.println("");
				actor.setNombre(Herramientas.leerString("Introduce el nombre: "));
				actor.setApellidos(Herramientas.leerString("Introduce los apellidos: "));
				actor.setFechaNacimiento(Herramientas.leerFecha("Introduce la fecha de nacimiento: "));
				realizado = true;
			}

		}
		if (!realizado) {
			System.out.println("El id = " + id + " no ha sido encontrado.");
		}
	}

	private static void addActor() {
		String nombre, apellidos;
		LocalDate fecha;
		nombre = Herramientas.leerString("Inroduce el nombre: ");
		apellidos = Herramientas.leerString("Inroduce los apellidos: ");
		fecha = LocalDate.parse(Herramientas.leerString("Inroduce la fecha de nacimiento: "));
		actores.add(new Actor(nombre, apellidos, fecha));
	}

	private static void eliminarActor() {
		boolean realizado = false;
		int id = Herramientas.leerInt("Introduce el id del actor: ");
		for (Actor act : actores) {
			if (act.getId() == id) {
				if (act.isNuevo()) {
					actores.remove(act);
				} else {
					act.setEliminado(true);
				}
				realizado = true;
			}

		}
		if (!realizado) {
			System.out.println("El id = " + id + " no ha sido encontrado.");
		}
	}

	private static void cargarDatos() throws SQLException {

		Statement seleccionarActores = c.createStatement();

		ResultSet actoresRS = seleccionarActores.executeQuery("SELECT * FROM actor");

		while (actoresRS.next()) {

			int actor_id = actoresRS.getInt("actor_id");

			String first_name = actoresRS.getString("first_name");

			String last_name = actoresRS.getString("last_name");

			LocalDate last_update = actoresRS.getDate("last_update").toLocalDate();

			Actor actor = new Actor(actor_id, first_name, last_name, last_update);

			actores.add(actor);

		}

	}

	private static void actualizarDatos() {

		try {

			for (Actor actor : actores) {

				if (actor.isNuevo() == true) {

					String sql = "INSERT INTO actor (actor_id, first_name, last_name, last_update) VALUES (?, ?, ?, ?)";

					PreparedStatement insertarActor = c.prepareStatement(sql);

					insertarActor.setInt(1, actor.getId());

					insertarActor.setString(2, actor.getNombre());

					insertarActor.setString(3, actor.getApellidos());

					insertarActor.setDate(4, Date.valueOf(actor.getFechaNacimiento()));

					insertarActor.executeUpdate();

				} else if (actor.isModificado() == true) {

					String sql = "UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?";

					PreparedStatement modificarActor = c.prepareStatement(sql);

					modificarActor.setString(1, actor.getNombre());

					modificarActor.setString(2, actor.getApellidos());

					modificarActor.setDate(3, Date.valueOf(actor.getFechaNacimiento()));

					modificarActor.setInt(4, actor.getId());

					modificarActor.executeUpdate();

				} else if (actor.isEliminado() == true) {

					String sql = "DELETE FROM actor WHERE actor_id = ?";

					PreparedStatement eliminarActor = c.prepareStatement(sql);

					eliminarActor.setInt(1, actor.getId());

					eliminarActor.executeUpdate();

				}

			}

		} catch (SQLException e) {

			System.out.println(e);

		}

	}

}
