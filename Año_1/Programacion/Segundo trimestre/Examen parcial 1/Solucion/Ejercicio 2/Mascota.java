/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author ramonfr
 */
public class Mascota {
    private String nombre;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota() {
        this.nombre = "Pitu";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString () {

        return "Mascota: " + this.nombre;

    }
    
}
