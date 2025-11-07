<?php
/*
    Título: UD3 - 4 Exercicio: Arco da vella

    Autor: Carlos López Frieiro

    Data modificación: 16/10/2024

    Versión 1.1
*/
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Arco da vella</title>
    <link rel="stylesheet" href="Arco_da_vella.css" type="text/css">
</head>

<body>
    <h1>Arco da vella Carlos López Frieiro</h1>
    <?php
    // Función para generar un color aleatorio.
    function generarColorAleatorio()
    {
        $letras = '0123456789ABCDEF';
        $color = '#';
        for ($i = 0; $i < 6; $i++) {
            $color .= $letras[rand(0, 15)];
        }
        return $color;
    }

    // Creamos un array para almacenar los colores únicos.
    $colores = [];

    // Generamos hasta 10 colores diferentes.
    $numeroColores = rand(1, 10);
    while (count($colores) <= $numeroColores) {
        $color = generarColorAleatorio();
        // Aseguramos que el color no esté repetido
        if (!in_array($color, $colores)) {
            $colores[] = $color;
        }
    }

    // Definimos el tamaño base para el primer semicírculo.
    $altura = 200;
    $anchura = 400;
    $espaciado = 20;

    // Comenzamos la estructura HTML.
    echo '<div class="container">';

    foreach ($colores as $index => $color) {
        // Cálculos para reducir el tamaño de cada semicírculo.
        $currentHeight = $altura - ($index * $espaciado);
        $currentWidth = $anchura - ($index * ($espaciado * 2));

        echo '<div class="semicircle" style="
        background-color: ' . $color . ';
        height: ' . $currentHeight . 'px;
        width: ' . $currentWidth . 'px;
        border-radius: ' . ($anchura / 2) . 'px ' . ($anchura / 2) . 'px 0 0;
        position: absolute;
        top: ' . ($index * $espaciado) . 'px;
        left: ' . ($index * $espaciado) . 'px;
    "></div>';
    }

    echo '</div>';
    ?>


</body>

</html>