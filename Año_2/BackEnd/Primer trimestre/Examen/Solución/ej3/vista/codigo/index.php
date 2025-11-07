<?php
include_once  './../../controlador/ControlPacente.class.php';
$controlPacente = new ControlPacente_class();
$pacentes = $controlPacente->mostrarPacentes();
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../styles/index.css">
    <title>Ej3_index</title>
</head>

<body>
    <header>
        <?php include './../../../menu.php'; ?>
    </header>
    <main>
        <h1>Táboa de pacentes:</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Data de nacemento</th>
                <th>Servizos</th>
                <th>Alta no sistema</th>
                <th>Accións</th>
            </tr>
            <?php foreach ($pacentes as $pacente) { ?>
                <tr>
                    <td><?php echo $pacente->id; ?></td>
                    <td><?php echo $pacente->nome; ?></td>
                    <td><?php echo $pacente->email; ?></td>
                    <td><?php echo $pacente->nacemento; ?></td>
                    <td>
                        <?php
                        $servizos = $controlPacente->mostrarServizosPacente($pacente->id);
                        foreach ($servizos as $servizo) {
                            echo $servizo . ' ';
                        }
                        ?>
                    </td>
                    <td><?php echo $pacente->alta; ?></td>
                    <td><a href="./../../controlador/borrarPacente.php?id=<?php echo $pacente->id; ?>">Borrar</a></td>
                </tr>
            <?php } ?>
        </table>
        <br>
        <a href="./engadirPacente.php">Engadir pacente</a>
    </main>
</body>

</html>