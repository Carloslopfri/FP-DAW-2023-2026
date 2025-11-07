/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;

import java.sql.*;

public class Ejercicio5 {

    public static void ejecutar() {

        Connection connection = null;

        try {

            connection.setAutoCommit(false);

            String insertProveedorSQL = "INSERT INTO proveedores (nombre) VALUES (?)";

            PreparedStatement insertProveedorStmt = connection.prepareStatement(insertProveedorSQL);

            insertProveedorStmt.setString(1, "Nuevo Proveedor");

            insertProveedorStmt.executeUpdate();

            int idProveedor = obtenerUltimoID(connection, "proveedores");

            String insertProductoSQL = "INSERT INTO productos (nombre, id_proveedor) VALUES (?, ?)";

            PreparedStatement insertProductoStmt = connection.prepareStatement(insertProductoSQL);

            insertProductoStmt.setString(1, "Producto 1");

            insertProductoStmt.setInt(2, idProveedor);

            insertProductoStmt.executeUpdate();

            insertProductoStmt.setString(1, "Producto 2");

            insertProductoStmt.setInt(2, idProveedor);

            insertProductoStmt.executeUpdate();

            connection.commit();

            System.out.println("Transacción completada: Nuevo proveedor y productos insertados correctamente.");

        } catch (SQLException e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException ex) {

                    System.out.println(e);

                }

            }

            e.printStackTrace();

        } finally {

            if (connection != null) {

                try {

                    connection.close();

                } catch (SQLException e) {

                    System.out.println(e);

                }

            }

        }

    }

    private static int obtenerUltimoID(Connection connection, String tabla) throws SQLException {

        int ultimoID = -1;

        String query = "SELECT MAX(id) AS ultimo_id FROM " + tabla;

        PreparedStatement statement = connection.prepareStatement(query);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {

                ultimoID = resultSet.getInt("ultimo_id");

            }

        }

        return ultimoID;

    }

}