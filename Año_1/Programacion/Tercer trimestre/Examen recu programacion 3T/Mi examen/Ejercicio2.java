/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


/**
 *
 * @author ramonfr
 */

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

public class Ejercicio2 {

    public static void ejecutar() {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {

            List<Proveedor> proveedores = obtenerProveedores(connection);

            guardarProveedoresEnArchivo(proveedores);

        }

        DatabaseConnection.closeConnection();

    }

    private static List<Proveedor> obtenerProveedores(Connection connection) {

        List<Proveedor> proveedores = new ArrayList<>();

        String query = "SELECT id_proveedor, codigo, imagen, nombre, marca, tipo, grupo, peso, precio_unidad, stock FROM proveedores";

        try (Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                int idProveedor = resultSet.getInt("id_proveedor");

                String codigo = resultSet.getString("codigo");

                byte[] imagen = resultSet.getBytes("imagen");

                String nombre = resultSet.getString("nombre");

                String marca = resultSet.getString("marca");

                String tipo = resultSet.getString("tipo");

                String grupo = resultSet.getString("grupo");

                double peso = resultSet.getDouble("peso");

                double precioUnidad = resultSet.getDouble("precio_unidad");

                int stock = resultSet.getInt("stock");

                Proveedor proveedor = new Proveedor(idProveedor, codigo, imagen, nombre, marca, tipo, grupo, peso, precioUnidad, stock);

                proveedores.add(proveedor);
            }

        } catch (SQLException e) {

            System.out.println(e);

        }

        return proveedores;

    }

    private static void guardarProveedoresEnArchivo(List<Proveedor> proveedores) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("proveedores.dat"))) {

            for (Proveedor proveedor : proveedores) {

                oos.writeObject(proveedor);

            }

            System.out.println("Datos de proveedores guardados en proveedores.dat");

        } catch (IOException e) {

            System.out.println(e);

        }

    }

}