<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

require '../control/ControlUsuarios.class.php';

// Iniciamos sesión.
session_start();

// Instanciamos la clase Control.
$control = new Control();

// Creamos la condición para cuando no exista el usuario nos mande al Inicio.
if (!isset($_SESSION['correo'])) {
    header("Location: inicio.php");
    exit;
}

?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
</head>

<body>
    <?php
    include './menu.php';
    ?>
    <h1>Perfil de Usuario:</h1>
    <?php
    // Busacamos la posición numérica de la arroba dentro del correo.
    $arroba = strpos($_SESSION["correo"], "@");
    // Sacamos el nombre que vamos a ponerle a la imagen.
    $nombreArchivo = substr($_SESSION["correo"], 0, $arroba);

    // Verificamos si existe la foto de perfil.
    if (file_exists('./img/' . $nombreArchivo . '.jpg')) {
        $foto = '<img src="img/' . $nombreArchivo . '.jpg" alt="fotoPerfil">';
    } else {
        $foto = '<img src="./img/perfil.jpg" alt="fotoPerfil">';
    }

    // Creamos la condición para cuando le demos al botón "enviar".
    if (isset($_POST["enviar"])) {
        // Creamos la condición para verificar que exista el archivo y para ver que no haya errores.
        if (isset($_FILES["archivo"]) && $_FILES["archivo"]["error"] == 0) {
            // Ponemos la ruta actual de la imagen en este caso.
            $rutatemporal = $_FILES["archivo"]["tmp_name"];

            // Ponemos la ruta nueva de la imagen.
            $destino = "img/" . $nombreArchivo . ".jpg";

            // Movemos la imagen de la ruta temporal a la nueva ruta.
            if (move_uploaded_file($rutatemporal, $destino)) {
                echo "<p style = 'color: green'>El archivo se cargó correctamente.</p>";
            } else {
                echo "<p style = 'color: red'>Hubo un error al cargar un archivo.</p>";
            }
        } else {
            echo "<p style = 'color: red'>Archivo no válido.</p>";
        }
        // Sacamos la imagen por pantalla.
        $foto = '<img src="img/' . $nombreArchivo . '.jpg" alt="fotoPerfil">';
    }
    echo $foto;
    ?>
    <form action="perfil.php" method="post" enctype="multipart/form-data">
        <input type="file" name="archivo" id="archivo">
        <button type="submit" name="enviar" id="enviar">Enviar</button>
        <?php
        // Mostramos los datos.
        $usuario = $control->mostrarUsuario($_SESSION["correo"]);
        echo '<p>Correo: ' . $usuario->correo . '</p>';
        echo '<p>Nombre: ' . $usuario->nombre . '</p>';

        // Mostrar los accesos con las cookies.
        echo '<p>Accesos:</p>';
        if (isset($_COOKIE['acceso'])) {
            $array = explode(',', $_COOKIE['acceso']);
            echo '<ul>';
            foreach ($array as $valor) {
                echo '<li>' . htmlspecialchars($valor) . '</li>';
            }
            echo '</ul>';
        } else {
            echo '<p>No hay accesos registrados.</p>';
        }
        ?>
    </form>
</body>

</html>