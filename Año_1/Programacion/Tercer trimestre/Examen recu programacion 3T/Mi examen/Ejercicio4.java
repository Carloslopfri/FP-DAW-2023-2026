package examen.daw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Ejercicio3 {

    public static void ejecutar() {

        Connection cn = Ejercicio1.getConnection();

        Scanner scanner = new Scanner(System.in);

        if (cn != null) {

            System.out.print("Ingrese el ID del empleado: ");

            int empleadoId = scanner.nextInt();

            double salarioDesdeBD = obtenerSalarioDesdeBD(cn, empleadoId);

            double salarioDesdeArchivo = obtenerSalarioDesdeArchivo(empleadoId);

            if (salarioDesdeBD == salarioDesdeArchivo) {

                System.out.println("Los salarios coinciden.");

            } else {

                System.out.println("Los salarios no coinciden.");

            }

        }

        DatabaseConnection.closeConnection();

    }

    private static double obtenerSalarioDesdeBD(Connection connection, int empleadoId) {

        double salario = -1;

        String query = "{CALL obtener_salario(?, ?)}";

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, empleadoId);

            stmt.registerOutParameter(2, Types.DOUBLE);

            stmt.execute();

            salario = stmt.getDouble(2);

        } catch (SQLException e) {

            System.out.println(e);

        }

        return salario;

    }

    private static double obtenerSalarioDesdeArchivo(int empleadoId) {

        double salario = -1;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"))) {

            Empleado empleado;

            while (true) {

                empleado = (Empleado) ois.readObject();

                if (empleado.getId() == empleadoId) {

                    salario = empleado.getSalarioAnual();

                    break;

                }

            }

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(e);

        }

        return salario;

    }

}
