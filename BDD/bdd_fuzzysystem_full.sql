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
  `bibliography` varchar(1000) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'1234567987','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','José Miguel','Pérez','José Miguel Pérez','byron.lopez.begins@gmail.com','Ecuador','1969-12-31','STATUSCAT','1','SEXCAT','1','electrónica','2019-09-02 19:52:04','2019-09-02 21:02:59',0,0,'bibliografia es ...'),(2,'987654314','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Alejandra Lisbeth','Mosquera','Alejandra Lisbeth Mosquera','byron.lopez@epn.edu.ec','Peru','1969-12-31','STATUSCAT','1','SEXCAT','1','Física','2019-08-14 22:22:24','2019-09-02 21:02:59',0,0,'test test '),(3,'9517538647','TYPEPERSONCAT','expert','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Vladímir Vladímirovich','Putin','Vladímir Vladímirovich Putin','byron.lopez.begins@gmail.com','Russia','1969-12-31','STATUSCAT','1','SEXCAT','1','Jurisprudencia','2019-08-19 15:24:08','2019-09-02 21:02:59',0,0,'test test test'),(9,'1723353404','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Primaria','Gonzalo david','proaño chicaiza','Gonzalo david proaño chicaiza','davidgonzalomejia@hotmail.com','NONO','1995-08-29','STATUSCAT','1','SEXCAT','1','Area de computacionn','2019-08-19 18:29:16','2019-09-02 21:02:59',0,0,'leyenda'),(10,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Gonzalo','epn','Gonzalo epn','gonzalo.proano@epn.edu.ec','ECuador','2018-09-04','STATUSCAT','1','SEXCAT','1','compuatacion','2019-08-19 06:02:07','2019-09-02 21:02:59',0,0,'brou'),(11,'1723353403','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','Byron','Lopez','Byron Lopez','davidgonzalomejia@gmail.com','Ecuador','2019-08-07','STATUSCAT','1','SEXCAT','1','area humana','2019-09-02 21:05:46','2019-09-02 21:05:46',0,0,NULL),(13,'444444444','TYPEPERSONCAT','admin','IDENTIFYTYPECAT','ID','ACADEMICDEGREECAT','Postgrados','eee','eeee','eee eeee','eee','eee','2019-09-11','STATUSCAT','1','SEXCAT','0','jjj','2019-09-02 21:18:25','2019-09-02 21:18:25',0,0,'eeeeee');
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QuestionItem`
--

LOCK TABLES `QuestionItem` WRITE;
/*!40000 ALTER TABLE `QuestionItem` DISABLE KEYS */;
INSERT INTO `QuestionItem` VALUES (2,1,1,'Brasióáíúóí?óíú','pais de la gartotas',NULL,'STATUSCAT','0','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(3,1,1,'Colombia','pais de cafe',NULL,'STATUSCAT','0','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(11,10,10,'UNIDAD ORGANIZATIVAS','Datos sobre Facultades, Institutos, CAMBIAME TAMANO COLUMN',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(12,10,10,'TITULACIONES','Se refiere a las carre',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(13,10,10,'ESTUDIANTES','Alumnos matriculados.',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(14,10,10,'SEGUIMIENTO DE EGRESADOS','Alumnos egresados.',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(15,10,10,'DOCENTES','Docentes que se encuentran con contrato.',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(16,10,10,'NUEVO ITEM','ITEM DESCRIPTION',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(17,11,10,'SEGUIMIENTO DE EGRESADOS','Alumnos egresados.',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(18,11,10,'DOCENTES','Docentes que se encuentran con contrato.',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(19,11,10,'NUEVO ITEM','ITEM DESCRIPTION',NULL,'STATUSCAT','1','2019-08-19 18:16:57','2019-08-19 18:16:57',1,1),(23,4,1,'Brasil',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(24,4,1,'Argentina',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(25,4,1,'Uruguay',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(26,5,1,'Venezuela',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(27,5,1,'Ecuador',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(36,3,1,'Estadio chucho benites',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(37,3,1,'Estadio Aucas',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(38,3,1,'Maracaná',NULL,NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(39,1,1,'Alemania','pais de hitler',NULL,'STATUSCAT','1','2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(40,12,13,'Azul','Color del mar',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1),(41,12,13,'Rojo','Color de la sangre',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1),(42,12,13,'Amarillo ','color del sol',NULL,'STATUSCAT','1','2019-08-19 23:50:51','2019-08-19 23:50:51',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questions`
--

LOCK TABLES `Questions` WRITE;
/*!40000 ALTER TABLE `Questions` DISABLE KEYS */;
INSERT INTO `Questions` VALUES (1,1,'cual es el ganadador de la copa america en el 2024','Acerca de la copa américa que se realizara en ecuador en 2024','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,2.00000000,NULL,NULL),(3,1,'Cuántas sedes tiene esta Copa América','sedes de la copa america','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,3.00000000,NULL,NULL),(4,1,'Quiénes son los máximos ganadores del título','maximos ganadores del titulo','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,4.00000000,NULL,NULL),(5,1,'Cuáles son las dos selecciones que nunca salieron campeonas','Nunca han ganado la copa america','STATUSCAT','1','1','10','1',NULL,'2019-09-02 19:52:12','2019-09-02 19:52:12',0,0,5.00000000,NULL,NULL),(10,10,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','5','100','5',NULL,'2019-08-19 18:16:57','2019-08-19 18:16:57',0,0,70.00000000,NULL,NULL),(11,10,'¿Cuál es la probabilidad que los siguientes conjuntos de datos se reutilicen para generar aplicaciones o servicios de valor agregado para la comunidad universitaria?','Indique el porcentaje más pesimista, moderado y optimista.','STATUSCAT','1','5','100','5',NULL,'2019-08-19 18:16:57','2019-08-19 18:16:57',0,0,80.00000000,NULL,NULL),(12,13,'cual es el color mas bonito poner unas cosas para que se llenen entonces colocamos el valor de los delphi ddddddd  ddddddd  ddddddd   dddddddddd ddddddd  dddddddddddd dddddddd ddddddd ddddddd','colores de elegancia','STATUSCAT','1','1','100','5',NULL,'2019-08-19 23:50:51','2019-08-19 23:50:51',0,0,70.00000000,0,0);
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
INSERT INTO `Quiz` VALUES (1,'Pronostico del equipo ganador en la copa america','MEJOR EQUIPO PARA GANAR LA COPA AMERICA','Equipo posible ganador de la copa américa.\n','STATUSCAT','1',NULL,7.00000000,'2019-09-02 19:52:12','2019-09-02 19:52:12',1,1),(10,'Considering reusers when selecting datasets to open: a case of study from universities','Investigación de Datos Abiertos','Gracias por dedicar unos minutos a completar esta encuesta, usted ha sido escogido por su experiencia\r\nen datos abiertos y la información que nos proporcione será muy útil para la investigación sobre el conjunto de datos que se debería abrir en la universidad ecuatoriana.\r\n\r\nPara la investigación vamos a utilizar una metodología llamada Delphi Difuso que consiste en llegar a consensos con los participantes sobre sus criterios, por tanto podríamos requerir de su colaboración una o dos veces adicionales.\r\n\r\nSus respuestas serán tratadas de forma confidencial y serán utilizadas para la investigación llevada a\r\ncabo entre la Universidad Central del Ecuador y La Universidad de Alicante en España sobre la línea de\r\nDatos Abiertos.\r\n\r\nEsta encuesta dura aproximadamente 20 minutos.\r\n\r\nLa fecha límite para realizar esta encuesta es una semana luego de que le llegue este correo.','STATUSCAT','1',NULL,70.00000000,'2019-08-21 17:26:32','2019-08-21 17:26:32',1,1),(13,'Encuesta de colores','Encuesta de colores ','los colores son chevres','STATUSCAT','1',NULL,7.00000000,'2019-09-02 20:47:28','2019-09-02 20:47:28',1,1);
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
INSERT INTO `Rounds` VALUES (1,13,9,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbUNsaWVudCIsImlhdCI6MTU2NzQ1NzI0OCwiZXhwIjozMTM1NTE5Mjk2LCJjb2RlUXVpeiI6MTMsInJvdW5kTnVtYmVyIjoxLCJjb2RlUGVyc29uIjo5fQ.E3Vu0lYjiviQXuUsRhXKgxZsz8GiDdrfh70oAYUJaTA','SENTSTATUSCAT','sent','2019-09-02 20:47:28','2019-09-02 20:47:28',0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'davidgonzalomejia@hotmail.com','elpapidelasnenas#summer','davidgonzalomejia@gmail.com','chS1I5CEjEekYCWFqBJr5g==',NULL,'2019-08-19 03:17:06','2019-08-20 20:35:02',1,1),(2,'davidgonzalomejia@gmail.com','Juanito','davidgonzalomejia@gmail.com','/UbhuM/HpBIJzFjn+NXXBg==',NULL,'2019-08-19 17:54:08','2019-08-19 18:11:52',1,1),(4,'byron@epn.edu.ec','Byron','byron@epn.edu.ec','yJzDaB0vwaCn1ypAC4ymNw==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU2NjQ4Nzg0MCwiZXhwIjozMTMzNTgwNDgwLCJlbWFpbCI6ImJ5cm9uQGVwbi5lZHUuZWMifQ.NT3eZRXT_Rwbrve9PcWuVV_YohBCezlqyIzLjwnqdCg','2019-08-21 16:47:12','2019-08-22 15:30:40',1,1),(7,'gonzalo.proano@epn.edu.ec','david','gonzalo.proano@epn.edu.ec','duL5bvMpezqMSw30EqclZQ==','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJGdXp6aURlbHBoaVN5c3RlbSIsImlhdCI6MTU2NzQ1MzgzOSwiZXhwIjozMTM1NTEyNDc5LCJlbWFpbCI6ImdvbnphbG8ucHJvYW5vQGVwbi5lZHUuZWMifQ.wZ89RcazFj3se-zw-6h5i12UtPOxup8Xd9n4U6xf5As','2019-09-02 19:50:19','2019-09-02 19:50:39',1,1);
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

-- Dump completed on 2019-09-02 16:19:35
