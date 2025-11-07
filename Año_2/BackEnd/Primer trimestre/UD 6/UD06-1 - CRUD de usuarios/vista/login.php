<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

/*
USUARIOS:
alex@cifprodolfoucha.es -> xubu123 (usuario)
carlos@cifprodolfoucha.es -> xubu123 (administrador)
*/

include('../control/ControlUsuarios.class.php');

// Iniciamos sesión.
session_start();

$control = new Control;

// Instanciamos la clase Control.
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <?php
    // Incluimos el menú.
    include 'menu.php';

    // Creamos el bucle para cuando activemos el botón "acceder".
    if (isset($_POST["acceder"])) {
        $textCorreo = $_POST["correo"];
        $textContraseña = $_POST["contraseña"];

        // Cuando todo lo anterior sea correcto guarda el correo en $_SESSION, creamos el array de cookies y nos manda al perfil.
        $respuesta = $control->validarLogin($textCorreo, $textContraseña);
        //var_dump($respuesta);
        if ($respuesta === true) {
            $_SESSION["correo"] = $textCorreo;

            // Si la cookie existe, se guarda en la sesión.
            if (isset($_COOKIE['acceso'])) {
                // Guardamos la cookie en un array y hacemos que las separe con comas.
                $arrayAccesos = explode(',', $_COOKIE['acceso']);
            } else {
                // En caso de que no exista crea el array vacío.
                $arrayAccesos = [];
            }

            // Agregamos el nuevo acceso (fecha y hora).
            $nuevoAcceso = date("Y-m-d H:i:s");
            $arrayAccesos[] = $nuevoAcceso;

            // Pasamos el array a String, separado por comas.
            $strArrayAcceso = implode(',', $arrayAccesos);
            // Mandamos la cookie
            setcookie('acceso', $strArrayAcceso);

            header("Location: ./perfil.php");
            exit();
        } else {
            echo "<ul>";
            foreach ($respuesta as $error) {
                echo $error;
            }
            echo "</ul>";
        }
    }
    ?>

    <form action="login.php" method="post">
        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" name="correo" required maxlength="50"><br><br>

        <label for="contraseña">Contraseña:</label>
        <input type="password" name="contraseña" id="contraseña" required maxlength="10" minlength="5"><br><br>

        <button type="submit" name="acceder">Acceder</button>
    </form>
</body>

</html>