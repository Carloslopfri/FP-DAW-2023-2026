<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

class DAO_class
{
    public $conexion;

    public function __construct()
    {
        // Creamos la conexión con la base de datos.
        try {
            // Localización de la BBDD.
            $dsn = "mysql:host=localhost;dbname=miniaplicacion;charset=utf8";
            // Usario de la bbd.
            $usuario = 'phpmyadmin';
            // Contraseña de la bbdd.
            $contraseña = 'xubu';
            // Establecemos la conexión.
            $this->conexion = new PDO($dsn, $usuario, $contraseña);
            // Obliga a preparar todas las consultas.
            $this->conexion->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
            // Activa las excepciones.
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            echo "Error al conectar a la base de datos: " . $e->getMessage();
        }
    }

    // Creamos la función para verificar el usuario.
    public function verificarUsuario($correo)
    {
        try {
            // Creamos la consulta (Selecciona la contraseña de la tabla usuarios donde el correo = :correo).
            $sql = "SELECT contrasena FROM usuarios WHERE correo = :correo";
            // Preparamos la consulta.
            $stmt = $this->conexion->prepare($sql);
            // Asignamos el valor de $correo a :correo, PDO::PARAM_STR indica que el valor es una cadena de texto.
            $stmt->bindValue(":correo", $correo, PDO::PARAM_STR);
            // Ejecutamos la consulta.
            $stmt->execute();
            // Obtenemos el resultado de la consulta.
            $contraseña = $stmt->fetch(PDO::FETCH_ASSOC);
            // Mandamos la contraseña, que ne caso de que exista el correo devolverá el hash y en caso de que no devolverá un false.
            return $contraseña;
        } catch (PDOException $e) {
            return "Error para verificar el usuario: " . $e->getMessage();
        }
    }

    // Creamos la función para obtener los datos de la base de datos.
    public function obtenerDatos()
    {
        try {
            $sql = 'SELECT * FROM usuarios';
            $stmt = $this->conexion->prepare($sql);
            $stmt->execute();
            // En este caso hay que poner fetchAll porque estas recogiendo varios datos.
            $usuarios = $stmt->fetchAll(PDO::FETCH_CLASS ,'Usuario');
            return $usuarios;
        } catch (PDOException $e) {
            return "Error para mostrar los datos: " . $e->getMessage();
        }
    }

    // Creamos la función para obtener los datos de un usuario específico de la base de datos.
    public function obtenerUsuario($correo)
    {
        try {
            $sql = 'SELECT * FROM usuarios WHERE correo = :correo';
            $stmt = $this->conexion->prepare($sql);
            $stmt->bindValue(':correo', $correo, PDO::FETCH_ASSOC);
            $stmt->execute();
            // En este caso hay que poner fetchAll porque estas recogiendo varios datos.
            $usuario = $stmt->fetchObject('Usuario');
            return $usuario;
        } catch (PDOException $e) {
            return "Error para mostrar el usuario: " . $e->getMessage();
        }
    }

    // Creamos la función para añadir un usuario nuevo a la base de datos.
    public function añadirUsuario($objetoUsr)
    {
        try {
            $nombre = $objetoUsr->nombre;
            $correo = $objetoUsr->correo;
            $contrasena = $objetoUsr->contrasena;
            $rol = $objetoUsr->rol;
            $imagen = $objetoUsr->imagen;

            $sql = 'INSERT INTO usuarios (nombre, correo, contrasena, rol, imagen) VALUES (:nombre, :correo, :contrasena, :rol, :imagen)';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam(':nombre', $nombre, PDO::PARAM_STR);
            $stm->bindParam(':correo', $correo, PDO::PARAM_STR);
            $stm->bindParam(':contrasena', $contrasena, PDO::PARAM_STR);
            $stm->bindParam(':rol', $rol, PDO::PARAM_STR);
            $stm->bindParam(':imagen', $imagen, PDO::PARAM_STR);
            $stm->execute();
        } catch (PDOException $e) {
            return "Error para añadir el nuevo usuario: " . $e->getMessage();
        }
    }

    // Creamos la función para borrar un usuario de la base de datos.
    public function borrarUsuario($idUsuario)
    {
        try {
            $sql = 'DELETE FROM usuarios WHERE id = :id';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam(':id', $idUsuario, PDO::PARAM_INT);
            $stm->execute();
        } catch (PDOException $e) {
            return "Error al eliminar el usuario: " . $e->getMessage();
        }
    }

    // Creamos la función para modificar un usuario de la base de datos.
    public function modificarUsuario($id, $objetoUsr)
    {
        try {
            $nombre = $objetoUsr->nombre;
            $correo = $objetoUsr->correo;
            $contrasena = $objetoUsr->contrasena;
            $rol = $objetoUsr->rol;

            $sql = 'UPDATE usuarios SET nombre = :nombre, correo = :correo, contrasena = :contrasena, rol = :rol WHERE id = :id';
            $stm = $this->conexion->prepare($sql);
            $stm->bindParam(':id', $id, PDO::PARAM_INT);
            $stm->bindParam(':nombre', $nombre, PDO::PARAM_STR);
            $stm->bindParam(':correo', $correo, PDO::PARAM_STR);
            $stm->bindParam(':contrasena', $contrasena, PDO::PARAM_STR);
            $stm->bindParam(':rol', $rol, PDO::PARAM_STR);
            $stm->execute();
        } catch (PDOException $e) {
            return 'Error al modificar el usuario: ' . $e->getMessage();
        }
    }
}