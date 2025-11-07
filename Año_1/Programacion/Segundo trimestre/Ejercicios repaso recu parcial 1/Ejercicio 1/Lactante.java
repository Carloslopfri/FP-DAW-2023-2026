package Ejercicio1;

public class Lactante extends Infante implements InterfacesBasicas {

    private TipoLactancia tipoLactancia;

    public Lactante(String fechaNacimiento, String nombre, TipoLactancia tipoLactancia) {

        super(fechaNacimiento, nombre);

        this.tipoLactancia = tipoLactancia;

    }

    public TipoLactancia getTipoLactancia() {

        return tipoLactancia;

    }

    public void setTipoLactancia(TipoLactancia tipoLactancia) {

        this.tipoLactancia = tipoLactancia;

    }

    public String comer (String comida) {

        return "El lactante " + getNombre() + " está comiendo " + comida + ".";

    }

    public String dormir (String lugar, int tiempo) {

        return "El lactante " + getNombre() + " está durmiendo en " + lugar + " durante " + tiempo + " minutos.";

    }

    public String hablar() {

        return "El lactante " + getNombre() + " está balbuceando.";

    }

    public String toString() {

        return "Lactante {" + "tipoLactancia=" + tipoLactancia + ", fechaNacimiento=" + getFechaNacimiento() + ", nombre=" + getNombre() + '}';

    }
    
}
