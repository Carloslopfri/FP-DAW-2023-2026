-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2024 a las 00:45:51
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `miniaplicacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `correo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `contrasena` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rol` enum('admin','usuario') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `imagen` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `contrasena`, `rol`, `imagen`) VALUES
(5, 'Alex', 'alex@cifprodolfoucha.es', '$2y$10$vaOmteRpFDt.Ad0PgYhbnOqn4c5QMKL72VhbhbCUV5hIGib80FiT2', 'usuario', 'img/alex.jpg'),
(8, 'Carlos', 'carlos@cifprodolfoucha.es', '$2y$10$vaOmteRpFDt.Ad0PgYhbnOqn4c5QMKL72VhbhbCUV5hIGib80FiT2', 'admin', 'img/carlos.jpg'),
(13, 'pepo', 'pepe@cifprodolfoucha.es', '$2y$10$Y0GC4BWOEie3hnXh1u51hOO79QjZMikODE.bwJ8SYhfQVH2T4LO/6', 'usuario', 'pepe.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_correo` (`correo`),
  ADD UNIQUE KEY `unique_imagen` (`imagen`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
