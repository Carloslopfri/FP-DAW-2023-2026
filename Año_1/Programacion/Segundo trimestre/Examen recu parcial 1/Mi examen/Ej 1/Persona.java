/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

public class Persona {

    private String nombre;

    private String apellidos;

    private String fechaNacimiento;

    public Persona (String nombre, String apellidos, String fechaNacimiento) {

        this.nombre=nombre;

        this.apellidos=apellidos;

        this.fechaNacimiento=fechaNacimiento;

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getApellidos() {

        return apellidos;

    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;

    }

    public String getFechaNacimiento() {

        return fechaNacimiento;

    }

    public void setFechaNacimiento(String fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;

    }

}
