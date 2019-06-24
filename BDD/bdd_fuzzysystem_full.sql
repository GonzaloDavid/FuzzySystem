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
  CONSTRAINT `AdminisEmail_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`),
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
  PRIMARY KEY (`seqdelphicalculation`),
  UNIQUE KEY `seqdelphicalculation_UNIQUE` (`seqdelphicalculation`),
  KEY `DelphiCalculations_Quiz_FK` (`codeQuiz`),
  KEY `DelphiCalculations_Questions_FK` (`codeQuestions`),
  KEY `DelphiCalculations_QuestionItem_FK` (`codeQuizItem`),
  KEY `DelphiCalculations_catalogueitem_FK` (`statusResultCat`,`statusResult`),
  CONSTRAINT `DelphiCalculations_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`) REFERENCES `questionitem` (`codeQuizItem`),
  CONSTRAINT `DelphiCalculations_Questions_FK` FOREIGN KEY (`codeQuestions`) REFERENCES `questions` (`codeQuestions`),
  CONSTRAINT `DelphiCalculations_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`),
  CONSTRAINT `DelphiCalculations_catalogueitem_FK` FOREIGN KEY (`statusResultCat`, `statusResult`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delphicalculations`
--

LOCK TABLES `delphicalculations` WRITE;
/*!40000 ALTER TABLE `delphicalculations` DISABLE KEYS */;
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
  CONSTRAINT `GraphicsData_GraphicsParam_FK` FOREIGN KEY (`codeGraphicsParam`) REFERENCES `graphicsparam` (`codeGraphicsParam`),
  CONSTRAINT `GraphicsData_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`) REFERENCES `questionitem` (`codeQuizItem`),
  CONSTRAINT `GraphicsData_Questions_FK` FOREIGN KEY (`codeQuestions`) REFERENCES `questions` (`codeQuestions`),
  CONSTRAINT `GraphicsData_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `quiz` (`codeQuiz`)
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
  `firstName` varchar(100) NOT NULL,
  `middleName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `lastNameMatern` varchar(100) NOT NULL,
  `academicDegreeCat` varchar(100) NOT NULL,
  `academicDegree` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `birthday` date DEFAULT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `sexCat` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (8,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','GONZALO','david','PROAÑO','Chicaiza','ACADEMICDEGREECAT','Postgrados','GONZALO david PROAÑO Chicaiza','email1','quito-ecuador','1995-08-29','STATUSCAT','1','SEXCAT','1','2019-06-03 23:20:20','2019-06-03 23:55:30',0,0),(9,'1723353404','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','GRACE','ADRIANA','PROAÑO','Chicaiza','ACADEMICDEGREECAT','Primaria','GRACE ADRIANA PROAÑO Chicaiza','email1','NONO','1995-08-29','STATUSCAT','1','SEXCAT','0','2019-06-03 23:44:20','2019-06-03 23:55:30',0,0),(10,'3123','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','das','dasd','dasd','dasda','ACADEMICDEGREECAT','Primaria','das dasd dasd dasda','dasda','dasd','2019-06-05','STATUSCAT','1','SEXCAT','1','2019-06-10 00:09:06','2019-06-10 00:09:06',0,0);
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
  `itemLabel` varchar(100) NOT NULL,
  `maximunValue` varchar(50) DEFAULT NULL,
  `minimumValue` varchar(100) DEFAULT NULL,
  `averageValue` varchar(100) DEFAULT NULL,
  `minimumParameterSetting` varchar(100) NOT NULL,
  `maximumParameterSetting` varchar(100) NOT NULL,
  `jumpNext` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuizItem`),
  UNIQUE KEY `codeQuizItem_UNIQUE` (`codeQuizItem`),
  KEY `QuestionItem_Questions_FK` (`codeQuestions`),
  CONSTRAINT `QuestionItem_Questions_FK` FOREIGN KEY (`codeQuestions`) REFERENCES `questions` (`codeQuestions`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionitem`
--

LOCK TABLES `questionitem` WRITE;
/*!40000 ALTER TABLE `questionitem` DISABLE KEYS */;
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
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuestions`),
  UNIQUE KEY `codeQuestions_UNIQUE` (`codeQuestions`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
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
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`),
  UNIQUE KEY `codeQuiz_UNIQUE` (`codeQuiz`),
  KEY `Quiz_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `Quiz_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-24  0:42:51
