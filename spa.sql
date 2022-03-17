/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `spa`;



DROP TABLE IF EXISTS `Administrator`;

CREATE TABLE `Administrator` (
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) VALUES 
(1,'Ana','Vucurevic','ana','ana123'),
(2,'Milos','Markovic','milos','milos123');



DROP TABLE IF EXISTS `Klijent`;

CREATE TABLE `Klijent` (
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeKlijenta` VARCHAR(20) NOT NULL,
  `PrezimeKlijenta` VARCHAR(30) NOT NULL,
  `Adresa` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(20) NOT NULL,
  `BrojTelefona` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`KlijentID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Klijent`(`KlijentID`,`ImeKlijenta`,`PrezimeKlijenta`,`Adresa`,`Email`,`BrojTelefona`) VALUES 
(1,'Nevena', 'Ilic', 'Marine Velickovic 23','nevena@gmail.com', '0631231234'),
(2,'Jana', 'Vilic', 'Sumatovacka 52','vila@gmail.com', '0654645434'),
(3,'Luka', 'Arsenovic', 'Dobropoljska 18','luka@gmail.com', '0641235153');



DROP TABLE IF EXISTS `Maser`;

CREATE TABLE `Maser` (
  `MaserID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeMasera` VARCHAR(30) NOT NULL,
  `PrezimeMasera` VARCHAR(30) NOT NULL,
  `Specijalnost` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`MaserID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Maser`(`MaserID`,`ImeMasera`,`PrezimeMasera`,`Specijalnost`) VALUES 
(1,'Anja', 'Crnogorac', 'Fizioterapeut'),
(2,'Marija', 'Markovic', 'Maser'),
(3,'David', 'Filipovic', 'Maser');




DROP TABLE IF EXISTS `Masaza`;

CREATE TABLE `Masaza` (
  `MasazaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivMasaze` VARCHAR(30) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  `TrajanjeMinuti` INT NOT NULL,
  `Cena` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`MasazaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Masaza`(`MasazaID`,`NazivMasaze`,`Opis`,`TrajanjeMinuti`,`Cena`) VALUES 
(1,'SVEDSKA MASAZA','Prebrutalna.',50,5500),
(2,'RELAX MASAZA','Opustajuca.',75,8000);






DROP TABLE IF EXISTS `RegijaTela`;

CREATE TABLE `RegijaTela` (
  `RegijaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivRegije` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`RegijaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `RegijaTela`(`RegijaID`,`NazivRegije`) VALUES 
(1,'Noge'),
(2,'Ruke'),
(3,'Ledja'),
(4,'Stopala'),
(5,'Glava'),
(6,'Sake');


DROP TABLE IF EXISTS `StavkaMasaze`;

CREATE TABLE `StavkaMasaze` (
  `MasazaID` BIGINT(10) UNSIGNED NOT NULL,
  `Rb` INT(7) NOT NULL,
  `TrajanjeMinuti` INT(7) NOT NULL,
  `Tehnika` VARCHAR(50) NOT NULL,
  `RegijaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`MasazaID`,`Rb`),
  CONSTRAINT `fk_masaza_id` FOREIGN KEY (`MasazaID`) REFERENCES `Masaza` (`MasazaID`) ON DELETE CASCADE,
  CONSTRAINT `fk_reg_id` FOREIGN KEY (`RegijaID`) REFERENCES `RegijaTela` (`RegijaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `StavkaMasaze`(`MasazaID`,`Rb`,`TrajanjeMinuti`, `Tehnika`,`RegijaID`) VALUES 
(1,1,15,'Oklagija',1),
(1,2,20,'Oklagija',2),
(1,3,15,'Ruke',3),
(2,1,30,'Ruke',4),
(2,2,30,'Ruke',5),
(2,3,15,'Ruke',6);



DROP TABLE IF EXISTS `Rezervacija`;

CREATE TABLE `Rezervacija` (
  `RezervacijaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVremePocetka` DATETIME NOT NULL,
  `DatumVremeKraja` DATETIME NOT NULL,
  `Prostorija` VARCHAR(30) NOT NULL,
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL,
  `MaserID` BIGINT(10) UNSIGNED NOT NULL,
  `MasazaID` BIGINT(10) UNSIGNED NOT NULL,
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`RezervacijaID`),
  CONSTRAINT `fk_klijent_id` FOREIGN KEY (`KlijentID`) REFERENCES `Klijent` (`KlijentID`),
  CONSTRAINT `fk_maser_id` FOREIGN KEY (`MaserID`) REFERENCES `Maser` (`MaserID`),
  CONSTRAINT `fk2_masaza_id` FOREIGN KEY (`MasazaID`) REFERENCES `Masaza` (`MasazaID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `Administrator` (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Rezervacija`(`RezervacijaID`,`DatumVremePocetka`,`DatumVremeKraja`,`Prostorija`,`KlijentID`,`MaserID`,`MasazaID`,`AdministratorID`) VALUES 
(1,'2021-02-02 10:00:00','2021-02-02 10:50:00','A1',1,1,1,1);


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
