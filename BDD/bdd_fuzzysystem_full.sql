-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: DephiFuzzyMethod
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `DelphiCalculations`
--

DROP TABLE IF EXISTS `DelphiCalculations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DelphiCalculations` (
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `roundNumber` bigint(20) NOT NULL,
  `lowerValue` decimal(30,8) NOT NULL,
  `mediaValue` decimal(30,8) NOT NULL,
  `upperValue` decimal(30,8) NOT NULL,
  `defuzzificationValue` decimal(30,8) NOT NULL,
  `threshold` decimal(30,8) NOT NULL,
  `lowerAverage` decimal(30,8) NOT NULL,
  `mediaAverage` decimal(30,8) NOT NULL,
  `upperAverage` decimal(30,8) NOT NULL,
  `consensus` int(11) NOT NULL,
  `validated` int(11) NOT NULL,
  `statusResultCat` varchar(100) NOT NULL,
  `statusResult` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`,`codeQuestions`,`codeQuizItem`,`roundNumber`),
  KEY `DelphiCalculations_Quiz_FK` (`codeQuiz`),
  KEY `DelphiCalculations_Questions_FK` (`codeQuestions`),
  KEY `DelphiCalculations_QuestionItem_FK` (`codeQuizItem`),
  KEY `DelphiCalculations_catalogueitem_FK` (`statusResultCat`,`statusResult`),
  KEY `DelphiCalculations_FK_1` (`codeQuestions`,`codeQuiz`),
  KEY `DelphiCalculations_FK_2` (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  KEY `DelphiCalculations_FK_3` (`roundNumber`,`codeQuiz`),
  CONSTRAINT `DelphiCalculations_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `DelphiCalculations_FK_1` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `DelphiCalculations_FK_2` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `DelphiCalculations_FK_5` FOREIGN KEY (`statusResultCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `DelphiCalculations_FK_6` FOREIGN KEY (`statusResultCat`, `statusResult`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DelphiCalculations`
--

LOCK TABLES `DelphiCalculations` WRITE;
/*!40000 ALTER TABLE `DelphiCalculations` DISABLE KEYS */;
INSERT INTO `DelphiCalculations` VALUES (14,13,43,1,25.00000000,44.85488054,85.00000000,51.61829351,70.00000000,37.22222222,46.11111111,57.77777778,0,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1),(14,13,44,1,30.00000000,64.33931758,95.00000000,63.11310586,70.00000000,48.33333333,65.00000000,80.55555556,1,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1),(14,13,45,1,30.00000000,66.46076641,100.00000000,65.48692214,70.00000000,57.22222222,67.77777778,87.22222222,1,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1),(15,14,46,1,35.00000000,54.41351073,100.00000000,63.13783691,70.00000000,49.44444444,57.22222222,71.66666667,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,47,1,35.00000000,73.32008831,100.00000000,69.44002944,70.00000000,68.33333333,75.55555556,89.44444444,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,48,1,30.00000000,66.46076641,100.00000000,65.48692214,70.00000000,57.22222222,67.77777778,87.22222222,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,49,1,30.00000000,58.48578807,100.00000000,62.82859602,70.00000000,47.77777778,61.11111111,76.66666667,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,50,1,25.00000000,53.63669471,90.00000000,56.21223157,70.00000000,41.66666667,56.11111111,67.22222222,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,51,1,20.00000000,58.48217738,100.00000000,59.49405913,70.00000000,55.55555556,62.77777778,72.77777778,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,52,1,40.00000000,68.49298436,100.00000000,69.49766145,70.00000000,56.11111111,69.44444444,89.44444444,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,53,1,25.00000000,60.35877475,95.00000000,60.11959158,70.00000000,50.00000000,62.77777778,79.44444444,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,54,1,20.00000000,55.60502702,95.00000000,56.86834234,70.00000000,46.11111111,57.77777778,64.44444444,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,55,1,20.00000000,47.32054551,90.00000000,52.44018184,70.00000000,38.88888889,50.00000000,63.33333333,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,56,1,30.00000000,57.24213999,100.00000000,62.41404666,70.00000000,42.77777778,59.44444444,64.44444444,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,57,1,20.00000000,43.61857870,85.00000000,49.53952623,70.00000000,35.55555556,46.66666667,60.00000000,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,58,1,25.00000000,47.41423413,85.00000000,52.47141138,70.00000000,43.33333333,50.55555556,61.11111111,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,59,1,25.00000000,66.38559335,95.00000000,62.12853112,70.00000000,50.55555556,68.33333333,75.55555556,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,60,1,20.00000000,57.42159417,100.00000000,59.14053139,70.00000000,48.33333333,60.00000000,83.33333333,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,61,1,35.00000000,63.97947957,100.00000000,66.32649319,70.00000000,60.00000000,67.22222222,84.44444444,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,62,1,35.00000000,58.78256063,100.00000000,64.59418688,70.00000000,48.33333333,61.11111111,75.00000000,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,63,1,30.00000000,64.33931758,95.00000000,63.11310586,70.00000000,48.33333333,65.00000000,80.55555556,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,64,1,30.00000000,63.39926665,90.00000000,61.13308888,70.00000000,52.77777778,65.55555556,67.22222222,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,65,1,35.00000000,52.82157278,100.00000000,62.60719093,70.00000000,48.33333333,55.55555556,73.33333333,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,66,1,35.00000000,62.09494289,100.00000000,65.69831430,70.00000000,57.22222222,64.44444444,70.55555556,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,67,1,25.00000000,60.63547344,100.00000000,61.87849115,70.00000000,51.11111111,63.88888889,72.22222222,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,68,1,35.00000000,54.42864662,95.00000000,61.47621554,70.00000000,49.44444444,59.44444444,77.22222222,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,69,1,40.00000000,82.30444048,100.00000000,74.10148016,70.00000000,69.44444444,82.77777778,95.55555556,1,1,'STATUSRESULTCAT','approved','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,70,1,30.00000000,60.30539408,95.00000000,61.76846469,70.00000000,48.33333333,61.66666667,73.88888889,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,71,1,30.00000000,54.20770026,100.00000000,61.40256675,70.00000000,48.33333333,57.22222222,63.88888889,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,72,1,30.00000000,53.32229473,100.00000000,61.10743158,70.00000000,48.33333333,56.11111111,62.77777778,0,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(15,14,73,1,25.00000000,54.13688600,85.00000000,54.71229533,70.00000000,41.66666667,56.11111111,68.88888889,1,0,'STATUSRESULTCAT','rejected','2019-09-12 09:06:22','2019-09-12 09:06:22',1,1),(21,15,74,1,1.00000000,4.00000000,10.00000000,5.00000000,7.00000000,1.00000000,4.00000000,10.00000000,1,0,'STATUSRESULTCAT','rejected','2019-11-16 22:36:21','2019-11-16 22:36:21',1,1),(21,15,75,1,1.00000000,4.00000000,10.00000000,5.00000000,7.00000000,1.00000000,4.00000000,10.00000000,1,0,'STATUSRESULTCAT','rejected','2019-11-16 22:36:21','2019-11-16 22:36:21',1,1),(21,15,76,1,1.00000000,7.00000000,10.00000000,6.00000000,7.00000000,1.00000000,7.00000000,10.00000000,1,0,'STATUSRESULTCAT','rejected','2019-11-16 22:36:21','2019-11-16 22:36:21',1,1),(21,15,77,1,1.00000000,4.00000000,10.00000000,5.00000000,7.00000000,1.00000000,4.00000000,10.00000000,1,0,'STATUSRESULTCAT','rejected','2019-11-16 22:36:21','2019-11-16 22:36:21',1,1);
/*!40000 ALTER TABLE `DelphiCalculations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FAHP`
--

DROP TABLE IF EXISTS `FAHP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FAHP` (
  `codefahp` bigint(20) NOT NULL AUTO_INCREMENT,
  `statusfahpCat` varchar(100) NOT NULL,
  `statusfahp` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  `valueFAHPCat` varchar(100) NOT NULL,
  PRIMARY KEY (`codefahp`),
  UNIQUE KEY `codefahp_UNIQUE` (`codefahp`),
  KEY `FAHP_catalogueitem_FK` (`statusfahpCat`,`statusfahp`),
  KEY `FAHP_FK` (`valueFAHPCat`),
  CONSTRAINT `FAHP_FK` FOREIGN KEY (`valueFAHPCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `FAHP_catalogue_FK` FOREIGN KEY (`statusfahpCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `FAHP_catalogueitem_FK` FOREIGN KEY (`statusfahpCat`, `statusfahp`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FAHP`
--

LOCK TABLES `FAHP` WRITE;
/*!40000 ALTER TABLE `FAHP` DISABLE KEYS */;
INSERT INTO `FAHP` VALUES (28,'STATUSFAHPCAT','executed','2019-11-07 22:30:57','2019-11-14 20:19:53',0,0,'VALUEFAHPCAT'),(38,'STATUSFAHPCAT','sent','2019-11-17 01:44:49','2019-11-17 01:44:49',0,0,'VALUEFAHPCAT'),(39,'STATUSFAHPCAT','sent','2019-11-19 20:58:17','2019-11-19 20:58:17',0,0,'VALUEFAHPCAT_RELEVANT'),(40,'STATUSFAHPCAT','executed','2019-11-19 21:51:27','2019-11-20 01:21:06',0,0,'VALUEFAHPCAT');
/*!40000 ALTER TABLE `FAHP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `codePerson` bigint(20) NOT NULL AUTO_INCREMENT,
  `identify` varchar(100) DEFAULT NULL,
  `typePersonCat` varchar(100) NOT NULL,
  `typePerson` varchar(100) NOT NULL,
  `typeIdentifyCat` varchar(100) DEFAULT NULL,
  `typeIdentify` varchar(100) DEFAULT NULL,
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
  `contactNumber` varchar(100) DEFAULT NULL,
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
  KEY `Person_FK` (`sexCat`,`sex`),
  CONSTRAINT `Person_FK` FOREIGN KEY (`sexCat`, `sex`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK` FOREIGN KEY (`typePersonCat`, `typePerson`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_1` FOREIGN KEY (`typeIdentifyCat`, `typeIdentify`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_2` FOREIGN KEY (`academicDegreeCat`, `academicDegree`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`),
  CONSTRAINT `Person_catalogueitem_FK_4` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,NULL,'TYPEPERSONCAT','expert','IDENTIFYTYPECAT',NULL,'ACADEMICDEGREECAT','Postgrados','Juan Miguel','Pérez','Juan Miguel Pérez','davidgonzalomejia@hotmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Eléctrica','0987654321','2019-11-13 05:53:02','2019-11-13 05:53:02',1,1),(2,'987654314','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Beatriz Lisbeth','Mosquera','Beatriz Lisbeth Mosquera','davidgonzalomejia@hotmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Física',NULL,'2019-09-12 08:03:24','2019-09-12 08:03:24',0,0),(3,'9517538647','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Sebastian Mateo','Putin','Sebastian Mateo Putin','davidgonzalomejia@hotmail.com','Russia','1969-12-31','STATUSCAT','1','SEXCAT','1','Jurisprudencia',NULL,'2019-09-12 08:04:08','2019-09-12 08:04:08',0,0),(4,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Gonzalo david','proaño chicaiza','Gonzalo david proaño chicaiza','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Área de computación',NULL,'2019-09-12 02:42:37','2019-09-12 02:42:37',0,0),(5,'1234567987','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','José Miguel','Pérez','José Miguel Pérez','davidgonzalomejia@hotmail.com','Ecuador','1969-12-31','STATUSCAT','1','SEXCAT','1','electrónica',NULL,'2019-09-12 02:42:46','2019-09-12 02:42:46',0,0),(6,'987654314','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Alejandra Lisbeth','Mosquera','Alejandra Lisbeth Mosquera','davidgonzalomejia@hotmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Física',NULL,'2019-09-12 02:42:53','2019-09-12 02:42:53',0,0),(7,'9517538647','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Vladímir Vladímirovich','Putin','Vladímir Vladímirovich Putin','davidgonzalomejia@hotmail.com','Russia','1969-12-31','STATUSCAT','1','SEXCAT','1','Jurisprudencia',NULL,'2019-09-12 02:42:59','2019-09-12 02:42:59',0,0),(8,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Rosa','proaño chicaiza','Rosa proaño chicaiza','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Area de computacionn',NULL,'2019-09-12 02:43:08','2019-09-12 02:43:08',0,0),(9,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Jenny ','Pavón','Jenny  Pavón','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','0','Area de computacionn',NULL,'2019-11-07 04:01:26','2019-11-07 04:01:26',0,0),(10,'1723353403','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Gonzalo','epn','Gonzalo epn','davidgonzalomejia@hotmail.com','ECuador','2018-09-04','STATUSCAT','1','SEXCAT','1','compuatacion',NULL,'2019-09-12 02:43:21','2019-09-12 02:43:21',0,0),(11,'1723353403','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Byron','Lopez','Byron Lopez','davidgonzalomejia@hotmail.com','Ecuador','2019-08-07','STATUSCAT','1','SEXCAT','1','area humana',NULL,'2019-09-12 02:43:28','2019-09-12 02:43:28',0,0),(12,'121243342','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Universidad','test','test','test test','davidgonzalomejia@hotmail.com','ecuador','2019-10-15','STATUSCAT','1','SEXCAT','1','test',NULL,'2019-10-08 03:35:24','2019-10-08 03:35:24',0,0);
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
  `classification` varchar(100) DEFAULT NULL,
  `itemdescription` varchar(500) DEFAULT NULL,
  `itemobservation` varchar(500) DEFAULT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuizItem_UNIQUE` (`codeQuizItem`),
  KEY `QuestionItem_Questions_FK` (`codeQuestions`),
  KEY `QuestionItem_Questions_FK1` (`codeQuestions`,`codeQuiz`),
  KEY `QuestionItem_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `QuestionItem_Questions_FK1` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `QuestionItem_catalogue_FK` FOREIGN KEY (`statusCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `QuestionItem_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QuestionItem`
--

LOCK TABLES `QuestionItem` WRITE;
/*!40000 ALTER TABLE `QuestionItem` DISABLE KEYS */;
INSERT INTO `QuestionItem` VALUES (2,1,1,'Brasil',NULL,'pais de la gartotas',NULL,'STATUSCAT','0','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/2.png',NULL),(3,1,1,'Colombia',NULL,'pais de cafe',NULL,'STATUSCAT','0','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/3.png',NULL),(23,4,1,'Brasil',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,NULL,NULL),(24,4,1,'Argentina',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,NULL,NULL),(25,4,1,'Uruguay',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,NULL,NULL),(26,5,1,'Venezuela',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,NULL,NULL),(27,5,1,'Ecuador',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,NULL,NULL),(36,3,1,'Estadio chucho benites',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/36.png',NULL),(37,3,1,'Estadio Aucas',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/37.png',NULL),(38,3,1,'Maracaná',NULL,NULL,NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/38.png',NULL),(39,1,1,'Alemania',NULL,'pais de hitler',NULL,'STATUSCAT','1','2019-11-16 05:00:23','2019-11-16 05:00:23',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/39.png',NULL),(43,13,14,'DATOS DE SENSORES',NULL,'Datos de sensores ubicados en las dependencias, controles, equipos, registros, Wifi, cÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¡maras, accesos.',NULL,'STATUSCAT','1','2019-10-08 07:17:09','2019-10-08 07:17:09',1,1,NULL,NULL),(44,13,14,'UNIDAD ORGANIZATIVAS',NULL,'Datos sobre Facultades, Institutos, Centros y Departamentos AcadÃƒÂ©micos, Administrativos y de InvestigaciÃƒÂ³n.',NULL,'STATUSCAT','1','2019-10-08 07:17:09','2019-10-08 07:17:09',1,1,NULL,NULL),(45,13,14,'TITULACIONES',NULL,'Se refiere a las carreras que proporciona, sus asignaturas, plan de estudios.',NULL,'STATUSCAT','1','2019-10-08 07:17:09','2019-10-08 07:17:09',1,1,NULL,NULL),(46,14,15,'Colectores de Basura.','ORGANIZACIÓN E INFRAESTRUCTURA','Sistema de recolección interna de basura, tachos de basura, horarios de recolección.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(47,14,15,'Proyectos de Investigación. ','INVESTIGACIÓN','Proyectos que se están ejecutando, investigadores.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(48,14,15,'Titulaciones.','ACADÉMICO','Carreras, asignaturas, plan de estudios.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(49,14,15,'Seguimiento a Egresados.','ACADÉMICO','Alumnos egresados.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(50,14,15,'Datos Metereológicos.','DATOS TIEMPO REAL SENSORES','Temperatura, Humedad, Rayos Ultravioleta, Lluvia, Presión atmosférica, Polución.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(51,14,15,'Oportunidades de trabajo.','BIENESTAR ESTUDIANTIL','Oportunidades de trabajo, pasantías y prácticas. ',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(52,14,15,'Estudiantes.','ACADÉMICO','Alumnos matriculados.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(53,14,15,'Convenios.','INVESTIGACIÓN','Convenios suscritos con entidades universitarias, empresas, gobiernos.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(54,14,15,'Eventos Culturales y Deportivos.','BIENESTAR ESTUDIANTIL','Descripción de Eventos culturales y deportivos.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(55,14,15,'Proyectos de Infraestructura.','ORGANIZACIÓN E INFRAESTRUCTURA','Detalle de proyectos de infraestructura en mantenimiento a implementarse.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(56,14,15,'Telefonía.','ORGANIZACIÓN E INFRAESTRUCTURA','Consumo telefónico tomado en forma física y digital.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(57,14,15,'Jardinería.','ORGANIZACIÓN E INFRAESTRUCTURA','Sistema de arreglo de jardinería, por zona, personal, herramientas, horarios de arreglo.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(58,14,15,'Administrativos.','ACADÉMICO','Trabajadores administrativos.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(59,14,15,'Docentes.','ACADÉMICO','Docentes que se encuentran con contrato.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(60,14,15,'Becas y Ayudas.','BIENESTAR ESTUDIANTIL','Becas y ayudas existentes.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(61,14,15,'Presupuesto.','ORGANIZACIÓN E INFRAESTRUCTURA','Presupuestos de la Universidad.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(62,14,15,'Transporte.','BIENESTAR ESTUDIANTIL','Sistemas de transporte desde y hacia la Universidad.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(63,14,15,'Unidades Organizativas.','ACADÉMICO','Datos sobre Facultades, Institutos, Centros y Departamentos Académicos, Administrativos y de Investigación. ',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(64,14,15,'Datos Geoposicionados.','ORGANIZACIÓN E INFRAESTRUCTURA','Datos geoposicionados de los edificios, dependencias, equipos de comunicaciones, máquinas expendedoras, zonas de jardinería y otros.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(65,14,15,'Servicios para el Estudiante.','BIENESTAR ESTUDIANTIL','Servicios médicos, legales, administrativos.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(66,14,15,'Agua.','ORGANIZACIÓN E INFRAESTRUCTURA','Consumo de agua tomado en forma física y digital.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(67,14,15,'Bibliotecas.','BIENESTAR ESTUDIANTIL','Sistema de bibliotecas dentro de la Universidad.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(68,14,15,'Restaurantes y Puestos de Comida.','ORGANIZACIÓN E INFRAESTRUCTURA','Descripción de restaurantes, puestos de comida y bares.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(69,14,15,'Publicaciones Científicas. ','INVESTIGACIÓN','Publicaciones científicas del personal docente investigador publicados e indexados.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(70,14,15,'Datos de Sensores.','DATOS TIEMPO REAL SENSORES','Datos de sensores ubicados en las dependencias, controles, equipos, registros, Cámaras, WiFi, accesos.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(71,14,15,'Guardianía.','ORGANIZACIÓN E INFRAESTRUCTURA','Sistema de guardianía, por zona, personal, herramientas, rutas, cámaras.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(72,14,15,'Energía.','ORGANIZACIÓN E INFRAESTRUCTURA','Consumo de energía tomado en forma física y digital.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(73,14,15,'Organigrama de Dirección.','ORGANIZACIÓN E INFRAESTRUCTURA','Datos de personal que dirige las unidades administrativas, académicas e investigación.',NULL,'STATUSCAT','1','2019-10-08 07:16:14','2019-10-08 07:16:14',1,1,NULL,NULL),(74,15,21,'Logotipo 1',NULL,NULL,NULL,'STATUSCAT','1','2019-11-14 01:35:04','2019-11-14 01:35:04',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/74.png',NULL),(75,15,21,'logotipo 2',NULL,NULL,NULL,'STATUSCAT','1','2019-11-14 01:35:04','2019-11-14 01:35:04',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/75.png',NULL),(76,15,21,'logotipo 3',NULL,NULL,NULL,'STATUSCAT','1','2019-11-14 01:35:04','2019-11-14 01:35:04',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/76.png',NULL),(77,15,21,'logotipo 4',NULL,NULL,NULL,'STATUSCAT','1','2019-11-14 01:35:04','2019-11-14 01:35:04',1,1,'/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems/77.png',NULL),(78,16,30,'Qué el sistema soporte el manejo de varias dimensiones de indicadores.',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:13:40','2019-11-19 21:13:40',1,1,NULL,NULL),(79,16,30,'Qué el sistema permita la migración de datos de diferentes fuentes.',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:13:40','2019-11-19 21:13:40',1,1,NULL,NULL),(80,16,30,'Qué el sistema permita la creación de tableros de control personalizados.',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:13:40','2019-11-19 21:13:40',1,1,NULL,NULL),(81,16,30,'Qué el sistema permita realizar tareas de minerías de datos.',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:13:40','2019-11-19 21:13:40',1,1,NULL,NULL),(84,17,31,'A',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:47:50','2019-11-19 21:47:50',1,1,NULL,NULL),(85,17,31,'B',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:47:50','2019-11-19 21:47:50',1,1,NULL,NULL),(86,17,31,'C',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:47:50','2019-11-19 21:47:50',1,1,NULL,NULL),(87,17,31,'D',NULL,NULL,NULL,'STATUSCAT','1','2019-11-19 21:47:50','2019-11-19 21:47:50',1,1,NULL,NULL);
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
  `question` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `minimumParameterSetting` varchar(100) NOT NULL,
  `maximumParameterSetting` varchar(100) NOT NULL,
  `jumpNext` varchar(100) NOT NULL,
  `questionObservation` varchar(500) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questions`
--

LOCK TABLES `Questions` WRITE;
/*!40000 ALTER TABLE `Questions` DISABLE KEYS */;
INSERT INTO `Questions` VALUES (1,1,'cual es el ganadador de la copa america en el 2024','Acerca de la copa américa que se realizara en ecuador en 2024','STATUSCAT','1','0','10','1',NULL,'2019-11-16 05:00:23','2019-11-16 05:00:23',0,0,7.00000000,NULL,NULL),(3,1,'Cuántas sedes tiene esta Copa América','sedes de la copa america','STATUSCAT','1','0','10','1',NULL,'2019-11-16 05:00:23','2019-11-16 05:00:23',0,0,3.00000000,NULL,NULL),(4,1,'Quiénes son los máximos ganadores del título','maximos ganadores del titulo','STATUSCAT','1','0','10','1',NULL,'2019-11-16 05:00:23','2019-11-16 05:00:23',0,0,4.00000000,NULL,NULL),(5,1,'Cuáles son las dos selecciones que nunca salieron campeonas','Nunca han ganado la copa america','STATUSCAT','1','0','10','1',NULL,'2019-11-16 05:00:23','2019-11-16 05:00:23',0,0,5.00000000,NULL,NULL),(13,14,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','0','100','5',NULL,'2019-10-08 07:17:09','2019-10-08 07:17:09',0,0,70.00000000,0,0),(14,15,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista\nde acuerdo a su criterio de probabilidad de reutilización','STATUSCAT','1','0','100','5',NULL,'2019-10-08 07:16:14','2019-10-08 07:16:14',0,0,70.00000000,0,0),(15,21,'Según su opinion identifique el mejor logotipo para la parroquia de NONO (Quito), basado en los siguientes criterios de evaluación ','El logotipo debe llevar las caracteristicas y tradiciones de la parroquia de NONO','STATUSCAT','1','1','10','1',NULL,'2019-11-14 01:35:04','2019-11-14 01:35:04',0,0,7.00000000,0,0),(16,30,'Según su opinión identifique el requerimiento del sistema de indicadores que responda a mejor a cada uno de los siguientes criterios de evaluación','Realice una comparación.','STATUSCAT','1','1','10','1',NULL,'2019-11-19 21:13:40','2019-11-19 21:13:40',0,0,7.00000000,0,0),(17,31,'P1','D1','STATUSCAT','1','0','100','1',NULL,'2019-11-19 21:47:50','2019-11-19 21:47:50',0,0,7.00000000,0,0);
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
  `nameQuiz` varchar(500) NOT NULL,
  `shortNameQuiz` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `statusCat` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `quizObservation` varchar(1000) DEFAULT NULL,
  `diffuseDelphiDiscriminator` decimal(30,8) DEFAULT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeQuiz`),
  UNIQUE KEY `codeQuiz_UNIQUE` (`codeQuiz`),
  KEY `Quiz_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `Quiz_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quiz`
--

LOCK TABLES `Quiz` WRITE;
/*!40000 ALTER TABLE `Quiz` DISABLE KEYS */;
INSERT INTO `Quiz` VALUES (1,'Pronostico del equipo ganador en la copa america','MEJOR EQUIPO PARA GANAR LA COPA AMERICA','Equipo posible ganador de la copa américa.\n','STATUSCAT','1',NULL,7.00000000,'2019-11-16 16:06:30','2019-11-16 16:06:30',1,1),(14,'Seleccion de casos de estudio universitario','Investigación de Datos Abiertos','Gracias por dedicar unos minutos a completar esta encuesta, usted ha sido escogido por su experiencia','STATUSCAT','1',NULL,70.00000000,'2019-10-08 07:17:09','2019-10-08 07:17:09',1,1),(15,'Considering reusers when selecting datasets to open: a case of study from universities','Investigación Universitaria','Gracias por dedicar unos minutos a completar esta encuesta, usted ha sido escogido por su experiencia en datos abiertos y la informaci&#243;n que nos proporcione ser&#225; muy &#250;til para la investigaci&#243;n sobre el conjunto de datos que se deber&#237;a abrir en la universidad ecuatoriana.<div><br></div><div>Para la investigaci&#243;n vamos a utilizar una metodolog&#237;a llamada&#160;<span>Delphi Difuso</span>&#160;que consiste en llegar a consensos con los participantes sobre sus criterios, por tanto podr&#237;amos requerir de su colaboraci&#243;n una o dos veces adicionales. Sus respuestas ser&#225;n tratadas de forma confidencial y ser&#225;n utilizadas para la investigaci&#243;n llevada a cabo entre la Universidad Central del Ecuador y La Universidad de Alicante en Espa&#241;a sobre la l&#237;nea de Datos Abiertos.&#160;</div><div><br></div><div>Esta encuesta dura aproximadamente&#160;<font color=\"#8000ff\">20 minutos</font>.&#160;</div><div>La fecha l&#237;mite para realizar esta encuesta es una semana luego de que le llegue este correo.</div>','STATUSCAT','1',NULL,70.00000000,'2019-11-13 04:01:26','2019-11-13 04:01:26',1,1),(21,'Elección del mejor logotipo para la parroquia de NONO','Logotipo para la parroquia de NONO','Un logotipo que identifique la cultura y tradiciones de la parroquia de NONO','STATUSCAT','1',NULL,7.00000000,'2019-11-17 01:39:18','2019-11-17 01:39:18',1,1),(30,'Sistema de indicadores para la elicitación de requisitos no funcionales.','Sistema de Indicadores para elicitación de requisitos no funcionales','<div>Gracias por dedicar unos minutos a completar esta encuesta. La informaci&#243;n que nos proporcione ser&#225; muy &#250;til para la investigaci&#243;n sobre el Sistema de indicadores para la elicitaci&#243;n de requisitos no funcionales en base al est&#225;ndar ISO/IEC 25010.</div><div><br></div><div>Esta encuesta dura aproximadamente 10 minutos.</div>','STATUSCAT','1',NULL,7.00000000,'2019-11-19 21:13:40','2019-11-19 21:13:40',1,1),(31,'ENCUESTA','EC','D','STATUSCAT','1',NULL,NULL,'2019-11-19 21:47:50','2019-11-19 21:47:50',1,1);
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
  `rangeG` decimal(10,0) DEFAULT NULL,
  `statusRangeG` int(11) DEFAULT NULL,
  `rangeC` decimal(10,0) DEFAULT NULL,
  `distanceGtoC` decimal(10,0) DEFAULT NULL,
  `validated` int(11) DEFAULT NULL,
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
INSERT INTO `Quizvalues` VALUES (1,1,14,13,43,'25','30','35',10,1,15,-5,0,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,1,14,13,44,'60','70','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,1,14,13,45,'75','85','90',60,1,19,41,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,1,21,15,74,'1','5.5','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-17 01:44:04','2019-11-17 01:44:04',0,0),(1,1,21,15,75,'1','5.5','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-17 01:44:04','2019-11-17 01:44:04',0,0),(1,1,21,15,76,'1','5.5','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-17 01:44:04','2019-11-17 01:44:04',0,0),(1,1,21,15,77,'1','5.5','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-17 01:44:04','2019-11-17 01:44:04',0,0),(1,2,14,13,43,'35','40','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,14,13,44,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,14,13,45,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,15,14,46,'50','65','80',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,47,'95','100','100',65,1,27,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,48,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,49,'30','35','45',15,1,23,-8,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,50,'40','60','85',60,1,6,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,51,'55','55','65',45,1,3,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,52,'45','55','80',40,1,13,27,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,53,'80','85','90',65,1,25,40,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,54,'20','45','65',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,55,'55','60','90',70,1,13,57,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,56,'30','70','75',45,1,13,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,57,'35','60','70',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,58,'30','35','45',20,1,12,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,59,'55','65','80',55,1,1,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,60,'20','45','85',65,1,12,53,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,61,'65','70','95',60,1,6,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,62,'40','45','85',50,1,14,36,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,63,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,64,'45','65','60',30,1,2,28,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,65,'35','40','80',45,1,13,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,66,'75','80','85',50,1,18,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,67,'25','55','65',40,1,6,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,68,'35','70','75',40,1,16,24,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,69,'95','95','100',60,1,13,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,70,'40','70','90',60,1,10,50,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,71,'30','45','60',30,1,9,21,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,72,'55','65','80',50,1,12,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,15,14,73,'45','70','75',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,2,21,15,74,'1','4','10',9,1,0,9,1,NULL,NULL,'2019-11-16 22:36:21','2019-11-16 22:36:21',0,0),(1,2,21,15,75,'1','4','10',9,1,0,9,1,NULL,NULL,'2019-11-16 22:36:21','2019-11-16 22:36:21',0,0),(1,2,21,15,76,'1','7','10',9,1,0,9,1,NULL,NULL,'2019-11-16 22:36:21','2019-11-16 22:36:21',0,0),(1,2,21,15,77,'1','4','10',9,1,0,9,1,NULL,NULL,'2019-11-16 22:36:21','2019-11-16 22:36:21',0,0),(1,3,14,13,43,'25','35','45',20,1,10,10,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,14,13,44,'80','85','95',65,1,21,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,14,13,45,'80','85','95',65,1,19,46,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,15,14,46,'60','70','85',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,47,'60','75','95',60,1,2,58,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,48,'50','65','80',50,1,1,49,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,49,'60','70','90',60,1,12,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,50,'65','75','90',65,1,21,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,51,'60','70','85',65,1,12,53,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,52,'60','70','90',50,1,2,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,53,'50','65','85',60,1,5,55,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,54,'50','60','70',50,1,4,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,55,'20','30','35',15,1,17,-2,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,56,'60','70','85',55,1,13,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,57,'20','30','35',15,1,14,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,58,'25','30','40',15,1,17,-2,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,59,'60','70','90',65,1,4,61,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,60,'65','75','90',70,1,18,52,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,61,'60','75','90',55,1,11,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,62,'65','80','95',60,1,21,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,63,'30','50','75',45,1,14,31,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,64,'65','75','90',60,1,12,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,65,'65','75','90',55,1,22,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,66,'55','70','75',40,1,8,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,67,'70','80','95',70,1,19,51,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,68,'50','65','85',50,1,11,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,69,'60','75','95',55,1,7,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,70,'65','75','95',65,1,15,50,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,71,'60','70','85',55,1,16,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,72,'60','70','85',55,1,17,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,3,15,14,73,'25','35','50',25,1,19,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,14,13,43,'35','40','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,14,13,44,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,14,13,45,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,15,14,46,'50','65','80',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,47,'95','100','100',65,1,27,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,48,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,49,'30','35','45',15,1,23,-8,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,50,'40','60','85',60,1,6,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,51,'55','55','65',45,1,3,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,52,'45','55','80',40,1,13,27,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,53,'30','55','45',20,1,5,15,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,54,'20','45','65',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,55,'55','60','90',70,1,13,57,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,56,'30','70','75',45,1,13,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,57,'35','60','70',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,58,'30','35','45',20,1,12,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,59,'55','65','80',55,1,1,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,60,'20','45','85',65,1,12,53,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,61,'65','70','95',60,1,6,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,62,'40','45','85',50,1,14,36,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,63,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,64,'45','65','60',30,1,2,28,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,65,'35','40','80',45,1,13,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,66,'55','70','75',40,1,8,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,67,'25','55','65',40,1,6,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,68,'35','70','75',40,1,16,24,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,69,'95','95','100',60,1,13,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,70,'40','70','90',60,1,10,50,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,71,'30','45','60',30,1,9,21,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,72,'55','65','80',50,1,12,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,4,15,14,73,'45','70','75',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,14,13,43,'35','50','65',40,1,5,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,14,13,44,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,14,13,45,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,15,14,46,'35','35','60',25,1,19,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,47,'55','60','90',55,1,13,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,48,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,49,'35','65','100',70,1,7,63,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,50,'30','45','50',25,1,9,16,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,51,'20','30','45',25,1,28,-3,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,52,'40','60','100',60,1,8,52,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,53,'25','45','85',60,1,15,45,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,54,'50','45','30',10,1,11,-1,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,55,'20','40','45',25,1,7,18,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,56,'35','50','45',15,1,7,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,57,'35','35','70',50,1,9,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,58,'60','65','80',55,1,18,37,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,59,'40','80','70',45,1,14,31,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,60,'35','40','75',55,1,17,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,61,'35','35','65',30,1,29,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,62,'35','55','50',15,1,4,11,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,63,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,64,'30','40','25',-5,0,23,-28,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,65,'35','40','50',15,1,13,2,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,66,'60','65','70',35,1,3,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,67,'40','45','50',25,1,16,9,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,68,'40','25','75',40,1,29,11,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,69,'40','75','100',60,1,7,53,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,70,'45','45','50',20,1,15,5,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,71,'35','35','30',0,0,19,-19,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,72,'30','35','30',0,0,18,-18,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,5,15,14,73,'50','65','85',60,1,11,49,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,14,13,43,'35','50','65',40,1,5,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,14,13,44,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,14,13,45,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,15,14,46,'50','60','70',35,1,6,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,47,'60','70','85',50,1,3,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,48,'50','60','80',50,1,6,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,49,'30','50','60',30,1,8,22,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,50,'40','70','80',55,1,16,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,51,'60','80','90',70,1,22,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,52,'50','80','90',50,1,12,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,53,'50','60','80',55,1,0,55,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,54,'40','60','70',50,1,4,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,55,'40','60','80',60,1,13,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,56,'30','40','50',20,1,17,3,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,57,'40','60','70',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,58,'35','50','60',35,1,3,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,59,'35','60','70',45,1,6,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,60,'50','60','80',60,1,3,57,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,61,'60','80','90',55,1,16,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,62,'60','80','90',55,1,21,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,63,'50','70','80',50,1,6,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,64,'70','80','90',60,1,17,43,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,65,'50','60','80',45,1,7,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,66,'50','60','70',35,1,2,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,67,'65','80','90',65,1,19,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,68,'70','80','90',55,1,26,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,69,'50','70','85',45,1,12,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,70,'30','60','80',50,1,0,50,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,71,'50','70','80',50,1,16,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,72,'40','50','50',20,1,3,17,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,6,15,14,73,'30','50','60',35,1,4,31,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,7,14,13,43,'45','50','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,7,14,13,44,'65','70','75',45,1,6,39,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,7,14,13,45,'80','85','90',60,1,19,41,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,43,'40','50','60',35,1,5,30,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,44,'50','70','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,45,'50','60','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,15,14,46,'40','45','50',15,1,9,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,47,'75','80','90',55,1,7,48,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,48,'80','85','90',60,1,19,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,49,'60','65','70',40,1,7,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,50,'35','40','45',20,1,14,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,51,'60','65','70',50,1,7,43,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,52,'75','80','85',45,1,12,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,53,'70','80','90',65,1,20,45,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,54,'20','45','65',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,55,'25','30','35',15,1,17,-2,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,56,'40','45','50',20,1,12,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,57,'25','30','35',15,1,14,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,58,'25','30','40',15,1,17,-2,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,59,'25','35','45',20,1,31,-11,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,60,'60','70','80',60,1,13,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,61,'70','75','80',45,1,11,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,62,'35','50','60',25,1,9,16,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,63,'65','70','75',45,1,6,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,64,'40','60','80',50,1,3,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,65,'55','65','70',35,1,12,23,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,66,'50','60','65',30,1,2,28,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,67,'75','85','95',70,1,24,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,68,'40','45','50',15,1,9,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,69,'80','85','95',55,1,3,52,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,70,'40','45','50',20,1,15,5,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,71,'45','50','55',25,1,4,21,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,72,'40','45','50',20,1,8,12,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,8,15,14,73,'25','35','45',20,1,19,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,14,13,43,'60','70','85',60,1,25,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,14,13,44,'30','50','75',45,1,14,31,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,14,13,45,'50','65','80',50,1,1,49,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,15,14,46,'90','95','100',65,1,41,24,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,47,'85','90','95',60,1,17,43,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,48,'80','85','95',65,1,19,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,49,'75','80','90',60,1,22,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,50,'70','80','85',60,1,26,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,51,'90','95','100',80,1,37,43,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,52,'80','85','95',55,1,17,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,53,'85','90','95',70,1,30,40,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,54,'85','90','95',75,1,34,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,55,'80','85','90',70,1,38,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,56,'90','95','100',70,1,38,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,57,'70','80','85',65,1,36,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,58,'70','80','85',60,1,33,27,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,59,'85','90','95',70,1,24,46,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,60,'90','95','100',80,1,38,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,61,'90','95','100',65,1,31,34,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,62,'90','95','100',65,1,36,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,63,'80','85','95',65,1,21,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,64,'70','80','85',55,1,17,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,65,'90','95','100',65,1,42,23,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,66,'90','95','100',65,1,33,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,67,'90','95','100',75,1,34,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,68,'80','90','95',60,1,36,24,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,69,'85','90','95',55,1,8,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,70,'70','75','80',50,1,15,35,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,71,'90','95','100',70,1,41,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,72,'90','95','100',70,1,42,28,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,9,15,14,73,'70','70','85',60,1,16,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,46,'35','35','60',25,1,19,6,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,47,'55','60','90',55,1,13,42,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,48,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,49,'35','65','100',70,1,7,63,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,50,'30','45','50',25,1,9,16,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,51,'20','30','45',25,1,28,-3,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,52,'40','60','100',60,1,8,52,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,53,'25','40','85',60,1,20,40,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,54,'50','45','30',10,1,11,-1,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,55,'20','40','45',25,1,7,18,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,56,'35','50','45',15,1,7,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,57,'35','35','70',50,1,9,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,58,'60','65','80',55,1,18,37,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,59,'40','80','70',45,1,14,31,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,60,'35','40','75',55,1,17,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,61,'35','35','65',30,1,29,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,62,'35','55','50',15,1,4,11,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,63,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,64,'30','40','25',-5,0,23,-28,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,65,'35','40','50',15,1,13,2,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,66,'45','35','35',0,0,27,-27,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,67,'40','45','50',25,1,16,9,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,68,'40','25','75',40,1,29,11,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,69,'40','75','100',60,1,7,53,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,70,'45','45','50',20,1,15,5,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,71,'35','35','30',0,0,19,-19,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,72,'30','35','30',0,0,18,-18,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,10,15,14,73,'50','65','85',60,1,11,49,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,46,'35','45','60',25,1,9,16,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,47,'35','45','60',25,1,28,-3,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,48,'75','85','90',60,1,19,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,49,'75','85','90',60,1,27,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,50,'25','30','35',10,1,24,-14,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,51,'80','85','90',70,1,27,43,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,52,'70','80','85',45,1,12,33,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,53,'35','45','60',35,1,15,20,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,54,'80','85','90',70,1,29,41,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,55,'35','45','60',40,1,2,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,56,'35','45','55',25,1,12,13,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,57,'25','30','35',15,1,14,1,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,58,'55','65','75',50,1,18,32,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,59,'60','70','80',55,1,4,51,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,60,'60','70','80',60,1,13,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,61,'60','70','80',45,1,6,39,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,62,'35','45','60',25,1,14,11,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,63,'60','70','80',50,1,6,44,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,64,'80','85','90',60,1,22,38,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,65,'35','45','60',25,1,8,17,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,66,'35','45','60',25,1,17,8,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,67,'30','35','40',15,1,26,-11,0,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,68,'55','65','75',40,1,11,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,69,'80','85','90',50,1,3,47,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,70,'60','70','80',50,1,10,40,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,71,'60','70','75',45,1,16,29,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,72,'35','45','60',30,1,8,22,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0),(1,11,15,14,73,'35','45','60',35,1,9,26,1,NULL,NULL,'2019-09-12 09:06:21','2019-09-12 09:06:21',0,0);
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
  `token` varchar(1000) NOT NULL,
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
INSERT INTO `Rounds` VALUES (1,1,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU3Mzg3ODQ2NCwiZXhwIjozMTQ4MzYxNzI4LCJjb2RlUXVpeiI6MSwicm91bmROdW1iZXIiOjEsImNvZGVQZXJzb24iOjF9.2nYOzkwppHzGyXIoKKQjyhgAiJu57iycJDVUzt4-d50','SENTSTATUSCAT','sent','2019-11-16 04:27:44','2019-11-16 04:27:44',0,0),(1,14,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzUwMSwiZXhwIjozMTM1Njk5ODAyLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxfQ.iRxXep3hUoI0jDNnUNPU5ZzaooX6BzziCTi8M0DA3LI','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:41','2019-09-03 22:00:01',0,0),(1,14,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5OSwiZXhwIjozMTM1Njk5Nzk4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoyfQ.eWeed0I70LpXkXFMeKIaIVrJcklYTyyR5TR0CshXbnk','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:39','2019-09-03 22:00:25',0,0),(1,14,3,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5NiwiZXhwIjozMTM1Njk5NzkyLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjozfQ.5dmyKG_lmCDWwv9U5ie2KdJAndBOMwS_IvFWCUpD-oI','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:36','2019-09-03 22:00:47',0,0),(1,14,4,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5NCwiZXhwIjozMTM1Njk5Nzg4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo0fQ.-izb7AokvwxmA7F0Sy6iJIQoR9lGOkT-2yUxW9lK4Lo','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:34','2019-09-03 22:01:10',0,0),(1,14,5,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5MSwiZXhwIjozMTM1Njk5NzgzLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo1fQ.QpwIPw_xk28O1msCK6agZNzi8TqZMfiK3YmUDiP46Oo','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:31','2019-09-03 22:01:36',0,0),(1,14,6,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4OSwiZXhwIjozMTM1Njk5Nzc4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo2fQ.OcytIYS6e5dIkDi4yJU6Kyy6_yNDTZyWlTXn78eCfWQ','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:29','2019-09-03 22:01:52',0,0),(1,14,7,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4NiwiZXhwIjozMTM1Njk5NzczLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo3fQ.aa8Yg8oGFQlFHAsvw5ECZbWuaQnJnRC9juEoS_iMLNw','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:26','2019-09-03 22:02:11',0,0),(1,14,8,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4MywiZXhwIjozMTM1Njk5NzY3LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo4fQ.hgqAmBkVTUvvPpApp-hjPgg-HzCbYrhkMlVimKrNTkg','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:23','2019-09-03 22:02:27',0,0),(1,14,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ3OSwiZXhwIjozMTM1Njk5NzU5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo5fQ.K7FT24Z9UgvnOZpTaG_f1KLdk7MrTwVQ7HV3x3D0Z8w','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:19','2019-09-03 21:57:24',0,0),(1,15,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ0OSwiZXhwIjozMTM3MTE3Njk4LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxfQ.7SR5FX1CcnCQW5U_lsVqmtV5Twe2OD9IoMgmAYxIR0w','SENTSTATUSCAT','sent','2019-09-12 02:47:29','2019-09-12 02:47:29',0,0),(1,15,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ1NCwiZXhwIjozMTM3MTE3NzA5LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoyfQ.AOUJg-5O08FVQECbBeH8F0aSQOgyl2Ec_8eWj8FrTVU','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:34','2019-09-12 07:47:39',0,0),(1,15,3,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ1NywiZXhwIjozMTM3MTE3NzE1LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjozfQ.lFLwxXyS1q99t1GAXfpDcyzRVGIBK3oYQtoE22QCegU','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:37','2019-09-12 08:26:00',0,0),(1,15,4,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ2MCwiZXhwIjozMTM3MTE3NzIxLCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo0fQ.mbVl15xTDve4t5u02kEau1rwvda_83b6ZYVEQ7hAyaI','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:40','2019-09-12 07:28:03',0,0),(1,15,5,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ2MywiZXhwIjozMTM3MTE3NzI3LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo1fQ.KKiqdhOhz4a6IuNNKFgHDjEjWV251R3OKswqCuHAVXM','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:43','2019-09-12 07:13:06',0,0),(1,15,6,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ2NywiZXhwIjozMTM3MTE3NzM0LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo2fQ.vuiA4K_SiHQCCQRBB80i6hLfLSigGmf5WGg7kFzI7Q4','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:47','2019-09-12 08:15:08',0,0),(1,15,7,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ3MCwiZXhwIjozMTM3MTE3NzQxLCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo3fQ.lGd3KVF0qfrAp8Q0O8w1I5oucST64XaiYaTUrInmAWA','SENTSTATUSCAT','sent','2019-09-12 02:47:50','2019-09-12 02:47:50',0,0),(1,15,8,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ3MywiZXhwIjozMTM3MTE3NzQ3LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo4fQ.u_O0ELK-06NBgcpcIknLAzFV5EkR6Fcd5POU_9jNRxM','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:53','2019-09-12 08:01:34',0,0),(1,15,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ3NiwiZXhwIjozMTM3MTE3NzUzLCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo5fQ.f6NUG8eW3A01RMIFn1vL-dLMf10dzGnmOpCGYrTScyE','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:57','2019-09-12 06:59:05',0,0),(1,15,10,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ3OSwiZXhwIjozMTM3MTE3NzU5LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxMH0.AOZ0Mk45Jxqi_sw2s_Wjrq0VM2mOfmrViPuBm8r4LBs','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:47:59','2019-09-12 06:50:00',0,0),(1,15,11,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODI1NjQ4MiwiZXhwIjozMTM3MTE3NzY1LCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxMX0.By7Zmhl3n7iV7U8c2A9nHxIyzTAZAJJFBlkyTQDTolo','SENTSTATUSCAT','sentAndAnswered','2019-09-12 02:48:02','2019-09-12 06:31:32',0,0),(1,21,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU3Mzk1NDc1OCwiZXhwIjozMTQ4NTE0MzE3LCJjb2RlUXVpeiI6MjEsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxfQ.F6AFEDW2rnzp5Oh_keGPs_4BrUj4GNuvXM2-wJUSIzE','SENTSTATUSCAT','sentAndAnswered','2019-11-17 01:39:18','2019-11-17 01:44:04',0,0),(1,21,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU3MzkyMDUxNCwiZXhwIjozMTQ4NDQ1ODI5LCJjb2RlUXVpeiI6MjEsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoyfQ.OHwpa6mYrqTj9-9z_JNCsKTqTV53Ld3FRlguI83TKsE','SENTSTATUSCAT','sentAndAnswered','2019-11-16 16:08:34','2019-11-16 16:09:47',0,0),(2,1,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU3MzkyMDM5MSwiZXhwIjozMTQ4NDQ1NTgyLCJjb2RlUXVpeiI6MSwicm91bmROdW1iZXIiOjIsImNvZGVQZXJzb24iOjF9.rb6R1ZkURLI8SbaCWvkJYQkqShEGGlyIzO6MgvjdXLI','SENTSTATUSCAT','sent','2019-11-16 16:06:31','2019-11-16 16:06:31',0,0),(2,14,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODA0MTkzOSwiZXhwIjozMTM2Njg4Njc5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjoxfQ.I9GwmmMw1hVCsqsnvKyRziNLz7HgsVQzFDvTYikJFSM','SENTSTATUSCAT','forwarded','2019-09-09 15:12:19','2019-09-09 15:12:19',0,0),(2,14,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTczNywiZXhwIjozMTM1NzA0Mjc1LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjoyfQ.4L49pS_tAoP3NOcta5IVHoW8MLzzBqpnPnR3vjjnpkA','SENTSTATUSCAT','sent','2019-09-03 22:28:57','2019-09-03 22:28:57',0,0),(2,14,3,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0MywiZXhwIjozMTM1NzA0Mjg2LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjozfQ.rJ6VEwEpwN3C8almhuObtG-9WXXRoRBS19FF9yM6DnU','SENTSTATUSCAT','sent','2019-09-03 22:29:03','2019-09-03 22:29:03',0,0),(2,14,4,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0MCwiZXhwIjozMTM1NzA0MjgxLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo0fQ.N5LaoxKknnQFG4HVsGls25V8VNcF2Y2CWCLjXNpSjEo','SENTSTATUSCAT','sent','2019-09-03 22:29:00','2019-09-03 22:29:00',0,0),(2,14,5,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0NSwiZXhwIjozMTM1NzA0MjkwLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo1fQ.UVrnMIwz5AqfZ650R_BGZoHEOiwzhff3JmasbV919kY','SENTSTATUSCAT','sent','2019-09-03 22:29:05','2019-09-03 22:29:05',0,0),(2,14,6,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0NywiZXhwIjozMTM1NzA0Mjk1LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo2fQ.gVMQQ8UYF9ZaPKtyt6aBV4bu9xoh7qTn7uuUm7OAwsE','SENTSTATUSCAT','sent','2019-09-03 22:29:07','2019-09-03 22:29:07',0,0),(2,14,7,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0OSwiZXhwIjozMTM1NzA0Mjk5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo3fQ._zsbSAWLjyEIcmGrMjdOd3CvXgPsxqy9RUfJBXasVZg','SENTSTATUSCAT','sent','2019-09-03 22:29:09','2019-09-03 22:29:09',0,0),(2,14,8,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc1MiwiZXhwIjozMTM1NzA0MzA0LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo4fQ.Ym6r43z1xCRMlyUAqaCeJiLc0kKRjxmwS4931tYhBa8','SENTSTATUSCAT','sent','2019-09-03 22:29:12','2019-09-03 22:29:12',0,0),(2,14,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc1NCwiZXhwIjozMTM1NzA0MzA5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo5fQ.DJkXtM7bc4imSdX_WAzHTFrJEjSMjnpKnMy8xoL3MVY','SENTSTATUSCAT','sent','2019-09-03 22:29:14','2019-09-03 22:29:14',0,0),(2,15,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU3MzYxNzY4NiwiZXhwIjozMTQ3ODQwMTczLCJjb2RlUXVpeiI6MTUsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjoxfQ.mz5POL4nK4KpfehINrckfYLlbz1HZpBEZ5X93X8E5Fw','SENTSTATUSCAT','sent','2019-11-13 04:01:26','2019-11-13 04:01:26',0,0);
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
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `recoveryMail` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL,
  `token` varchar(500) DEFAULT NULL,
  `workarea` varchar(300) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeuser`,`email`,`username`),
  UNIQUE KEY `codeuser_UNIQUE` (`codeuser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (4,'byron@epn.edu.ec','Byron','byron@epn.edu.ec','yJzDaB0vwaCn1ypAC4ymNw==',NULL,'Area computación','2019-08-21 16:47:12','2019-11-13 17:28:46',1,1),(9,'davidgonzalomejia@hotmail.com','Davidthebest','davidgonzalomejia@hotmail.com','P0Bo6lTP3bfYTX+UlpFtsg==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU3NDE5MjIwMywiZXhwIjozMTQ4OTg5MjA2LCJlbWFpbCI6ImRhdmlkZ29uemFsb21lamlhQGhvdG1haWwuY29tIn0.MYVKrth4Y6tuNxLe8UpPJ-1Rmypr5C4Uml0m5xFRU50','Inteligencia Artificial','2019-11-16 04:26:02','2019-11-19 19:36:43',1,1),(10,'renriquez@uce.edu.ec','renriquez','renriquez@uce.edu.ec','CBFiBN385nOiSTMBQEm5yQ==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU2OTg4Mjk4OSwiZXhwIjozMTQwMzcwNzc5LCJlbWFpbCI6InJlbnJpcXVlekB1Y2UuZWR1LmVjIn0.-BP0Boy0U1ulJ-d6l2WwSmJf28BTaH-rsZ5XRg5uzeI','Area computación','2019-10-08 07:22:43','2019-11-13 17:28:46',1,1),(11,'davidgonzalomejiaaa@hotmail.com','pepe jose','davidgonzalomejiaaa@hotmail.com','duL5bvMpezqMSw30EqclZQ==',NULL,'Area de mecatronica','2019-11-14 05:04:46','2019-11-14 05:12:37',1,1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributesMatrixAverageValue`
--

DROP TABLE IF EXISTS `attributesMatrixAverageValue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributesMatrixAverageValue` (
  `codefahp` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `itemLabel` bigint(20) NOT NULL,
  `itemLabelCouple` bigint(20) NOT NULL,
  `valuecriteriaFAHP` varchar(100) NOT NULL,
  `valuecriteriaFAHPCat` varchar(100) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeCriteria`,`codeQuiz`,`codeQuestions`,`itemLabel`,`itemLabelCouple`),
  KEY `attributesMatrixAverageValue_catalogueitem_FK` (`valuecriteriaFAHPCat`,`valuecriteriaFAHP`),
  KEY `attributesMatrixAverageValue_criteria_FK` (`codeCriteria`),
  KEY `attributesMatrixAverageValue_Quiz_FK` (`codeQuiz`),
  KEY `attributesMatrixAverageValue_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `attributesMatrixAverageValue_QuestionItem_FK` (`itemLabel`,`codeQuestions`,`codeQuiz`),
  KEY `attributesMatrixAverageValue_QuestionItem_FK_1` (`itemLabelCouple`,`codeQuestions`,`codeQuiz`),
  CONSTRAINT `attributesMatrixAverageValue_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `attributesMatrixAverageValue_QuestionItem_FK` FOREIGN KEY (`itemLabel`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixAverageValue_QuestionItem_FK_1` FOREIGN KEY (`itemLabelCouple`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixAverageValue_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixAverageValue_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `attributesMatrixAverageValue_catalogue_FK` FOREIGN KEY (`valuecriteriaFAHPCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `attributesMatrixAverageValue_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributesMatrixAverageValue`
--

LOCK TABLES `attributesMatrixAverageValue` WRITE;
/*!40000 ALTER TABLE `attributesMatrixAverageValue` DISABLE KEYS */;
INSERT INTO `attributesMatrixAverageValue` VALUES (40,12,31,17,84,86,'0.1111111111111111,0.14285714285714285,0.2','VALUEFAHPCAT'),(40,12,31,17,87,86,'0.1111111111111111,0.14285714285714285,0.2','VALUEFAHPCAT'),(28,3,1,1,3,2,'0.14285714285714285,0.2,0.3333333333333333','VALUEFAHPCAT'),(28,4,1,1,3,2,'0.14285714285714285,0.2,0.3333333333333333','VALUEFAHPCAT'),(28,4,1,1,39,2,'0.14285714285714285,0.2,0.3333333333333333','VALUEFAHPCAT'),(28,5,1,1,3,2,'0.14285714285714285,0.2,0.3333333333333333','VALUEFAHPCAT'),(28,5,1,1,39,2,'0.14285714285714285,0.2,0.3333333333333333','VALUEFAHPCAT'),(28,3,1,1,39,2,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(28,3,1,1,39,3,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(28,4,1,1,39,3,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(28,5,1,1,39,3,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,75,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,76,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,76,75,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,77,75,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,77,76,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,21,15,75,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,21,15,76,75,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,21,15,77,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,21,15,77,75,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,21,15,77,76,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,21,15,75,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,21,15,76,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,21,15,77,74,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,21,15,77,75,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,21,15,77,76,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,11,31,17,87,84,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,12,31,17,87,85,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,13,31,17,85,84,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,14,31,17,87,84,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,23,21,15,77,74,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(38,24,21,15,76,74,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(38,25,21,15,76,75,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,85,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,86,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,86,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,87,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,87,86,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,85,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,86,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,87,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,86,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,86,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,87,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,87,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,87,86,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,85,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,86,84,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,86,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,87,85,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(28,3,1,1,2,2,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,3,1,1,3,3,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,3,1,1,39,39,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,4,1,1,2,2,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,4,1,1,3,3,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,4,1,1,39,39,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,5,1,1,2,2,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,5,1,1,3,3,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,5,1,1,39,39,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,21,15,74,74,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,21,15,75,75,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,21,15,76,76,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,21,15,77,77,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,24,21,15,74,74,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,24,21,15,75,75,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,24,21,15,76,76,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,24,21,15,77,77,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,25,21,15,74,74,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,25,21,15,75,75,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,25,21,15,76,76,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,25,21,15,77,77,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,84,84,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,85,85,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,86,86,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,11,31,17,87,87,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,84,84,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,85,85,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,86,84,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,86,86,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,31,17,87,87,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,84,84,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,85,85,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,86,86,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,31,17,87,87,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,84,84,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,85,85,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,86,86,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,86,87,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,87,86,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,31,17,87,87,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,21,15,74,77,'1.0,1.0,3.0','VALUEFAHPCAT'),(38,24,21,15,74,76,'1.0,1.0,3.0','VALUEFAHPCAT'),(38,25,21,15,75,76,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,11,31,17,84,85,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,11,31,17,84,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,11,31,17,85,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,11,31,17,85,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,11,31,17,86,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,12,31,17,84,85,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,12,31,17,84,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,12,31,17,85,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,13,31,17,84,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,13,31,17,84,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,13,31,17,85,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,13,31,17,85,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,13,31,17,86,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,14,31,17,84,85,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,14,31,17,84,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,14,31,17,85,86,'1.0,1.0,3.0','VALUEFAHPCAT'),(40,14,31,17,85,87,'1.0,1.0,3.0','VALUEFAHPCAT'),(28,3,1,1,2,39,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,3,1,1,3,39,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,4,1,1,3,39,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,5,1,1,3,39,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,21,15,74,75,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,21,15,74,76,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,21,15,75,76,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,21,15,75,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,21,15,76,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,21,15,74,75,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,21,15,74,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,21,15,75,76,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,21,15,75,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,21,15,76,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,25,21,15,74,75,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,25,21,15,74,76,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,25,21,15,74,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,25,21,15,75,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,25,21,15,76,77,'1.0,3.0,5.0','VALUEFAHPCAT'),(40,11,31,17,84,87,'1.0,3.0,5.0','VALUEFAHPCAT'),(40,12,31,17,85,87,'1.0,3.0,5.0','VALUEFAHPCAT'),(40,13,31,17,84,85,'1.0,3.0,5.0','VALUEFAHPCAT'),(40,14,31,17,84,87,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,3,1,1,2,3,'3.0,5.0,7.0','VALUEFAHPCAT'),(28,4,1,1,2,3,'3.0,5.0,7.0','VALUEFAHPCAT'),(28,4,1,1,2,39,'3.0,5.0,7.0','VALUEFAHPCAT'),(28,5,1,1,2,3,'3.0,5.0,7.0','VALUEFAHPCAT'),(28,5,1,1,2,39,'3.0,5.0,7.0','VALUEFAHPCAT'),(40,12,31,17,86,87,'5.0,7.0,9.0','VALUEFAHPCAT');
/*!40000 ALTER TABLE `attributesMatrixAverageValue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributesMatrixValue`
--

DROP TABLE IF EXISTS `attributesMatrixValue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributesMatrixValue` (
  `codefahp` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `itemLabel` bigint(20) NOT NULL,
  `itemLabelCouple` bigint(20) NOT NULL,
  `valuecriteriaFAHP` varchar(100) NOT NULL,
  `valuecriteriaFAHPCat` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codePerson`,`codeCriteria`,`codeQuiz`,`codeQuestions`,`itemLabel`,`itemLabelCouple`),
  KEY `attributesMatrixValue_catalogueitem_FK` (`valuecriteriaFAHPCat`,`valuecriteriaFAHP`),
  KEY `attributesMatrixValue_criteria_FK` (`codeCriteria`),
  KEY `attributesMatrixValue_Person_FK` (`codePerson`),
  KEY `attributesMatrixValue_Quiz_FK` (`codeQuiz`),
  KEY `attributesMatrixValue_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `attributesMatrixValue_QuestionItem_FK` (`itemLabel`,`codeQuestions`,`codeQuiz`),
  KEY `attributesMatrixValue_QuestionItem_FK_1` (`itemLabelCouple`,`codeQuestions`,`codeQuiz`),
  CONSTRAINT `attributesMatrixValue_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `attributesMatrixValue_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `attributesMatrixValue_QuestionItem_FK` FOREIGN KEY (`itemLabel`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixValue_QuestionItem_FK_1` FOREIGN KEY (`itemLabelCouple`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixValue_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `attributesMatrixValue_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `attributesMatrixValue_catalogue_FK` FOREIGN KEY (`valuecriteriaFAHPCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `attributesMatrixValue_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributesMatrixValue`
--

LOCK TABLES `attributesMatrixValue` WRITE;
/*!40000 ALTER TABLE `attributesMatrixValue` DISABLE KEYS */;
INSERT INTO `attributesMatrixValue` VALUES (28,1,3,1,1,2,2,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,2,3,'3,5,7','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,2,39,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,3,2,'1/7, 1/5, 1/3','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,3,3,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,3,39,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,39,2,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,39,3,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,1,1,39,39,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,2,2,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,2,3,'3,5,7','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,2,39,'3,5,7','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,3,2,'1/7, 1/5, 1/3','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,3,3,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,3,39,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,39,2,'1/7, 1/5, 1/3','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,39,3,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,1,1,39,39,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,2,2,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,2,3,'3,5,7','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,2,39,'3,5,7','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,3,2,'1/7, 1/5, 1/3','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,3,3,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,3,39,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,39,2,'1/7, 1/5, 1/3','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,39,3,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,1,1,39,39,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(38,3,23,21,15,74,74,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,74,75,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,74,76,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,74,77,'1,1,3','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,75,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,75,75,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,75,76,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,75,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,76,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,76,75,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,76,76,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,76,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,77,74,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,77,75,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,77,76,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,21,15,77,77,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,74,74,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,74,75,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,74,76,'1,1,3','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,74,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,75,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,75,75,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,75,76,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,75,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,76,74,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,76,75,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,76,76,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,76,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,77,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,77,75,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,77,76,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,21,15,77,77,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,74,74,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,74,75,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,74,76,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,74,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,75,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,75,75,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,75,76,'1,1,3','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,75,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,76,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,76,75,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,76,76,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,76,77,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,77,74,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,77,75,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,77,76,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,21,15,77,77,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(40,1,11,31,17,84,84,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,84,85,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,84,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,84,87,'1,3,5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,85,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,85,85,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,85,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,85,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,86,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,86,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,86,86,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,86,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,87,84,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,87,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,87,86,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,31,17,87,87,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,84,84,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,84,85,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,84,86,'1/9,1/7,1/5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,84,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,85,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,85,85,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,85,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,85,87,'1,3,5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,86,84,'1/1/5, 1/1/7, 1/1/9','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,86,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,86,86,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,86,87,'5,7,9','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,87,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,87,85,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,87,86,'1/9, 1/7, 1/5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,31,17,87,87,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,84,84,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,84,85,'1,3,5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,84,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,84,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,85,84,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,85,85,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,85,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,85,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,86,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,86,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,86,86,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,86,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,87,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,87,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,87,86,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,31,17,87,87,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,84,84,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,84,85,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,84,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,84,87,'1,3,5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,85,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,85,85,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,85,86,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,85,87,'1,1,3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,86,84,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,86,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,86,86,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,86,87,'1,1,1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,87,84,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,87,85,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,87,86,'1/1, 1/1, 1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,14,31,17,87,87,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0);
/*!40000 ALTER TABLE `attributesMatrixValue` ENABLE KEYS */;
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
INSERT INTO `catalogue` VALUES ('ACADEMICDEGREECAT','ACADEMICDEGREECAT','Catalogo de nivel de estudios realizado por la persona','2019-11-16 23:16:49','2019-11-16 23:16:49',0,0),('fsd','knjn','jjnk','2019-11-15 16:18:22','2019-11-15 16:18:22',0,0),('IDENTIFYTYPECAT','IDENTIFYTYPECAT','tipo de tipo identificaciones','2019-11-14 02:14:21','2019-11-14 02:14:21',0,0),('SENTSTATUSCAT','SENTSTATUSCAT','Cátalogo estados de las encuestas','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SEXCAT','SEXCAT','Sexo de cada persona','2019-11-12 21:19:11','2019-11-12 21:19:11',0,0),('STATUSCAT','STATUSCAT','Cátalogo estados','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSFAHPCAT','STATUSFAHPCAT','Cátalogo con los estados del proceso sobre el algoritmo fuzzy AHP','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSRESULTCAT','STATUSRESULTCAT','Cátalogo estados de resultados de si converge o no','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSSENTFAHPCAT','STATUSSENTFAHPCAT','Cátalogo de estados de envio de mail para proceso de FAHP','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('TYPEPERSONCAT','TYPEPERSONCAT','tipo de personas como admin, expertos etc','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('VALUEFAHPCAT','VALUEFAHPCAT','Lista de valores para fuzzy AHP (importancia)','2019-11-20 00:50:18','2019-11-20 00:50:18',0,0),('VALUEFAHPCAT_beatufull','Estetica','es una definicion de la estetica','2019-11-15 23:42:54','2019-11-15 23:42:54',0,0),('VALUEFAHPCAT_RELEVANT','Relevancia','Un aspecto es más reelevante que otro','2019-11-20 01:29:15','2019-11-20 01:29:15',0,0);
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
INSERT INTO `catalogueitem` VALUES ('ACADEMICDEGREECAT','Postgrados','Postgrados','2019-11-16 23:16:49','2019-11-16 23:16:49',0,0),('ACADEMICDEGREECAT','Primaria','Primaria','2019-11-16 23:16:49','2019-11-16 23:16:49',0,0),('ACADEMICDEGREECAT','Secundaria','Secundaria','2019-11-16 23:16:49','2019-11-16 23:16:49',0,0),('ACADEMICDEGREECAT','Universidad','Universidad','2019-11-16 23:16:49','2019-11-16 23:16:49',0,0),('fsd','jknjknjk','hjkn','2019-11-15 16:18:22','2019-11-15 16:18:22',0,0),('IDENTIFYTYPECAT','ID','Cédula','2019-11-14 02:14:21','2019-11-14 02:14:21',0,0),('IDENTIFYTYPECAT','RUC','RUC','2019-11-14 02:14:21','2019-11-14 02:14:21',0,0),('SENTSTATUSCAT','forwarded','Reenviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','forwardedAndAnswered','Reenviado / Contestado','2019-08-03 17:17:36','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sent','Enviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sentAndAnswered','Enviado /Contestado','2019-08-03 17:17:27','2019-05-14 22:00:07',1,1),('SEXCAT','0','Mujer','2019-11-12 21:19:11','2019-11-12 21:19:11',0,0),('SEXCAT','1','Hombre','2019-11-12 21:19:11','2019-11-12 21:19:11',0,0),('STATUSCAT','0','Inactivo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','1','Activo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSFAHPCAT','answered','Respondido','2019-10-02 02:40:25','2019-05-14 22:00:07',1,1),('STATUSFAHPCAT','created','Creado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSFAHPCAT','executed','Ejecutado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSFAHPCAT','sent','Enviado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSRESULTCAT','approved','Aprobado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSRESULTCAT','rejected','No converge','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSSENTFAHPCAT','answered','Respondido','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSSENTFAHPCAT','forwarded','Reenviado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSSENTFAHPCAT','sent','Enviado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','admin','ADMINISTRADOR','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','expert','EXPERTOS','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('VALUEFAHPCAT','1,1,1','Igual Importante ','2019-11-20 00:50:18','2019-11-20 00:50:18',0,0),('VALUEFAHPCAT','1,1,3','Moderadamente Importante que','2019-11-20 00:50:18','2019-11-20 00:50:18',0,0),('VALUEFAHPCAT','1,3,5','Fuertemente Importante que','2019-11-20 00:50:18','2019-11-20 00:50:18',0,0),('VALUEFAHPCAT','5,7,9','Muy fuerte Importante  que ','2019-11-20 00:50:18','2019-11-20 00:50:18',0,0),('VALUEFAHPCAT_beatufull','1,3,4','ss','2019-11-15 23:42:54','2019-11-15 23:42:54',0,0),('VALUEFAHPCAT_RELEVANT','1,1,3','es menos reelevante','2019-11-20 01:29:15','2019-11-20 01:29:15',0,0),('VALUEFAHPCAT_RELEVANT','1,3,5','es igual reelevante','2019-11-20 01:29:15','2019-11-20 01:29:15',0,0),('VALUEFAHPCAT_RELEVANT','3,5,7','es más reelevante','2019-11-20 01:29:15','2019-11-20 01:29:15',0,0),('VALUEFAHPCAT_RELEVANT','5,7,9','es mucho más relevante','2019-11-20 01:29:15','2019-11-20 01:29:15',0,0);
/*!40000 ALTER TABLE `catalogueitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria`
--

DROP TABLE IF EXISTS `criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criteria` (
  `codeCriteria` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameCriteria` varchar(100) NOT NULL,
  `descriptionCriteria` varchar(1000) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeCriteria`),
  UNIQUE KEY `codeCriteria_UNIQUE` (`codeCriteria`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria`
--

LOCK TABLES `criteria` WRITE;
/*!40000 ALTER TABLE `criteria` DISABLE KEYS */;
INSERT INTO `criteria` VALUES (3,'Disponibilidad','concepto de disponiblidad','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(4,'Precio','Ahorro de recursos como dinero','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(5,'Durabilidad ','Tiene una duracion mayor en el tiempo','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(6,'Aspecto','tiene mejor rasgos ','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(7,'Fisico','valor del dinero','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(8,'Storage','Almacenamiento','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(9,'camera','camara','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(10,'looks','el aspecto','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(11,'Gonzalo','impacto Ambiental','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(12,'Grace','Consumo de carbon','2019-11-20 00:52:08','2019-11-20 00:52:08',0,0),(13,'Aidee','Head rate','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(14,'Diana','Costos Totales','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(23,'Tradición y cultura ','El diseño debe identificar la cultura, flora y fauna de la parroquia de NONO ','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(24,'Sencillez','es el elemento de mayor importancia para diferenciarse realizando pruebas interesantes, como: dibujarlo en la arena con facilidad y explicarlo brevemente por correo electrónico o teléfono.','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(25,'Inolvidable','el objetivo de todo creador es obtener un resultado memorable que se recuerde siempre','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(28,'Eficiencia en el desempeño','El grado en que el producto de software proporciona un rendimiento adecuado, en relación con la cantidad de recursos utilizados, bajo las condiciones establecidas','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(29,'Fiabilidad','El grado en que el producto de software puede mantener un nivel específico de rendimiento cuando se utiliza bajo condiciones específicas.','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(30,'Mantenibilidad','El grado en que el producto de software puede ser modificado. Las modificaciones pueden incluir correcciones, mejoras o adaptación del software a los cambios en el entorno, y en los requisitos y especificaciones funcionales','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0),(31,'Seguridad','La protección de los elementos del sistema contra el acceso, uso, modificación, destrucción o divulgación accidentales o malintencionados','2019-11-20 00:52:21','2019-11-20 00:52:21',0,0);
/*!40000 ALTER TABLE `criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteriaMatrixAverageValue`
--

DROP TABLE IF EXISTS `criteriaMatrixAverageValue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criteriaMatrixAverageValue` (
  `codefahp` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `codeCriteriaCouple` bigint(20) NOT NULL,
  `valuecriteriaFAHP` varchar(100) NOT NULL,
  `valuecriteriaFAHPCat` varchar(100) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeCriteria`,`codeCriteriaCouple`),
  KEY `criteriaMatrixAverageValue_criteria_FK_1` (`codeCriteria`),
  KEY `criteriaMatrixAverageValue_catalogueitem_FK` (`valuecriteriaFAHPCat`,`valuecriteriaFAHP`),
  CONSTRAINT `criteriaMatrixAverageValue_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `criteriaMatrixAverageValue_catalogue_FK` FOREIGN KEY (`valuecriteriaFAHPCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `criteriaMatrixAverageValue_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`),
  CONSTRAINT `criteriaMatrixAverageValue_criteria_FK_1` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteriaMatrixAverageValue`
--

LOCK TABLES `criteriaMatrixAverageValue` WRITE;
/*!40000 ALTER TABLE `criteriaMatrixAverageValue` DISABLE KEYS */;
INSERT INTO `criteriaMatrixAverageValue` VALUES (40,11,14,'0.1111111111111111,0.14285714285714285,0.2','VALUEFAHPCAT'),(28,4,3,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(28,5,3,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(28,5,4,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,23,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,25,24,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,11,13,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(40,12,14,'0.2,0.3333333333333333,1.0','VALUEFAHPCAT'),(38,24,23,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,11,12,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,12,13,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(40,13,14,'0.3333333333333333,1.0,1.0','VALUEFAHPCAT'),(28,3,3,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,4,4,'1.0,1.0,1.0','VALUEFAHPCAT'),(28,5,5,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,23,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,24,24,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,25,25,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,11,11,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,11,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,12,12,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,11,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,12,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,13,13,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,11,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,12,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,13,'1.0,1.0,1.0','VALUEFAHPCAT'),(40,14,14,'1.0,1.0,1.0','VALUEFAHPCAT'),(38,23,24,'1.0,1.0,3.0','VALUEFAHPCAT'),(28,3,4,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,3,5,'1.0,3.0,5.0','VALUEFAHPCAT'),(28,4,5,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,23,25,'1.0,3.0,5.0','VALUEFAHPCAT'),(38,24,25,'1.0,3.0,5.0','VALUEFAHPCAT');
/*!40000 ALTER TABLE `criteriaMatrixAverageValue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteriaMatrixValue`
--

DROP TABLE IF EXISTS `criteriaMatrixValue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criteriaMatrixValue` (
  `codefahp` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `codeCriteriaCouple` bigint(20) NOT NULL,
  `valuecriteriaFAHP` varchar(100) NOT NULL,
  `valuecriteriaFAHPCat` varchar(100) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codePerson`,`codeCriteria`,`codeCriteriaCouple`),
  KEY `criteriaMatrixValue_Person_FK` (`codePerson`),
  KEY `criteriaMatrixValue_criteria_FK_1` (`codeCriteria`),
  KEY `criteriaMatrixValue_catalogueitem_FK` (`valuecriteriaFAHPCat`,`valuecriteriaFAHP`),
  CONSTRAINT `criteriaMatrixValue_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `criteriaMatrixValue_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `criteriaMatrixValue_catalogue_FK` FOREIGN KEY (`valuecriteriaFAHPCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `criteriaMatrixValue_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`),
  CONSTRAINT `criteriaMatrixValue_criteria_FK_1` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteriaMatrixValue`
--

LOCK TABLES `criteriaMatrixValue` WRITE;
/*!40000 ALTER TABLE `criteriaMatrixValue` DISABLE KEYS */;
INSERT INTO `criteriaMatrixValue` VALUES (28,1,3,3,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,4,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,3,5,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,3,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,4,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,4,5,'1,3,5','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,3,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,4,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(28,1,5,5,'1','VALUEFAHPCAT','2019-11-07 22:31:33','2019-11-07 22:31:33',0,0),(38,3,23,23,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,24,'1,1,3','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,23,25,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,23,'1/3, 1/1, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,24,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,24,25,'1,3,5','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,23,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,24,'1/5, 1/3, 1/1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(38,3,25,25,'1','VALUEFAHPCAT','2019-11-16 22:43:13','2019-11-16 22:43:13',0,0),(40,1,11,11,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,12,'1/3,1/1,1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,13,'1/5,1/3,1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,11,14,'1/9,1/7,1/5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,11,'1/1/1, 1/1/1, 1/1/3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,12,'1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,13,'1/3,1/1,1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,12,14,'1/5,1/3,1/1','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,11,'1/1/1, 1/1/3, 1/1/5','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,12,'1/1/1, 1/1/1, 1/1/3','VALUEFAHPCAT','2019-11-20 01:20:49','2019-11-20 01:20:49',0,0),(40,1,13,13,'1','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0),(40,1,13,14,'1/3,1/1,1/1','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0),(40,1,14,11,'1/1/5, 1/1/7, 1/1/9','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0),(40,1,14,12,'1/1/1, 1/1/3, 1/1/5','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0),(40,1,14,13,'1/1/1, 1/1/1, 1/1/3','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0),(40,1,14,14,'1','VALUEFAHPCAT','2019-11-20 01:20:50','2019-11-20 01:20:50',0,0);
/*!40000 ALTER TABLE `criteriaMatrixValue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteriabycodefahp`
--

DROP TABLE IF EXISTS `criteriabycodefahp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criteriabycodefahp` (
  `codefahp` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeCriteria`),
  KEY `criteriabycodefahp_criteria_FK` (`codeCriteria`),
  CONSTRAINT `criteriabycodefahp_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `criteriabycodefahp_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteriabycodefahp`
--

LOCK TABLES `criteriabycodefahp` WRITE;
/*!40000 ALTER TABLE `criteriabycodefahp` DISABLE KEYS */;
INSERT INTO `criteriabycodefahp` VALUES (28,3,'2019-11-07 22:17:42','2019-11-07 22:17:42',0,0),(28,4,'2019-11-07 22:17:42','2019-11-07 22:17:42',0,0),(28,5,'2019-11-07 22:17:42','2019-11-07 22:17:42',0,0),(38,23,'2019-11-16 22:37:58','2019-11-16 22:37:58',0,0),(38,24,'2019-11-16 22:37:58','2019-11-16 22:37:58',0,0),(38,25,'2019-11-16 22:37:58','2019-11-16 22:37:58',0,0),(39,28,'2019-11-19 20:55:13','2019-11-19 20:55:13',0,0),(39,29,'2019-11-19 20:55:13','2019-11-19 20:55:13',0,0),(39,30,'2019-11-19 20:55:13','2019-11-19 20:55:13',0,0),(39,31,'2019-11-19 20:55:13','2019-11-19 20:55:13',0,0),(40,11,'2019-11-19 21:48:53','2019-11-19 21:48:53',0,0),(40,12,'2019-11-19 21:48:53','2019-11-19 21:48:53',0,0),(40,13,'2019-11-19 21:48:53','2019-11-19 21:48:53',0,0),(40,14,'2019-11-19 21:48:53','2019-11-19 21:48:53',0,0);
/*!40000 ALTER TABLE `criteriabycodefahp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `environment`
--

DROP TABLE IF EXISTS `environment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `environment` (
  `uri` varchar(100) NOT NULL,
  `typeenvironment` varchar(100) NOT NULL,
  `placeofuse` varchar(100) NOT NULL,
  PRIMARY KEY (`uri`,`typeenvironment`,`placeofuse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla que contiene las urls de front y back';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `environment`
--

LOCK TABLES `environment` WRITE;
/*!40000 ALTER TABLE `environment` DISABLE KEYS */;
INSERT INTO `environment` VALUES ('/home/david/Documentos/tesis/front/FuzzySystem-Frontend/src/assets/imagenesItems','backend','pathImageItem'),('http://localhost:4200/client/fahp','frontend','fahpclient'),('http://localhost:4200/client/quizclient','frontend','quizclient');
/*!40000 ALTER TABLE `environment` ENABLE KEYS */;
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
INSERT INTO `itemComment` VALUES (39,1,1,1,1,'hola','2019-11-16 04:43:44','2019-11-16 04:43:44',0,0),(74,15,21,1,2,'hola como estas','2019-11-16 18:03:04','2019-11-16 18:03:04',0,0),(75,15,21,1,2,'hhh','2019-11-16 18:03:43','2019-11-16 18:03:43',0,0),(76,15,21,1,2,'hhh','2019-11-16 18:05:40','2019-11-16 18:05:40',0,0),(77,15,21,1,2,'mmm','2019-11-16 18:05:49','2019-11-16 18:05:49',0,0);
/*!40000 ALTER TABLE `itemComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processFahpatributebycriteria`
--

DROP TABLE IF EXISTS `processFahpatributebycriteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processFahpatributebycriteria` (
  `codefahp` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `weight` decimal(30,8) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeQuiz`,`codeQuestions`,`codeQuizItem`,`codeCriteria`),
  KEY `processFahpatributebycriteria_Quiz_FK` (`codeQuiz`),
  KEY `processFahpatributebycriteria_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `processFahpatributebycriteria_criteria_FK` (`codeCriteria`),
  KEY `processFahpatributebycriteria_QuestionItem_FK` (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  CONSTRAINT `processFahpatributebycriteria_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `processFahpatributebycriteria_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `processFahpatributebycriteria_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `processFahpatributebycriteria_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`),
  CONSTRAINT `processFahpatributebycriteria_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processFahpatributebycriteria`
--

LOCK TABLES `processFahpatributebycriteria` WRITE;
/*!40000 ALTER TABLE `processFahpatributebycriteria` DISABLE KEYS */;
INSERT INTO `processFahpatributebycriteria` VALUES (28,1,1,2,3,0.62623895,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,2,4,0.69242362,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,2,5,0.69242362,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,3,3,0.22214893,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,3,4,0.19873471,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,3,5,0.19873471,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,39,3,0.15161212,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,39,4,0.10884167,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,39,5,0.10884167,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(38,21,15,74,23,0.39521176,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,74,24,0.39102955,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,74,25,0.44058757,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,75,23,0.28801474,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,75,24,0.28509264,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,75,25,0.24312994,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,76,23,0.18334111,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,76,24,0.20794804,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,76,25,0.20333902,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,77,23,0.13343239,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,77,24,0.11592978,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,77,25,0.11294347,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(40,31,17,84,11,0.36112136,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,84,12,0.18960577,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,84,13,0.36274545,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,84,14,0.36234699,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,85,11,0.26221645,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,85,12,0.31938426,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,85,13,0.23320128,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,85,14,0.26255890,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,86,11,0.21779216,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,86,12,0.37661089,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,86,13,0.21895287,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,86,14,0.20101440,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,87,11,0.15887002,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,87,12,0.11439908,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,87,13,0.18510040,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,87,14,0.17407971,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0);
/*!40000 ALTER TABLE `processFahpatributebycriteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processFahpconsistencybycriteria`
--

DROP TABLE IF EXISTS `processFahpconsistencybycriteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processFahpconsistencybycriteria` (
  `codefahp` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `indexConsistency` decimal(30,8) NOT NULL,
  `ratioConsistency` decimal(30,8) NOT NULL,
  `consistency` decimal(30,8) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codePerson`),
  KEY `processFahpconsistencybycriteria_Person_FK` (`codePerson`),
  CONSTRAINT `processFahpconsistencybycriteria_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `processFahpconsistencybycriteria_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processFahpconsistencybycriteria`
--

LOCK TABLES `processFahpconsistencybycriteria` WRITE;
/*!40000 ALTER TABLE `processFahpconsistencybycriteria` DISABLE KEYS */;
INSERT INTO `processFahpconsistencybycriteria` VALUES (28,1,0.28528343,54.86219744,3.57056685,'2019-11-07 22:32:09','2019-11-07 22:32:09',0,0),(38,3,0.20826442,40.05085069,3.41652885,'2019-11-16 23:15:49','2019-11-16 23:15:49',0,0),(40,1,-0.26333635,-29.58835447,3.20999094,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0);
/*!40000 ALTER TABLE `processFahpconsistencybycriteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processFahpweightbycriteria`
--

DROP TABLE IF EXISTS `processFahpweightbycriteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processFahpweightbycriteria` (
  `codefahp` bigint(20) NOT NULL,
  `codeCriteria` bigint(20) NOT NULL,
  `weight` decimal(30,8) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeCriteria`),
  KEY `processFahpweightbycriteria_criteria_FK` (`codeCriteria`),
  CONSTRAINT `processFahpweightbycriteria_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `processFahpweightbycriteria_criteria_FK` FOREIGN KEY (`codeCriteria`) REFERENCES `criteria` (`codeCriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processFahpweightbycriteria`
--

LOCK TABLES `processFahpweightbycriteria` WRITE;
/*!40000 ALTER TABLE `processFahpweightbycriteria` DISABLE KEYS */;
INSERT INTO `processFahpweightbycriteria` VALUES (28,3,54.30197869,'2019-11-07 22:32:09','2019-11-07 22:32:09',0,0),(28,4,29.51495164,'2019-11-07 22:32:09','2019-11-07 22:32:09',0,0),(28,5,16.18306966,'2019-11-07 22:32:09','2019-11-07 22:32:09',0,0),(38,23,46.45477219,'2019-11-16 23:15:49','2019-11-16 23:15:49',0,0),(38,24,36.80400967,'2019-11-16 23:15:49','2019-11-16 23:15:49',0,0),(38,25,16.74121814,'2019-11-16 23:15:49','2019-11-16 23:15:49',0,0),(40,11,14.71083399,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,12,23.54738320,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,13,29.36252620,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,14,32.37925660,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0);
/*!40000 ALTER TABLE `processFahpweightbycriteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultFAHP`
--

DROP TABLE IF EXISTS `resultFAHP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultFAHP` (
  `codefahp` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `codeQuizItem` bigint(20) NOT NULL,
  `weight` decimal(30,8) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeQuiz`,`codeQuestions`,`codeQuizItem`),
  KEY `resultFAHP_Quiz_FK` (`codeQuiz`),
  KEY `resultFAHP_Questions_FK` (`codeQuestions`,`codeQuiz`),
  KEY `resultFAHP_QuestionItem_FK` (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  CONSTRAINT `resultFAHP_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `resultFAHP_QuestionItem_FK` FOREIGN KEY (`codeQuizItem`, `codeQuestions`, `codeQuiz`) REFERENCES `QuestionItem` (`codeQuizItem`, `codeQuestions`, `codeQuiz`),
  CONSTRAINT `resultFAHP_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `resultFAHP_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultFAHP`
--

LOCK TABLES `resultFAHP` WRITE;
/*!40000 ALTER TABLE `resultFAHP` DISABLE KEYS */;
INSERT INTO `resultFAHP` VALUES (28,1,1,2,65.64840347,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,3,21.14490931,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(28,1,1,39,13.20668723,'2019-11-07 22:32:10','2019-11-07 22:32:10',0,0),(38,21,15,74,40.12690005,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,75,27.94250268,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,76,19.57453416,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(38,21,15,77,12.35606310,'2019-11-16 23:15:50','2019-11-16 23:15:50',0,0),(40,31,17,84,32.16076501,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,85,26.72692692,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,86,25.00981157,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0),(40,31,17,87,16.10249650,'2019-11-20 01:21:08','2019-11-20 01:21:08',0,0);
/*!40000 ALTER TABLE `resultFAHP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sentemailbycodefahp`
--

DROP TABLE IF EXISTS `sentemailbycodefahp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sentemailbycodefahp` (
  `codefahp` bigint(20) NOT NULL,
  `codePerson` bigint(20) NOT NULL,
  `statussentfahpCat` varchar(100) NOT NULL,
  `statussentfahp` varchar(100) NOT NULL,
  `token` varchar(1000) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codePerson`),
  KEY `sentemailbycodefahp_Person_FK` (`codePerson`),
  KEY `sentemailbycodefahp_catalogueitem_FK` (`statussentfahpCat`,`statussentfahp`),
  CONSTRAINT `sentemailbycodefahp_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `sentemailbycodefahp_Person_FK` FOREIGN KEY (`codePerson`) REFERENCES `Person` (`codePerson`),
  CONSTRAINT `sentemailbycodefahp_catalogue_FK` FOREIGN KEY (`statussentfahpCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `sentemailbycodefahp_catalogueitem_FK` FOREIGN KEY (`statussentfahpCat`, `statussentfahp`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sentemailbycodefahp`
--

LOCK TABLES `sentemailbycodefahp` WRITE;
/*!40000 ALTER TABLE `sentemailbycodefahp` DISABLE KEYS */;
INSERT INTO `sentemailbycodefahp` VALUES (28,1,'STATUSSENTFAHPCAT','answered','','2019-11-07 22:30:57','2019-11-07 22:31:33',0,0),(38,1,'STATUSSENTFAHPCAT','sent','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6eUFuYWx5dGljSGllcmFyY2h5UHJvY2VzcyIsImlhdCI6MTU3Mzk1NTA4OSwiZXhwIjozMTQ4NTE0OTc4LCJjb2RlcGVyc29uIjoxLCJjb2RlZmFocCI6Mzh9.F0ergyhbaNXn1xO-58qZTTdP5gVZZaK3hWKNtG2OFyA','2019-11-17 01:44:49','2019-11-17 01:44:49',0,0),(38,3,'STATUSSENTFAHPCAT','answered','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6eUFuYWx5dGljSGllcmFyY2h5UHJvY2VzcyIsImlhdCI6MTU3Mzk0Mzg5NCwiZXhwIjozMTQ4NDkyNTg5LCJjb2RlcGVyc29uIjozLCJjb2RlZmFocCI6Mzh9.YY1VxzgVbttwW53A67EBZCTzHQtDWhDngnwYwPImXMo','2019-11-16 22:38:15','2019-11-16 22:43:13',0,0),(39,1,'STATUSSENTFAHPCAT','sent','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6eUFuYWx5dGljSGllcmFyY2h5UHJvY2VzcyIsImlhdCI6MTU3NDE5NzA5NywiZXhwIjozMTQ4OTk4OTk0LCJjb2RlcGVyc29uIjoxLCJjb2RlZmFocCI6Mzl9.ZYRC2HfpkNSHTOQUg7E1yMlUau2uqsGVxQkL-6KiqsQ','2019-11-19 20:58:17','2019-11-19 20:58:17',0,0),(40,1,'STATUSSENTFAHPCAT','answered','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6eUFuYWx5dGljSGllcmFyY2h5UHJvY2VzcyIsImlhdCI6MTU3NDIwMDI4NywiZXhwIjozMTQ5MDA1Mzc1LCJjb2RlcGVyc29uIjoxLCJjb2RlZmFocCI6NDB9.3uP225N8wVFvRCUxD3eZTjjPZj40xWMJMdNcikL748I','2019-11-19 21:51:27','2019-11-19 21:57:25',0,0);
/*!40000 ALTER TABLE `sentemailbycodefahp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveybycodefahp`
--

DROP TABLE IF EXISTS `surveybycodefahp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surveybycodefahp` (
  `codefahp` bigint(20) NOT NULL,
  `codeQuiz` bigint(20) NOT NULL,
  `codeQuestions` bigint(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codefahp`,`codeQuiz`,`codeQuestions`),
  KEY `surveybycodefahp_Quiz_FK` (`codeQuiz`),
  KEY `surveybycodefahp_Questions_FK` (`codeQuestions`,`codeQuiz`),
  CONSTRAINT `surveybycodefahp_FAHP_FK` FOREIGN KEY (`codefahp`) REFERENCES `FAHP` (`codefahp`),
  CONSTRAINT `surveybycodefahp_Questions_FK` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `surveybycodefahp_Quiz_FK` FOREIGN KEY (`codeQuiz`) REFERENCES `Quiz` (`codeQuiz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveybycodefahp`
--

LOCK TABLES `surveybycodefahp` WRITE;
/*!40000 ALTER TABLE `surveybycodefahp` DISABLE KEYS */;
INSERT INTO `surveybycodefahp` VALUES (28,1,1,'2019-11-07 22:17:42','2019-11-07 22:17:42',0,0),(38,21,15,'2019-11-16 22:37:58','2019-11-16 22:37:58',0,0),(39,30,16,'2019-11-19 20:55:13','2019-11-19 20:55:13',0,0),(40,31,17,'2019-11-19 21:48:53','2019-11-19 21:48:53',0,0);
/*!40000 ALTER TABLE `surveybycodefahp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 22:09:54
