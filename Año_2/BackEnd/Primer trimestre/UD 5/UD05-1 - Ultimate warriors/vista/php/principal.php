<?php
/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

// Cargamos las clases de los diferentes persoanjes.
include 'Personaje.class.php';
include 'Barbaro.class.php';
include 'Clerigo.class.php';
include 'Bardo.class.php';
include 'Log.class.php';

// Iniciamos sesión.
session_start();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./../../styles/principal.css">
    <title>Ultimate warriors</title>
</head>

<body>
    <header>
        <h1>Ultimate warriors</h1>
    </header>
    <div>
        <?php
        // Creamos un bucle que verifique la existencia de la sesión que guarda el array donde vamos a guardar los persoanjes, con esto aseguramos que los personajes no se sobrescriban.
        if (!isset($_SESSION['personajes'])) {
            $_SESSION['personajes'] = [];
        }

        // Creamos la función del botón "añadir".
        if (isset($_POST["añadir"])) {

            $IDcorrecto = false;
            $IdRepCorrecto = false;
            $nombreCorrecto = false;
            $imagenCorrecto = false;
            $vidaCorrecto = false;
            $ataqueCorrecto = false;
            $defensaCorrecto = false;
            $categoriaCorrecto = false;
            $categoriaPersCorrecto = false;

            echo '<ul>';

            // Validamos el id.
            $textID = $_POST['id'];
            if (empty($textID)) {
                echo '<li style = "color:red">El id es obligatorio.</li>';
            } else if (strlen($textID) <= 0) {
                echo '<li style = "color:red">El id tiene que ser mínimo de un caracter.</li>';
            } else if (!is_numeric($textID)) { // "is_numeric" confirma si es dato es numérico.
                echo '<li style = "color:red">El id tiene que tener un valor numérico.</li>';
            } else {
                $IDcorrecto = true;
            }

            // Validamos que el id no se repita.
            $existe = false;
            foreach ($_SESSION['personajes'] as $personaje) {
                if ($personaje->id == $textID) {
                    $existe = true;
                }
            }
            if ($existe == true) {
                echo '<li style = "color:red">El id ya existe.</li>';
            } else {
                $IdRepCorrecto = true;
            }

            // Validamos el nombre.
            $textNombre = $_POST['nombre'];
            if (empty($textNombre)) {
                echo '<li style = "color:red">El nombre es obligatorio.</li>';
            } else if (strlen($textNombre) < 4 || strlen($textNombre) > 20) {
                echo '<li style = "color:red">El nombre tine que tener un mínimo de 4 caracteres y un máximo de 20.</li>';
            } else {
                $nombreCorrecto = true;
            }

            // Validamos la imagen.
            $textImg = $_FILES['img'];
            if (!isset($textImg)) {
                echo '<li style = "color:red">El campo de la imagen es obligatorio.</li>';
            } else {
                $imagenCorrecto = true;
            }

            // Validamos los puntos de vida.
            $textVida = $_POST['pv'];
            if (empty($textVida)) {
                echo '<li style = "color:red">El campo de puntios de vida es obligatorio.</li>';
            } else if (strlen($textVida) < 3 || strlen($textVida) > 10) {
                echo '<li style = "color:red">El campo de puntios de vida tine que tener un mínimo de 3 caracteres y un máximo de 10.</li>';
            } else if (!is_numeric($textVida)) {
                echo '<li style = "color:red">El campo de puntios de vida tiene que tener un valor numérico.</li>';
            } else {
                $vidaCorrecto = true;
            }

            // Validamos los puntos de ataque.
            $textAtaque = $_POST['pa'];
            if (empty($textAtaque)) {
                echo '<li style = "color:red">El campo de puntios de ataque es obligatorio.</li>';
            } else if (strlen($textAtaque) < 3 || strlen($textAtaque) > 10) {
                echo '<li style = "color:red">El campo de puntios de ataque tine que tener un mínimo de 3 caracteres y un máximo de 10.</li>';
            } else if (!is_numeric($textAtaque)) {
                echo '<li style = "color:red">El campo de puntios de ataque tiene que tener un valor numérico.</li>';
            } else {
                $ataqueCorrecto = true;
            }

            // Validamos los puntos de defensa.
            $textDefensa = $_POST['pd'];
            if (empty($textDefensa)) {
                echo '<li style = "color:red">El campo de puntios de defensa es obligatorio.</li>';
            } else if (strlen($textDefensa) < 3 || strlen($textDefensa) > 10) {
                echo '<li style = "color:red">El campo de puntios de defensa tine que tener un mínimo de 3 caracteres y un máximo de 10.</li>';
            } else if (!is_numeric($textDefensa)) {
                echo '<li style = "color:red">El campo de puntios de defensa tiene que tener un valor numérico.</li>';
            } else {
                $defensaCorrecto = true;
            }

            // Validamos la categoría.
            $textCategoria = $_POST['categoria'];
            if ($textCategoria == 'vacio') {
                echo '<li style = "color:red">La categoría es obligatoria.</li>';
            } else {
                $categoriaCorrecto = true;
            }

            // Validamos los atributos, dependiendo de que tipo de personaje elijamos.
            $textNivelBerserker = $_POST['nivelBerserker'];
            $textCuracion = $_POST['curacion'];
            $textCancion = $_POST['cancion'];
            if ($textCategoria == 'barbaro') {
                if (empty($textNivelBerserker)) {
                    echo '<li style = "color:red">El campo de Nivel de berserker es obligatorio.</li>';
                } else if (strlen($textNivelBerserker) > 2) {
                    echo '<li style = "color:red">El campo de Nivel de berserker tiene que ser como máximo nivel 99.</li>';
                } else if (!is_numeric($textNivelBerserker)) {
                    echo '<li style = "color:red">El valor de Nivel de berserker tiene que ser numérico.</li>';
                } else {
                    $categoriaPersCorrecto = true;
                }
            } else if ($textCategoria == 'clerigo') {
                if (empty($textCuracion)) {
                    echo '<li style = "color:red">El campo de Poder de curación es obligatorio.</li>';
                } else if (strlen($textCuracion) < 3 || strlen($textCancion) > 10) {
                    echo '<li style = "color:red">El campo de Poder de curación tiene que tener un mínino de 3 caracteres y un máximo de 10.</li>';
                } else if (!is_numeric($textCuracion)) {
                    echo '<li style = "color:red">El valor de Poder de curación tiene que ser numérico.</li>';
                } else {
                    $categoriaPersCorrecto = true;
                }
            } else if ($textCategoria == 'bardo') {
                $textCancion = $_POST['cancion'];
                if ($textCancion == 'vacio') {
                    echo '<li style = "color:red">La canción es obligatoria.</li>';
                } else {
                    $categoriaPersCorrecto = true;
                }
            }

            // En el caso de que todas las validaciones estén bien, guardamos todos los datos en la sesión array de objetos "personajes".
            if ($IDcorrecto == true && $nombreCorrecto == true && $vidaCorrecto == true && $ataqueCorrecto == true && $defensaCorrecto == true && $categoriaCorrecto == true && $imagenCorrecto == true && $categoriaPersCorrecto == true && $IdRepCorrecto == true) {
                // Creamos la condición para verificar que exista el archivo y para ver que no haya errores.
                if (isset($_FILES["img"]) && $_FILES["img"]["error"] == 0) { // "img" es el nombre que le diste al input de tipo file de la imagem, y para que el formulario lo coja tiene que poner en la etiqueta de "<form>" enctype="multipart/form-data".
                    // Ponemos la ruta actual de la imagen en este caso.
                    $rutatemporal = $_FILES["img"]["tmp_name"];
                    // Ponemos la ruta nueva de la imagen.
                    $destino = "./../../img/" . $textNombre . ".png"; // Para que reconozca la carpeta tienes que darle permisos de escritura: chmod 755 img (en la carpeta donde se encuentre img).
                    // Movemos la imagen de la ruta temporal a la nueva ruta.
                    if (!move_uploaded_file($rutatemporal, $destino)) {
                        echo "<li style = 'color: red'>Hubo un error al cargar la imagen.</li>";
                    }
                }

                if ($textCategoria == 'barbaro') {
                    // Creamos el objeto Barbaro en este caso. 
                    $objBarbaro = new Barbaro($textID, $textNombre, $destino, $textVida, $textAtaque, $textDefensa, $textCategoria, $textNivelBerserker);
                    // Lo guardamos en el array.
                    array_push($_SESSION['personajes'], $objBarbaro);
                    // Registrarmos la inserción en el log.
                    Log::registrarLog("Personaje creado: " . $textNombre . "\n");
                } else if ($textCategoria == 'clerigo') {
                    $textAura = $_POST['aura'];
                    // Creamos el objeto Clerigo en este caso.
                    $objClerigo = new Clerigo($textID, $textNombre, $destino, $textVida, $textAtaque, $textDefensa, $textCategoria, $textCuracion, $textAura);
                    // Lo guardamos en el array.
                    array_push($_SESSION['personajes'], $objClerigo);
                    // Registrarmos la inserción en el log.
                    Log::registrarLog("Personaje creado: " . $textNombre . "\n");
                } else if ($textCategoria == 'bardo') {
                    // Creamos el objeto Bardo en este caso. 
                    $objBardo = new Bardo($textID, $textNombre, $destino, $textVida, $textAtaque, $textDefensa, $textCategoria, $textCancion);
                    // Lo guardamos en el array.
                    array_push($_SESSION['personajes'], $objBardo);
                    // Registrarmos la inserción en el log.
                    Log::registrarLog("Personaje creado: " . $textNombre . "\n");
                }
            }

            echo '</ul>';
        }
        ?>
    </div>
    <div class="contenedor">
        <form class="persoanjes" action="principal.php" method="post" enctype="multipart/form-data">
            <h3 class="h3personajes">Personajes</h3>

            <label for="id" id="label">ID:</label>
            <input type="text" id="id" name="id" value="<?php if (isset($_POST["id"])) { echo $_POST["id"]; } ?>" required><br><br>

            <label for="nombre" id="label">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<?php if (isset($_POST["nombre"])) { echo $_POST["nombre"]; } ?>" required minlength="4" maxlength="20"><br><br>

            <label for="img" id="label">Imagen:</label>
            <input type="file" id="img" name="img" value="<?php if (isset($textImg)) { echo $textImg; } ?>" required><br><br>

            <label for="pv" id="label">Puntos de vida:</label>
            <input type="text" id="pv" name="pv" value="<?php if (isset($_POST["pv"])) { echo $_POST["pv"]; } ?>" required minlength="3" maxlength="10"><br><br>

            <label for="pa" id="label">Puntos de ataque:</label>
            <input type="text" id="pa" name="pa" value="<?php if (isset($_POST["pa"])) { echo $_POST["pa"]; } ?>" required minlength="3" maxlength="10"><br><br>

            <label for="pd" id="label">Puntos de defensa:</label>
            <input type="text" id="pd" name="pd" value="<?php if (isset($_POST["pd"])) { echo $_POST["pd"]; } ?>" required minlength="3" maxlength="10"><br><br>

            <label for="categoria" id="label">Categoría</label>
            <select name="categoria" id="categoria">
                <option value="vacio"></option>
                <option value="barbaro" <?php if (isset($_POST['categoria'])) {if ($_POST['categoria'] == 'barbaro') {echo 'selected';}} ?>>Bárbaro</option>
                <option value="clerigo" <?php if (isset($_POST['categoria'])) {if ($_POST['categoria'] == 'clerigo') {echo 'selected';}} ?>>Clérigos</option>
                <option value="bardo" <?php if (isset($_POST['categoria'])) {if ($_POST['categoria'] == 'bardo') {echo 'selected';}} ?>>Bardo</option>
            </select><br>

            <div class="atributos" id="atributos">
                <h4 class="titAtribustos">Atributos de clase</h4>

                <div id="atrBarbaro" style="display: none">
                    <label for="nivelBerserker">Nivel de Berserker:</label>
                    <input type="text" name="nivelBerserker" value="<?php if (isset($_POST["nivelBerserker"])) { echo $_POST["nivelBerserker"]; } ?>">
                </div>

                <div id="atrClerigo" style="display: none">
                    <label for="aura">Aura activada</label>
                    <input name="aura" type="checkbox" value="activada" <?php if (isset($_POST['aura']) && $_POST['aura'] == 'activada') echo 'checked'; ?>><br>

                    <label for="curacion">Poder de curación:</label>
                    <input type="text" name="curacion" value="<?php if (isset($_POST["curacion"])) { echo $_POST["curacion"]; } ?>">
                </div>

                <div id="atrBardo" style="display: none">
                    <label for="cancion">Elige una canción:</label>
                    <select name="cancion" id="cancion">
                        <option value="vacio"></option>
                        <option value="Apatrullando la ciudad, Por la noche con su coche apatrulla la ciudad" <?php if (isset($_POST['cancion'])) {if ($_POST['cancion'] == 'Apatrullando la ciudad, Por la noche con su coche apatrulla la ciudad') {echo 'selected';}} ?>>Canción 1</option>
                        <option value="¡Qué viva España!, lo-lo-lo, lo-lo-lo-lo-lo" value="<?php if (isset($_POST['cancion'])) {if ($_POST['cancion'] == '¡Qué viva España!, lo-lo-lo, lo-lo-lo-lo-lo') {echo 'selected';}} ?>">Canción 2</option>
                        <option value="Al partir un beso y una flor Un te quiero, una caricia y un adiós" value="<?php if (isset($_POST['cancion'])) {if ($_POST['cancion'] == 'Al partir un beso y una flor Un te quiero, una caricia y un adiós') {echo 'selected';}} ?>">Canción 3</option>
                    </select>
                </div>
            </div>

            <button class="boton" type="submit" name="añadir" id="añadir">Añadir</button>
            <a href="cerrarSesion.php" class="boton">Borrar sesión</a>
        </form>

        <div class="barbaros">
            <h3 class="h3">Bárbaros</h3>
            <?php
            foreach ($_SESSION['personajes'] as $personaje) {
                if ($personaje->categoria == 'barbaro') {
                    echo '<a href="ficha.php?id=' . $personaje->id . '"><img src="' . $personaje->imagen . '" alt="Barbaro" class="foto"></a><br><br>';
                }
            }
            ?>
        </div>

        <div class="clerigos">
            <h3 class="h3">Clérigos</h3>
            <?php
            foreach ($_SESSION['personajes'] as $personaje) {
                if ($personaje->categoria == 'clerigo') {
                    echo '<a href="ficha.php?id=' . $personaje->id . '"><img src="' . $personaje->imagen . '" alt="Clerigo" class="foto"></a><br><br>';
                }
            }
            ?>
        </div>

        <div class="bardos">
            <h3 class="h3">Bardos</h3>
            <?php
            foreach ($_SESSION['personajes'] as $personaje) {
                if ($personaje->categoria == 'bardo') {
                    echo '<a href="ficha.php?id=' . $personaje->id . '"><img src="' . $personaje->imagen . '" alt="Bardo" class="foto"></a><br><br>';
                }
            }
            ?>
        </div>
    </div>
    <script language="JavaScript" src="./../js/principal.js"></script>
</body>

</html>