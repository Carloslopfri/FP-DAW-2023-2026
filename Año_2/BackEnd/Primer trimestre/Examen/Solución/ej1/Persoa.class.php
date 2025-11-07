<?php
class Persoa
{
    public string $nome;
    public string $data;

    public function __construct($nome, $data)
    {
        $this->nome = $nome;
        $this->data = $data;
    }

    public function ObterIdade()
    {
        $anoActual = (int)date('Y', time());
        $anoPersoa = (int)date('Y', strtotime($this->data));
        $calculo = $anoActual - $anoPersoa;
        return $calculo;
    }

    public function NaceuBisiesto()
    {
        $año = date('Y', strtotime($this->data));
        if ($año % 4 == 0 && $año % 100 != 0 && $año % 400 == 0) {
            return 'No';
        } else if ($año % 4 == 0 && $año % 100 != 0) {
            return 'Si';
        } else {
            return 'No';
        }
    }

    public function Naceu29febreiro()
    {
        if (date('d-m', strtotime($this->data)) == '29-02') {
            return 'Si';
        } else {
            return 'No';
        }
    }
}
