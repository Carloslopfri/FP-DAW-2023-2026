<?php
/*
    Título: UD3 - 1 Exercicios básicos con Strings, Datas, Condicionais e Bucles

    Autor: Carlos López Frieiro

    Data modificación: 08/10/2024

    Versión 1.1

*/

use PhpParser\Node\Expr\Cast\Double;

?>
<html>

<head>
    <title>ej1_UD3</title>
    <link rel="stylesheet" href="ej1_UD3.css" type="text/css">
</head>

<body>
    <h3>Apartado 01. Strings.</h3>
    <p>
        <?php
        // Declaramos la variable.
        $correo = "pepe@gmail.com";

        echo "Correo: " . $correo . "<br>";

        // Creamos la función para que buscque la @.
        function buscarArroba($correo): string
        {
            return strpos($correo, "@");
        }

        // Creamos la función para que buscque el punto.
        function buscarPunto($correo): string
        {
            return strpos($correo, ".");
        }

        // Hacesmos unos bucles if para sacar los mensajes.
        if (strpos($correo, "@") > 0 && buscarPunto($correo) > 0) {
            echo "Estado del correo: " . "Válido";
        } else {
            echo "Estado del correo: " . "No válido";
        }
        ?>
    </p>

    <p>
        <?php
        // Declaramos la variable de la canción;
        $cancion = "
        Esta bueno en pepitoria
        Y esta mas bueno al limón
        Esta bueno con almendraaas
        Y también al chilindrón
        El pollo el pollito el polllo
        El pollo que rico está
        Y encima está muy baratoo
        Mientras no sea de corral
        Y Ole!
        ";

        // Creamos la función 
        function sustituirLetras($letra): string
        {
            // Cambiamos las letras minusculas por números.
            $letra = str_replace('a', '4', $letra);
            $letra = str_replace('e', '3', $letra);
            $letra = str_replace('i', '1', $letra);
            $letra = str_replace('o', '0', $letra);

            // Cambiamos las letras mayúsculas por números y le cambiamos el tamaño.
            $letra = str_replace('A', '<span style = "font-size: 50px">' . '4' . '</span>', $letra);
            $letra = str_replace('E', '<span style = "font-size: 50px">' . '3' . '</span>', $letra);
            $letra = str_replace('I', '<span style = "font-size: 50px">' . '1' . '</span>', $letra);
            $letra = str_replace('O', '<span style = "font-size: 50pxs">' . '0' . '</span>', $letra);

            return $letra;
        }

        // Sacamos la canción con los cambios.
        echo sustituirLetras($cancion);
        ?>
    </p>

    <br>

    <h3>Apartado 02. Datas.</h3>
    <p>
        <?php
        // Declaramos la variable de la fecha actual.
        $fechaActual = time();
        // Indicamos con cada letra el momento actual pero con el formato que representa.
        echo date('l-F-Y') . "<br>";
        // mktime crea una fecha en segundos, minutos, horas, mes, dia, año.
        $año_anterior = mktime(0, 0, 0, 1, 6, 2024);
        // Hacemos el cálculo.
        $calculoFinal = ($fechaActual - $año_anterior) / 604800;
        // Redondeamos.
        echo "Entre la fecha actual y la fecha (06-01-2023) hay un total de " . round($calculoFinal, 2) . " semanas.<br>";
        // Creamos la función que nos desvuelva un true o false dependiendo del dia.
        function venres(int $fechaCualquiera): bool
        {
            if (date("N", $fechaCualquiera) == 5) {
                return true;
            } else {
                return false;
            }
        }
        // Hacemos un if para que nos saque la información por pantalla.
        if (venres($año_anterior) == true) {
            echo  "El dia " . date('d-m-Y', $año_anterior) . " es viernes.";
        } else {
            echo "El dia " . date('d-m-Y', $año_anterior) . " no es viernes.";
        }
        ?>
    </p>

    <h3>Apartado 03. Condicionais.</h3>
    <p>
        <?php
        // Declaramos la hora que queramos.
        $hora = date('50', mktime(18, 0, 0, 0, 0, 0));
        // Creamos la función para elegir entre que franja horaria nos sale el mensaje.
        function saludar(int $horaCualquiera): string
        {
            if ($horaCualquiera >= 8 && $horaCualquiera < 12) {
                return "Buenos dias.";
            } else if ($horaCualquiera >= 12 && $horaCualquiera < 20) {
                return "Buenas tardes.";
            } else if ($horaCualquiera >= 20 && $horaCualquiera < 24) {
                return "Buenas noches.";
            } else {
                return "Pasa para cama!";
            }
        }
        echo saludar($hora);

        // Creamos una variable con un texto cualquiera.
        $Quijote = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor.";
        // Creamos la funcior para contar los caracteres del texto.
        function contarLetras($texto): string
        {
            // Declaramos los contadores de los diferentes tipos de caracteres.
            $cont_a = 0;
            $cont_e = 0;
            $cont_i = 0;
            $cont_o = 0;
            $cont_u = 0;
            $cont_num = 0;
            $cont_otros = 0;
            // Creamos un bucle for que recorra el textp.
            for ($i = 0; $i < strlen($texto); $i++) {
                // Metemos el texto como array dentro de la variable.
                $caracteres = strtolower($texto[$i]);
                // Creamos un switch para los diferentes tipos de caracteres.
                switch ($caracteres) {
                    case 'a':
                        $cont_a++;
                        break;

                    case 'e':
                        $cont_e++;
                        break;

                    case 'i':
                        $cont_i++;
                        break;

                    case 'o':
                        $cont_o++;
                        break;

                    case 'u':
                        $cont_u++;
                        break;

                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    case "0":
                        $cont_num++;
                        break;
                    default:
                        $cont_otros++;
                        break;
                }
            }
            // Devolvemos el mensaje.
            return "<br> a:" . $cont_a . " e:" . $cont_e . " i:" . $cont_i . " o:" . $cont_o . " u:" . $cont_u . " Números:" . $cont_num . " Otros:" . $cont_otros . ".";
        }
        // Lo sacamos por pantalla.
        echo contarLetras($Quijote);
        ?>
    </p>

    <h3>Apartado 04. Bucles</h3>
    <p>
        <?php
        // Declaramos la base y el exponente.
        $base = 5;
        $expoñente = 5;
        // Creamos la función que muestre las potencias.
        function mostrarPotencias($a, $b): void
        {
            for ($i = 1; $i <= $b; $i++) {
                echo "$a<sup>$i</sup>" . ",";
            }
        }
        // Lo mmostramos por pantalla.
        mostrarPotencias($base, $expoñente);
        ?>
    </p>

    <p>
        <?php
        // Declaramos la contraeña como String.
        $contraseña = "1234";
        $digitosBase = "0";
        $limite = "9999";
        // Creamo sun bucle while para que vaya recorriendo desde el 0 hasta la contraeña indicada.
        while ($digitosBase != $contraseña) {
            $digitosBase++;
        }
        if ($digitosBase < $limite) { // Hacemos un if que compruebe que no se pase el límite.
            echo "La contraseña es: " . $digitosBase;
        } else {
            echo "Contraseña no válida.";
        }
        ?>
    </p>

    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Valor</th>
        </tr>
        <?php
        // Obtenemos todas las variables del entorno.
        $variablesEntorno = getenv();
        // Mostramos cada variable en dos columnas usando un foreach.
        foreach ($variablesEntorno as $clave => $valor) { // El "=>" se refiere a que la variable $clave va a tener el valor $valor. 
            // Verificamos si el nombre de la variable es LANG o PATH para destacar en negrita.
            $negrita = ($clave === 'LANG' || $clave === 'PATH') ? 'negrita' : ''; // Esto es una simplificación de un if, dice que si $key es igual a LANG o PATH devuelva en 'negrita' (Lo que va segido después de la "?" es en el caso verdadero) y que si no lo es no devuelva nada (Lo que va después de los ":").
            echo "<tr>";
            echo "<td class='col1 $negrita'>{$clave}</td>"; // En caso que el if anterior sea correcto aparecera como seguna clase 'negrita'.
            echo "<td class='col2 $negrita'>{$valor}</td>";
            echo "</tr>";
        }
        ?>
    </table>

    <br>

    <footer>
        ©
        <?php
        // Le damos formato y la sacamos por pantalla.
        echo date('Y', $fechaActual);
        ?>
    </footer>
</body>

</html>