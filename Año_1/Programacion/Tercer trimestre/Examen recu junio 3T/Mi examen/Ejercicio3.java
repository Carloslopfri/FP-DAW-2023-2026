/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author
 */
public class Ejercicio3 {

	public static void ejecutar() {

		File carpeta = new File("./data/ejercicio_3");

		File[] elementos = carpeta.listFiles();

		for (File elemento : elementos) {

			if (elemento.isFile()) {

				File ficheroCopia = new File("data/ejercicio_3/copia_" + elemento.getName());

				try {

					Files.copy(elemento.toPath(), ficheroCopia.toPath());

				} catch (IOException e) {

					System.out.println(e);

				}

			}

		}

	}

}
