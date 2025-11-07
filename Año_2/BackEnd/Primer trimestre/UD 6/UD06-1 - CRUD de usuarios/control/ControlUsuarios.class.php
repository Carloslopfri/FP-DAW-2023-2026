<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

require('../modelo/DAO.class.php');
require_once '../modelo/Usuario.class.php';

class Control
{
    // Creamos la función para validar el formulario del login.
    public function validarLogin($correo, $contraseña)
    {
        $correoCorrecto = false;
        $contraseñaCorracta = false;

        $errores = [];

        $dominio = "@cifprodolfoucha.es";
        if (empty($correo)) {
            array_push($errores, "<li style = 'color: red'>Error: Tienes que cubrir el apartado de correo electrónico.</li>");
        } else if (substr($correo, -19) != $dominio) {
            array_push($errores, "<li style = 'color: red'>Error: El apartado del corre electrónico no tiene un formato correcto (es obligatorio que el dominio sea '@cifprodolfoucha.es').</li>");
        } else {
            $correoCorrecto = true;
        }


        if (empty($contraseña)) {
            array_push($errores, "<li style = 'color: red'>Error: El apartado de contraseña no puede estar vacío.</li>");
        } else if (strlen($contraseña) < 5 || strlen($contraseña) > 10) {
            array_push($errores, "<li style = 'color: red'>Error: El apartado de contraseña tiene que tener un mínimo de 5 caracteres y un máximo de 10.</li>");
        } else {
            $contraseñaCorracta = true;
        }

        // Creamos la condición, para cuando esté todo correcto, ejecutar la funcion craeda en la clase DAO.
        if ($correoCorrecto == true && $contraseñaCorracta == true) {
            $dao = new DAO_class();
            $verificacion = $dao->verificarUsuario($correo);
            if ($verificacion === false) {
                array_push($errores, "<li style = 'color: red'>El usuario no existe.</li>");
                return $errores;
            } else {
                if (password_verify($contraseña, $verificacion['contrasena'])) {
                    return true;
                } else {
                    array_push($errores, "<li style = 'color: red'>La contraseña no es correcta.</li>");
                    return $errores;
                }
            }
        } else {
            return $errores;
        }
    }

    // Creamos la función para validar el formulario de Añadir Usuario.
    public function validarAñadirUsr($nombre, $correo, $contraseña, $rol)
    {
        $nombreCorrecto = false;
        $correoCorrecto = false;
        $contraseñaCorrecto = false;
        $rolCorrecto = false;

        $errores = [];

        if (empty($nombre)) {
            array_push($errores, '<li style = "color:red">El campo de nombre es obligatorio.</li>');
        } else if (strlen($nombre) > 20) {
            array_push($errores, '<li style = "color:red">El campo de nombre no puede tener más de 20 caracteres</li>');
        } else {
            $nombreCorrecto = true;
        }

        $dominio = "@cifprodolfoucha.es";
        if (empty($correo)) {
            array_push($errores, '<li style = "color:red">El campo de correo electrónico es obligatorio.</li>');
        } else if (substr($correo, -19) != $dominio) { // El substr sirve para recorrer el String, al poner un número negativo lo recorre del revés.
            array_push($errores, "<li style = 'color: red'>Error: El apartado del corre electrónico no tiene un formato correcto (es obligatorio que el dominio sea '@cifprodolfoucha.es').</li>");
        } else {
            $correoCorrecto = true;
        }

        if (empty($contraseña)) {
            array_push($errores, '<li style = "color:red">El campo de contraseña es obligatorio.</li>');
        } else if (strlen($contraseña) < 4 || strlen($contraseña) > 20) {
            array_push($errores, '<li style = "color:red">El campo de contraseña tiene que tener un mínimo de 4 caracteres y un máximo de 20.</li>');
        } else {
            $contraseñaCorrecto = true;
        }

        if ($rol == 'vacio') {
            array_push($errores, '<li style = "color:red">El campo de rol es obligatorio.</li>');
        } else {
            $rolCorrecto = true;
        }

        // Creamos la condición, para cuando esté todo correcto, ejecutar la funcion craeda en la clase DAO.
        if ($nombreCorrecto == true && $correoCorrecto == true && $contraseñaCorrecto == true && $rolCorrecto == true) {
            $hashContraseña = password_hash($contraseña, PASSWORD_DEFAULT);
            $imagen = $nombre . '.jpg';
            $nuevoUsuario = new Usuario();
            $nuevoUsuario->crear($nombre, $correo, $hashContraseña, $rol, $imagen);
            $dao = new DAO_class();
            $dao->añadirUsuario($nuevoUsuario);
            return true;
        } else {
            return $errores;
        }
    }

    // Creamos la función para validar el formulario de Modificar Usuario.
    public function validarModificarUsr($id, $nombre, $correo, $contraseña, $rol)
    {
        $nombreCorrecto = false;
        $correoCorrecto = false;
        $contraseñaCorrecto = false;

        $errores = [];

        if (empty($nombre)) {
            array_push($errores, '<li style = "color:red">El campo de nombre es obligatorio.</li>');
        } else if (strlen($nombre) > 20) {
            array_push($errores, '<li style = "color:red">El campo de nombre no puede tener más de 20 caracteres</li>');
        } else {
            $nombreCorrecto = true;
        }

        $dominio = "@cifprodolfoucha.es";
        if (empty($correo)) {
            array_push($errores, '<li style = "color:red">El campo de correo electrónico es obligatorio.</li>');
        } else if (substr($correo, -19) != $dominio) { // El substr sirve para recorrer el String, al poner un número negativo lo recorre del revés.
            array_push($errores, "<li style = 'color: red'>Error: El apartado del corre electrónico no tiene un formato correcto (es obligatorio que el dominio sea '@cifprodolfoucha.es').</li>");
        } else {
            $correoCorrecto = true;
        }

        if (empty($contraseña)) {
            array_push($errores, '<li style = "color:red">El campo de contraseña es obligatorio.</li>');
        } else if (strlen($contraseña) < 4 || strlen($contraseña) > 20) {
            array_push($errores, '<li style = "color:red">El campo de contraseña tiene que tener un mínimo de 4 caracteres y un máximo de 20.</li>');
        } else {
            $contraseñaCorrecto = true;
        }

        // Creamos la condición, para cuando esté todo correcto, ejecutar la funcion craeda en la clase DAO.
        if ($nombreCorrecto == true && $correoCorrecto == true && $contraseñaCorrecto == true) {
            $hashContraseña = password_hash($contraseña, PASSWORD_DEFAULT);
            $imagen = $nombre . '.jpg';
            $objUsuario = new Usuario();
            $objUsuario->crear($nombre, $correo, $hashContraseña, $rol, $imagen);
            $dao = new DAO_class();
            $dao->modificarUsuario($id, $objUsuario);
            return true;
        } else {
            return $errores;
        }
    }

    // Creamos la función para mostrar los datos de la base de datos, usando la función creada en la clase DAO.
    public function mostrarDatos()
    {
        $dao = new DAO_class();
        $usuario = $dao->obtenerDatos();
        return $usuario;
    }

    // Creamos la función para mostrar los datos de un usuario en concreto de la base de datos, usando la función creada en la clase DAO.
    public function mostrarUsuario($correo)
    {
        $dao = new DAO_class();
        $usuario = $dao->obtenerUsuario($correo);
        return $usuario;
    }

    // Creamos la función para eliminar un usuario de la base de datos, usando la función creada en la clase DAO.
    public function eliminar($id)
    {
        $dao = new DAO_class();
        $dao->borrarUsuario($id);
    }
}