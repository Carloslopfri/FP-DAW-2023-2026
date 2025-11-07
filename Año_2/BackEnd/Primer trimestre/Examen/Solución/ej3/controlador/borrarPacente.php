<?php
include_once './../modelo/DAO.class.php';
$dao = new DAO_class();
$id = $_GET['id'];
$dao->borrarPacente($id);
header('Location: ../vista/codigo/index.php');
exit();
