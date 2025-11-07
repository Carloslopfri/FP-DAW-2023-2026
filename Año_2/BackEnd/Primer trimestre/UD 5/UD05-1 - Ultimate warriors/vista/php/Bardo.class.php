<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

class Bardo extends Personaje
{
    public $principalCancion;

    public function __construct($id, $nombre, $imagen, $pv, $pa, $pd, $categoria, $principalCancion)
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->imagen = $imagen;
        $this->pv = $pv;
        $this->pa = $pa;
        $this->pd = $pd;
        $this->categoria = $categoria;
        $this->principalCancion = $principalCancion;
    }

    public function cantar() {
        return $this->principalCancion[rand(1,3)];
    }
}
