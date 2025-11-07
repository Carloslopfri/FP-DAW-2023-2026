package examen;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class Vuelo implements Comparable<Vuelo> {

    private String id;
    
    private LocalDateTime salida;
    
    private LocalDateTime llegada;

    public Vuelo(String id, LocalDateTime salida, LocalDateTime llegada) {
        
        this.id = id;
        
        this.salida = salida;
        
        this.llegada = llegada;
    }

    public String getId() {
        
        return id;
        
    }

    public LocalDateTime getSalida() {
        
        return salida;
        
    }

    public void setSalida(LocalDateTime salida) {
        
        this.salida = salida;
        
    }

    public LocalDateTime getLlegada() {
        
        return llegada;
        
    }

    public void setLlegada(LocalDateTime llegada) {
        
        this.llegada = llegada;
        
    }

    @Override
    public int compareTo(Vuelo otroVuelo) {
        
        return this.salida.compareTo(otroVuelo.getSalida());
        
    }

    public void modificarHorario(int minutos) {
        
        this.salida = this.salida.plusMinutes(minutos);
        
        this.llegada = this.llegada.plusMinutes(minutos);
        
    }

    @Override
    public String toString() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        return "Vuelo ID: " + id + ", Salida: " + salida.format(formatter) + ", Llegada: " + llegada.format(formatter);
        
    }

}
