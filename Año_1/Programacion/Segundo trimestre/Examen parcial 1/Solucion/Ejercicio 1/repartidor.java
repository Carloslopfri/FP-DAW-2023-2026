package Paquete_examen;

public class repartidor extends Clase_empleado {

    private String zona;

    public repartidor (String nombre, int edad, double salario, String zona) {

        super(nombre, edad, salario);

        this.zona=zona;

    }

    public String getzona () {

        return this.zona=zona;

    }

    public void setzona (String zona) {

        this.zona=zona;

    }

    public String toString () {

        return super.toString().replace("Empleado", "Repartidor") + "/n- Zona: " + this.zona;

    }
    
}
