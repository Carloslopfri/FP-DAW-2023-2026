package examen.daw;

import java.io.Serializable;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String nombre;

    private String apellido;

    private int edad;

    private double salarioAnual;

    public Empleado(int id, String nombre, String apellido, int edad, double salarioAnual) {

        this.id = id;

        this.nombre = nombre;

        this.apellido = apellido;

        this.edad = edad;

        this.salarioAnual = salarioAnual;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getApellido() {

        return apellido;

    }

    public void setApellido(String apellido) {

        this.apellido = apellido;

    }

    public int getEdad() {

        return edad;

    }

    public void setEdad(int edad) {

        this.edad = edad;

    }

    public double getSalarioAnual() {

        return salarioAnual;

    }

    public void setSalarioAnual(double salarioAnual) {

        this.salarioAnual = salarioAnual;

    }

    @Override
    public String toString() {

        return "Empleado{" +

                "id=" + id +

                ", nombre='" + nombre + '\'' +

                ", apellido='" + apellido + '\'' +

                ", edad=" + edad +

                ", salarioAnual=" + salarioAnual +

                '}';

    }

}

