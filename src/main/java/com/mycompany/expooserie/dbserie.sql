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

    use mydb;
SELECT * FROM serie;
SELECT * FROM temporada;
SELECT * FROM episodio;

INSERT INTO serie (id, tituloSerie, nota) VALUES ('1', 'Os Anéis de Poder', '4');
INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('1', 'Tendo início em uma época de relativa paz, a série acompanha um grupo de personagens que enfrentam o ressurgimento do mal na Terra Média',
                                                                  '1', '1');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('1', 'A Sombra do Passado', '4', 'Um toque de nostalgia',
                                                                                       '65', '1');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('2', 'À Deriva', '4', 'O início de toda a bagunça',
                                                                                       '67', '1');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('3', 'Adar', '3', 'A história começa a tomar um rumo para seguir',
                                                                                       '69', '1');

INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('2', 'Sauron retornou... Com planos para dominar toda a Terra Media',
                                                                  '2', '1');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('4', 'Os Élficos Reis sob o Céu', '3', 'A Terra Média já está envolta em um grande caos',
                                                                                       '76', '2');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('5', 'Onde as Estrelas São Estranhas', '2', 'Os dois lados buscam aliados',
                                                                                       '63', '2');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('6', 'A Águia e o Cetro', '2', 'Momentos de diplomacia',
                                                                                       '66', '2');

INSERT INTO serie (id, tituloSerie, nota) VALUES ('2', 'Todo Mundo Odeia o Chris', '4');
INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('3', 'O comediante Crhis Rock conta a história de sua infância com pais rígidos e trabalhadores e sendo o mais velho de três irmãos no Brooklyn nos anos 80',
                                                                  '1', '2');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('7', 'Todo Mundo Odeia o Crhis', '5', 'Introdução da série e apresentação dos personagens',
                                                                                       '20', '3');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('8', 'Todo Mundo Odeia Keisha', '2', 'Crhis apaixonado pela viznha e Julius duvidando de sua fidelidade',
                                                                                       '20', '3');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('9', 'Todo Mundo Odeia Basquete', '3', 'Crhis é convocado para o time de basquete gratuitamente, sem saber nada do jogo',
                                                                                       '20', '3');

INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('4', 'O comediante Crhis Rock conta a história de sua infância com pais rígidos e trabalhadores e sendo o mais velho de três irmãos no Brooklyn nos anos 80',
                                                                  '2', '2');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('10', 'Todo Mundo Odeia Rejeição', '2', 'Reunião da vizinhança por segurança, mas acaba em confusão',
                                                                                       '20', '4');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('11', 'Todo Mundo Odeia o Presidente da Turma', '4', 'Crhis se candidata a presidente da turma, mas descobre que não é tão bem vinda assim',
                                                                                       '20', '4');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('12', 'Todo Mundo Odeia Eleições', '4', 'Ainda tentando a presidência, Crhis promete mundos e fundos, mas não pode cumprir',
                                                                                       '20', '4');

INSERT INTO serie (id, tituloSerie, nota) VALUES ('3', 'One Piece', '4');
INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('5', 'Monkey D. Luffy se recusa a abandonar seu sonho de ser o grande Rei dos Piratas e sai em uma jornada repleta de desafios ao encontro do lendário tesouro conhecido como One Piece',
                                                                  '1', '3');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('13', 'Eu sou Luffy e serei o Rei dos Piratas!', '4', 'Onde Luffy aparece pela primeira vez dando um gostinho de sua personalidade',
                                                                                       '25', '5');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('14', 'O Caçador de Piratas Roronoa Zoro!', '4', 'Apresentação do Zoro, futuro tripilante do bando',
                                                                                       '25', '5');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('15', 'Morgan vs Luffy!', '4', 'O primeiro tripulante da jornada é integrado ao bando e Nami é vista pela primeira vez',
                                                                                       '25', '5');

INSERT INTO temporada (id, descricao, numeroTP, Serie_id) VALUES ('6', 'A aventura se estende por novas terras e atraca em Alabasta',
                                                                  '2', '3');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('16', 'A Baleia Gigante, Laboon!', '3', 'Após atravessar a Red Line, há o encontro com a triste Laboon',
                                                                                       '25', '6');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('17', 'Luffy e a Baleia prometem se Encontrar!', '4', 'A história de Laboon é revelada',
                                                                                       '25', '6');
INSERT INTO episodio (id, titulo, avalicao, comentario, duracao, Temporada_id) VALUES ('18', 'Partindo para Whisky Peak!', '3', 'Uma cidade que recepciona piratas no caminha para a Grand Line',
                                                                                       '25', '6');

ALTER TABLE episodio ADD numero INT;
ALTER TABLE episodio MODIFY COLUMN numero INT NOT NULL;
ALTER TABLE episodio CHANGE COLUMN avalicao avaliacao INT;