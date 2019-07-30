-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: localhost    Database: dephifuzzymethod
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminisemail`
--

DROP TABLE IF EXISTS `adminisemail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminisemail` (
  `seqadminisemail` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeQuiz` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `statusEmailCat` varchar(100) NOT NULL,
  `statusEmail` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`seqadminisemail`,`codeQuiz`,`codePerson`),
  UNIQUE KEY `seqAdminisEmail_UNIQUE` (`seqadminisemail`),
  KEY `AdminisEmail_Person_FK` (`codePerson`),
  KEY `AdminisEmail_Quiz_FK` (`codeQuiz`),
  KEY `AdminisEmail_catalogueitem_FK` (`statusEmailCat`,`statusEmail`),
  CONSTRAINT `AdminisEmail_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `person` (`codePerson`),
  CONSTRAINT `AdminisEmail_catalogueitem_FK` FOREIGN KEY (`statusEmailCat`, `statusEmail`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminisemail`
--

LOCK TABLES `adminisemail` WRITE;
/*!40000 ALTER TABLE `adminisemail` DISABLE KEYS */;
/*!40000 ALTER TABLE `adminisemail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogue` (
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogue`
--

LOCK TABLES `catalogue` WRITE;
/*!40000 ALTER TABLE `catalogue` DISABLE KEYS */;
INSERT INTO `catalogue` VALUES ('ACADEMICDEGREECAT','ACADEMICDEGREECAT','Grado de educación de una persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('IDENTIFYTYPECAT','IDENTIFYTYPECAT','tipo de tipo identificaciones','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SEXCAT','SEXCAT','Sexo de cada persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSCAT','STATUSCAT','Cátalogo estados','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('TYPEPERSONCAT','TYPEPERSONCAT','tipo de personas como admin, expertos etc','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1);
/*!40000 ALTER TABLE `catalogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogueitem`
--

DROP TABLE IF EXISTS `catalogueitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogueitem` (
  `codeCatalogue` varchar(100) NOT NULL,
  `codeItem` varchar(100) NOT NULL,
  `nameItem` varchar(255) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeCatalogue`,`codeItem`),
  CONSTRAINT `catalogueitem_catalogue_FK` FOREIGN KEY (`codeCatalogue`) REFERENCES `catalogue` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogueitem`
--

LOCK TABLES `catalogueitem` WRITE;
/*!40000 ALTER TABLE `catalogueitem` DISABLE KEYS */;
INSERT INTO `catalogueitem` VALUES ('ACADEMICDEGREECAT','Postgrados','Postgrados','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Primaria','Primaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Secundaria','Secundaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Universidad','Universidad','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','ID','Cédula','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','RUC','RUC','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SEXCAT','0','Mujer','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SEXCAT','1','Hombre','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','0','Inactivo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','1','Activo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','admin','ADMINISTRADOR','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','expert','EXPERTOS','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1);
/*!40000 ALTER TABLE `catalogueitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delphicalculations`
--

DROP TABLE IF EXISTS `delphicalculations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delphicalculations` (
  `seqdelphicalculation` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `convergenceIndex` double NOT NULL,
  `roundNumber` bigint(20) NOT NULL,
  `discriminator` double NOT NULL,
  `statusResultCat` varchar(100) NOT NULL,
  `statusResult` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  `lowervalue` double NOT NULL,
  `mediavalue` varchar(100) NOT NULL,
  `uppervalue` varchar(100) NOT NULL,
  PRIMARY KEY (`seqdelphicalculation`),
  UNIQUE KEY `seqdelphicalculation_UNIQUE` (`seqdelphicalculation`),
  KEY `DelphiCalculations_Quiz_FK` (`codeQuiz`),
  KEY `DelphiCalculations_Questions_FK` (`codeQuestions`),
  KEY `DelphiCalculations_QuestionItem_FK` (`codeQuizItem`),
  KEY `DelphiCalculations_catalogueitem_FK` (`statusResultCat`,`statusResult`),
  CONSTRAINT `DelphiCalculations_catalogueitem_FK` FOREIGN KEY (`statusResultCat`, `statusResult`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delphicalculations`
--

LOCK TABLES `delphicalculations` WRITE;
/*!40000 ALTER TABLE `delphicalculations` DISABLE KEYS */;
INSERT INTO `delphicalculations` VALUES (4,1,1,1,6,1,7,'TYPEPERSONCAT','admin','2019-07-30 19:10:30','2019-07-30 19:10:30',1,1,3,'6.688','10');
/*!40000 ALTER TABLE `delphicalculations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graphicsdata`
--

DROP TABLE IF EXISTS `graphicsdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `graphicsdata` (
  `seqgraphicsdata` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeGraphicsParam` varchar(50) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `xAxisvalues` varchar(100) NOT NULL,
  `yAxisvalues` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`seqgraphicsdata`),
  UNIQUE KEY `seqgraphicsdata_UNIQUE` (`seqgraphicsdata`),
  KEY `GraphicsData_GraphicsParam_FK` (`codeGraphicsParam`),
  KEY `GraphicsData_Quiz_FK` (`codeQuiz`),
  KEY `GraphicsData_Questions_FK` (`codeQuestions`),
  KEY `GraphicsData_QuestionItem_FK` (`codeQuizItem`),
  CONSTRAINT `GraphicsData_GraphicsParam_FK` FOREIGN KEY (`codeGraphicsParam`) REFERENCES `graphicsparam` (`codeGraphicsParam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graphicsdata`
--

LOCK TABLES `graphicsdata` WRITE;
/*!40000 ALTER TABLE `graphicsdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `graphicsdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graphicsparam`
--

DROP TABLE IF EXISTS `graphicsparam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `graphicsparam` (
  `codeGraphicsParam` varchar(50) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `xAxis` varchar(100) NOT NULL,
  `yAxis` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeGraphicsParam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graphicsparam`
--

LOCK TABLES `graphicsparam` WRITE;
/*!40000 ALTER TABLE `graphicsparam` DISABLE KEYS */;
/*!40000 ALTER TABLE `graphicsparam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `seqMenu` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent` bigint(20) NOT NULL,
  `nameMenu` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `group` tinyint(1) NOT NULL DEFAULT '0',
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`seqMenu`),
  UNIQUE KEY `seqMenu_UNIQUE` (`seqMenu`),
  KEY `Menu_Menu_FK` (`parent`),
  CONSTRAINT `Menu_Menu_FK` FOREIGN KEY (`parent`) REFERENCES `menu` (`seqMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `codePerson` bigint(20) NOT NULL AUTO_INCREMENT,
  `identify` varchar(100) NOT NULL,
  `typePersonCat` varchar(100) NOT NULL,
  `typePerson` varchar(100) NOT NULL,
  `typeIdentifyCat` varchar(100) NOT NULL,
  `typeIdentify` varchar(100) NOT NULL,
  `academicDegreeCat` varchar(100) NOT NULL,
  `academicDegree` varchar(100) NOT NULL,
  `names` varchar(100) NOT NULL,
  `lastNames` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `birthday` date DEFAULT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `sexCat` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `workArea` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codePerson`),
  UNIQUE KEY `codePerson_UNIQUE` (`codePerson`),
  KEY `Person_catalogueitem_FK` (`typePersonCat`,`typePerson`),
  KEY `Person_catalogueitem_FK_1` (`typeIdentifyCat`,`typeIdentify`),
  KEY `Person_catalogueitem_FK_2` (`academicDegreeCat`,`academicDegree`),
  KEY `Person_catalogueitem_FK_3` (`country`),
  KEY `Person_catalogueitem_FK_4` (`statusCat`,`status`),
  CONSTRAINT `Person_catalogueitem_FK` FOREIGN KEY (`typePersonCat`, `typePerson`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_1` FOREIGN KEY (`typeIdentifyCat`, `typeIdentify`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_2` FOREIGN KEY (`academicDegreeCat`, `academicDegree`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_4` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (9,'1723353404','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Gonzalo david','proaño chicaiza','Gonzalo david proaño chicaiza','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','0','SEXCAT','1','Area de computacion','2019-07-23 18:40:07','2019-07-23 18:40:07',0,0),(13,'32','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','RUC','ACADEMICDEGREECAT','Postgrados','Grace Adriana ','Proaño Chicaiza','Grace Adriana  Proaño Chicaiza','gonzalo.proano@epn.edu.ec','32131','2019-06-19','STATUSCAT','1','SEXCAT','1','Area de Biotecnologia','2019-07-23 18:40:10','2019-07-23 18:40:10',0,0),(14,'1234567897','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Universidad','Byron','Lopez','Byron Lopez','byron.lopez.begins@gmail.com','Ecuador','2000-07-02','STATUSCAT','1','SEXCAT','1','CEO','2019-07-24 22:02:50','2019-07-24 22:02:50',0,0);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionitem`
--

DROP TABLE IF EXISTS `questionitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionitem` (
  `codeQuizItem` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `itemLabel` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuizItem_UNIQUE` (`codeQuizItem`),
  KEY `QuestionItem_Questions_FK` (`codeQuestions`),
  KEY `QuestionItem_Questions_FK1` (`codeQuestions`,`codeQuiz`),
  CONSTRAINT `QuestionItem_Questions_FK1` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `questions` (`codeQuestions`, `codeQuiz`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionitem`
--

LOCK TABLES `questionitem` WRITE;
/*!40000 ALTER TABLE `questionitem` DISABLE KEYS */;
INSERT INTO `questionitem` VALUES (2,1,1,'Brasil','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(3,1,1,'Colombia','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(23,4,1,'Brasil','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(24,4,1,'Argentina','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(25,4,1,'Uruguay','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(26,5,1,'Venezuela','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(27,5,1,'Ecuador','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(36,3,1,'Estadio chucho benites','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(37,3,1,'Estadio Aucas','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(38,3,1,'MaracanÃ¡','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(39,1,1,'Alemania','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(41,8,2,'david','2019-07-22 16:39:08','2019-07-22 16:39:08',1,1),(42,8,2,'gnzalo','2019-07-22 16:39:08','2019-07-22 16:39:08',1,1),(43,9,9,'yyyy','2019-07-23 00:20:21','2019-07-23 00:20:21',1,1),(44,10,10,'wwww','2019-07-23 00:21:52','2019-07-23 00:21:52',1,1),(45,1,1,'Italia','2019-07-28 17:15:59','2019-07-28 17:15:59',1,1);
/*!40000 ALTER TABLE `questionitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `codeQuestions` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeQuiz` bigint(20) NOT NULL,
  `question` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `minimumParameterSetting` varchar(100) NOT NULL,
  `maximumParameterSetting` varchar(100) NOT NULL,
  `jumpNext` varchar(100) NOT NULL,
  `questionObservation` varchar(100) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuestions_UNIQUE` (`codeQuestions`),
  KEY `Questions_Quiz_FK` (`codeQuiz`),
  CONSTRAINT `Questions_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'cual es el ganadador de la copa america en el 2024','Acerca de la copa america que se realizara en ecuador en 2024','STATUSCAT','1','1','10','1',NULL,'2019-07-28 17:15:59','2019-07-30 18:22:34',0,0),(3,1,'CuÃ¡ntas sedes tiene esta Copa AmÃ©rica','sedes de la copa america','STATUSCAT','1','1','10','1',NULL,'2019-07-28 17:15:59','2019-07-28 17:15:59',0,0),(4,1,'QuiÃ©nes son los mÃ¡ximos ganadores del tÃ­tulo','maximos ganadores del titulo','STATUSCAT','1','1','10','1',NULL,'2019-07-28 17:15:59','2019-07-28 17:15:59',0,0),(5,1,'CuÃ¡les son las dos selecciones que nunca salieron campeonas','Nunca han ganado la copa america','STATUSCAT','1','1','10','1',NULL,'2019-07-28 17:15:59','2019-07-28 17:15:59',0,0),(8,2,'Mi nombre2','aaaa','STATUSCAT','1','10','100','10',NULL,'2019-07-22 16:39:07','2019-07-30 18:22:34',0,0),(9,9,'eee','ssss','STATUSCAT','1','10','100','10',NULL,'2019-07-23 00:20:21','2019-07-30 18:22:34',0,0),(10,10,'www','wwww','STATUSCAT','1','10','100','10',NULL,'2019-07-23 00:21:52','2019-07-30 18:22:34',0,0);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz` (
  `codeQuiz` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameQuiz` varchar(100) NOT NULL,
  `shortNameQuiz` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `quizObservation` varchar(100) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`),
  UNIQUE KEY `codeQuiz_UNIQUE` (`codeQuiz`),
  KEY `Quiz_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `Quiz_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'Pronostico del equipo ganador en la copa america','MEJOR EQUIPO PARA GANAR LA COPA AMERICA','Equipo posible ganador de la copa america','STATUSCAT','1',NULL,'2019-07-28 17:15:59','2019-07-28 17:15:59',1,1),(2,'sss','sssss','ssss','STATUSCAT','1','','2019-07-22 16:39:07','2019-07-22 16:39:07',1,1),(9,'AAA','sssaaa','aaaA','STATUSCAT','1','','2019-07-23 00:20:21','2019-07-23 00:20:21',1,1),(10,'qqqq','qqq','qqqq','STATUSCAT','1','','2019-07-23 00:21:52','2019-07-23 00:21:52',1,1);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizvalues`
--

DROP TABLE IF EXISTS `quizvalues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quizvalues` (
  `roundNumber` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `minimumValue` varchar(100) NOT NULL,
  `averageValue` varchar(100) NOT NULL,
  `maximunValue` varchar(100) NOT NULL,
  `quizObservation` varchar(100) DEFAULT NULL,
  `questionObservation` varchar(100) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`roundNumber`,`codePerson`,`codeQuiz`,`codeQuestions`,`codeQuizItem`),
  KEY `Quizvalues_Person_FK` (`codePerson`),
  KEY `Quizvalues_Quiz_FK` (`codeQuiz`),
  KEY `Quizvalues_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `Quizvalues_QuestionItem_FK` (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  KEY `Quizvalues_Rounds_FK` (`roundNumber`,`codeQuiz`,`codePerson`),
  CONSTRAINT `Quizvalues_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `person` (`codePerson`),
  CONSTRAINT `Quizvalues_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `questionitem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `Quizvalues_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `Quizvalues_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`),
  CONSTRAINT `Quizvalues_Rounds_FK` FOREIGN KEY (`roundNumber`, `codeQuiz`, `codePerson`) REFERENCES `rounds` (`roundNumber`, `codeQuiz`, `codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizvalues`
--

LOCK TABLES `quizvalues` WRITE;
/*!40000 ALTER TABLE `quizvalues` DISABLE KEYS */;
INSERT INTO `quizvalues` VALUES (0,9,2,8,41,'1','2','3','',NULL,'2019-07-24 03:11:09','2019-07-24 03:11:09',0,0),(0,9,2,8,42,'4','5','6','',NULL,'2019-07-24 03:11:09','2019-07-24 03:11:09',0,0),(3,9,1,1,2,'1','2','4',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,1,3,'2','3','4',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,1,39,'1','1','1',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,3,36,'1','11','1',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,3,37,'1','1','11',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,3,38,'1','1','11',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,4,23,'1','11','1',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,4,24,'1','1','11',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,4,25,'1','1','11',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,5,26,'11','1','1',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(3,9,1,5,27,'11','1','1',NULL,NULL,'2019-07-23 19:18:17','2019-07-23 19:20:05',0,0),(4,9,1,1,2,'1','2','3','encuesta observacion nuemro 1','onservacion pregunta 1','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,1,3,'4','4','44','encuesta observacion nuemro 1','onservacion pregunta 1','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,1,39,'4','4','4','encuesta observacion nuemro 1','onservacion pregunta 1','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,3,36,'2','2','22','encuesta observacion nuemro 1','observacion pregunta 2','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,3,37,'2','2','2','encuesta observacion nuemro 1','observacion pregunta 2','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,3,38,'22','2','2','encuesta observacion nuemro 1','observacion pregunta 2','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,4,23,'3','33','3','encuesta observacion nuemro 1','Onservacion pregunta 3','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,4,24,'3','3','33','encuesta observacion nuemro 1','Onservacion pregunta 3','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,4,25,'3','33','3','encuesta observacion nuemro 1','Onservacion pregunta 3','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,5,26,'4','44','4','encuesta observacion nuemro 1','pregunta 4','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(4,9,1,5,27,'4','44','4','encuesta observacion nuemro 1','pregunta 4','2019-07-24 06:48:29','2019-07-24 06:48:29',0,0),(5,9,1,1,2,'1','2','3','la encuesta estubo ok','Brasil es el mas opcionado y me parece que falta ecuador en los items','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,1,3,'4','5','6','la encuesta estubo ok','Brasil es el mas opcionado y me parece que falta ecuador en los items','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,1,39,'7','8','9','la encuesta estubo ok','Brasil es el mas opcionado y me parece que falta ecuador en los items','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,3,36,'7','8','9','la encuesta estubo ok','el mejor es el estadio del aucas','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,3,37,'10','11','12','la encuesta estubo ok','el mejor es el estadio del aucas','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,3,38,'13','14','15','la encuesta estubo ok','el mejor es el estadio del aucas','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,4,23,'16','17','18','la encuesta estubo ok','de ley brasil es el mejor','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,4,24,'19','20','21','la encuesta estubo ok','de ley brasil es el mejor','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,4,25,'22','23','24','la encuesta estubo ok','de ley brasil es el mejor','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,5,26,'25','26','27','la encuesta estubo ok','ecuador va ser futuro campeon solo esperen','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0),(5,9,1,5,27,'28','29','30','la encuesta estubo ok','ecuador va ser futuro campeon solo esperen','2019-07-24 15:15:36','2019-07-24 15:15:36',0,0);
/*!40000 ALTER TABLE `quizvalues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rounds`
--

DROP TABLE IF EXISTS `rounds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rounds` (
  `roundNumber` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`roundNumber`,`codeQuiz`,`codePerson`),
  KEY `Rounds_Quiz_FK` (`codeQuiz`),
  KEY `Rounds_Person_FK` (`codePerson`),
  CONSTRAINT `Rounds_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `person` (`codePerson`),
  CONSTRAINT `Rounds_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rounds`
--

LOCK TABLES `rounds` WRITE;
/*!40000 ALTER TABLE `rounds` DISABLE KEYS */;
INSERT INTO `rounds` VALUES (0,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(0,2,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(0,9,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(1,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(2,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(3,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(4,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(5,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(6,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(7,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(8,1,9,'2019-07-24 17:41:45','2019-07-24 17:42:59',0,0),(9,1,14,'2019-07-24 22:03:14','2019-07-24 22:03:14',0,0),(10,1,14,'2019-07-24 22:20:29','2019-07-24 22:20:29',0,0);
/*!40000 ALTER TABLE `rounds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `codeuser` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeperson` bigint(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeuser`,`codeperson`),
  UNIQUE KEY `codeuser_UNIQUE` (`codeuser`),
  KEY `User_Person_FK` (`codeperson`),
  CONSTRAINT `User_Person_FK` FOREIGN KEY (`codeperson`) REFERENCES `person` (`codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-30 16:19:01
