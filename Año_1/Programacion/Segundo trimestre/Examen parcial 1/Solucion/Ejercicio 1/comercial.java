package Paquete_examen;

public class comercial extends Clase_empleado{

    private double comision;

    public comercial (String nombre, int edad, double salario, double comision) {

        super(nombre, edad, salario);

        this.comision=comision;

    }

    public double getcomision () {

        return this.comision;

    }

    public void setcomision (double comision) {

        this.comision=comision;

    }

    public String toString () {

        return super.toString().replace("Empleado", "Comercial") + "/n- Zona: " + this.comision;

    }

}
