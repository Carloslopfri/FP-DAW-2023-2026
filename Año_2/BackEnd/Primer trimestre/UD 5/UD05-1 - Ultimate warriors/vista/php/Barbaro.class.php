<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

// Creamos la clase Barbaro que hereda de Personaje.
class Barbaro extends Personaje
{
    public $nivelBerserker;

    // Creamos el constructor.
    public function __construct($id, $nombre, $imagen, $pv, $pa, $pd, $categoria, $nivelBerserker)
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->imagen = $imagen;
        $this->pv = $pv;
        $this->pa = $pa;
        $this->pd = $pd;
        $this->categoria = $categoria;
        $this->nivelBerserker = $nivelBerserker;
    }

    // Creamos el metodo cargar().
    public function cargar()
    {
        return $this->pa + 10;
    }
}