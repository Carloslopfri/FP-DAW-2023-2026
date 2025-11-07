<?php
/*
    Título: UD06-1 - CRUD de usuarios

    Autor: Carlos López Frieiro

    Data modificación: 03/12/2024

    Versión 1.1
*/

session_start();
include '../modelo/Usuario.class.php';
include '../control/ControlUsuarios.class.php';

$control = new Control();

// Creamos la condición para cuando no exista el usuario o el rol del usuario no sea el de administrador nos mande al Inicio.
$usuario = $control->mostrarUsuario($_SESSION["correo"]);
if (!isset($_SESSION['correo']) || $usuario->rol == 'usuario') {
    header("Location: ../inicio.php");
    exit;
}

$idUsr = $_GET['id'];

$usuarios = $control->mostrarDatos();
foreach ($usuarios as $usuario) {
    if ($usuario->id == $idUsr) {
        $nombre = $usuario->nombre;
        $correo = $usuario->correo;
        $contraseña = $usuario->contrasena;
        $rol = $usuario->rol;
        $imagen = $usuario->imagen;
        break;
    }
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar usuario</title>
</head>

<body>
    <?php
    include 'menu.php';
    ?>
    <h1>Introduce los datos del usuario que desees modificar:</h1>
    <?php
    if (isset($_POST['modificar'])) {
        $textNombre = $_POST['nombre'];
        $textCorreo = $_POST['correo'];
        $textContraseña = $_POST['contraseña'];
        $textRol = $_POST['roles'];

        $respuesta = $control->validarModificarUsr($idUsr, $textNombre, $textCorreo, $textContraseña, $textRol);
        if ($respuesta === true) {
            echo '<h3 style = "color:green">Usuario modificado exitosamente!!!</h3>';
        } else {
            echo '<ul>';
            foreach ($respuesta as $error) {
                echo $error;
            }
            echo '</ul>';
        }
    }
    ?>
    <form action="./modificarUsr.php?id=<?php echo $idUsr ?>" method="post" enctype="multipart/form-data">
        <label for="nombre">Nombre: </label>
        <input type="text" name="nombre" required value="<?php if (isset($nombre)) {
                                                                echo $nombre;
                                                            } ?>"><br><br>

        <label for="correo">Correo electrónico: </label>
        <input type="text" name="correo" required value="<?php if (isset($correo)) {
                                                                echo $correo;
                                                            } ?>"><br><br>

        <label for="contraseña">Contraseña: </label>
        <input type="password" name="contraseña" required><br><br>

        <label for="roles">Rol: </label>
        <select name="roles" id="roles">
            <option value="usuario" <?php if (isset($textRol)) {
                                        if ($textRol == 'usuario') {
                                            echo 'selected';
                                        }
                                    } ?>>Usuario</option>
            <option value="admin" <?php if (isset($textRol)) {
                                        if ($textRol == 'admin') {
                                            echo 'selected';
                                        }
                                    } ?>>Administrador</option>
        </select><br><br>

        <button name="modificar" type="submit">Modificar</button>
    </form>
</body>

</html>