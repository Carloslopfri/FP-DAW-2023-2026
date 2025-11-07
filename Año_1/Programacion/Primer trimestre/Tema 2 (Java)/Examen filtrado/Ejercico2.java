package Paquete_de_modelo_de_examen_filtrado;

import java.util.Scanner;

public class Ejercico2 {

	public static void main(String[] args) {
		
		Scanner escaner=new Scanner(System.in);
		
		System.out.print("Hola, si desea saber su calificación introduzaca su nota: ");
		
		double nota=escaner.nextDouble();
		
		if(nota>=0 && nota<5) {
			
			System.out.print("Con un total de " + nota + " ha obtenido una calificación de SUPENSO.");
			
		}
		
		else if(5<=nota && nota<6.5) {
			
			System.out.print("Con un total de " + nota + " ha obtenido una calificación de APROBADO.");
			
		}
		
		else if(6.5<=nota && nota<8.5) {
			
			System.out.print("Con un total de " + nota + " ha obtenido una calificación de NOTABLE.");
			
		}
		
		else if(8.5<=nota && nota<=10) {
			
			System.out.print("Con un total de " + nota + " ha obtenido una calificación de SOBRESALIENTE.");
			
		}
		
		else {
			
			System.out.print("Nota no valida, recuerde que la nota tiene que tener un valor entre 0 y 10.");
			
		}
		
		escaner.close();

	}

}
