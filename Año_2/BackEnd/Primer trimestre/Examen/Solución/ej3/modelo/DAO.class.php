<?php
require_once __DIR__ . '/Paciente.class.php';
require_once __DIR__ . '/Servizo.class.php';

class DAO_class
{
    public $conexion;

    public function __construct()
    {
        try {
            $dns = 'mysql:host=localhost;dbname=repasoExamen;charset=utf8';
            $usuario = 'root';
            $contraseña = null;
            $this->conexion = new PDO($dns, $usuario, $contraseña);
            $this->conexion->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            echo "Error para conectar á base de datos: " . $e->getMessage();
        }
    }

    public function obterPacentes()
    {
        try {
            $sql = 'SELECT * FROM pacentes';
            $stm = $this->conexion->prepare($sql);
            $stm->execute();
            $pacentes = $stm->fetchAll(PDO::FETCH_CLASS, 'Paciente');
            return $pacentes;
        } catch (PDOException $e) {
            echo "Error para obter os pacentes: " . $e->getMessage();
        }
    }

    public function obtenerServizosPacentes($id)
    {
        try {
            $sql = 'SELECT * FROM pacente_servizo WHERE pacente_id = :id';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam('id', $id);
            $stm->execute();
            $lista = $stm->fetchAll();
            return $lista;
        } catch (PDOException $e) {
            echo "Error para obter os servizos dos pacentes: " . $e->getMessage();
        }
    }

    public function obtenerServizo($id)
    {
        try {
            $sql = 'SELECT * FROM servizos WHERE id = :id';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam('id', $id);
            $stm->execute();
            $lista = $stm->fetchObject('Servizo');
            return $lista;
        } catch (PDOException $e) {
            echo "Error para obter o servizo: " . $e->getMessage();
        }
    }

    public function engadirPacente($pacente, $idsServizos)
    {
        try {
            $this->conexion->beginTransaction();

            $sql = 'INSERT INTO pacentes (nome, email, nacemento, alta) VALUES (:nome, :email, :nacemento, :alta)';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam('nome', $pacente->nome);
            $stm->bindParam('email', $pacente->email);
            $stm->bindParam('nacemento', $pacente->nacemento);
            $stm->bindParam('alta', $pacente->alta);
            $stm->execute();

            $idPacente = $this->conexion->lastInsertId();
            $sqlPibote = 'INSERT INTO pacente_servizo (pacente_id, servizo_id) VALUES (:pacente_id, :servizo_id)';
            $stmPibote = $this->conexion->prepare($sqlPibote);
            foreach ($idsServizos as $id) {
                $stmPibote->bindParam('pacente_id', $idPacente);
                $stmPibote->bindParam('servizo_id', $id);
                $stmPibote->execute();
            }

            $this->conexion->commit();
        } catch (PDOException $e) {
            $this->conexion->rollBack();
            echo "Error para engadir o pacente: " . $e->getMessage();
        }
    }

    public function borrarPacente($id)
    {
        try {
            $this->conexion->beginTransaction();

            $sqlPibote = 'DELETE FROM pacente_servizo WHERE pacente_id = :id';
            $stmPibote = $this->conexion->prepare($sqlPibote);
            $stmPibote->bindParam('id', $id);
            $stmPibote->execute();

            $sql = 'DELETE FROM pacentes WHERE id = :id';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam('id', $id);
            $stm->execute();

            $this->conexion->commit();
        } catch (PDOException $e) {
            $this->conexion->rollBack();
            echo "Error para borrar o pacente: " . $e->getMessage();
        }
    }
}
