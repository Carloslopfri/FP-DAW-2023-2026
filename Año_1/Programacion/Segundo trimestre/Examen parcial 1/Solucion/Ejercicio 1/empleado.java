package Paquete_examen;

public abstract class empleado {
    
    private String nombre;

    private int edad;

    private double salario;

    private final int PLUS=300;

    public empleado (String nombre, int edad, double salario) {

        this.nombre=nombre;

        this.edad=edad;

        this.salario=salario;

    }

    public String getnombre () { //getter

        return this.nombre;

    }

    public void setnombre (String nombre) { //setter

        this.nombre=nombre; 

    }

    public int getedad () {

        return this.edad;

    }

    public void setedad (int edad) {

        this.edad=edad;

    }

    public double getsalario () {

        return this.salario;

    }

    public void setsalario (double salario) {

        this.salario=salario;

    }

    public String toString () {

        return "Clase_empleado -> /n"
        
                + "- Nombre: " + this.nombre + "/n"

                + "- Edad: " + this.edad  + "/n"

                + "- Salario " + this.salario;

    }

}
