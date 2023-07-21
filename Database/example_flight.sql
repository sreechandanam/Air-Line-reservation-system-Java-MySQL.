-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: example
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_designator` int NOT NULL,
  `From_Station` char(10) DEFAULT NULL,
  `To_Station` char(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `air_line` char(20) DEFAULT NULL,
  `arrival` char(20) DEFAULT NULL,
  `departure` char(20) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`flight_designator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (230,'Kolkata','Delhi','2021-12-22','Indigo','7:10 am','9:25 am',12000),(845,'Hyderabad','Nagpur','2021-12-11','Air India','6 pm','6:55 pm',11000),(1010,'Srinagar','Delhi','2021-12-20','JetLite','2:30 pm','3:30 pm',10000),(1110,'Kolkata','Guwahati','2021-12-21','Alliance Air','5:50 am','7:25 am',10000),(1234,'efnjv','foi','2020-10-10','edrf','9','10',10000),(1235,'bapatla','chirala','2020-10-10','garuda','9','9.10',NULL),(1305,'Dhaka','Kolkata','2021-12-13','SpiceJet','9:20 am','9:40 am',NULL),(1780,'Chennai','Mumbai','2021-11-09','Spice Jet','6:50 am','8:45 am',NULL),(1818,'Dubai','Mumbai','2021-12-27','Indigo','6 pm','10:30 pm',NULL),(1847,'Kolkata','Dhaka','2021-12-30','SpiceJet','7:05 am','8:35 am',NULL),(1971,'Bangalore','Singapore','2021-12-05','Indigo','9:20 pm','4:30 pm',NULL),(2400,'Bangalore','Mumbai','2021-11-19','Indigo','10 pm','11:30 pm',NULL),(2540,'Mumbai','Bangalore','2021-11-19','Indigo','2 pm','3:30 pm',NULL),(2744,'Mumbai','Dubai','2021-12-27','Indigo','1:10 pm','2:55 pm',NULL),(2810,'Guwahati','Kolkata','2021-12-15','Alliance Air','10:25 am','11:55 am',NULL),(3010,'Srinagar','Delhi','2021-12-20','Airasia India','8:02 am','9:02 am',NULL),(3679,'Nagpur','Hyderabad','2021-12-12','Air India','10 am','11 am',NULL),(3692,'Vizag','Delhi','2021-12-18','Airasia','9:35 am','12 am',NULL),(3780,'Chennai','Mumbai','2021-11-29','Air India','6:50 am','8:45 am',NULL),(3877,'Bangkok','Delhi','2021-11-28','SpiceJet','3:50 am','6:25 am',NULL),(4560,'Bangalore','Kolkata','2021-11-30','Airasia','3:40 pm','7:40 pm',NULL),(4605,'Goa','Bangalore','2021-12-10','Air India','10 pm','11:15 pm',NULL),(5004,'Maharastra','Delhi','2021-12-01','Jetspace','9am','12am',13000),(5208,'Delhi','Bangkok','2021-11-28','SpiceJet','9:20 pm','3:00 am',NULL),(5930,'Bangalore','Delhi','2021-12-02','Indigo','9:55 am','12:35 pm',NULL),(6543,'Bapatla','Vijayawada','2021-12-01','Garuda','9am','10am',10000),(7902,'Vizag','Pune','2021-12-18','Airasia','4 am','5:30 am',NULL),(8720,'Cochin','Bangalore','2021-11-25','Alliance Air','7:10 pm','8:30 am',NULL),(8899,'Goa','Hyderabad','2021-12-01','Air India','1:30 pm','2:45 pm',NULL),(9200,'Hyderabad','Bangalore','2021-12-31','Airasia','9:25 am','11 am',NULL),(9310,'Jaipur','Delhi','2021-12-17','Alliance Air','8:30 pm','9:30 pm',NULL),(9910,'Singapore','Bangalore','2021-12-05','Indigo','5:30 am','8 am',NULL),(11380,'Hyderabad','Chicago','2022-01-31','Air India','8:55 pm','7:25 am',NULL),(12345,'bapatla','hyderabad','2020-10-10','garuda','9am','12am',NULL),(38390,'Paris','Chennai','2022-03-05','Kuwait Airways','1:10 pm','2:15 am',NULL),(59296,'Delhi','SanFranciso','2022-06-21','Emirates','10:35 pm','2:15 pm',NULL),(59321,'Delhi','Los Angeles','2022-01-02','Atlantic','3:55 am','3:25 pm',NULL),(72616,'Chennai','Sydney','2022-04-29','Thai Airways','1:30 am','9:20 pm',NULL),(72687,'Nagpur','New York','2022-09-19','Air India','7:55 am','5:25 pm',NULL);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-15 18:39:17
