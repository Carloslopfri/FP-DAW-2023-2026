<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

class Clerigo extends Personaje
{
    public $poderDeCuracion;
    public $aura;

    public function __construct($id, $nombre, $imagen, $pv, $pa, $pd, $categoria, $poderDeCuracion, $aura)
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->imagen = $imagen;
        $this->pv = $pv;
        $this->pa = $pa;
        $this->pd = $pd;
        $this->categoria = $categoria;
        $this->poderDeCuracion = $poderDeCuracion;
        $this->aura = $aura;
    }

    public function sanar() {
        foreach ($_SESSION['personajes'] as $personaje) {
            $suma = ($this->poderDeCuracion + $personaje->pv) - $this->pv;
        }
        return $suma;
    }
}
