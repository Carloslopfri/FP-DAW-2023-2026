<?php
/*

    Título: Tarefa 2 - 1 Comezando con PHP

    Autor: Carlos López Frieiro

    Data modificación: 26/09/2024

    Versión 1.0

*/
?>
<!DOCTYPE html>
<html>

<head>
    <title>
        <?php

        use function Laravel\Prompts\table;

        // Defino a constante e a almaceno par usala no apartado 1.
        define("constante", "Meu primeiro php");
        echo constante;
        ?>
    </title>
    <link rel="stylesheet" href="ej1.css" type="text/css">
</head>

<body>

    <div class="clase1">
        <?php
        echo "<h1>", constante, "</h1>";
        ?>
    </div>

    <h3>Apartado 2:</h3>
    <div>
        <?php
        // Amosamos o nome do usuario por pantalla usando span.
        define("BENVIDA", "<span>Benvido %s</span>");
        printf(BENVIDA, 'Carlos');
        ?>
    </div>

    <h3>Apartado 3:</h3>
    <div>
        <?php
        // Definimos unha constante.
        define("π", 3.14);
        define("radio1", 1);
        define("radio2", 1);
        // Definimos os cálculos.
        define("solucion1", π * (radio1 * radio1));
        echo "<p>", "R1 = ", solucion1, "</p>";
        define("solucion2", π * (radio2 * radio2));
        echo "R2 = ", solucion2;
        // Creamos a función para que os devolva o cálculo.
        function printCircleArea($radio)
        {
            return π * ($radio * $radio);
        }

        // Os mostramos.
        echo "<h3>", number_format(printCircleArea(1), 2, ','), "</h3>"; // Este codigo se usa para dar forma al número, el 2 es para poner en cuantos decimales lo dividimos y el ',' es para elegir con que separamos los decimales.
        ?>

    </div>

    <h3>Aparatado 4:</h3>
    <table border="1">
        <?php
        // Declaramos os números aleatorios.
        $num1 = rand();
        $num2 = rand();
        $num3 = rand();
        ?>
        <tr>
            <th></th>
            <th>Número 1</th>
            <th>Número 2</th>
            <th>Número 3</th>
        </tr>
        <tr>
            <th>Decimal</th>
            <td>
                <?php
                // O poñemos en formato decimal cun máximo de 2 decimais.
                echo number_format((rand() / 100), 2, ',', '.');
                ?>
            </td>
            <td>
                <?php
                echo number_format((rand() / 100), 3, ',', '.');
                ?>
            </td>
            <td>
                <?php
                echo number_format((rand() / 100), 4, ',', '.');
                ?>
            </td>
        </tr>
        <tr>
            <th>Binario</th>
            <?php
            // Poñemos os números aleatorios en binario escribindo %b.
            ?>
            <td><?php printf('%b', $num1) ?></td>
            <td><?php printf('%b', $num2) ?></td>
            <td><?php printf('%b', $num3) ?></td>
        </tr>
        <tr>
            <th>Hexadecimal</th>
            <?php
            // Poñemos os números aleatorios en hexadecimal escribindo %x.
            ?>
            <td><?php printf('%x', $num1) ?></td>
            <td><?php printf('%x', $num2) ?></td>
            <td><?php printf('%x', $num3) ?></td>
        </tr>
    </table>

    <h3>Apartado 5:</h3>
    <table border="1">
        <?php
        $num1 = rand();
        $num2 = rand();
        $num3 = rand();

        // Declaramos os cores.
        $color1 = 'green';
        $color2 = 'red';
        $color3 = 'blue';
        ?>
        <tr>
            <th></th>
            <th>Número 1</th>
            <th>Número 2</th>
            <th>Número 3</th>
        </tr>
        <?php
        // Poñemos el fondo empregando a etiqueta style no tr.
        ?>
        <tr style="background-color: <?php echo $color1 ?>">
            <th>Decimal</th>
            <td>
                <?php
                echo number_format((rand() / 100), 2, ',', '.');
                ?>
            </td>
            <td>
                <?php
                echo number_format((rand() / 100), 3, ',', '.');
                ?>
            </td>
            <td>
                <?php
                echo number_format((rand() / 100), 4, ',', '.');
                ?>
            </td>
        </tr>
        <tr style="background-color: <?php echo $color2 ?>">
            <th>Binario</th>
            <td><?php printf('%b', $num1) ?></td>
            <td><?php printf('%b', $num2) ?></td>
            <td><?php printf('%b', $num3) ?></td>
        </tr>
        <tr style="background-color: <?php echo $color3 ?>">
            <th>Hexadecimal</th>
            <td><?php printf('%x', $num1) ?></td>
            <td><?php printf('%x', $num2) ?></td>
            <td><?php printf('%x', $num3) ?></td>
        </tr>
    </table>

    <p>
    <h3>Apartado 6:</h3>
    <?php
    // Definimos a variable externa $prezo con un valor aleatorio.
    $prezo = rand(100, 1000) / 10;

    // Definimos a función que devolve o valor do prezo co IVE engadido.
    function calcularPrezoConIVE(float $prezo, float $ive = 0.21): float
    {
        $prezoDoIVE = $prezo * $ive;
        $prezoConIVE = $prezo + $prezoDoIVE;
        return round($prezoConIVE, 2);
    }

    // Chamadas á función con diferentes valores de IVE
    echo "Prezo con IVE do 21%: " . calcularPrezoConIVE($prezo) . "€" . "<br><br>";
    echo "Prezo con IVE do 4%: " . calcularPrezoConIVE($prezo, 0.04) . "€";
    ?>

    </p>

    <p>
    <h3>Apartado 7:</h3>
    Radio Float:
    <br>
    <?php
    // Creamos a función para calcular a área do círculo.
    function calcularAreaCirculoFloat(?float $radioFloat): float
    {
        return π * $radioFloat * $radioFloat;
    }
    // O mostramos.
    echo calcularAreaCirculoFloat(5) . '<br>' . '<br>';
    echo 'Radio Null:' . '<br>';
    echo calcularAreaCirculoFloat(null) . '<br>';
    ?>
    </p>

    <p>
    <h3>Apartado 8:</h3>
    <?php
    // Función para calcular o prezo con desconto
    function aplicarDesconto(float $prezo, float $desconto = 0.10): float
    {
        $prezoDoDesconto = $prezo * $desconto;
        $prezoFinal = $prezo - $prezoDoDesconto;
        return round($prezoFinal, 2);
    }

    echo "Prezo con desconto do 10%: " . aplicarDesconto($prezo) . "€" . "<br><br>";

    // Calculamos o prezo final co IVE do 21% sobre o prezo con desconto
    $prezoFinalConIVE = calcularPrezoConIVE(aplicarDesconto($prezo));
    echo "Prezo final con IVE do 21% con o desconto do 10%: " . $prezoFinalConIVE . "€";
    ?>
    </p>

    <p>
    <h3>Apartado 9:</h3>
    <?php
    // Valores de exemplo para o ancho e a altura
    $ancho = 5;
    $altura = 10;

    // Función que calcula a área e o perímetro dun rectángulo e devolve ambos por referencia
    function calcularAreaEPerimetro(float $ancho, float $altura, float &$area, float &$perimetro): void
    {
        // Calculamos a área e o perímetro
        $area = $ancho * $altura;
        $perimetro = 2 * ($ancho + $altura);
    }

    // Variables para gardar os resultados
    $area = 0;
    $perimetro = 0;

    // Chamamos á función pasando as variables por referencia
    calcularAreaEPerimetro($ancho, $altura, $area, $perimetro);

    // Amósanse a área e o perímetro por pantalla
    echo "Área: " . $area . "m²" . "<br><br>";
    echo "Perímetro: " . $perimetro . "m";
    ?>
    </p>

    <p>
    <h3>Apartado 10:</h3>
    <?php
    // Usamos var_dump para que nos mostre información,neste caso unha variable, como pode ser o seu tipo e valor.
    var_dump($area) or die('oops!'); // Ponemos o die para sair e que nos mostre a mensaxe.
    ?>
    </p>

</body>

</html>