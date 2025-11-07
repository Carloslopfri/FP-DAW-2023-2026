package Paquete_modelo_examen;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner escaner = new Scanner(System.in);
		
		System.out.println("Bienvenido a nuestra página, para calcular su edad siga los pasos:");
		
		System.out.print("Ponga su año de nacimiento: ");
		
		int yearBorn=escaner.nextInt();
		
		System.out.print("Ponga el año actual: ");
		
		int yearNowadays=escaner.nextInt();
		
		int edad=0;
		
		for(int i=yearBorn; i<yearNowadays; i++) {
		edad++;
		
		}
		
		System.out.print("Habiendo nacido en el año " + yearBorn + " y estando en el año " + yearNowadays + ", tiene una edad de " + edad + " años.");
		
		escaner.close();

	}

}
