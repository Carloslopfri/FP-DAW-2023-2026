<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

session_start();
include '../modelo/Usuario.class.php';
include '../control/ControlUsuarios.class.php';

$control = new Control();

// Creamos la condición para cuando no exista el usuario o el rol del usuario no sea el de administrador nos mande al Inicio.
$usuario = $control->mostrarUsuario($_SESSION["correo"]);
if (!isset($_SESSION['correo']) || $usuario->rol == 'usuario') {
    header("Location: ../inicio.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir usuario</title>
</head>

<body>
    <?php
    include "menu.php";
    ?>
    <h1>Introduce los datos del usuario que desees añadir:</h1>
    <?php
    if (isset($_POST['añadir'])) {
        $textNombre = $_POST['nombre'];
        $textCorreo = $_POST['correo'];
        $textContraseña = $_POST['contraseña'];
        $textRol = $_POST['roles'];

        $resultado = $control->validarAñadirUsr($textNombre, $textCorreo, $textContraseña, $textRol);
        if ($resultado === true) {
            header('Location: usuarios.php');
            exit();
        } else {
            echo '<ul>';
            foreach ($resultado as $error) {
                echo $error;
            }
            echo '</ul>';
        }
    }
    ?>
    <form action="./añadirUsr.php" method="post" enctype="multipart/form-data">
        <label for="nombre">Nombre: </label>
        <input type="text" name="nombre" required><br><br>

        <label for="correo">Correo electrónico: </label>
        <input type="text" name="correo" required><br><br>

        <label for="contraseña">Contraseña: </label>
        <input type="password" name="contraseña" required><br><br>

        <label for="roles">Rol: </label>
        <select name="roles" id="roles">
            <option value="vacio"></option>
            <option value="usuario">Usuario</option>
            <option value="admin">Administrador</option>
        </select><br><br>

        <button name="añadir" type="submit">Añadir</button>
    </form>
</body>

</html>