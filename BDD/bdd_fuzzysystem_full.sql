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
INSERT INTO `DelphiCalculations` VALUES (14,13,43,1,25.00000000,44.85488054,85.00000000,51.61829351,70.00000000,37.22222222,46.11111111,57.77777778,0,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1),(14,13,44,1,30.00000000,64.33931758,95.00000000,63.11310586,70.00000000,48.33333333,65.00000000,80.55555556,1,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1),(14,13,45,1,30.00000000,66.46076641,100.00000000,65.48692214,70.00000000,57.22222222,67.77777778,87.22222222,1,0,'STATUSRESULTCAT','rejected','2019-09-03 22:26:28','2019-09-03 22:26:28',1,1);
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
  `bibliography` varchar(1000) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,NULL,'TYPEPERSONCAT','expert','IDENTIFYTYPECAT',NULL,'ACADEMICDEGREECAT','Postgrados','Jose Miguel','Pérez','Jose Miguel Pérez','byron.lopez.begins@gmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Eléctrica','0987654321','bibliografia es ...','2019-09-08 22:01:39','2019-09-08 22:01:39',1,1),(2,'987654314','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Alejandra Lisbeth','Mosquera','Brandom','byron.lopez.begins@gmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Física',NULL,'test test ','2019-08-14 22:22:24','2019-09-03 21:45:48',0,0),(3,'9517538647','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Vladímir Vladímirovich','Putin','Miguel','byron.lopez.begins@gmail.com','Russia','1969-12-31','STATUSCAT','1','SEXCAT','1','Jurisprudencia',NULL,'test test test','2019-08-19 15:24:08','2019-09-03 21:45:48',0,0),(4,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Gonzalo david','proaño chicaiza','Gonzalo david proaño chicaiza','byron.lopez.begins@gmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Área de computación',NULL,'leyenda','2019-09-07 23:56:44','2019-09-07 23:56:44',0,0),(5,'1234567987','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','José Miguel','Pérez','Manuel','byron.lopez.begins@gmail.com','Ecuador','1969-12-31','STATUSCAT','1','SEXCAT','1','electrónica',NULL,'bibliografia es ...','2019-09-02 19:52:04','2019-09-03 21:45:48',0,0),(6,'987654314','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Alejandra Lisbeth','Mosquera','Richard','byron.lopez.begins@gmail.com','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Física',NULL,'test test ','2019-08-14 22:22:24','2019-09-03 21:45:48',0,0),(7,'9517538647','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Vladímir Vladímirovich','Putin','Patricio','byron.lopez.begins@gmail.com','Russia','1969-12-31','STATUSCAT','1','SEXCAT','1','Jurisprudencia',NULL,'test test test','2019-08-19 15:24:08','2019-09-03 21:45:48',0,0),(8,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Rosa','proaño chicaiza','David','byron.lopez.begins@gmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Area de computacionn',NULL,'leyenda','2019-08-19 18:29:16','2019-09-03 21:45:48',0,0),(9,'1723353404','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Jenny ','Pavón','Jenny','byron.lopez.begins@gmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','0','Area de computacionn',NULL,'leyenda','2019-08-19 18:29:16','2019-09-09 00:37:04',0,0),(10,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Gonzalo','epn','Gonzalo epn','byron.lopez.begins@gmail.com','ECuador','2018-09-04','STATUSCAT','1','SEXCAT','1','compuatacion',NULL,'brou','2019-08-19 06:02:07','2019-09-03 21:42:12',0,0),(11,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Byron','Lopez','Byron Lopez','davidgonzalomejia@gmail.com','Ecuador','2019-08-07','STATUSCAT','1','SEXCAT','1','area humana',NULL,NULL,'2019-09-02 21:05:46','2019-09-02 21:05:46',0,0);
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
  PRIMARY KEY (`codeQuizItem`,`codeQuestions`,`codeQuiz`),
  UNIQUE KEY `codeQuizItem_UNIQUE` (`codeQuizItem`),
  KEY `QuestionItem_Questions_FK` (`codeQuestions`),
  KEY `QuestionItem_Questions_FK1` (`codeQuestions`,`codeQuiz`),
  KEY `QuestionItem_catalogueitem_FK` (`statusCat`,`status`),
  CONSTRAINT `QuestionItem_Questions_FK1` FOREIGN KEY (`codeQuestions`, `codeQuiz`) REFERENCES `Questions` (`codeQuestions`, `codeQuiz`),
  CONSTRAINT `QuestionItem_catalogue_FK` FOREIGN KEY (`statusCat`) REFERENCES `catalogue` (`code`),
  CONSTRAINT `QuestionItem_catalogueitem_FK` FOREIGN KEY (`statusCat`, `status`) REFERENCES `catalogueitem` (`codeCatalogue`, `codeItem`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QuestionItem`
--

LOCK TABLES `QuestionItem` WRITE;
/*!40000 ALTER TABLE `QuestionItem` DISABLE KEYS */;
INSERT INTO `QuestionItem` VALUES (2,1,1,'Brasióáíúóí?óíú',NULL,'pais de la gartotas',NULL,'STATUSCAT','0','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(3,1,1,'Colombia',NULL,'pais de cafe',NULL,'STATUSCAT','0','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(11,10,10,'UNIDAD ORGANIZATIVAS','Académico','Datos sobre Facultades, Institutos, CAMBIAME TAMANO COLUMN',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(12,10,10,'TITULACIONES','Académico','Se refiere a las carre',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(13,10,10,'ESTUDIANTES','Académico','Alumnos matriculados.',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(14,10,10,'SEGUIMIENTO DE EGRESADOS','Académico','Alumnos egresados.',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(15,10,10,'DOCENTES','Académico','Docentes que se encuentran con contrato.',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(16,10,10,'NUEVO ITEM','Académico','ITEM DESCRIPTION',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(17,11,10,'SEGUIMIENTO DE EGRESADOS',NULL,'Alumnos egresados.',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(18,11,10,'DOCENTES',NULL,'Docentes que se encuentran con contrato.',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(19,11,10,'NUEVO ITEM',NULL,'ITEM DESCRIPTION',NULL,'STATUSCAT','1','2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(23,4,1,'Brasil',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(24,4,1,'Argentina',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(25,4,1,'Uruguay',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(26,5,1,'Venezuela',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(27,5,1,'Ecuador',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(36,3,1,'Estadio chucho benites',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(37,3,1,'Estadio Aucas',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(38,3,1,'Maracaná',NULL,NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(39,1,1,'Alemania',NULL,'pais de hitler',NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(40,12,13,'Azul',NULL,'Color del mar',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1),(41,12,13,'Rojo',NULL,'Color de la sangre',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1),(42,12,13,'Amarillo ',NULL,'color del sol',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1),(43,13,14,'DATOS DE SENSORES',NULL,'Datos de sensores ubicados en las dependencias, controles, equipos, registros, Wifi, cÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¡maras, accesos.',NULL,'STATUSCAT','1','2019-09-03 22:23:10','2019-09-03 22:23:10',1,1),(44,13,14,'UNIDAD ORGANIZATIVAS',NULL,'Datos sobre Facultades, Institutos, Centros y Departamentos AcadÃƒÂ©micos, Administrativos y de InvestigaciÃƒÂ³n.',NULL,'STATUSCAT','1','2019-09-03 22:23:10','2019-09-03 22:23:10',1,1),(45,13,14,'TITULACIONES',NULL,'Se refiere a las carreras que proporciona, sus asignaturas, plan de estudios.',NULL,'STATUSCAT','1','2019-09-03 22:23:10','2019-09-03 22:23:10',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questions`
--

LOCK TABLES `Questions` WRITE;
/*!40000 ALTER TABLE `Questions` DISABLE KEYS */;
INSERT INTO `Questions` VALUES (1,1,'cual es el ganadador de la copa america en el 2024','Acerca de la copa américa que se realizara en ecuador en 2024','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,2.00000000,NULL,NULL),(3,1,'Cuántas sedes tiene esta Copa América','sedes de la copa america','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,3.00000000,NULL,NULL),(4,1,'Quiénes son los máximos ganadores del título','maximos ganadores del titulo','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,4.00000000,NULL,NULL),(5,1,'Cuáles son las dos selecciones que nunca salieron campeonas','Nunca han ganado la copa america','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,5.00000000,NULL,NULL),(10,10,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','5','100','5',NULL,'2019-09-09 16:00:58','2019-09-09 16:00:58',0,0,70.00000000,NULL,NULL),(11,10,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','5','100','5',NULL,'2019-09-09 16:00:58','2019-09-09 16:00:58',0,0,80.00000000,NULL,NULL),(12,13,'cual es el color mas bonito poner unas cosas para que se llenen entonces colocamos el valor de los delphi ddddddd  ddddddd  ddddddd   dddddddddd ddddddd  dddddddddddd dddddddd ddddddd ddddddd','colores de elegancia','STATUSCAT','1','1','100','5',NULL,'2019-08-19 23:50:51','2019-08-19 23:50:51',0,0,70.00000000,0,0),(13,14,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','0','100','5',NULL,'2019-09-03 22:23:10','2019-09-06 03:42:46',0,0,70.00000000,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quiz`
--

LOCK TABLES `Quiz` WRITE;
/*!40000 ALTER TABLE `Quiz` DISABLE KEYS */;
INSERT INTO `Quiz` VALUES (1,'Pronostico del equipo ganador en la copa america','MEJOR EQUIPO PARA GANAR LA COPA AMERICA','Equipo posible ganador de la copa américa.\n','STATUSCAT','1',NULL,7.00000000,'2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(10,'Considering reusers when selecting datasets to open: a case of study from universities','Investigación de Datos Abiertos','<div>Gracias por dedicar unos minutos a completar esta encuesta, usted ha sido escogido por su experiencia en datos abiertos y la informaci&#243;n que nos proporcione ser&#225; muy &#250;til para la investigaci&#243;n sobre el conjunto de datos que se deber&#237;a abrir en la universidad ecuatoriana.<div><br></div><div>Para la investigaci&#243;n vamos a utilizar una metodolog&#237;a llamada <b>Delphi Difuso</b> que consiste en llegar a consensos con los participantes sobre sus criterios, por tanto podr&#237;amos requerir de su colaboraci&#243;n una o dos veces adicionales. Sus respuestas ser&#225;n tratadas de forma confidencial y ser&#225;n utilizadas para la investigaci&#243;n llevada a cabo entre la Universidad Central del Ecuador y La Universidad de Alicante en Espa&#241;a sobre la l&#237;nea de Datos Abiertos.&#160;</div><div><br></div><div>Esta encuesta dura aproximadamente <font color=\"#8000ff\">20 minutos</font>.&#160;</div><div><span>La fecha l&#237;mite para realizar esta encuesta es una semana luego de que le llegue este correo.</span></div></div>','STATUSCAT','1',NULL,70.00000000,'2019-09-09 16:00:58','2019-09-09 16:00:58',1,1),(13,'Encuesta de colores','Encuesta de colores ','los colores son chevres','STATUSCAT','1',NULL,7.00000000,'2019-09-02 20:47:28','2019-09-02 20:47:28',1,1),(14,'Considering reusers when selecting datasets to open: a case of study from universities','Investigación de Datos Abiertos','Gracias por dedicar unos minutos a completar esta encuesta, usted ha sido escogido por su experiencia','STATUSCAT','1',NULL,70.00000000,'2019-09-09 15:12:19','2019-09-09 15:12:19',1,1);
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
INSERT INTO `Quizvalues` VALUES (1,1,14,13,43,'25','30','35',10,1,15,-5,0,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,1,14,13,44,'60','70','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,1,14,13,45,'75','85','90',60,1,19,41,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,14,13,43,'35','40','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,14,13,44,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,2,14,13,45,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,14,13,43,'25','35','45',20,1,10,10,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,14,13,44,'80','85','95',65,1,21,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,3,14,13,45,'80','85','95',65,1,19,46,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,14,13,43,'35','40','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,14,13,44,'45','60','70',40,1,4,36,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,4,14,13,45,'30','50','100',70,1,16,54,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,14,13,43,'35','50','65',40,1,5,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,14,13,44,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,5,14,13,45,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,14,13,43,'35','50','65',40,1,5,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,14,13,44,'30','60','90',60,1,4,56,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,6,14,13,45,'60','65','75',45,1,1,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,7,14,13,43,'45','50','55',30,1,5,25,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,7,14,13,44,'65','70','75',45,1,6,39,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,7,14,13,45,'80','85','90',60,1,19,41,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,43,'40','50','60',35,1,5,30,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,44,'50','70','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,8,14,13,45,'50','60','80',50,1,6,44,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,14,13,43,'60','70','85',60,1,25,35,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,14,13,44,'30','50','75',45,1,14,31,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0),(1,9,14,13,45,'50','65','80',50,1,1,49,1,NULL,NULL,'2019-09-03 22:26:28','2019-09-03 22:26:28',0,0);
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
INSERT INTO `Rounds` VALUES (1,14,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzUwMSwiZXhwIjozMTM1Njk5ODAyLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoxfQ.iRxXep3hUoI0jDNnUNPU5ZzaooX6BzziCTi8M0DA3LI','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:41','2019-09-03 22:00:01',0,0),(1,14,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5OSwiZXhwIjozMTM1Njk5Nzk4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjoyfQ.eWeed0I70LpXkXFMeKIaIVrJcklYTyyR5TR0CshXbnk','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:39','2019-09-03 22:00:25',0,0),(1,14,3,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5NiwiZXhwIjozMTM1Njk5NzkyLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjozfQ.5dmyKG_lmCDWwv9U5ie2KdJAndBOMwS_IvFWCUpD-oI','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:36','2019-09-03 22:00:47',0,0),(1,14,4,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5NCwiZXhwIjozMTM1Njk5Nzg4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo0fQ.-izb7AokvwxmA7F0Sy6iJIQoR9lGOkT-2yUxW9lK4Lo','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:34','2019-09-03 22:01:10',0,0),(1,14,5,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ5MSwiZXhwIjozMTM1Njk5NzgzLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo1fQ.QpwIPw_xk28O1msCK6agZNzi8TqZMfiK3YmUDiP46Oo','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:31','2019-09-03 22:01:36',0,0),(1,14,6,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4OSwiZXhwIjozMTM1Njk5Nzc4LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo2fQ.OcytIYS6e5dIkDi4yJU6Kyy6_yNDTZyWlTXn78eCfWQ','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:29','2019-09-03 22:01:52',0,0),(1,14,7,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4NiwiZXhwIjozMTM1Njk5NzczLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo3fQ.aa8Yg8oGFQlFHAsvw5ECZbWuaQnJnRC9juEoS_iMLNw','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:26','2019-09-03 22:02:11',0,0),(1,14,8,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ4MywiZXhwIjozMTM1Njk5NzY3LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo4fQ.hgqAmBkVTUvvPpApp-hjPgg-HzCbYrhkMlVimKrNTkg','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:23','2019-09-03 22:02:27',0,0),(1,14,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0NzQ3OSwiZXhwIjozMTM1Njk5NzU5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo5fQ.K7FT24Z9UgvnOZpTaG_f1KLdk7MrTwVQ7HV3x3D0Z8w','SENTSTATUSCAT','sentAndAnswered','2019-09-03 21:51:19','2019-09-03 21:57:24',0,0),(2,14,1,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2ODA0MTkzOSwiZXhwIjozMTM2Njg4Njc5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjoxfQ.I9GwmmMw1hVCsqsnvKyRziNLz7HgsVQzFDvTYikJFSM','SENTSTATUSCAT','forwarded','2019-09-09 15:12:19','2019-09-09 15:12:19',0,0),(2,14,2,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTczNywiZXhwIjozMTM1NzA0Mjc1LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjoyfQ.4L49pS_tAoP3NOcta5IVHoW8MLzzBqpnPnR3vjjnpkA','SENTSTATUSCAT','sent','2019-09-03 22:28:57','2019-09-03 22:28:57',0,0),(2,14,3,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0MywiZXhwIjozMTM1NzA0Mjg2LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjozfQ.rJ6VEwEpwN3C8almhuObtG-9WXXRoRBS19FF9yM6DnU','SENTSTATUSCAT','sent','2019-09-03 22:29:03','2019-09-03 22:29:03',0,0),(2,14,4,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0MCwiZXhwIjozMTM1NzA0MjgxLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo0fQ.N5LaoxKknnQFG4HVsGls25V8VNcF2Y2CWCLjXNpSjEo','SENTSTATUSCAT','sent','2019-09-03 22:29:00','2019-09-03 22:29:00',0,0),(2,14,5,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0NSwiZXhwIjozMTM1NzA0MjkwLCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo1fQ.UVrnMIwz5AqfZ650R_BGZoHEOiwzhff3JmasbV919kY','SENTSTATUSCAT','sent','2019-09-03 22:29:05','2019-09-03 22:29:05',0,0),(2,14,6,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0NywiZXhwIjozMTM1NzA0Mjk1LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo2fQ.gVMQQ8UYF9ZaPKtyt6aBV4bu9xoh7qTn7uuUm7OAwsE','SENTSTATUSCAT','sent','2019-09-03 22:29:07','2019-09-03 22:29:07',0,0),(2,14,7,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc0OSwiZXhwIjozMTM1NzA0Mjk5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo3fQ._zsbSAWLjyEIcmGrMjdOd3CvXgPsxqy9RUfJBXasVZg','SENTSTATUSCAT','sent','2019-09-03 22:29:09','2019-09-03 22:29:09',0,0),(2,14,8,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc1MiwiZXhwIjozMTM1NzA0MzA0LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo4fQ.Ym6r43z1xCRMlyUAqaCeJiLc0kKRjxmwS4931tYhBa8','SENTSTATUSCAT','sent','2019-09-03 22:29:12','2019-09-03 22:29:12',0,0),(2,14,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzU0OTc1NCwiZXhwIjozMTM1NzA0MzA5LCJjb2RlUXVpeiI6MTQsInJvdW5kTnVtYmVyIjoyLCJjb2RlUGVyc29uIjo5fQ.DJkXtM7bc4imSdX_WAzHTFrJEjSMjnpKnMy8xoL3MVY','SENTSTATUSCAT','sent','2019-09-03 22:29:14','2019-09-03 22:29:14',0,0);
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
  `dateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateLastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userCreate` bigint(20) NOT NULL,
  `userLastModify` bigint(20) NOT NULL,
  PRIMARY KEY (`codeuser`,`email`,`username`),
  UNIQUE KEY `codeuser_UNIQUE` (`codeuser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'davidgonzalomejia@hotmail.com','elpapidelasnenas#summer','davidgonzalomejia@gmail.com','chS1I5CEjEekYCWFqBJr5g==',NULL,'2019-08-19 03:17:06','2019-08-20 20:35:02',1,1),(2,'davidgonzalomejia@gmail.com','Juanito','davidgonzalomejia@gmail.com','/UbhuM/HpBIJzFjn+NXXBg==',NULL,'2019-08-19 17:54:08','2019-08-19 18:11:52',1,1),(4,'byron@epn.edu.ec','Byron','byron@epn.edu.ec','yJzDaB0vwaCn1ypAC4ymNw==',NULL,'2019-08-21 16:47:12','2019-09-06 02:56:58',1,1),(7,'gonzalo.proano@epn.edu.ec','david','gonzalo.proano@epn.edu.ec','duL5bvMpezqMSw30EqclZQ==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU2NzQ1MzgzOSwiZXhwIjozMTM1NTEyNDc5LCJlbWFpbCI6ImdvbnphbG8ucHJvYW5vQGVwbi5lZHUuZWMifQ.wZ89RcazFj3se-zw-6h5i12UtPOxup8Xd9n4U6xf5As','2019-09-02 19:50:19','2019-09-02 19:50:39',1,1),(8,'byron@gmail.com','Byron López Chávez','byron@gmail.com','yJzDaB0vwaCn1ypAC4ymNw==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU2Nzk3NDAyNSwiZXhwIjozMTM2NTUyODUxLCJlbWFpbCI6ImJ5cm9uQGdtYWlsLmNvbSJ9.WBRpCNfSPtR-8VUPBxO0pufc3gWKQ3Te5jQa2LZUbzA','2019-09-06 02:57:26','2019-09-08 20:20:25',1,1);
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
INSERT INTO `catalogue` VALUES ('ACADEMICDEGREECAT','ACADEMICDEGREECAT','Grado de educación de una persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('IDENTIFYTYPECAT','IDENTIFYTYPECAT','tipo de tipo identificaciones','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SENTSTATUSCAT','SENTSTATUSCAT','Cátalogo estados de las encuestas','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('SEXCAT','SEXCAT','Sexo de cada persona','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSCAT','STATUSCAT','Cátalogo estados','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('STATUSRESULTCAT','STATUSRESULTCAT','Cátalogo estados de resultados de si converge o no','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1),('TYPEPERSONCAT','TYPEPERSONCAT','tipo de personas como admin, expertos etc','2019-05-15 00:18:02','2019-05-14 21:59:19',1,1);
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
INSERT INTO `catalogueitem` VALUES ('ACADEMICDEGREECAT','Postgrados','Postgrados','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Primaria','Primaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Secundaria','Secundaria','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('ACADEMICDEGREECAT','Universidad','Universidad','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','ID','Cédula','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('IDENTIFYTYPECAT','RUC','RUC','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','forwarded','Reenviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','forwardedAndAnswered','Reenviado / Contestado','2019-08-03 17:17:36','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sent','Enviado / No contestado','2019-08-03 17:17:16','2019-05-14 22:00:07',1,1),('SENTSTATUSCAT','sentAndAnswered','Enviado /Contestado','2019-08-03 17:17:27','2019-05-14 22:00:07',1,1),('SEXCAT','0','Mujer','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('SEXCAT','1','Hombre','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','0','Inactivo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSCAT','1','Activo','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSRESULTCAT','approved','Aprobado','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('STATUSRESULTCAT','rejected','No converge','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','admin','ADMINISTRADOR','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1),('TYPEPERSONCAT','expert','EXPERTOS','2019-05-14 22:00:07','2019-05-14 22:00:07',1,1);
/*!40000 ALTER TABLE `catalogueitem` ENABLE KEYS */;
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
INSERT INTO `environment` VALUES ('http://localhost:4200/client/quizclient','frontend','quizclient');
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

-- Dump completed on 2019-09-09 11:02:36
