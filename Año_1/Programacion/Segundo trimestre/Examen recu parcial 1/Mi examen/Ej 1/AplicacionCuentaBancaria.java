/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;


import java.util.Scanner;

public class AplicacionCuentaBancaria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CuentaBancaria[] cuentas = new CuentaBancaria[100];

        Persona[] personas = new Persona[100]; // Declaración de la variable personas

        int numCuentas = 0;

        int numPersonas = 0;

        while (true) {

            System.out.println("1. Abrir una nueva cuenta.");

            System.out.println("2. Ver un listado de las cuentas disponibles.");

            System.out.println("3. Realizar un ingreso en una cuenta.");

            System.out.println("4. Retirar efectivo de una cuenta.");

            System.out.println("5. Salir de la aplicación.");

            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Ingrese el nombre del titular de la cuenta:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese los apellidos del titular de la cuenta:");
                    String apellidos = scanner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento del titular de la cuenta:");
                    String fechaNacimiento = scanner.nextLine();
                    // ...
                    Persona persona = new Persona(nombre, apellidos, fechaNacimiento);
                    personas[numPersonas] = persona;
                    numPersonas++;

                case 2:

                    System.out.println("Listado de personas:");
                    for (int i = 0; i < numPersonas; i++) {
                        System.out.println("Persona " + (i + 1) + ":");
                        System.out.println("Nombre: " + personas[i].getNombre());
                        System.out.println("Apellidos: " + personas[i].getApellidos());
                        System.out.println("Fecha de nacimiento: " + personas[i].getFechaNacimiento());
                    }

                    break;

                case 3:

                    System.out.println("Ingrese el número de la cuenta en la que desea realizar el ingreso:");
                    int numCuenta = scanner.nextInt();
                    if (numCuenta < 1 || numCuenta > numCuentas) {
                        System.out.println("Número de cuenta no válido. Por favor, intente de nuevo.");
                    } else {
                        System.out.println("Ingrese la cantidad a ingresar:");
                        double cantidad = scanner.nextDouble();
                        if (cantidad < 0) {
                            System.out.println("La cantidad a ingresar no puede ser negativa. Por favor, intente de nuevo.");
                        } else {
                            cuentas[numCuenta - 1].ingresar(cantidad);
                            System.out.println("Se ha ingresado " + cantidad + " en la cuenta " + numCuenta);
                        }
                    }

                    break;

                case 4:



                    break;

                case 5:

                    System.out.println("Saliendo de la aplicación...");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Opción no válida. Por favor, intente de nuevo.");

                    break;

            }

        }

    }

}