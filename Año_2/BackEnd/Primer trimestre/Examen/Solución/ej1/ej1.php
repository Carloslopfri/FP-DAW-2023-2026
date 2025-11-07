<?php
require_once './Persoa.class.php';
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej1</title>
</head>

<body>
    <header>
        <?php include '../menu.php'; ?>
    </header>
    <main>
        <h1>Formulario Persoas</h1>
        <?php
        function ordearPorIdade($lista)
        {
            usort($lista, function ($a, $b) {
                return strtotime($a->data) - strtotime($b->data);
            });
            return $lista;
        }

        if (!isset($_SESSION['persoas'])) {
            $_SESSION['persoas'] = [];
        }

        if (isset($_POST['engadir'])) {
            $textNome = $_POST['nome'];
            $textData = $_POST['data'];

            $errores = [];

            if (strlen($textNome) <= 0) {
                array_push($errores, '<p style="color:red">O apartado do nome non pode estar baleiro.</p>');
            }

            if (strlen($textData) <= 0) {
                array_push($errores, '<p style="color:red">O apartado da data de nacemento non pode estara baleiro.</p>');
            }

            if (empty($errores)) {
                $persoa = new Persoa($textNome, $textData);
                array_push($_SESSION['persoas'], $persoa);
                $_SESSION['persoas'] = ordearPorIdade($_SESSION['persoas']);
                $textNome = '';
                $textData = '';
            } else {
                foreach ($errores as $error) {
                    echo $error;
                }
            }
        }

        if (isset($_POST['borrar'])) {
            session_destroy();
            header('Location: ej1.php');
            exit();
        }
        ?>
        <form action="ej1.php" method="post">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" value="<?php if (isset($_POST['engadir'])) {
                                                                echo $textNome;
                                                            } ?>">

            <label for="data">Data de nacemento:</label>
            <input type="date" name="data" id="data" value="<?php if (isset($_POST['engadir'])) {
                                                                echo $textData;
                                                            } ?>">

            <button name="engadir" type="submit">Engadir Persoa</button><br><br>

            <button name="borrar" type="submit">Borrar sesión</button>
        </form>
        <h1>Persoas Rexistradas (Ordeadas por idade):</h1>
        <ul>
            <?php foreach ($_SESSION['persoas'] as $persoa) { ?>
                <li>Nome: <?php echo $persoa->nome; ?>, Data de nacemento: <?php echo date('d/m/Y', strtotime($persoa->data)); ?>, Idade: <?php echo $persoa->ObterIdade(); ?> anos, Bisiesto: <?php echo $persoa->NaceuBisiesto(); ?>, 29 de febreiro: <?php echo $persoa->Naceu29febreiro(); ?>.</li>
            <?php } ?>
        </ul>
    </main>
</body>

</html>