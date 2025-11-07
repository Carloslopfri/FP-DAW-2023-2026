package paquete;

public class Jugador {

    private String nombre;

    private Ficha ficha;

    private int casilla;

    public Jugador(String nombre, Ficha ficha, int casilla) {

        this.nombre=nombre;

        this.ficha=ficha;

        this.casilla=casilla;

    }

    public String getNombre() {

        return this.nombre;

    }

    public Ficha getFicha() {

        return this.ficha;

    }

    public int getCasilla() {

        return this.casilla;

    }

    public void setCasilla(int casilla) {

        if(casilla>=1 && casilla<=63) {

            this.casilla=casilla;

        }

    }

    public int tirarDados() {

        return Dado.getCara() + Dado.getCara();

    }
    
}
