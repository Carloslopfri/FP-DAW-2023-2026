<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

class Personaje
{
    public $id;
    public $nombre;
    public $imagen;
    public $pv;
    public $pa;
    public $pd;
    public $categoria;

    public function __construct($id, $nombre, $imagen, $pv, $pa, $pd, $categoria)
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->imagen = $imagen;
        $this->pv = $pv;
        $this->pa = $pa;
        $this->pd = $pd;
        $this->categoria = $categoria;
    }
}