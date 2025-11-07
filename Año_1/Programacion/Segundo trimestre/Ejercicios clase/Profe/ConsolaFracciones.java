package paquete_clase;

import java.util.*;

public class ConsolaFracciones {

	public static void main(String[] args) {
		
		Scanner escaner=new Scanner(System.in);
		
		System.out.print("Introduzca el numerador de la 1ª fracción: ");
		
		int numerador1=escaner.nextInt();
		
		System.out.print("Introduzca el denominador de la 1ª fracción: ");
		
		int denominador1=escaner.nextInt();
		
		System.out.print("Introduzca el numerador de la 2ª fracción: ");
		
		int numerador2=escaner.nextInt();
		
		System.out.print("Introduzca el denominador de la 2ª fracción: ");
		
		int denominador2=escaner.nextInt();
		
		Fracciones fr1=new Fracciones(numerador1, denominador1);
		
		Fracciones fr2=new Fracciones(numerador2, denominador2);
		
		System.out.println("La primera fracción es: " + fr1.getNumerador() + "/" + fr1.getDenominador());
		
		System.out.println("La primera fracción es: " + fr2.getNumerador() + "/" + fr2.getDenominador());
		
		escaner.close();

	}

}
