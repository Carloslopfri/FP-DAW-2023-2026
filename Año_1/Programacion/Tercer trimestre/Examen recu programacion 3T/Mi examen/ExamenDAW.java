/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.daw;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author RAMONFR
 */
public class ExamenDAW {

    static int numEjer = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ejer = 0;

        menu();

        if (Ejercicio1.getConnection() != null) {
            try {
                Ejercicio1.getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void menu() {
        int option = 0;

        do {
            System.out.println("*** MENÚ ***");
            for (int i = 1; i <= numEjer; i++) {
                System.out.println("\t(" + i + ") Ejercicio " + i + ".");
            }
            System.out.println("\t(0) Salir.");
            option = Herramientas.validarOpcion(0, numEjer);
            switch (option) {
                case 1:
                    Ejercicio1.ejecutar();
                    break;
                case 2:
                    Ejercicio5.ejecutar();
                    break;
                case 3:
                    Ejercicio3.ejecutar();
                    break;
                case 4:
                    Ejercicio4.ejecutar();
                    break;
                case 5:
                    Ejercicio5.ejecutar();
                    break;
            }
        } while (option != 0);
    }

}
