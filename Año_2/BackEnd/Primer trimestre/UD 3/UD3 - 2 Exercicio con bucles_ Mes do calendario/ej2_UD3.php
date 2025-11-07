<?php
/*
    Título: UD3 - 2 Exercicio con bucles: Mes do calendario

    Autor: Carlos López Frieiro

    Data modificación: 09/10/2024

    Versión 1.0

*/
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Calendario</title>
    <link rel="stylesheet" href="ej2_UD3.css" type="text/css">
</head>

<body>
    <h1>Calendario Carlos López</h1>
    <table>
        <?php
        $filas = 6;
        $columnas = 7;
        $diasSemana = ['Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'];
        $diasMesNumero = 31;
        $primerDia = 1;
        echo  "<tr>";
        // Creamos un bucle que recorra el array de diasSemana.
        for ($i = 1; $i <= $columnas; $i++) {
            print "<th>" . $diasSemana[$i - 1] . "</th>";
        }
        echo "</tr>";
        // Creamos un bucle para crear las filas.
        for ($j = 1; $j < $filas; $j++) {
            echo  "<tr>";
            // Creamos un bucle para crear las columnas.
            for ($i = 1; $i <= $columnas; $i++) {
                // Para ver si el número existe o no, si no exite lo deja en blanco y si existe suma un número.
                if ($primerDia <= $diasMesNumero) {
                    // Si es fin de semana es de un x color y si no lo es pone otro.
                    if ($i == 6 || $i == 7) {
                        echo "<td class = 'finde'>";
                    } else {
                        echo "<td class = 'entreSemana'>";
                    }
                    echo $primerDia++;
                } else {
                    echo "<td>";
                }
                echo "</td>";
            }
            echo "</tr>";
        }
        ?>
    </table>
</body>

</html>