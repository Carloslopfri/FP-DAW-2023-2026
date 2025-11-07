<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

class Log
{
    // Creamos la ruta del archivo de log.
    private static $ruta = './../../logs/log.txt';

    // Hacemos la función para guardar el mensaje en log.txt.
    public static function registrarLog($mensaje)
    {
        // Obtenemos la fecha y hora actual.
        $fechaHora = date('d-m-Y H:i:s');

        // Formateamos el mensaje.
        $logMensaje = $fechaHora . $mensaje . ' ';

        // Abrimos el .txt.
        $fp = fopen(self::$ruta, "a"); // self sirve para poder acceder a datos estáticos.

        // Escrinimos el mensaje en el archivo de log.
        fwrite($fp, $logMensaje);
    }
}
