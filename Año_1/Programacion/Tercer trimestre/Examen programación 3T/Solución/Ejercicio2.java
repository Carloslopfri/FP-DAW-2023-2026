/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.io.*;

import java.sql.SQLOutput;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class Ejercicio2 {


    public static void ejecutar() {

        try {

            Scanner escaner = new Scanner(System.in);

            File ruta = new File("data/ejercicio_2/ejercicio_2.txt");

            FileReader fReader = new FileReader(ruta);

            BufferedReader bReader = new BufferedReader(fReader);

            System.out.println("Palabra a buscar: ");

            String palabraBuscar = escaner.nextLine();

            String linea = bReader.readLine();

            int contador = 0;

            while (linea != null) { //Mentras exista la linea.

                String[] palabrasLinea = linea.split(" "); //Creo un Array de palabras, y lo que indica el "split" es que detecte la palabea cada vez que hay un espacio, si no pillaria todo como una palabra.

                for (String palabralinea : palabrasLinea) {

                    if (palabralinea.toLowerCase().contains(palabraBuscar.toLowerCase()) == true) { //El "contains" sirve para ver si contienme la palabra buscada. El "toLowerCase" pone todo en minusculas para poder comparar.

                        contador++;

                    }

                }

                linea = bReader.readLine(); //Para que siga leyendo.

            }

            System.out.println("Se han encotrado " + contador + " ocurrencias.");

        } catch (FileNotFoundException e) {

            System.out.println(e);

        } catch (IOException e) {

            System.out.println(e);

        }

    }
    
}