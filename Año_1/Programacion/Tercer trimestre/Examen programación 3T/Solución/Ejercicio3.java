/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.awt.*;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;

/**
 *
 * @author 
 */
public class Ejercicio3 {

    public static void ejecutar() {

        // Creas los archivos

        File ficheroReal = new File("data/ejercicio_3/ejercicio_3.mkv");

        File ficheroCopia = new File("data/ejercicio_3/copia_ejercicio_3.mkv");

        try {

            // Copias el archivo real en la copia

            Files.copy(ficheroReal.toPath(), ficheroCopia.toPath()); //El "copy" coge el contendio del fichero de la ruta y y lo copia en otra ruta. El "toPath" representa la ruta.

            // Abrir el archivo copiado con la aplicación predeterminada

            Desktop desktop = Desktop.getDesktop(); //Es un objeto que permite abrir cosas del sistema.

            desktop.open(ficheroCopia);

        } catch (IOException e) {

            System.out.println(e);

        }

    }

}
