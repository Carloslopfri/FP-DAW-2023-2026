package paquete_vehiculos;

public class furgoneta {
	
	int CV;
	
	int capacidad_personas;
	
	int capacidad_carga;
	
	public void establece_CV(int CV) {
		
		this.CV=CV;
		
	}
	
	public String dame_CV() {
		
		if(CV==120) {
			
			return "El motor del coche tendrá una potencia de 70 CV.";
			
		}
		
		else if(CV==140) {
			
			return "El motor del coche tendrá una potencia de 100 CV.";
			
		}
		
		else if(CV==160) {
			
			return "El motor del coche tendrá una potencia de 120 CV.";
			
		}
		
		else {
			
			return "Opción no válida.";
			
		}
		
	}
	
	public void establece_personas(int personas) {
		
		capacidad_personas=personas;
		
	}
	
	public String dame_CarPers() {
		
		if(capacidad_personas==7) {
			
			return "La furgoneta tiene 7 plazas:";
			
		}
		
		else if(capacidad_personas==8) {
			
			return "La furgoneta tiene 8 plazas:";
			
		}
		
		else if(capacidad_personas==9) {
			
			return "La furgoneta tiene 9 plazas:";
			
		}
		
		else {
			
			return "Opción no válida.";
			
		}
		
	}

}















