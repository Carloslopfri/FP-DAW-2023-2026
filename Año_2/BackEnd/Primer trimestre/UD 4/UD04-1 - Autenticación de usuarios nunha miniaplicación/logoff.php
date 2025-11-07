<?php
/*
    Título: UD04-1 - Autenticación de usuarios nunha miniaplicación

    Autor: Carlos López Frieiro

    Data modificación: 06/11/2024

    Versión 1.1
*/

// Iniciamos sesión.
session_start();
// Destruimos la sesión.
session_destroy();
// Nos manda al inicio.
header("Location: inicio.php");
exit;
?>