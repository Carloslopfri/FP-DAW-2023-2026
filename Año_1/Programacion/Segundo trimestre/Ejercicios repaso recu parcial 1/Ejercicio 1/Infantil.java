package Ejercicio1;

public class Infantil extends Infante implements InterfacesBasicas{

    private String nombreGuarderia;

    private boolean alergico;

    public Infantil(String nombreGuarderia, boolean alergico, String fechaNacimiento, String nombre) {

        super(fechaNacimiento, nombre);

        this.nombreGuarderia = nombreGuarderia;

        this.alergico = alergico;

    }

    public String getNombreGuarderia() {

        return nombreGuarderia;

    }

    public void setNombreGuarderia(String nombreGuarderia) {

        this.nombreGuarderia = nombreGuarderia;

    }

    public boolean isAlergico() {

        return alergico;

    }

    public void setAlergico(boolean alergico) {

        this.alergico = alergico;

    }

    public String comer (String comida) {

        return "El niño " + getNombre() + " está comiendo " + comida + ".";

    }

    public String dormir (String lugar, int tiempo) {

        return "El niño " + getNombre() + " está durmiendo en " + lugar + " durante " + tiempo + " minutos.";

    }

    public String hablar() {

        return "El niño " + getNombre() + " está hablando.";

    }

    public String toString() {

        return "Infantil {" + "nombreGuarderia=" + nombreGuarderia + ", alergico=" + alergico + ", fechaNacimiento=" + getFechaNacimiento() + ", nombre=" + getNombre() + '}';

    }
    
}
