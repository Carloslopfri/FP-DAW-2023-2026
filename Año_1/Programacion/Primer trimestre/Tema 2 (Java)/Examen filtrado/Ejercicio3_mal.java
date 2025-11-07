package Paquete_de_modelo_de_examen_filtrado;

import java.util.Scanner;

public class Ejercicio3_mal {

	public static void main(String[] args) {
		
		Scanner escaner=new Scanner (System.in);
		
		String [][] matrix=new String[5][4];
		
			matrix[0][0]="Ramón";
			matrix[0][1]="Fernández";
			matrix[0][2]="López";
			matrix[0][3]="33000111";
		
			matrix[1][0]="Cármen";
			matrix[1][1]="Lui";
			matrix[1][2]="Pérez";
			matrix[1][3]="33000222";
		
			matrix[2][0]="Sandra";
			matrix[2][1]="Lema";
			matrix[2][2]="Osir";
			matrix[2][3]="33000333";
		
			matrix[3][0]="Brais";
			matrix[3][1]="German";
			matrix[3][2]="Friol";
			matrix[3][3]="33000444";
			
			matrix[4][0]="Saul";
			matrix[4][1]="Pereiro";
			matrix[4][2]="Do Santos";
			matrix[4][3]="33000555";
			
		System.out.print("Introduzaca el DNI de la persona que desee buscar los datos: ");

		String dni_usuario=escaner.nextLine();
		
		String dni_ramon=matrix[0][3];
		
		String dni_carmen=matrix[1][3];
		
		String dni_sandra=matrix[2][3];
		
		String dni_brais=matrix[3][3];
		
		String dni_saul=matrix[4][3];
		
		if(dni_usuario.equals(dni_ramon)==true) {
			
			System.out.print("Esa persona se llama " + matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + " y su DNI es " + matrix[0][3] + ".");
			
		}
		
		else if(dni_usuario.equals(dni_carmen)==true) {
			
			System.out.print("Esa persona se llama " + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + " y su DNI es " + matrix[1][3] + ".");
			
		}
		
		else if(dni_usuario.equals(dni_sandra)==true) {
			
			System.out.print("Esa persona se llama " + matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2] + " y su DNI es " + matrix[2][3] + ".");
			
		}
		
		else if(dni_usuario.equals(dni_brais)==true) {
			
			System.out.print("Esa persona se llama " + matrix[3][0] + " " + matrix[3][1] + " " + matrix[3][2] + " y su DNI es " + matrix[3][3] + ".");
			
		}
		
		else if(dni_usuario.equals(dni_saul)==true) {
			
			System.out.print("Esa persona se llama " + matrix[4][0] + " " + matrix[4][1] + " " + matrix[4][2] + " y su DNI es " + matrix[4][3] + ".");
			
		}
		
		else {
			
			System.out.print("El DNI introducido no pertenece a ninguna persona que esté registrada. ");
			
		}
		
		escaner.close();
		
	}

}
