<?php
/*
    Título: UD04-1 - Autenticación de usuarios nunha miniaplicación

    Autor: Carlos López Frieiro

    Data modificación: 06/11/2024

    Versión 1.1
*/

// Creamos el menú con los casos dependiendo si hay un usuario logueado o no.
if (!isset($_SESSION['correo'])) {
    echo '<a href="login.php">Acceder</a>';
    echo ' ';
    echo '<a href="inicio.php">Inicio</a>';
} else {
    echo '<a href="inicio.php">Inicio</a>';
    echo ' ';
    echo '<a href="perfil.php">Perfil</a>';
    echo ' ';
    echo '<a href="logoff.php">Salir</a>';
}
?>