-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: DephiFuzzyMethod
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.10.1

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
-- Table structure for table `AdminisEmail`
--

DROP TABLE IF EXISTS `AdminisEmail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AdminisEmail` (
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
  CONSTRAINT `AdminisEmail_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `AdminisEmail_catalogueitem_FK` FOREIGN KEY (`statusEmailCat`, `statusEmail`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AdminisEmail`
--

LOCK TABLES `AdminisEmail` WRITE;
/*!40000 ALTER TABLE `AdminisEmail` DISABLE KEYS */;
/*!40000 ALTER TABLE `AdminisEmail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DelphiCalculations`
--

DROP TABLE IF EXISTS `DelphiCalculations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DelphiCalculations` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DelphiCalculations`
--

LOCK TABLES `DelphiCalculations` WRITE;
/*!40000 ALTER TABLE `DelphiCalculations` DISABLE KEYS */;
/*!40000 ALTER TABLE `DelphiCalculations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GraphicsData`
--

DROP TABLE IF EXISTS `GraphicsData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GraphicsData` (
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
  CONSTRAINT `GraphicsData_GraphicsParam_FK` FOREIGN KEY (`codeGraphicsParam`) REFERENCES `GraphicsParam` (`codeGraphicsParam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GraphicsData`
--

LOCK TABLES `GraphicsData` WRITE;
/*!40000 ALTER TABLE `GraphicsData` DISABLE KEYS */;
/*!40000 ALTER TABLE `GraphicsData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GraphicsParam`
--

DROP TABLE IF EXISTS `GraphicsParam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GraphicsParam` (
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
-- Dumping data for table `GraphicsParam`
--

LOCK TABLES `GraphicsParam` WRITE;
/*!40000 ALTER TABLE `GraphicsParam` DISABLE KEYS */;
/*!40000 ALTER TABLE `GraphicsParam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menu` (
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
  CONSTRAINT `Menu_Menu_FK` FOREIGN KEY (`parent`) REFERENCES `Menu` (`seqMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (9,'1723353404','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Gonzalo david','proaño chicaiza','Gonzalo david proaño chicaiza','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Area de computacionn,,,,','2019-08-04 18:25:26','2019-08-04 18:25:26',0,0),(10,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Gonzalo','epn','Gonzalo epn','gonzalo.proano@epn.edu.ec','ECuador','2018-09-04','STATUSCAT','1','SEXCAT','1','compuatacion','2019-08-03 21:45:18','2019-08-03 21:45:18',0,0),(11,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Byron','Lopez','Byron Lopez','davidgonzalomejia@gmail.com','Ecuador','2019-08-07','STATUSCAT','1','SEXCAT','1','area humana','2019-08-03 21:46:12','2019-08-03 21:46:12',0,0);
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QuestionItem`
--

DROP TABLE IF EXISTS `QuestionItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QuestionItem` (
  `codeQuizItem` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `itemLabel` varchar(100) NOT NULL,
  `itemdescription` varchar(100) DEFAULT NULL,
  `itemobservation` varchar(100) DEFAULT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuizItem_UNIQUE` (`codeQuizItem`),
  KEY `QuestionItem_Questions_FK` (`codeQuestions`),
  KEY `QuestionItem_Questions_FK1` (`codeQuestions`,`codeQuiz`),
  KEY `QuestionItem_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `QuestionItem_Questions_FK1` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `QuestionItem_catalogue_FK` FOREIGN KEY (`statusCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `QuestionItem_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QuestionItem`
--

LOCK TABLES `QuestionItem` WRITE;
/*!40000 ALTER TABLE `QuestionItem` DISABLE KEYS */;
INSERT INTO `QuestionItem` VALUES (2,1,1,'Brasil','pais de la gartotas',NULL,'STATUSCAT','0','2019-08-05 19:32:14','2019-08-05 19:44:35',1,1),(3,1,1,'Colombia','pais de cafe',NULL,'STATUSCAT','0','2019-08-05 19:32:14','2019-08-05 19:44:35',1,1),(23,4,1,'Brasil',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(24,4,1,'Argentina',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(25,4,1,'Uruguay',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(26,5,1,'Venezuela',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(27,5,1,'Ecuador',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(36,3,1,'Estadio chucho benites',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(37,3,1,'Estadio Aucas',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(38,3,1,'Maracaná',NULL,NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(39,1,1,'Alemania','pais de hitler',NULL,'STATUSCAT','1','2019-08-05 19:32:14','2019-08-05 19:32:14',1,1);
/*!40000 ALTER TABLE `QuestionItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Questions`
--

DROP TABLE IF EXISTS `Questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Questions` (
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
  `diffuseDelphiDiscriminatorbyQuestion` decimal(30,8) DEFAULT NULL,
  `scale` int(11) DEFAULT NULL,
  `scaleSpace` int(11) DEFAULT NULL,
  PRIMARY KEY (`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuestions_UNIQUE` (`codeQuestions`),
  KEY `Questions_Quiz_FK` (`codeQuiz`),
  CONSTRAINT `Questions_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questions`
--

LOCK TABLES `Questions` WRITE;
/*!40000 ALTER TABLE `Questions` DISABLE KEYS */;
INSERT INTO `Questions` VALUES (1,1,'cual es el ganadador de la copa america en el 2024','Acerca de la copa américa que se realizara en ecuador en 2024','STATUSCAT','1','1','10','1',NULL,'2019-08-05 19:32:14','2019-08-05 19:32:14',0,0,2.00000000,NULL,NULL),(3,1,'Cuántas sedes tiene esta Copa América','sedes de la copa america','STATUSCAT','1','1','10','1',NULL,'2019-08-05 19:32:14','2019-08-05 19:32:14',0,0,3.00000000,NULL,NULL),(4,1,'Quiénes son los máximos ganadores del título','maximos ganadores del titulo','STATUSCAT','1','1','10','1',NULL,'2019-08-05 19:32:14','2019-08-05 19:32:14',0,0,4.00000000,NULL,NULL),(5,1,'Cuáles son las dos selecciones que nunca salieron campeonas','Nunca han ganado la copa america','STATUSCAT','1','1','10','1',NULL,'2019-08-05 19:32:14','2019-08-05 19:32:14',0,0,NULL,NULL,NULL),(22,22,'eee','sds','STATUSCAT','1','1','1','2',NULL,'2019-08-02 16:50:41','2019-08-02 16:50:41',0,0,1.00000000,NULL,NULL);
/*!40000 ALTER TABLE `Questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Quiz`
--

DROP TABLE IF EXISTS `Quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Quiz` (
  `codeQuiz` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameQuiz` varchar(100) NOT NULL,
  `shortNameQuiz` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `quizObservation` varchar(100) DEFAULT NULL,
  `diffuseDelphiDiscriminator` decimal(30,8) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`),
  UNIQUE KEY `codeQuiz_UNIQUE` (`codeQuiz`),
  KEY `Quiz_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `Quiz_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quiz`
--

LOCK TABLES `Quiz` WRITE;
/*!40000 ALTER TABLE `Quiz` DISABLE KEYS */;
INSERT INTO `Quiz` VALUES (1,'Pronostico del equipo ganador en la copa america','MEJOR EQUIPO PARA GANAR LA COPA AMERICA','Equipo posible ganador de la copa américa.','STATUSCAT','1',NULL,7.00000000,'2019-08-05 19:32:14','2019-08-05 19:32:14',1,1),(22,'sss','sss','ssss','STATUSCAT','1',NULL,NULL,'2019-08-02 16:50:41','2019-08-02 16:50:41',1,1);
/*!40000 ALTER TABLE `Quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Quizvalues`
--

DROP TABLE IF EXISTS `Quizvalues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Quizvalues` (
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
  CONSTRAINT `Quizvalues_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `Quizvalues_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `Quizvalues_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `Quizvalues_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `Quizvalues_Rounds_FK` FOREIGN KEY (`roundNumber`, `codeQuiz`, `codePerson`) REFERENCES `Rounds` (`roundNumber`, `codeQuiz`, `codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quizvalues`
--

LOCK TABLES `Quizvalues` WRITE;
/*!40000 ALTER TABLE `Quizvalues` DISABLE KEYS */;
INSERT INTO `Quizvalues` VALUES (1,9,1,1,2,'1','5.5','10','esta es un prueba ','ssss','2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,1,3,'1','5.5','10','esta es un prueba ','ssss','2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,1,39,'1','4','10','esta es un prueba ','ssss','2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,3,36,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,3,37,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,3,38,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,4,23,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,4,24,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,4,25,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,5,26,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,9,1,5,27,'1','5.5','10','esta es un prueba ',NULL,'2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(2,9,1,1,2,'7','8','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,1,3,'4','5','6',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,1,39,'5','6','9',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,3,36,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,3,37,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,3,38,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,4,23,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,4,24,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,4,25,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,5,26,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,9,1,5,27,'1','5.5','10',NULL,NULL,'2019-08-05 17:48:53','2019-08-05 17:48:53',0,0);
/*!40000 ALTER TABLE `Quizvalues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rounds`
--

DROP TABLE IF EXISTS `Rounds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rounds` (
  `roundNumber` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `sentstatusCat` varchar(100) NOT NULL,
  `sentstatus` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`roundNumber`,`codeQuiz`,`codePerson`),
  KEY `Rounds_Quiz_FK` (`codeQuiz`),
  KEY `Rounds_Person_FK` (`codePerson`),
  KEY `Rounds_catalogueitem_FK` (`sentstatusCat`,`sentstatus`),
  CONSTRAINT `Rounds_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `Rounds_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `Rounds_catalogue_FK` FOREIGN KEY (`sentstatusCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `Rounds_catalogueitem_FK` FOREIGN KEY (`sentstatusCat`, `sentstatus`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rounds`
--

LOCK TABLES `Rounds` WRITE;
/*!40000 ALTER TABLE `Rounds` DISABLE KEYS */;
INSERT INTO `Rounds` VALUES (1,1,9,'SENTSTATUSCAT','sentAndAnswered','2019-08-05 20:06:02','2019-08-05 20:06:02',0,0),(1,1,10,'SENTSTATUSCAT','forwarded','2019-08-04 21:25:19','2019-08-04 21:25:19',0,0),(1,1,11,'SENTSTATUSCAT','forwarded','2019-08-03 22:23:44','2019-08-03 22:23:44',0,0),(2,1,9,'SENTSTATUSCAT','forwardedAndAnswered','2019-08-05 17:48:53','2019-08-05 17:48:53',0,0),(2,1,11,'SENTSTATUSCAT','sent','2019-08-03 23:46:11','2019-08-03 23:46:11',0,0),(3,1,9,'SENTSTATUSCAT','forwarded','2019-08-05 17:52:33','2019-08-05 17:52:33',0,0);
/*!40000 ALTER TABLE `Rounds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `codeuser` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeperson` bigint(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeuser`,`codeperson`),
  UNIQUE KEY `codeuser_UNIQUE` (`codeuser`),
  KEY `User_Person_FK` (`codeperson`),
  CONSTRAINT `User_Person_FK` FOREIGN KEY (`codeperson`) REFERENCES `Person` (`codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
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
INSERT INTO `catalogue` VALUES ('ACADEMICDEGREECAT','ACADEMICDEGREECAT','Grado de educación de una persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('IDENTIFYTYPECAT','IDENTIFYTYPECAT','tipo de tipo identificaciones','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SENTSTATUSCAT','SENTSTATUSCAT','Cátalogo estados de las encuestas','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SEXCAT','SEXCAT','Sexo de cada persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSCAT','STATUSCAT','Cátalogo estados','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('TYPEPERSONCAT','TYPEPERSONCAT','tipo de personas como admin, expertos etc','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1);
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
INSERT INTO `catalogueitem` VALUES ('ACADEMICDEGREECAT','Postgrados','Postgrados','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Primaria','Primaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Secundaria','Secundaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Universidad','Universidad','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','ID','Cédula','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','RUC','RUC','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','forwarded','Reenviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','forwardedAndAnswered','Reenviado / Contestado','2019-08-03 17:17:36','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sent','Enviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sentAndAnswered','Enviado /Contestado','2019-08-03 17:17:27','2019-05-14 22:00:07',1,1),('SEXCAT','0','Mujer','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SEXCAT','1','Hombre','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','0','Inactivo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','1','Activo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','admin','ADMINISTRADOR','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','expert','EXPERTOS','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1);
/*!40000 ALTER TABLE `catalogueitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemComment`
--

DROP TABLE IF EXISTS `itemComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemComment` (
  `codeQuizItem` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `roundNumber` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `commentary` varchar(500) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`,`codeQuestions`,`codeQuizItem`,`roundNumber`,`codePerson`),
  KEY `itemComment_Rounds_FK` (`roundNumber`,`codeQuiz`,`codePerson`),
  KEY `itemComment_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `itemComment_QuestionItem_FK` (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  KEY `itemComment_Person_FK` (`codePerson`),
  CONSTRAINT `itemComment_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `itemComment_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `itemComment_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `itemComment_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `itemComment_Rounds_FK` FOREIGN KEY (`roundNumber`, `codeQuiz`, `codePerson`) REFERENCES `Rounds` (`roundNumber`, `codeQuiz`, `codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemComment`
--

LOCK TABLES `itemComment` WRITE;
/*!40000 ALTER TABLE `itemComment` DISABLE KEYS */;
INSERT INTO `itemComment` VALUES (2,1,1,2,9,'ddd','2019-08-05 15:38:26','2019-08-05 15:38:26',0,0),(2,1,1,3,9,'hh','2019-08-05 15:28:22','2019-08-05 15:28:22',0,0),(3,1,1,2,9,'sss','2019-08-05 03:50:01','2019-08-05 03:50:01',0,0);
/*!40000 ALTER TABLE `itemComment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-05 15:07:40