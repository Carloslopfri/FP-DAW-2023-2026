package Ejercicio1;

public class Escolar extends Infante implements InterfacesBasicas {

    private String nombreColegio;

    private String deporte1;

    private String deporte2;

    private String deporte3;

    public Escolar(String fechaNacimiento, String nombre, String nombreColegio, String deporte1, String deporte2, String deporte3) {

        super(fechaNacimiento, nombre);

        this.nombreColegio = nombreColegio;

        this.deporte1 = deporte1;

        this.deporte2 = deporte2;

        this.deporte3 = deporte3;

    }

    public String getNombreColegio() {

        return nombreColegio;

    }

    public void setNombreColegio(String nombreColegio) {

        this.nombreColegio = nombreColegio;

    }

    public String getDeporte1() {

        return deporte1;

    }

    public void setDeporte1(String deporte1) {

        this.deporte1 = deporte1;

    }

    public String getDeporte2() {

        return deporte2;

    }

    public void setDeporte2(String deporte2) {

        this.deporte2 = deporte2;

    }

    public String getDeporte3() {

        return deporte3;

    }

    public void setDeporte3(String deporte3) {

        this.deporte3 = deporte3;

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

        return "Escolar {" + "nombreColegio=" + nombreColegio + ", deporte1=" + deporte1 + ", deporte2=" + deporte2 + ", deporte3=" + deporte3 + ", fechaNacimiento=" + getFechaNacimiento() + ", nombre=" + getNombre() + '}';

    }
    
}
