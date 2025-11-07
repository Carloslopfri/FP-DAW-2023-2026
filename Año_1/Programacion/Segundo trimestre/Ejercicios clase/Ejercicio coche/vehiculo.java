package paquete_vehiculos;

public class vehiculo {
	
	 private int ruedas;
     
	    private int largo;

	    private int ancho;

	    private int motor;

	    private int peso_plataforma;

	    private String color;

	    //private int peso_total;

	    private boolean asientos_cuero;
	    
	    private boolean climatizador;
	    
	    public vehiculo() {
	    	
	    	ruedas=4;
	    	
	    	largo=200;
	    	
	    	ancho=300;
	    	
	    	motor=1600;
	    	
	    	peso_plataforma=600;
	    	
	    }

	    public void establece_color(String color) {
	
	    	this.color=color;
	
	    }
	    
	    public void establece_asientos(String asientos) {
	    	
	    	if(asientos=="si") {
	    		
	    		asientos_cuero=true;
	    		
	    	}
	    	
	    	else if(asientos=="no") {
	    		
	    		asientos_cuero=false;
	    		
	    	}
	    	
	    }
	    
	    public void establece_climatizador(String climatizador) {
	    	
	    	if(climatizador=="si") {
	    		
	    		this.climatizador=true;
	    		
	    	}
	    	
	    	else if(climatizador=="no") {
	    		
	    		this.climatizador=false;
	    		
	    	}
	    	
	    }
	    
}