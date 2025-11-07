CREATE SCHEMA IF NOT EXISTS `examen2_CARLOSLF` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci ;
USE `examen2_CARLOSLF` ;

CREATE TABLE IF NOT EXISTS `examen2_CARLOSLF`.`comercial` (
  `id` INT(10) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido1` VARCHAR(100) NOT NULL,
  `apellido2` VARCHAR(100) NULL,
  `comision` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS `examen2_CARLOSLF`.`cliente` (
  `id` INT(10) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido1` VARCHAR(100) NOT NULL,
  `apellido2` VARCHAR(100) NULL,
  `ciudad` VARCHAR(100) NULL,
  `categoria` INT(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS `examen2_CARLOSLF`.`pedido` (
  `id` INT(10) NOT NULL,
  `cantidad` DOUBLE NOT NULL,
  `fecha` DATE NULL,
  `id_cliente` INT(10) NOT NULL,
  `id_comercial` INT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_comercial_idx` (`id_comercial` ASC) VISIBLE,
  INDEX `fk_pedido_cliente_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_comercial`
    FOREIGN KEY (`id_comercial`)
    REFERENCES `examen2_CARLOSLF`.`comercial` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `examen2_CARLOSLF`.`cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)

