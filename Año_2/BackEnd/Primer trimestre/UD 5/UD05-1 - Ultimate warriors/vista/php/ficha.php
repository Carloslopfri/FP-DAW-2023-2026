<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

include 'Personaje.class.php';
include 'Barbaro.class.php';
include 'Clerigo.class.php';
include 'Bardo.class.php';
include 'Log.class.php';

session_start();

// El $_GET sirve para coger los datos dentro de la ? de la URl.
$idPersonaje = $_GET['id'];

// Declaramos el objeto vacio.
$objPersonaje = null;
// Creamos un bucle para recorrer el array y guardar el personaje dentro de $objPersonaje.
foreach ($_SESSION['personajes'] as $personaje) {
    if ($personaje->id == $idPersonaje) {
        $objPersonaje = $personaje;
        break;
    }
}

if (isset($_POST['borrar'])) {
    $indice = 0;
    foreach ($_SESSION['personajes'] as $personaje) {
        if ($personaje->id != $idPersonaje) {
            $indice++;
        } else {
            // Registrarmos la eliminación en el log.
            Log::registrarLog("Personaje borrado: " . $personaje->nombre . "\n");
            break;
        }
    }

    // Borramos la imagen de la carpeta img.
    unlink($_SESSION['personajes'][$indice]->imagen);
    // Borramos el personaje.
    unset($_SESSION['personajes'][$indice]);
    // Reordenamos el array.
    $_SESSION['personajes'] = array_values($_SESSION['personajes']);

    header('Location: principal.php');
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ficha</title>
</head>

<body>
    <h3>Id: </h3>
    <p><?php echo $objPersonaje->id; ?></p>

    <h3>Nombre: </h3>
    <p><?php echo $objPersonaje->nombre; ?></p>

    <h3>Imagen: </h3>
    <p><img src="<?php echo $objPersonaje->imagen; ?>" alt="personaje" style="width:125px;"></p>

    <h3>Puntos de vida: </h3>
    <p><?php echo $objPersonaje->pv; ?></p>

    <h3>Puntos de ataque: </h3>
    <p><?php echo $objPersonaje->pa; ?></p>

    <h3>Puntos de defensa: </h3>
    <p><?php echo $objPersonaje->pd; ?></p>

    <h3>Categoría: </h3>
    <p><?php echo $objPersonaje->categoria; ?></p>

    <?php
    if ($objPersonaje->categoria == 'barbaro') {
        echo '<h3>Nivel de Berserker: </h3>';
        echo '<p>' . $objPersonaje->nivelBerserker . '</p>';
    } else if ($objPersonaje->categoria == 'clerigo') {
        echo '<h3>Poder de curación: </h3>';
        echo '<p>' . $objPersonaje->poderDeCuracion . '</p>';

        echo '<h3>Aura: </h3>';
        echo '<p>' . $objPersonaje->aura . '</p>';
    } else {
        echo '<h3>Canción: </h3>';
        echo '<p>' . $objPersonaje->principalCancion . '<p>';
    }
    ?>

    <br><br>
    <form action="ficha.php?id=<?php echo $_GET["id"] ?>" method="post">
        <button type="submit" name="borrar">Borrar personaje</button>
    </form>
    <br>
    <a href="principal.php"><button>Volver al inicio</button></a>
</body>

</html>