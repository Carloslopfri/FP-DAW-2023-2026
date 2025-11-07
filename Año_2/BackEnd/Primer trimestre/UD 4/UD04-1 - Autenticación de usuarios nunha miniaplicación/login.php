<?php
/*
    Título: UD04-1 - Autenticación de usuarios nunha miniaplicación

    Autor: Carlos López Frieiro

    Data modificación: 06/11/2024

    Versión 1.1
*/

// Iniciamos sesión.
session_start();
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

    // Hacemos los hash de las contraseñas.
    $contraseña = "xubu789";
    $prueba = password_hash($contraseña, PASSWORD_DEFAULT);
    //echo $prueba;

    // Creamos el array de usuarios.
    $usuarios = [
        'carlos@cifprodolfoucha.es' => [
            'nombre' => 'Carlos',
            'apellidos' => 'López',
            'contraseña' => '$2y$10$vaOmteRpFDt.Ad0PgYhbnOqn4c5QMKL72VhbhbCUV5hIGib80FiT2' // xubu123
        ],

        'alex@cifprodolfoucha.es' => [
            'nombre' => 'Alex',
            'apellidos' => 'Casal',
            'contraseña' => '$2y$10$syzsqOUzf/aSnLNiiQPcl.aEB2GcsVIFijG8AspsB7/qS2H1g8sXS' // xubu456
        ],

        'jorge@cifprodolfoucha.es' => [
            'nombre' => 'Jorge',
            'apellidos' => 'Rey',
            'contraseña' => '$2y$10$3.LEDsv5T5vOEFhXBpBw9uQv7CevhtM7ZHYfKTgTuziiJKwPSZTcW' //xubu789
        ]
    ];

    // Creamos el bucle para cuando activemos el botón "acceder".
    if (isset($_POST["acceder"])) {
        $correoCorrecto = false;
        $contraseñaCorrecto = false;

        echo "<ul>";

        // Creamos las validaciones para el correo.
        $textCorreo = $_POST["correo"];
        $dominio = "@cifprodolfoucha.es";
        if (empty($textCorreo)) {
            echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de correo electrónico.</li>";
        } else if (substr($textCorreo, -19) != $dominio) { // El substr sirve para recorrer el String, al poner un número negativo lo recorre del revés.
            echo "<li style = 'color: red'>Error: El apartado del corre electrónico no tiene un formato correcto (es obligatorio que el dominio sea '@cifprodolfoucha.es').</li>";
        } else if (!array_key_exists($textCorreo, $usuarios)) { // Validación para ver si existe el correo en el array.
            echo "<li style = 'color: red'>Error: El correo electrónico no existe.</li>";
        } else {
            $correoCorrecto = true;
        }

        // Creamos las validacines para la contraseña. 
        $textContraseña = $_POST["contraseña"];
        if (empty($textContraseña)) {
            echo "<li style = 'color: red'>Error: El apartado de contraseña no puede estar vacío.</li>";
        } else if (strlen($textContraseña) < 5 || strlen($textContraseña) > 10) {
            echo "<li style = 'color: red'>Error: El apartado de contraseña tiene que tener un mínimo de 5 caracteres y un máximo de 10.</li>";
        } else if (array_key_exists($textCorreo, $usuarios) && !password_verify($textContraseña, $usuarios[$textCorreo]['contraseña'])) { // Verificamos que la contraseña escrita por el usuario sea lo mismo que el hash de la contraseña.
            echo "<li style = 'color: red'>Error: Las credenciales de la contraseña son incorrectas.</li>";
        } else {
            $contraseñaCorrecto = true;
        }

        // Cuando todo lo anterior sea correcto guarda el correo en $_SESSION, creamos el array de cookies y nos manda al perfil.
        if ($correoCorrecto == true && $contraseñaCorrecto == true) {
            $_SESSION["correo"] = $textCorreo;
            $_SESSION['datosUsuario'] = $usuarios[$_POST['correo']];

            // Si la cookie existe (la cual se crea con el $_SESSION).
            if (isset($_COOKIE['acceso'])) {
                // Creamos el array donde separamos las cookies existentes con la nueva por una coma.
                $arrayAccesos = explode(',', $_COOKIE['acceso']);
            } else {
                // En caso de no existir ningina cookie, creamos un array vacío.
                $arrayAccesos = [];
            }

            // Metemos la fecha y hora actual en el array.
            array_push($arrayAccesos, date('Y-m-d  /  H:i:s'));
            // Pasamos el array a String.
            $strArrayAcceso = implode(',', $arrayAccesos);
            // Mandamos la cookie.
            setcookie('acceso', $strArrayAcceso);

            header("Location: perfil.php");
            exit();
        }
        echo "</ul>";
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