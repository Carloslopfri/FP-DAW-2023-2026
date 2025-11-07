/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
*
*       AÑADE TÚ CODIGO
*
*/


/**
 *
 * @author 
 */
public class Ejercicio4 {

    static List<Actor> actores = new ArrayList<Actor>();

    private static Connection conexion;

    private static String url = "jdbc:mysql://localhost:3306/sakila"; //EXAMEN = jdbc:mysql://172.21.29.50:3306/sakila

    private static String usuario = "userDAW";

    private static String contraseña = "Java";

    public static void ejecutar() {

        //CONEXION A LA BBDD.

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, contraseña);

        } catch (ClassNotFoundException e) {

            System.out.println(e);

        } catch (SQLException e) {

            System.out.println(e);

        }

        cargarDatos();
            menu();
            actualizarDatos();

        try {

            conexion.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    private static void menu() {
        byte option;
        int id = 0;

        do {
            System.out.println("**************************");
            System.out.println("*** Ejercicio 4 - MENÚ ***");
            System.out.println("**************************");

            System.out.println("\t(1) Mostrar actores.");
            System.out.println("\t(2) Modificar un actor.");
            System.out.println("\t(3) Añadir nuevo actor.");
            System.out.println("\t(4) Elminar actor.");
            System.out.println("\t(0) Salir.");
            option = Herramientas.validarOpcion(0, 4);
            switch (option) {
                case 1:
                    mostrarActores();
                    break;
                case 2:
                    modificarActor();
                    break;
                case 3:
                    addActor();
                    break;
                case 4:
                    eliminarActor();
                    break;
            }
        } while (option != 0);

    }

    private static void mostrarActores() {
        Iterator it = actores.iterator();
        Actor act;
        System.out.println("*** Listado de actores ***");

        while (it.hasNext()) {
            act = (Actor) it.next();
            if (!act.isEliminado()) {
                System.out.println(act);
            }
        }

        System.out.println("");
    }

    private static void modificarActor() {
        Actor actor;
        boolean realizado = false;
        int id = Herramientas.leerInt("Introduce el id del actor: ");
        for (Actor act : actores) {
            if (act.getId() == id) {
                actor = act;
                System.out.println("Datos originales del actor: ");
                System.out.println(act);
                System.out.println("");
                actor.setNombre(Herramientas.leerString("Introduce el nombre: "));
                actor.setApellidos(Herramientas.leerString("Introduce los apellidos: "));
                actor.setFechaNacimiento(Herramientas.leerFecha("Introduce la fecha de nacimiento: "));
                realizado = true;
            }

        }
        if (!realizado) {
            System.out.println("El id = " + id + " no ha sido encontrado.");
        }
    }

    private static void addActor() {
        String nombre, apellidos;
        LocalDate fecha;
        nombre = Herramientas.leerString("Inroduce el nombre: ");
        apellidos = Herramientas.leerString("Inroduce los apellidos: ");
        fecha = LocalDate.parse(Herramientas.leerString("Inroduce la fecha de nacimiento: "));
        actores.add(new Actor(nombre, apellidos, fecha));
    }

    private static void eliminarActor() {
        boolean realizado = false;
        int id = Herramientas.leerInt("Introduce el id del actor: ");
        for (Actor act : actores) {
            if (act.getId() == id) {
                if(act.isNuevo()){
                    actores.remove(act);
                }else{
                    act.setEliminado(true);
                }
                realizado = true;
            }

        }
        if (!realizado) {
            System.out.println("El id = " + id + " no ha sido encontrado.");
        }
    }

    private static void cargarDatos() {

        try {

            String sql = "SELECT * FROM actores";

            Statement orden = conexion.createStatement(); //Preparas una orden de sql vacía.

            ResultSet actoresRS = orden.executeQuery(sql); //Ejecutas el sql en la orden vacía, para que te devuleva algo.

            while (actoresRS.next()) { //Los ResultSet solo se pueden recorrer con un while.

                Actor actor = new Actor(

                        actoresRS.getInt("actor_id"),

                        actoresRS.getString("nombre"),

                        actoresRS.getString("apellidos"),

                        actoresRS.getDate("fecha_complueaños").toLocalDate()

                );

                actores.add(actor);

            }

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    private static void actualizarDatos() {

        for (Actor actor : actores) {

            if (actor.isNuevo() == true) {

                try {

                    String sql = "INSERT INTO actores (actor_id, nombre, apellidos, fecha_complueaños) VALUES (?,?,?,?)";

                    PreparedStatement orden = conexion.prepareStatement(sql); //Ejecutas el sql.

                    orden.setInt(1, actor.getId());

                    orden.setString(2, actor.getNombre());

                    orden.setString(3, actor.getApellidos());

                    orden.setDate(4, Date.valueOf(actor.getFechaNacimiento()));

                    orden.executeUpdate();

                } catch (SQLException e) {

                    System.out.println(e);

                }

            }

            else if (actor.isModificado() == true) {

                try {

                    String sql = "UPDATE actores SET nombre = ?, apellidos = ?, fecha_complueaños = ? WHERE actor_id = ?";

                    PreparedStatement orden = conexion.prepareStatement(sql); //Ejecutas el sql.

                    orden.setString(1, actor.getNombre());

                    orden.setString(2, actor.getApellidos());

                    orden.setDate(3, Date.valueOf(actor.getFechaNacimiento()));

                    orden.setInt(4, actor.getId());

                    orden.executeUpdate();

                } catch (SQLException e) {

                    System.out.println(e);

                }

            }

            else if (actor.isEliminado() == true) {

                try {

                    String sql = "DELETE FROM actores WHERE actor_id = ?";

                    PreparedStatement orden = conexion.prepareStatement(sql); //Ejecutas el sql.

                    orden.setInt(1, actor.getId());

                    orden.executeUpdate();

                } catch (SQLException e) {

                    System.out.println(e);

                }

            }

        }
        
    }

}
