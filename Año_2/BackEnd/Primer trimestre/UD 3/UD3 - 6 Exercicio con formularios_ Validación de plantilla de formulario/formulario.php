<?php
/*
    Título: UD3 - 6 Exercicio con formularios: Validación de plantilla de formulario

    Autor: Carlos López Frieiro

    Data modificación: 22/10/2024

    Versión 1.1
*/
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>

<body>

    <div class="contenedor-principal">
        <!-- Cabeceira con título -->
        <header>
            <h1>Formulario Carlos López Frieiro</h1>
        </header>
        <?php
        if (isset($_POST["enviar"])) {
            $correoCorrecto = false;
            $contraseñaCorrecto = false;
            $CcontraseñaCorrecto = false;
            $edadCorrecto = false;
            $NIFCorrecto = false;
            $fechaCorrecto = false;
            $estadoCivilCorrecto = false;
            $vehiculoCorrecto = false;
            $continentesCorrecto = false;
            $paisesCorrecto = false;
            $comentariosCorrecto = false;
            $enlaceCorrecto = false;
            $ocultoCorrecto = false;

            echo "<ul>";
            $textCorreo = $_POST["correo"];
            if (empty($textCorreo)) { // empty es para indicar si está vacío.
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de correo electrónico.</li>";
            } else if (!filter_var($textCorreo, FILTER_VALIDATE_EMAIL)) { // filter_van sirve para dar formato, lo que viene despues de $textCorreo es el filtro indicado que en el caso de los email php ya tiene uno predeterminado.
                echo "<li style = 'color: red'>Error: El formato del correo electrónico no es válido.</li>";
            } else {
                $correoCorrecto = true;
            }

            $textContraseña = $_POST["contraseña"];
            if (empty($textContraseña)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de contraseña.</li>";
            } else if (strlen($textContraseña) < 5) {
                echo "<li style = 'color: red'>Error: La contraseña tiene que tener un mínimo de 5 caracteres.</li>";
            } else if (strlen($textContraseña) > 10) {
                echo "<li style = 'color: red'>Error: La contraseña tiene que tener un máximo de 10 caracteres.</li>";
            } else {
                $contraseñaCorrecto = true;
            }

            $textCcontraseña = $_POST["Ccontraseña"];
            if (empty($textCcontraseña)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de confirmar contraseña.</li>";
            } else if ($textCcontraseña != $textContraseña) {
                echo "<li style = 'color: red'>Error: El apartado de 'confirmar contraseña' tiene que ser igual al apartado de contraseña.</li>";
            } else {
                $CcontraseñaCorrecto = true;
            }

            $textEdad = $_POST["edad"];
            if (empty($textEdad)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de edad.</li>";
            } else if (strlen($textEdad) > 2) {
                echo "<li style = 'color: red'>Error: El formato de Edad tiene que ser como máximo de 2 dígito.</li>";
            } else {
                $edadCorrecto = true;
            }

            $textNIF = $_POST["NIF"];
            if (empty($textNIF)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de NIF.</li>";
            } else if (!preg_match('/^[0-9]{8}[A-Z]{1}$/', $textNIF)) {
                echo "<li style = 'color: red'>Error: El formato del NIF tine que ser de 8 digitos numéricos y terminar en un caracter alfabético en mayúsculas.</li>";
            } else {
                $NIFCorrecto = true;
            }

            $textFecha = $_POST["fecha"];
            if (empty($textFecha)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Fecha.</li>";
            } else if (!preg_match('/^[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}$/', $textFecha)) {
                echo "<li style = 'color: red'>Error: La fecha introducida no tiene el formato YYYY/mm/dd.</li>";
            } else {
                $fechaCorrecto = true;
            }

            if (!isset($_POST["estadoCivil"])) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Estado Civil.</li>";
            } else {
                $estadoCivilCorrecto = true;
            }

            if (!isset($_POST["vehiculo"])) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Vehiculo propio.</li>";
            } else {
                $vehiculoCorrecto = true;
            }

            if (empty($_POST["continentes"])) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Continente.</li>";
            } else {
                $continentesCorrecto = true;
            }

            $textPaises = $_POST["paises"];
            if (empty($textPaises)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Paises.</li>";
            } else {
                $paisesCorrecto = true;
            }

            $textComentarios = $_POST["comentarios"];
            if (empty($textComentarios)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Comentarios.</li>";
            } else if (strlen($textComentarios) < 10 || strlen($textComentarios) > 50) {
                echo "<li style = 'color: red'>Error: El apartado de comentarios tiene que tener un mínimo de 10 caracteres y un máximo de 50.</li>";
            } else {
                $comentariosCorrecto = true;
            }

            $textEnlace = $_POST["enlace"];
            if (empty($textEnlace)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado de Enlace.</li>";
            } else if (!filter_var($textEnlace, FILTER_VALIDATE_URL)) {
                echo "<li style = 'color: red'>Error: El formato del enlace no es válido.</li>";
            } else {
                $enlaceCorrecto = true;
            }

            $textOculto = $_POST["oculto"];
            if (empty($textOculto)) {
                echo "<li style = 'color: red'>Error: Tienes que cubrir el apartado oculto.</li>";
            } else {
                $ocultoCorrecto = true;
            }

            if ($correoCorrecto == true && $contraseñaCorrecto == true && $CcontraseñaCorrecto == true && $edadCorrecto == true && $NIFCorrecto == true && $fechaCorrecto == true && $estadoCivilCorrecto == true && $vehiculoCorrecto == true && $continentesCorrecto == true && $paisesCorrecto == true && $comentariosCorrecto == true && $enlaceCorrecto == true && $ocultoCorrecto == true ) {
                header("Location: correcto.html");
                exit();
            }
            echo "</ul>";
        }

        if (isset($_POST["cancelar"])) {
            header("Location: paginaDos.html");
            exit();
        }
        ?>
        <!-- Contido principal -->
        <div class="vista-agenda">

            <!-- Formulario -->
            <section id="formulario-seccion">
                <h2>Date de alta:</h2>
                <form id="formulario-contactos" action="formulario.php" method="post">
                    <label for="correo" id="lcorreo">Correo electrónico:</label>
                    <input type="email" id="correo" name="correo" value="<?php if (isset($_POST["correo"])) { echo $_POST["correo"]; } ?>"><br><br>

                    <label for="contraseña" id="lcontraseña">Contraseña:</label>
                    <input type="password" id="contraseña" name="contraseña" value="<?php if (isset($_POST["contraseña"])) { echo $_POST["contraseña"]; } ?>"><br><br>

                    <label for="Ccontraseña" id="lCcontraseña">Confirma la contraseña:</label>
                    <input type="password" id="Ccontraseña" name="Ccontraseña" value="<?php if (isset($_POST["Ccontraseña"])) { echo $_POST["Ccontraseña"]; } ?>"><br><br>

                    <label for="edad" id="ledad">Edad:</label>
                    <input type="number" id="edad" name="edad" value="<?php if (isset($_POST["edad"])) { echo $_POST["edad"]; } ?>"><br><br>

                    <label for="NIF" id="lNIF">NIF:</label>
                    <input type="text" id="NIF" name="NIF" value="<?php if (isset($_POST["NIF"])) { echo $_POST["NIF"]; } ?>"><br><br>

                    <label for="fecha" id="lfecha">Fecha de nacimiento:</label>
                    <input type="date" id="fecha" name="fecha" value="<?php if (isset($_POST["fecha"])) { echo $_POST["fecha"]; } ?>"><br><br>

                    <p>Estado civil:</p>
                    <input type="radio" id="casado" name="estadoCivil" value="casado" <?php if (isset($_POST['estadoCivil']) && $_POST['estadoCivil'] == 'casado') echo 'checked'; ?>>
                    <label for="casado">Casad@</label><br>
                    <input type="radio" id="soltero" name="estadoCivil" value="soltero" <?php if (isset($_POST['estadoCivil']) && $_POST['estadoCivil'] == 'soltero') echo 'checked'; ?>>
                    <label for="soltero">Solter@</label><br>
                    <input type="radio" id="pareja" name="estadoCivil" value="pareja" <?php if (isset($_POST['estadoCivil']) && $_POST['estadoCivil'] == 'pareja') echo 'checked'; ?>>
                    <label for="pareja">Con pareja</label><br><br>

                    <p>Vehiculo propio:</p>
                    <input type="checkbox" id="coche" name="vehiculo" value="coche" <?php if (isset($_POST['vehiculo']) && $_POST['vehiculo'] == 'coche') echo 'checked'; ?>>
                    <label for="coche">Coche</label><br>
                    <input type="checkbox" id="moto" name="vehiculo" value="moto" <?php if (isset($_POST['vehiculo']) && $_POST['vehiculo'] == 'moto') echo 'checked'; ?>>
                    <label for="moto">Moto</label><br>
                    <input type="checkbox" id="bicipatin" name="vehiculo" value="bicipatin" <?php if (isset($_POST['vehiculo']) && $_POST['vehiculo'] == 'bicipatin') echo 'checked'; ?>>
                    <label for="bicipatin">Bici o monopatín</label><br>
                    <input type="checkbox" id="nada" name="vehiculo" value="nada" <?php if (isset($_POST['vehiculo']) && $_POST['vehiculo'] == 'nada') echo 'checked'; ?>>
                    <label for="nada">Ninguno</label><br><br>

                    <label for="continente">Continente:</label>
                    <select name="continentes[]" id="continente" size="5" multiple>
                        <option value="Europa" <?php if (isset($_POST['continentes'])) {if (in_array("Europa", $_POST["continentes"])) echo 'selected';} ?>>Europa</option>
                        <option value="America" <?php if (isset($_POST['continentes'])) {if (in_array("America", $_POST["continentes"])) echo 'selected';} ?>>América</option>
                        <option value="Africa" <?php if (isset($_POST['continentes'])) {if (in_array("Africa", $_POST["continentes"])) echo 'selected';} ?>>África</option>
                        <option value="Asia" <?php if (isset($_POST['continentes'])) {if (in_array("Asia", $_POST["continentes"])) echo 'selected';} ?>>Ásia</option>
                        <option value="Oceania" <?php if (isset($_POST['continentes'])) {if (in_array("Oceania", $_POST["continentes"])) echo 'selected';} ?>>Oceanía</option>
                    </select><br><br>

                    <label for="pais">País:</label>
                    <select name="paises" id="pais">
                        <option value="españa" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'españa') echo 'selected'; ?>>España</option>
                        <option value="francia" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'francia') echo 'selected'; ?>>Francia</option>
                        <option value="italia" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'italia') echo 'selected'; ?>>Italia</option>
                        <option value="portugal" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'portugal') echo 'selected'; ?>>Portugal</option>
                        <option value="UK" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'UK') echo 'selected'; ?>>UK</option>
                        <option value="alemania" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'alemania') echo 'selected'; ?>>Alemania</option>
                        <option value="belgica" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'belgica') echo 'selected'; ?>>Bélgica</option>
                        <option value="otro" <?php if (isset($_POST['paises']) && $_POST['paises'] == 'otro') echo 'selected'; ?>>Otro...</option>
                    </select><br><br>

                    <label for="comentarios" id="lcomentarios">Comentarios:</label>
                    <textarea id="comentarios" name="comentarios"> <?php if (isset($_POST["comentarios"])) { echo $_POST["comentarios"]; } ?> </textarea><br><br>

                    <label for="enlace" id="enlace">Enlace:</label>
                    <input type="url" id="enlace" name="enlace" value="<?php if (isset($_POST["enlace"])) { echo $_POST["enlace"]; } ?>"><br><br>

                    <input type="hidden" id="oculto" name="oculto" value="10">

                    <button type="submit" name="enviar">Enviar</button>
                    <button type="submit" name="cancelar">Cancelar</button>
                </form>
            </section>
        </div>
    </div>
</body>

</html>