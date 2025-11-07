/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.io.File;

/**
 *
 * @author 
 */
public class Ejercicio1 {

    public static void ejecutar() {       

        File carpeta = new File("data/ejercicio_1/"); //Declaramos la ruta.

        File[] elementos_carpeta = carpeta.listFiles(); //Devuelve un Array.

        // for (int i = 0; i < elementos_carpeta.length; i++)
        for (File elemento : elementos_carpeta) {

            if (elemento.isFile() == true) { //"isFile" detecta los ficheros.

                System.out.println(elemento + " F");

            }

            else if (elemento.isDirectory() == true) { //"isDirectory" detecta los directorios.

                System.out.println(elemento + " D");

            }

        }

    }
}
