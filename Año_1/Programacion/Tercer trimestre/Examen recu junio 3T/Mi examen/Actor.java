/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.time.LocalDate;

/**
 *
 * @author RAMONFR
 */
class Actor {
    private static int nextId = 0;

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int aNextId) {
        nextId = aNextId;
    }
    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean nuevo = false;
    private boolean modificado = false;
    private boolean eliminado = false;

    /*
    Para crear actores almacenados en la base de datos
    */
    public Actor(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        if(id >= nextId ){
           nextId = ++id;
        }
    }

    /*
    Para crear nuevos actores
    */
    public Actor(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        nuevo = true;
        id = nextId;
        nextId++;
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
                if(!nuevo){
            modificado = true;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
                if(!nuevo){
            modificado = true;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        if(!nuevo){
            modificado = true;
        }
        
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public boolean isModificado() {
        return modificado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
        nuevo = false;
        modificado = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Actor{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
