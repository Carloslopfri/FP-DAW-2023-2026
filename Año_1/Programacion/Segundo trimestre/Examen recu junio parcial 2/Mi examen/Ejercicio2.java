/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.daw;


import java.net.http.HttpRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Ejercicio2 {


    public static void ejecutar() {
			Scanner scanner = new Scanner(System.in);



			System.out.print("Obtener y mostrar la fecha y hora actual: ");

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			System.out.println(fechaHoraActual);



			System.out.println("Calcular la diferencia en días, semanas y meses entre dos fechas introducidas por el usuario: ");

			LocalDate fecha1 = Herramientas.leerFecha("Introduce la primera fecha (aaaa-mm-dd): ");

			LocalDate fecha2 = Herramientas.leerFecha("Introduce la segunda fecha (aaaa-mm-dd): ");

			System.out.println("Diferencias: ");

			System.out.println("Diferencia en días: " + (fecha1.getDayOfYear() - fecha2.getDayOfYear()));

			System.out.println("Diferencia en meses: " + (fecha1.getMonth().getValue() - fecha2.getMonth().getValue()));

			System.out.println("Diferencia en años: " + (fecha1.getYear() - fecha2.getYear()));



			System.out.println("Comprobar si una fecha introducida por el usuario es un fin de semana: ");

			System.out.print("Introduce una fecha (aaaa-mm-dd): ");

			LocalDate fecha3 = Herramientas.leerFecha("Introduce una fecha (aaaa-mm-dd): ");

			if (fecha3.getDayOfWeek().toString().equals("SATURDAY") || fecha3.getDayOfWeek().toString().equals("SUNDAY")) {

				System.out.println("Es fin de semana.");

			} else {

				System.out.println("No es fin de semana.");

			}



			System.out.println("Añadir y restar diferentes periodos (días, semanas, meses) a una fecha específica y mostrar los resultados: ");

			LocalDate fecha4 = LocalDate.of(2024, 6, 13);

			System.out.println("La fecha es: " + fecha4);

			System.out.println("Sumar 3 días: " + fecha4.plusDays(3));

			System.out.println("Restar 20 días: " + fecha4.minusDays(20));

			System.out.println("Sumar 1 mes: " + fecha4.plusMonths(1));

			System.out.println("Restar 3 meses: " + fecha4.minusMonths(3));

			System.out.println("Sumar 2 años: " + fecha4.plusYears(2));

			System.out.println("Restar 7 años: " + fecha4.minusYears(7));
    }
    
}