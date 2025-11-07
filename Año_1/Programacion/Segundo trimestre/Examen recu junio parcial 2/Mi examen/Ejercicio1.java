/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.util.Scanner;

/**
 * @author
 */
public class Ejercicio1 {

	public static void ejecutar() {

		Scanner scanner = new Scanner(System.in);

		int[][] matriz = new int[3][3];

		int mayor = 0, menor = 0;

		System.out.println("Inicializar la matriz: ");

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < 3; j++) {

				matriz[i][j] = Herramientas.leerInt("Introduce valor " + i + ", " + j + ": ");

			}

		}

		System.out.println("Imprimir la matriz: ");

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < 3; j++) {

				System.out.print(matriz[i][j] + " ");

			}

			System.out.println();

		}

		System.out.print("Encontrar el mayor: ");

		mayor = matriz[0][0];

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < 3; j++) {

				if (matriz[i][j] > mayor) {

					mayor = matriz[i][j];

				}

			}

		}

		System.out.print("El mayor es " + mayor);

		System.out.println("Encontrar el menor: ");

		menor = matriz[0][0];

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < 3; j++) {

				if (matriz[i][j] < menor) {

					menor = matriz[i][j];

				}

			}

		}

		System.out.println("El menor es " + menor);

	}

}
