<?php
include_once '../../modelo/DAO.class.php';
include_once '../../modelo/Paciente.class.php';

class ControlPacente_class
{
    public function mostrarPacentes()
    {
        $dao = new DAO_class();
        $pacentes = $dao->obterPacentes();
        return $pacentes;
    }

    public function mostrarServizosPacente($id)
    {
        $dao = new DAO_class();
        $ids = $dao->obtenerServizosPacentes($id);
        $lista = [];
        foreach ($ids as $idservizo) {
            $servizo = $dao->obtenerServizo($idservizo['servizo_id']);
            array_push($lista, $servizo->tipo);
        }
        return $lista;
    }

    public function validarEnagdir($nome, $email, $data, $idsServizos)
    {
        $errores = [];

        if (strlen($nome) == 0) {
            array_push($errores, '<p style="color:red">O apartado do nome é obrigatorio.</p>');
        }

        if (strlen($email) == 0) {
            array_push($errores, '<p style="color:red">O apartado do email é obrigatorio.</p>');
        } else if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            array_push($errores, '<p style="color:red">O email non ten un formato válido.</p>');
        }

        if (strlen($data) == 0) {
            array_push($errores, '<p style="color:red">O apartado da data de nacemento é obrigatorio.</p>');
        }

        if (empty($idsServizos)) {
            array_push($errores, '<p style="color:red">O apartado dos servizos é obrigatorio.</p>');
        }

        if (empty($errores)) {
            $formatoData = date('d/m/Y', strtotime($data));
            $alta = date('d/m/Y - h:i', time());
            $pacente = new Paciente();
            $pacente->crear($nome, $email, $data, $alta);
            $dao = new DAO_class();
            $dao->engadirPacente($pacente, $idsServizos);
            return true;
        } else {
            return $errores;
        }
    }
}
