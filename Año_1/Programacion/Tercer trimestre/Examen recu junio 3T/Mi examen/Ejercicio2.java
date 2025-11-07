/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.sql.*;
import java.time.LocalDate;

/**
 * @author
 */
public class Ejercicio2 {


	public static void ejecutar() {

		String url = "jdbc:mysql://172.21.29.50:3306/sakila";

		String user = "userDAW";

		String pass = "Java";

		Connection c = null;

		try {

			c = DriverManager.getConnection(url, user, pass);

			c.setAutoCommit(false);

			// Inserción del actor

			PreparedStatement insertarActor = c.prepareStatement("INSERT INTO actor (first_name, last_name, last_update) VALUES(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

			insertarActor.setString(1, "María");

			insertarActor.setString(2, "Pérez");

			insertarActor.setDate(3, Date.valueOf(LocalDate.now()));

			insertarActor.executeUpdate();

			System.out.println("La actriz María Pérez se ha insertado correctamente.");

			// Modificación del actor

			PreparedStatement modificarActor = c.prepareStatement("UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?");

			modificarActor.setString(1, "Cristina");

			modificarActor.setString(2, "Pérez");

			modificarActor.setDate(3, Date.valueOf(LocalDate.now()));

			modificarActor.setInt(4, 1);

			modificarActor.executeUpdate();

			System.out.println("Se ha cambiado el nombre de la actriz María a Cristina.");

			c.commit();

		} catch (SQLException e) {

			System.out.println(e);

			try {

				c.rollback();

			} catch (SQLException ex) {

				System.out.println(e);

			}

		}

	}

}