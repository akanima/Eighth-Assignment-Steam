-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: steam
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `gamedata`
--

DROP TABLE IF EXISTS `gamedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamedata` (
  `id` int NOT NULL,
  `title` text NOT NULL,
  `developer` text NOT NULL,
  `genre` text NOT NULL,
  `price` double NOT NULL,
  `release_year` int NOT NULL,
  `controller_support` tinyint NOT NULL,
  `reviews` int NOT NULL,
  `size` int NOT NULL,
  `file_path` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamedata`
--

LOCK TABLES `gamedata` WRITE;
/*!40000 ALTER TABLE `gamedata` DISABLE KEYS */;
INSERT INTO `gamedata` VALUES (292030,'\'The Witcher 3: Wild Hunt\'','\'CD Projekt Red\'','\'Role-playing\'',29.99,2015,1,96,798,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources292030.png\''),(323190,'\'Frostpunk\'','\'11 bit studios\'','\'Strategy\'',29.99,2018,0,91,944,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources359550.png\''),(359550,'\'Tom Clancy\'s Rainbow Six Siege\'','\'Ubisoft\'','\'First-person Shooter\'',19.99,2015,1,82,561,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources359550.png\''),(489830,'\'The Elder Scrolls V: Skyrim Special Edition\'','\'Bethesda Game Studios\'','\'Role-playing\'',39.99,2016,1,96,677,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources489830.png\''),(1085660,'\'Destiny 2\'','\'Bungie\'','\'First-person Shooter\'',0,2019,1,74,657,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources1085660.png\''),(1151640,'\'Horizon Zero Dawn Complete Edition\'','\'Guerrilla\'','\'Action-adventure\'',49.99,2020,1,87,915,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources1151640.png\''),(1174180,'\'Red Dead Redemption 2\'','\'Rockstar Games\'','\'Action-adventure\'',59.99,2018,1,90,771,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources1174180.png\''),(1196590,'\'Resident Evil Village\'','\'Capcom\'','\'Survival Horror\'',39.99,2021,1,95,811,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources1196590.png\''),(1245620,'\'Elden Ring\'','\'FromSoftware\'','\'Role-playing\'',59.99,2022,1,94,703,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources1245620.png\''),(2050650,'\'Resident Evil 4\'','\'Capcom\'','\'Survival Horror\'',59.99,2023,1,97,618,'\'C:Users\nimaDocumentsGitHubEigth-Assignment_steamsrcmainjavaServerResources2050650.png\'');
/*!40000 ALTER TABLE `gamedata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 13:11:27
