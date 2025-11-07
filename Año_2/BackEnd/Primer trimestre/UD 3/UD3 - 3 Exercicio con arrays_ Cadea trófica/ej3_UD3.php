<?php
/*
    Título: UD3 - 3 Exercicio con arrays: Cadea trófica

    Autor: Carlos López Frieiro

    Data modificación: 10/10/2024

    Versión 1.0
*/
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Cadena trófica</title>
</head>

<body>
    <h1>Cadena trófica Carlos López</h1>
    <?php
    // Metemos los carnívoros y los herbívoros en arrays diferentes.
    $herbivoros = ["🐄", "🐖", "🐀", "🐐", "🦃", "🐌", "🦆"];
    $carnivoros = ["🐺", "🦅", "🐍"];
    echo "<h2>Herbívoros:</h2>";
    // Creamos un bucle para que recorra el array de herbívoros y nos los saque por pantalla.
    foreach ($herbivoros as $clave => $valor) {
        echo $valor . " ";
    }
    echo "<br><h2>Carnívoros:</h2>";
    // Creamos un bucle para que recorra el array de carnívoros y nos los saque por pantalla.
    foreach ($carnivoros as $clave => $valor) {
        echo $valor . " ";
    }
    echo "<br><h2>Escogídos:</h2>";
    // Creamos un array donde metemos a todos los animales.
    $comer = [
        "🐺" => ["🐄", "🐖", "🐀", "🐐", "🦃", "🦆"],
        "🦅" => ["🐀", "🐐", "🦃", "🦆"],
        "🐍" => ["🐀", "🐌"]
    ];
    // Creamos unos números random.
    $randomH = $herbivoros[rand(0, count($herbivoros) - 1)];
    $randomC = $carnivoros[rand(0, count($carnivoros) - 1)];
    // Creamos un bucle para ir mostrando los datos del array.
    if (in_array ($randomH, $comer[$randomC])) {
        echo $randomC . " se come ha " . $randomH;
    } else {
        echo $randomC . " no se come ha " . $randomH;
    }
    ?>
</body>

</html>