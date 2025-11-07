package examenresuelto;

import java.util.*;

import libreriaprueba.*;

public class GestAirport {
    
    private List<Vuelos> vuelos = new ArrayList<>();

    public void mostrarColaDeVuelos() {
        
        Collections.sort(vuelos, Comparator.comparing(Vuelos::getFechaHoraOrigen));
        
        for (Vuelos vuelo : vuelos) {
            
            System.out.println(vuelo);
            
        }
        
    }

    public void añadirNuevoVuelo(Vuelos vuelo) throws FechaHoraSalidaNoValidaException {
        
        if (vuelo.getFechaHoraOrigen().compareTo(new Date()) < 0) {
            
            throw new FechaHoraSalidaNoValidaException("La fecha/hora de salida no puede ser anterior a la fecha/hora actual");
            
        }
        
        vuelos.add(vuelo);
        
        Collections.sort(vuelos, Comparator.comparing(Vuelos::getFechaHoraOrigen));
        
    }

    public void eliminarVuelo(String nombre) {
        
        vuelos.removeIf(vuelo -> vuelo.getNombre().equals(nombre));
        
    }

    public void darSalida() {
        
        if (!vuelos.isEmpty()) {
            
            vuelos.remove(0);
            
        }
        
    }

    public void actualizarListaDeVuelos() {
        
        vuelos.removeIf(vuelo -> vuelo.getFechaHoraOrigen().compareTo(new Date()) < 0);
        
    }

    public void modificarHorarios(String nombre, int minutos) throws ValorNoValidoException {
        
        if (minutos < 0) {
            
            throw new ValorNoValidoException("El valor no puede ser negativo");
            
        }
        
        for (Vuelos vuelo : vuelos) {
            
            if (vuelo.getNombre().equals(nombre)) {
                
                // Aquí debes actualizar los horarios del vuelo
                
            }
            
        }
        
    }

    public void salir() {
        
        System.exit(0);
        
    }

}