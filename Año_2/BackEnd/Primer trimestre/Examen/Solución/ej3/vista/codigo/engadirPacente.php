<?php
include_once  './../../controlador/ControlPacente.class.php';
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej3_engadir</title>
</head>

<body>
    <header>
        <?php include './../../../menu.php'; ?>
    </header>
    <main>
        <h1>Engada un novo pacente:</h1>
        <?php
        if (isset($_POST['engadir'])) {
            $textNome = $_POST['nome'];
            $textEmail = $_POST['email'];
            $textData = $_POST['data'];
            if (isset($_POST['servizos'])) {
                $textServizos = $_POST['servizos'];
            } else {
                $textServizos = [];
            }

            $controlPacente = new ControlPacente_class();
            $resultado = $controlPacente->validarEnagdir($textNome, $textEmail, $textData, $textServizos);
            if ($resultado === true) {
                header('Location: index.php');
                exit();
            } else {
                foreach ($resultado as $error) {
                    echo $error;
                }
            }
        }
        ?>
        <form action="./engadirPacente.php" method="post">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome"><br><br>

            <label for="email">Email:</label>
            <input type="text" name="email" id="email"><br><br>

            <label for="data">Data de nacemento:</label>
            <input type="date" name="data" id="name"><br><br>

            <label for="servizos">Servizos:</label>
            <select name="servizos[]" id="servizos" multiple>
                <option value="1">Dental</option>
                <option value="2">Ocular</option>
                <option value="3">Estética</option>
                <option value="4">Auditivo</option>
            </select><br><br>

            <button name="engadir" type="submit">Enagdir</button>
        </form>
    </main>
</body>

</html>