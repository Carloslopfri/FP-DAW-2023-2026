<?php
class Paciente
{
    public string $nome;
    public string $email;
    public string $nacemento;
    public string $alta;

    public function crear($nome, $email, $nacemento, $alta)
    {
        $this->nome = $nome;
        $this->email = $email;
        $this->nacemento = $nacemento;
        $this->alta = $alta;
    }
}
