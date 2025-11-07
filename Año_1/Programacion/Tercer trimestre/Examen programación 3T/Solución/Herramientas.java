/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author ramonfr
 */
public class Herramientas {
    static Scanner sc = new Scanner(System.in);
    
    public static byte validarOpcion(int min, int max) {
        byte opcion = 0;
        boolean repetir;
        //Scanner sc = new Scanner(System.in);
        do {
            repetir = false;
            System.out.print("Seleccione una opción: ");
            if (sc.hasNextByte()) {
                opcion = sc.nextByte();
                if (opcion < min || opcion > max) {
                    System.out.println("\tATENCIÓN! Opción no disponible. "
                            + "Vuelva a seleccionar. ");
                    repetir = true;
                }
            } else {
                System.out.println("\tERROR: Débe introducir un valor entre "
                        + min + " y " + max);
                sc.next();
                repetir = true;
            }
        } while (repetir);
        return opcion;
    }

    public static int leerInt(String cadena) {
        int valor = 0;
        boolean repetir;
        //Scanner sc = new Scanner(System.in);

        System.out.print(cadena);
        repetir = true;
        while (repetir) {
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                repetir = (valor < 1);
            } else {
                sc.next();
            }
            if (repetir) {
                System.out.print("\tERROR: debe introducir un valor numérico. "
                        + "\n\t\tVuelva a introducir un número: ");
            }
        }
        return valor;
    }

    public static String leerString(String cadena) {
        String valor = "";
        boolean repetir;
        Scanner sc = new Scanner(System.in);

        System.out.print(cadena);
        repetir = true;
        while (repetir) {
            if (sc.hasNextLine()) {
                valor = sc.nextLine();
                repetir = (valor.isEmpty());
            } else {
                sc.next();
            }
            if (repetir) {
                System.out.print("\tERROR: debe introducir algún texto. "
                        + "\n\t\tVuelva a introducir o valor: ");
            }
        }
        return valor;
    }

    public static float leerFloat(String cadena) {
        float valor = 0;
        boolean repetir;

        System.out.print(cadena);
        repetir = true;
        while (repetir) {
            if (sc.hasNextFloat()) {
                valor = sc.nextFloat();
                repetir = (valor < 1);
            } else {
                sc.next();
            }
            if (repetir) {
                System.out.print("\tERROR: debe introducir un valor float. "
                        + "\n\t\tVuelva a introducir un número: ");
            }
        }
        return valor;
    }

    public static LocalDate leerFecha(String cadena) {
        LocalDate fecha = null;
        String valor = null;
        boolean repetir;

        System.out.print(cadena);
        repetir = true;
        while (repetir) {
            if (sc.hasNextLine()) {
                valor = sc.nextLine();
                repetir = (valor.isEmpty());
            } else {
                sc.next();
            }
            try {
                fecha = LocalDate.parse(valor);
            } catch (Exception ex) {

            }
            if (repetir) {
                System.out.print("\tERROR: debe introducir una fecha (2024-05-18). "
                        + "\n\t\tVuelva a introducir el valor: ");
            }
        }
        return fecha;
    }
}
