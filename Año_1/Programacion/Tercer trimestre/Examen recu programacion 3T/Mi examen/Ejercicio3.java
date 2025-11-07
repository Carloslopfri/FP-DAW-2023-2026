/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.sql.Connection;

/**
 *
 * @author RAMONFR
 */

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

public class Ejercicio3 {

    public static void ejecutar() {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {

            List<Empleado> empleados = obtenerEmpleados(connection);

            guardarEmpleadosEnArchivo(empleados);

        }

        DatabaseConnection.closeConnection();

    }

    private static List<Empleado> obtenerEmpleados(Connection connection) {

        List<Empleado> empleados = new ArrayList<>();

        String query = "SELECT id, nombre, apellido, edad, salario_anual FROM empleados";

        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

             ResultSet resultSet = statement.executeQuery(query)) {

            resultSet.afterLast();

            while (resultSet.previous()) {

                int id = resultSet.getInt("id");

                String nombre = resultSet.getString("nombre");

                String apellido = resultSet.getString("apellido");

                int edad = resultSet.getInt("edad");

                double salarioAnual = resultSet.getDouble("salario_anual");

                Empleado empleado = new Empleado(id, nombre, apellido, edad, salarioAnual);

                empleados.add(empleado);

            }

        } catch (SQLException e) {

            System.out.println(e);

        }

        return empleados;

    }

    private static void guardarEmpleadosEnArchivo(List<Empleado> empleados) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {

            for (Empleado empleado : empleados) {

                oos.writeObject(empleado);

            }

            System.out.println("Datos de empleados guardados en empleados.dat en orden inverso.");

        } catch (IOException e) {

            System.out.println(e);

        }

    }

}