package paquete;

import java.util.Random;

public class Oca {

    private Jugador[] jugadores;

    private int idJugadorActual;

    public Oca(Jugador[] jugadores) {

        this.jugadores=jugadores;

        this.idJugadorActual=0;

    }

    public void comprobarCasillas (int casilla) {

        switch (casilla) {

            case 5:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 9 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(9);

            break;

            case 9:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 14 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(14);         

            break;

            case 14:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 18 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(18); 

            break;

            case 18:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 23 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(23);
                
            break;

            case 23:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 27 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(27);  
                          
            break;

            case 27:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 32 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(32);

            break;

            case 32:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 36 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(36);

            break;

            case 36:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 41 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(41);

            break;

            case 41:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 45 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(45);

            break;

            case 45:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 50 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(50);

            break;

            case 50:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 54 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(54);

            break;

            case 54:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 59 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(59);

            break;

            case 59:

                System.out.println("Caíste en una Oca. Avanzas hasta la casilla 63 y vuelves a tirar.");

                jugadores[idJugadorActual].setCasilla(63);

            break;

            case 6:
            case 12:

                System.out.println("Avanzas a la casilla 19. Pierdes un turno.");

                jugadores[idJugadorActual].setCasilla(19);

                //jugadorActual.pierdeTurno(1);

                //finalizarTurno();

            break;

            case 19:

                System.out.println("Caíste en la Posada. Pierdes un turno.");

                //jugadorActual.pierdeTurno(1);

                //finalizarTurno();

            break;

            case 31:

                System.out.println("El pozo, no puedes avanzar haste que otro jugador pase por esta casilla.");

                //jugadorActual.setBloqueado(true);

                //finalizarTurno();

            break;

            case 42:

                System.out.println("El Laberinto. Retrocedes a la casilla 30.");

                jugadores[idJugadorActual].setCasilla(30);

                //finalizarTurno();

            break;

            case 56:

                System.out.println("La carcel. Pierdes dos turnos.");

                //jugadorActual.pierdeTurno(2);

                //finalizarTurno();

            break;

            case 26:

                System.out.println("Dados. Vas a la otra casilla de dados y vueves a tirar.");

                jugadores[idJugadorActual].setCasilla(53);

            break;

            case 53:

                System.out.println("Dados. Vas a la otra casilla de dados y vueves a tirar.");

                jugadores[idJugadorActual].setCasilla(26);

            break;

            case 58:

                System.out.println("La calavera. Retrocedes a la casilla 1.");

                jugadores[idJugadorActual].setCasilla(1);

                //finalizarTurno();

            break;
            default:

                System.out.println("Avanzas a la casilla "+ jugadores[idJugadorActual].getCasilla() +".");

                //finalizarTurno();
        
        }
        
    }

    public void jugarRonda() {

        Jugador ganador= null;

        do {

            System.out.println("Tirada del jugador " + jugadores[idJugadorActual].getNombre());

            int casilla=jugadores[idJugadorActual].tirarDados();

            int casillaActual=jugadores[idJugadorActual].getCasilla();

            int siguienteCasilla=casillaActual + casilla;

            jugadores[idJugadorActual].setCasilla(siguienteCasilla);

            comprobarCasillas(siguienteCasilla);

            if(jugadores[idJugadorActual].getCasilla()==63) {

                ganador=jugadores[idJugadorActual];

            }

            if(idJugadorActual==3) {

                idJugadorActual=0;

            }

            else {

                idJugadorActual++;

            }

        } while(ganador==null);

        System.out.println("Ha ganado " + ganador.getNombre() + ".");

    }
    
}
