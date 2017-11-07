-- MySQL dump 10.13  Distrib 5.5.57, for Win64 (AMD64)
--
-- Host: localhost    Database: bussystem
-- ------------------------------------------------------
-- Server version	5.5.57

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
-- Table structure for table `boards`
--

DROP TABLE IF EXISTS `boards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boards` (
  `clientID` varchar(15) NOT NULL,
  `busID` varchar(9) NOT NULL,
  `seatNumber` tinyint(4) DEFAULT NULL,
  `toCity` varchar(9) NOT NULL,
  `travelDate` date NOT NULL,
  KEY `busID` (`busID`),
  KEY `toCity` (`toCity`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `boards_ibfk_1` FOREIGN KEY (`busID`) REFERENCES `bustable` (`busID`),
  CONSTRAINT `boards_ibfk_2` FOREIGN KEY (`toCity`) REFERENCES `city` (`cityID`),
  CONSTRAINT `boards_ibfk_3` FOREIGN KEY (`clientID`) REFERENCES `client` (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boards`
--

LOCK TABLES `boards` WRITE;
/*!40000 ALTER TABLE `boards` DISABLE KEYS */;
INSERT INTO `boards` VALUES ('123','sw123',1,'SW124','2017-10-27'),('234','nw123',1,'SW123','2017-10-27'),('7665','sw123',5,'SW124','2017-10-27'),('32r94','sw123',6,'SW124','2017-10-27'),('test2','sw123',4,'SW124','2017-10-27'),('test24','sw123',3,'SW124','2017-10-27'),('test24','nw123',3,'SW123','2017-10-29'),('test243','ce123',3,'SW124','2017-10-27'),('test243','ce123',3,'NW123','2017-10-27');
/*!40000 ALTER TABLE `boards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bustable`
--

DROP TABLE IF EXISTS `bustable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bustable` (
  `busID` varchar(9) NOT NULL,
  `bustype` varchar(20) NOT NULL,
  `seatcap` int(2) NOT NULL,
  PRIMARY KEY (`busID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bustable`
--

LOCK TABLES `bustable` WRITE;
/*!40000 ALTER TABLE `bustable` DISABLE KEYS */;
INSERT INTO `bustable` VALUES ('...','',0),('ce123','70seater',70),('lt123','19seater',19),('nw123','15seater',15),('sw123','30seater',30);
/*!40000 ALTER TABLE `bustable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `cityID` varchar(9) NOT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('CE123','Yaounde'),('LT123','Douala'),('NW123','Bamenda'),('SW123','Limbe'),('SW124','Buea'),('SW125','Kumba');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `clientID` varchar(15) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) NOT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('123','cahwa','fabu'),('234','pewatt','gilbert'),('32r94','Elcid','Chingy'),('7665','Chawa','Elcid'),('test2','test','test1'),('test24','test4','test14'),('test243','testing','testing2');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `names` varchar(255) DEFAULT NULL,
  `bus` varchar(9) NOT NULL,
  `seat` int(11) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `ddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES ('test4 test14','nw123',3,'SW123','2017-10-29');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-31  7:11:06
