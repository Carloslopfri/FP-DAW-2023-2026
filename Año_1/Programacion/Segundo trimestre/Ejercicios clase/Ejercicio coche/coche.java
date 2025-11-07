package paquete_vehiculos;

public class coche extends vehiculo {
	
	int CV;
	
	String aleron;
	
	boolean escapeT;
	
	public void establece_CV(int CV) {
		
		this.CV=CV;
		
	}
	
	public String dame_CV() {
		
		if(CV==70) {
			
			return "El motor del coche tendrá una potencia de 70 CV.";
			
		}
		
		else if(CV==100) {
			
			return "El motor del coche tendrá una potencia de 100 CV.";
			
		}
		
		else if(CV==120) {
			
			return "El motor del coche tendrá una potencia de 120 CV.";
			
		}
		
		else {
			
			return "Opción no válida.";
			
		}
		
	}
	
	public void establece_aleron(String aleron) {
		
		this.aleron=aleron;
		
	}
	
	public String dime_aleron() {
		
		if(aleron=="largo") {
			
			return "El coche tendrá el escape largo.";
			
		}
		
		else if(aleron=="corto") {
			
			return "El coche tendrá el escape corto.";
			
		}
		
		else if(aleron=="predeterminado") {
			
			return "El coche tendrá el escape predeterminado.";
			
		}
		
		else {
			
			return "Opción no válida.";
			
		}
		
	}
	
	public void establece_escape(String escape) {
		
		if(escape=="si") {
			
			escapeT=true;
			
		}
		
		else if(escape=="no") {
			
			escapeT=false;
			
		}
		
	}
	
	public String dame_escape() {
		
		if(escapeT=true) {
			
			return "El escape va a estar mejorado.";
			
		}
		
		else if(escapeT=false) {
			
			return "El escape va a ser el predeterminado.";
			
		}
		
		else {
			
			return "Opción no válida.";
			
		}
		
	}

}
