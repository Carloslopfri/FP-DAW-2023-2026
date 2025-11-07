/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.sql.Connection;

import java.sql.Date;

import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author RAMONFR
 */



public class Ejercicio1 {

    private static Connection connection = null;

    static {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("config.txt"));

            int valor = 10;

            String user = "userDAW";

            String password = "Java";

            String url = "jdbc:mysql://jdbc:postgresql://172.20.29.50:5432/super";

            Date fecha = Date.valueOf("2024-05-30");

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {

                    switch (parts[0].trim()) {

                        case "valor":

                            valor = Integer.parseInt(parts[1].trim());

                            break;

                        case "user":

                            user = parts[1].trim();

                            break;

                        case "password":

                            password = parts[1].trim();

                            break;

                        case "url":

                            url = parts[1].trim();

                            break;

                        case "fecha":

                            fecha = Date.valueOf(parts[1].trim());

                            break;

                    }

                }

            }

            if (url != null && user != null && password != null ) {

                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Conexión a la base de datos establecida.");

            } else {

                throw new IOException("Archivo de configuración incompleto.");

            }

        } catch (IOException | SQLException e) {

            System.out.println(e);

        }

    }

    public static Connection getConnection() {

        return connection;

    }

    public static void closeConnection() {

        if (connection != null) {

            try {

                connection.close();

                System.out.println("Conexión a la base de datos cerrada.");

            } catch (SQLException e) {

                System.out.println(e);

            }

        }

    }

}
