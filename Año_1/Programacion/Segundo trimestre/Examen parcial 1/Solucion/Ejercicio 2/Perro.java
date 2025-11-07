/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author ramonfr
 */
public class Perro extends Mascota {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }

    public Perro(String raza) {
        this.raza = raza;
    }
    
    public Perro() {
        this.raza = "Sin confirmar";
    }    

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void andar() {

        System.out.println("Soy " + this.getNombre() + " y estoy caminando.");

    }
    
    @Override
    public String toString(){
        return "Perro: "+ super.getNombre()+" Raza: "+raza+";";
    }
}
