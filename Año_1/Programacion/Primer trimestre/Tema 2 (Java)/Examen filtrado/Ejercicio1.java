package Paquete_de_modelo_de_examen_filtrado;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner escaner=new Scanner(System.in);
		
		System.out.println("Hola, bienvenido a nuestra web. Si desea solicitar una cita debe intruducir los siguientes datos: ");
		
		System.out.print("Nombre: ");
		
		String nombre=escaner.nextLine();
		
		System.out.print("Primer apellido: ");
		
		String apellido1=escaner.nextLine();
		
		System.out.print("Segundo apellido: ");
		
		String apellido2=escaner.nextLine();
		
		System.out.print("DNI: ");
		
		String DNI=escaner.nextLine();
		
		System.out.print("Número de contacto: ");
		
		int telefono=escaner.nextInt();
		
		System.out.println("Muchas gracias, " + nombre + ", " + apellido1 + " " + apellido2 + " (" + DNI + ") por registrarse.");
		
		System.out.println("Lo llamaremos al número " + telefono + " a la mayor brevedad posible.");
		
		escaner.close();
		
	}

}
