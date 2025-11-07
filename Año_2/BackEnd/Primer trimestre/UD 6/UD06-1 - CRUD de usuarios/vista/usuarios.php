<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

session_start();

include '../control/ControlUsuarios.class.php';

$control = new Control();


// Verificamos si el botón btnBorrarX se ha presionado.
if (isset($_GET["borrar"])) {
    $control->eliminar($_GET["borrar"]);
}

// Creamos la condición para cuando no exista el usuario o el rol del usuario no sea el de administrador nos mande al Inicio.
$usuario = $control->mostrarUsuario($_SESSION["correo"]);
if (!isset($_SESSION['correo']) || $usuario->rol == 'usuario') {
    header("Location: inicio.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">

<style>
    table,
    th,
    td {
        border: 1px solid black;
    }
</style>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrador</title>
</head>

<body>
    <?php
    include './menu.php';
    ?>
    <h1>Usuarios:</h1>
    <form action="usuarios.php" method="post">
        <a href="./añadirUsr.php">Añadir usuario</a><br><br>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
                <th>Imagen</th>
                <th>Acciones</th>
            </tr>
            <?php
            // LLamamos a la función que nos devuelve los datos.
            $usuarios = $control->mostrarDatos();
            // Mostramos los datos por pantalla.
            if (count($usuarios) > 0) {
                foreach ($usuarios as $usuario) {
                    echo '<tr>';
                    echo '<td>' . $usuario->id . '</td>';
                    echo '<td>' . $usuario->nombre . '</td>'; 
                    echo '<td>' . $usuario->correo . '</td>';
                    echo '<td>' . $usuario->rol . '</td>';
                    echo '<td>' . $usuario->imagen . '</td>';
                    echo '<td>
                            <a href="./modificarUsr.php?id=' . $usuario->id . '">Modificar</a> 
                            <a href="./usuarios.php?borrar=' . $usuario->id . '">Borrar</a> 
                          </td>';
                    echo '</tr>';
                    
                }
            } else {
                echo '<p style = "color:red">No se han encrontrado ningún usuario.</p>';
            }
            ?>
        </table>
    </form>
</body>

</html>