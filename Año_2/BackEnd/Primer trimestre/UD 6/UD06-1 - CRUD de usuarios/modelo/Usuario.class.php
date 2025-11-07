<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación:

    Versión 1.1
*/

class Usuario
{
    public string $nombre;
    public string $correo;
    public string $contrasena;
    public string $rol;
    public string $imagen;

    public function crear($nombre, $correo, $contrasena, $rol, $imagen)
    {
        $this->nombre = $nombre;
        $this->correo = $correo;
        $this->contrasena = $contrasena;
        $this->rol = $rol;
        $this->imagen = $imagen;
    }
}
