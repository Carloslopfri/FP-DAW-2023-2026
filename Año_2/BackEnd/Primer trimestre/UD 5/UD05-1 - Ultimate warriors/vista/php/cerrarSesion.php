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

// Vaciamos la carpeta img.
foreach ($_SESSION['personajes'] as $personaje) {
    unlink($personaje->imagen);
}

session_destroy();

header('Location: principal.php');
exit();
?>