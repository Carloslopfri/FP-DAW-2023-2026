package paquete_clase;

public class Fracciones {

	private int numerador;
	
	private int denominador;
	
	public Fracciones(int a, int b) {
		
		this.numerador=a;
		
		if(b!=0) {
			
			this.denominador=b;
			
		}
			
		else {
			
			this.denominador=1;
			
		}
		
	}
	
	public int getDenominador() {
		
		return this.denominador;
		
	}
	
	public int getNumerador() {
		
		return this.numerador;
		
	}
	
	public void setDenominador(int num) {
		
		this.denominador=num;
		
	}
	
	public void serNumerador(int num) {
		
		this.numerador=num;
		
	}
	
	public void invertir() {
		
		int aux;
		
		if(this.numerador !=0) {
			
			aux=this.numerador;
			
			this.numerador=this.denominador;
			
			this.denominador=aux;
			
		}
		
	}
	
	public static void invertir(Fracciones obj) {
		
		int aux;
		
		if(obj.numerador!=0) {
			
			aux=obj.numerador;
			
			obj.numerador=obj.denominador;
			
			obj.denominador=aux;
			
		}
		
	}
	
	public void simplificar() {
		
		int mod;
		
		mod=Fracciones.mod(Math.abs(this.numerador), Math.abs(this.denominador));
		
		this.numerador/=mod;
		
		this.denominador=this.denominador/mod;
		
	}
	
	public static int mod(int num1, int num2) {
		
		int a=Math.max(num1, num2);
		
		int b=Math.min(num1, num2);
		
		int resultado=0;
		
		do {
			
			resultado=b;
			
			b=a%b;
			
			a=resultado;
			
		}while(b!=0);
		
		return resultado;
		
	}

}
