package Ejercicio1;

public abstract class Infante {

    private String fechaNacimiento;

    private String nombre;

    protected Infante(String fechaNacimiento, String nombre) {

        this.fechaNacimiento = fechaNacimiento;

        this.nombre = nombre;

    }

    protected String getFechaNacimiento() {

        return fechaNacimiento;

    }

    protected void setFechaNacimiento(String fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;

    }

    protected String getNombre() {

        return nombre;

    }

    protected void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String toString() {

        return "Infante {" + "fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + '}';

    }
    
}
