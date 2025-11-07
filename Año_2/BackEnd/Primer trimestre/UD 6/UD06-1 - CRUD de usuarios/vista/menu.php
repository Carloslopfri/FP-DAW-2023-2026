<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

include_once '../control/ControlUsuarios.class.php';

echo '<a href="./inicio.php">Inicio</a>';
echo ' ';
if (isset($_SESSION['correo'])) {
    echo ' ';
    echo '<a href="./perfil.php">Perfil</a>';
    echo ' ';
    $control = new Control();
    $usuario = $control->mostrarUsuario($_SESSION['correo']);
    if ($usuario->rol == 'admin') {
        echo '<a href="./usuarios.php">Administrar</a>';
        echo ' ';
    }
    echo '<a href="./../control/logoff.php">Salir</a>';
} else {
    echo '<a href="./login.php">Acceder</a>';
}
?>