package Paquete_modelo_examen;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
	Scanner escaner = new Scanner(System.in);
	
	System.out.println("Bienvenido a nuestra página, para registrarse siga los pasos:");
	
	System.out.print("Nombre: ");
		
	String nombre=escaner.nextLine(); //"String" se usa para declarar texto y en el escaner tienes que poner "nextLine"
	
	System.out.print("Primer apellido: ");
	
	String Apellido1=escaner.nextLine();
	
	System.out.print("Segundo apellido: ");
	
	String Apellido2=escaner.nextLine();
	
	System.out.print("DNI: ");
	
	String DNI=escaner.nextLine();
	
	System.out.print("Número de contacto: ");
	
	int Telefono=escaner.nextInt();
	
	System.out.println("Muchas gracias " + nombre + " " + Apellido1 + " " + Apellido2 + "(" + DNI + ")" + " por registrarse.");
	
	System.out.print("Lo llamaremos al número " + Telefono + " a la mayor brevedad posible.");
	
	escaner.close();

	}

}
