import atletismo.Atleta;

import java.time.LocalDateTime;

import java.util.ArrayList;

public class Carrera {

    private String nombre;

    private LocalDateTime fechayhora;

    private int numeroMaximodeparticipantes;

    private int edadMinima;

    private ArrayList<Atleta> participantes;

    public Carrera(String nombre, LocalDateTime fechayhora, int numeroMaximodeparticipantes, int edadMinima) {

        this.nombre = nombre;

        this.fechayhora = fechayhora;

        this.numeroMaximodeparticipantes = numeroMaximodeparticipantes;

        this.edadMinima = edadMinima;

        this.participantes = new ArrayList<>();

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public LocalDateTime getFechayhora() {

        return fechayhora;

    }

    public void setFechayhora(LocalDateTime fechayhora) {

        this.fechayhora = fechayhora;

    }

    public int getNumeroMaximodeparticipantes() {

        return numeroMaximodeparticipantes;

    }

    public void setNumeroMaximodeparticipantes(int numeroMaximodeparticipantes) {

        this.numeroMaximodeparticipantes = numeroMaximodeparticipantes;

    }

    public int getEdadMinima() {

        return edadMinima;

    }

    public void setEdadMinima(int edadMinima) {

        this.edadMinima = edadMinima;

    }

    public ArrayList<Atleta> getParticipantes() {

        return participantes;

    }

    public void setParticipantes(ArrayList<Atleta> participantes) {

        this.participantes = participantes;

    }

    public void addParticipantes(Atleta atleta) {

        this.participantes.add(atleta);

    }

    @Override
    public String toString() {

        return "Carrera{" +

                "nombre='" + nombre + '\'' +

                ", fechayhora=" + fechayhora +

                ", numeroMaximodeparticipantes=" + numeroMaximodeparticipantes +

                ", edadMinima=" + edadMinima +

                ", participantes=" + participantes +

                '}';

    }

}
