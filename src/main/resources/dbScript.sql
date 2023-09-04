CREATE DATABASE student;

CREATE TABLE `student`.`student_info` (
  `S_ID` INT NOT NULL,
  `S_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`S_ID`))
ENGINE = InnoDB;

CREATE TABLE `student`.`college` (
  `C_ID` VARCHAR(10) NOT NULL,
  `C_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`C_ID`))
ENGINE = InnoDB;

CREATE TABLE `student`.`application` (
  `S_ID` INT NOT NULL,
  `C_ID` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`S_ID`, `C_ID`))
ENGINE = InnoDB;
