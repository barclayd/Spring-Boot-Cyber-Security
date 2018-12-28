CREATE SCHEMA IF NOT EXISTS behaviour;

USE behaviour;

-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Table gp
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gp (
  `gp_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `address_line_1` VARCHAR(45) NULL,
  `address_line_2` VARCHAR(45) NULL,
  `address_line_3` VARCHAR(45) NULL,
  `city` VARCHAR(30) NULL,
  `postcode` VARCHAR(10) NOT NULL,
  `telephone` VARCHAR(15) NULL,
  `fax` VARCHAR(15) NULL,
  `email` VARCHAR(50) NOT NULL,
  `practise_type` VARCHAR(40) NULL,
  `special_interest` VARCHAR(40) NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`gp_id`),
  UNIQUE INDEX `id_UNIQUE` (`gp_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table patient
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS patient (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `nhs_no` INT NOT NULL,
  `depression_level` INT NOT NULL DEFAULT 1,
  `gp_id` INT NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC),
  UNIQUE INDEX `nhs_no_UNIQUE` (`nhs_no` ASC),
  INDEX `fk_patient_gp_idx` (`gp_id` ASC),
  CONSTRAINT `fk_patient_gp`
    FOREIGN KEY (`gp_id`)
    REFERENCES gp (`gp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table activity
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS activity (
  `activity_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(140) NULL,
  `location` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`activity_id`),
  UNIQUE INDEX `activity_id_UNIQUE` (`activity_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table feeling_log
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS feeling_log (
  `feeling_id` INT NOT NULL AUTO_INCREMENT,
  `feeling_in_num_format` INT NOT NULL,
  `date_inputted` DATETIME NOT NULL,
  `comment` VARCHAR(140) NULL,
  `patient_patient_id` INT NOT NULL,
  `activity_activity_id` INT NOT NULL,
  PRIMARY KEY (`feeling_id`),
  UNIQUE INDEX `id_UNIQUE` (`feeling_id` ASC),
  INDEX `fk_mood_patient1_idx` (`patient_patient_id` ASC),
  INDEX `fk_mood_activity1_idx` (`activity_activity_id` ASC),
  CONSTRAINT `fk_mood_patient1`
    FOREIGN KEY (`patient_patient_id`)
    REFERENCES patient (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mood_activity1`
    FOREIGN KEY (`activity_activity_id`)
    REFERENCES activity (`activity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table scheduled
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS scheduled (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `condition` TINYINT(1) NOT NULL DEFAULT 0,
  `patient_patient_id` INT NOT NULL,
  `activity_activity_id` INT NOT NULL,
  PRIMARY KEY (`event_id`),
  INDEX `fk_schedule_patient1_idx` (`patient_patient_id` ASC),
  INDEX `fk_schedule_activity1_idx` (`activity_activity_id` ASC),
  UNIQUE INDEX `event_id_UNIQUE` (`event_id` ASC),
  CONSTRAINT `fk_schedule_patient1`
    FOREIGN KEY (`patient_patient_id`)
    REFERENCES patient (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_activity1`
    FOREIGN KEY (`activity_activity_id`)
    REFERENCES activity (`activity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table action_log
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS action_log (
  `action_id` INT NOT NULL AUTO_INCREMENT,
  `change_made` VARCHAR(100) NULL,
  `change_date` DATETIME NOT NULL,
  `patient_patient_id` INT NOT NULL,
  PRIMARY KEY (`action_id`),
  UNIQUE INDEX `action_id_UNIQUE` (`action_id` ASC),
  INDEX `fk_action_log_patient1_idx` (`patient_patient_id` ASC),
  CONSTRAINT `fk_action_log_patient1`
    FOREIGN KEY (`patient_patient_id`)
    REFERENCES patient (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- End Of Forward Engineered Code.