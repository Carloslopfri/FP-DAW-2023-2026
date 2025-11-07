package Paquete_de_modelo_de_examen_filtrado;

import java.util.Scanner;

public class Ejercicio3_bien {

	public static void main(String[] args) {
		
		Scanner escaner=new Scanner(System.in);
		
		String [][] datos= {{"Ramon","Fernandez","Lopez","33000111"},
							{"Carmen","Lui","Perez","33000222"},
							{"Sandra","Lema","Osir","33000333"},
							{"Brais","German","Friol","33000444"},
							{"Saul","Pereiro","Do Santos","33000555"}};
		
		String dni="";
		
		int indice=0;
		
		System.out.print("Dime el DNI del cliente que deseas comprobar: ");
		
		dni=escaner.nextLine();
		
		indice=busca(datos,dni);
		
		escaner.close();
		
		switch (indice) {
		
		case 6:
			
			System.out.print("El cliente no existe.");
			
		break;
		
		case 7:
			
			System.out.print("El DNI introducido no es válido.");
			
		break;
		
		default:
			
			System.out.println("DATOS DEL CLIENTE");
			
			System.out.println("NOMBRE: " + datos[indice][0]);
			
			System.out.println("Apellidos: " + datos[indice][1] + ", " + datos[indice][2]);
			
			System.out.println("DNI: " + datos[indice][3]);
			
			break;
		
		}
		
	}
	
	public static int busca(String [][] datos ,  String dni) {
		
		int indice=0;
		
		if(dni.length()==8) {
			
			for (int i=0; i<datos.length; i++) {
				
				if(dni.equals(datos[i][3])) {
					
					indice=i;	
					
				break;
					
				}
				
				else {
					
					indice=6;
					
				}
				
			}
			
		}
		
		else {
			
			indice=7;
			
		}
		
		return indice;
		
	}

}
