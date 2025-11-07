/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author ramonfr
 */
public class Pajaro extends Mascota implements Vuela {
    private String especie;

    public Pajaro(String especie, String nombre) {
        super(nombre);
        this.especie = especie;
    }

    public Pajaro(String especie) {
        this.especie = especie;
    }
    
    public Pajaro() {
        this.especie = "Sin determinar";
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void volar() {

        System.out.println("Soy " + this.getNombre() + " y estoy volando.");

    }
    
    @Override
    public String toString(){
        return "Pájaro: "+ super.getNombre()+" Especie: "+especie+";";
    }
}
