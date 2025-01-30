-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Serie` (
  `id` INT NOT NULL,
  `tituloSerie` VARCHAR(45) NOT NULL,
  `nota` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tituloSerie_UNIQUE` (`tituloSerie` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Temporada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Temporada` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `numeroTp` INT NOT NULL,
  `Serie_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Temporada_Serie_idx` (`Serie_id` ASC) VISIBLE,
  CONSTRAINT `fk_Temporada_Serie`
    FOREIGN KEY (`Serie_id`)
    REFERENCES `mydb`.`Serie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Episodio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Episodio` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `avalicao` INT NOT NULL,
  `comentario` VARCHAR(200) NOT NULL,
  `duracao` INT NOT NULL,
  `Temporada_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Episodio_Temporada1_idx` (`Temporada_id` ASC) VISIBLE,
  CONSTRAINT `fk_Episodio_Temporada1`
    FOREIGN KEY (`Temporada_id`)
    REFERENCES `mydb`.`Temporada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
