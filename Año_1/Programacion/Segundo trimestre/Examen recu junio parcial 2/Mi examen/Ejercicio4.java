/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.time.chrono.HijrahEra;
import java.util.Scanner;

/**
 * @author
 */
public class Ejercicio4 {

	public static void ejecutar() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Numero 1: ");
		int numero1 = scanner.nextInt();

		System.out.print("Numero 2: ");
		int numero2 = scanner.nextInt();


		try {
			System.out.println(numero1 + " / " + numero2 + " = " + (numero1/numero2));

			System.out.println(Math.sqrt(numero1));

			if (numero2 < 0) {
				throw new NumeroNegativoException("El segundo número es negativo.");
			}

		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NumeroNegativoException e) {
			e.printStackTrace();
		}
	}
}
