/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author
 */
public class Ejercicio1 {

	public static void ejecutar() {

		try {

			String username = Herramientas.leerString("Nombre de usuario: ");

			String password = Herramientas.leerString("Contraseña: ");

			FileReader fileReader = new FileReader("./data/ejercicio_1/usuarios.csv");

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String linea = bufferedReader.readLine();

			while (linea != null) {

				String[] trozos = linea.split(";");

				if (trozos[0].equalsIgnoreCase(username) && trozos[2].equalsIgnoreCase(password)) {

					System.out.println("Bienvenido " + username);

				}

				linea = bufferedReader.readLine();

			}

			bufferedReader.close();

			fileReader.close();

		} catch (FileNotFoundException e) {

			System.out.println(e);

		} catch (IOException e) {

			System.out.println(e);

		}

	}

}
