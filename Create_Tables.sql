-- -----------------------------------------------------
-- Table `aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aluno` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `aluno` (
  `idaluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`idaluno`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `matricula_UNIQUE` ON `aluno` (`matricula` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `aluno_has_turma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aluno_has_turma` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `aluno_has_turma` (
  `aluno_idaluno` INT NOT NULL,
  `turma_materia_idmateria` INT NOT NULL,
  `turma_professor_idprofessor` INT NOT NULL,
  `AV1` DECIMAL(2,1) NULL,
  `APS_1` DECIMAL(2,1) NULL,
  `AV2` DECIMAL(2,1) NULL,
  `APS_2` DECIMAL(2,1) NULL,
  `AV3` DECIMAL(2,1) NULL,
  PRIMARY KEY (`aluno_idaluno`, `turma_materia_idmateria`, `turma_professor_idprofessor`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `materia` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `materia` (
  `idmateria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idmateria`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `professor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`idprofessor`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `matricula_UNIQUE` ON `professor` (`matricula` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `turma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `turma` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `turma` (
  `materia_idmateria` INT NOT NULL,
  `professor_idprofessor` INT NOT NULL,
  `codigo_turma` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`materia_idmateria`, `professor_idprofessor`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `materia_idmateria_UNIQUE` ON `turma` (`materia_idmateria` ASC) VISIBLE;

SHOW WARNINGS;
CREATE UNIQUE INDEX `professor_idprofessor_UNIQUE` ON `turma` (`professor_idprofessor` ASC) VISIBLE;

SHOW WARNINGS;
