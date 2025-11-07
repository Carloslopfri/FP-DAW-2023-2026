package paquete1;

import java.util.ArrayList;

import java.util.Scanner;

public class Control {

	private int cantidadPersonas = 5;
	
	ArrayList<Persona> personas = new ArrayList<>();

	public Control(int cantidadPersonas, ArrayList<Persona> personas) {
		
		this.cantidadPersonas = cantidadPersonas;
		
		this.personas = personas;
		
	}
	
	public void menu() {
		
		for(int i = 0 ; i < cantidadPersonas; i++) {
			
			Scanner escaner=new Scanner(System.in);
    	
			System.out.println("Dime el nombre de la persona: ");
			
			String nombre=escaner.nextLine();
			
			String apellido=escaner.nextLine();
			
			String genero=escaner.nextLine();
			
			int edad=escaner.nextInt();
			
			Persona p1=new Persona(nombre, apellido, genero, edad);
			
			escaner.close();
    	
		}
    
	}
	
}