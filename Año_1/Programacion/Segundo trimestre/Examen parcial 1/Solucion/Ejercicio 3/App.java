package paquete;

public class App {
    public static void main(String[] args) {

        // Creamos las fichas.

        Ficha fichaRoja=new Ficha("rojo");
        
        Ficha fichaAzul=new Ficha("azul");

        Ficha fichaVerde=new Ficha("verde");

        Ficha fichaAmarilla=new Ficha("amarillo");

        // Creamos los jugadores.
        
        Jugador j1=new Jugador("Antonio", fichaRoja, 1);

        Jugador j2=new Jugador("Carlos", fichaAzul, 1);

        Jugador j3=new Jugador("María", fichaVerde, 1);

        Jugador j4=new Jugador("Laura", fichaAmarilla, 1);

        // Guardamos a los jugadores en un array.

        Jugador jugadores[]= {j1, j2, j3, j4};

        Oca oca=new Oca(jugadores);

        // Ejecutamos la ronda.

        oca.jugarRonda();

    }
}
