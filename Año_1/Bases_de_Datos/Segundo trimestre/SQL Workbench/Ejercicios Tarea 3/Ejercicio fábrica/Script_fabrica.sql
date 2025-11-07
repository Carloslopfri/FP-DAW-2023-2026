CREATE DATABASE IF NOT EXISTS `CARLOSLF_Fabrica` DEFAULT CHARACTER SET `utf8mb4`; -- Creamos la base de datos.
USE `CARLOSLF_Fabrica`; -- Para meternos dentro de la base de datos.
CREATE TABLE IF NOT EXISTS `Profesiones` (
	`IdProf` TINYINT AUTO_INCREMENT,
    `Descripcion` VARCHAR(30) NOT NULL,
    `Sector` VARCHAR(20),
    `Categoría` VARCHAR(30) NOT NULL,
    PRIMARY KEY(`IdProf`)
);
CREATE TABLE IF NOT EXISTS `Empresas` (
`IdEmpr` TINYINT AUTO_INCREMENT,
`Denominación` VARCHAR(30) NOT NULL,
`Dirección` VARCHAR(25),
`Ciudad` VARCHAR(25),
`Pais` VARCHAR(25) DEFAULT "España",
PRIMARY KEY(`IdEmpr`)
);
CREATE TABLE IF NOT EXISTS `Trabajadores` (
`IdTrab` INT AUTO_INCREMENT,
`Nombre` VARCHAR(30) NOT NULL,
`EstadoCivil` CHAR DEFAULT "S" CHECK(`EstadoCivil` IN ("S","C","V","D")),
`FechaNac` DATE,
`LugarNac` VARCHAR(20),
`IdProf` TINYINT NOT NULL,
`IdEmpresa` TINYINT NOT NULL,
`NumHijos` INT DEFAULT 1,
`FechaAlta` DATE NOT NULL,
`Edad` TINYINT,
PRIMARY KEY(`IdTrab`),
FOREIGN KEY(`IdProf`) REFERENCES `Profesiones`(`IdProf`),
FOREIGN KEY(`IdEmpresa`) REFERENCES `Empresas`(`IdEmpr`)
)