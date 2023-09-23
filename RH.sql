-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: rhu
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `absence` (
  `idA` int NOT NULL AUTO_INCREMENT,
  `id_Ab` int NOT NULL,
  `natureA` varchar(45) NOT NULL,
  `nbreA` int DEFAULT NULL,
  `dateA` varchar(100) NOT NULL,
  PRIMARY KEY (`idA`),
  UNIQUE KEY `idA_UNIQUE` (`idA`),
  KEY `id_Ab_idx` (`id_Ab`) /*!80000 INVISIBLE */,
  CONSTRAINT `id_Ab` FOREIGN KEY (`id_Ab`) REFERENCES `personne` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
INSERT INTO `absence` VALUES (1,2,'Justifiée',NULL,'2022-04-08 - 2022-04-09'),(4,2,'Justifiée',NULL,'2022-04-29 - 2022-04-30'),(5,3,'Non Justifiée',NULL,'2022-04-19 - 2022-04-22'),(8,4,'Non Justifiée',NULL,'2022-04-15 - 2022-04-16'),(9,3,'Non Justifiée',NULL,'2022-05-03 - 2022-05-04'),(10,4,'Justifiée',NULL,'2022-04-12 - 2022-04-15'),(11,5,'Non Justifiée',NULL,'2022-05-10 - 2022-05-12'),(12,3,'Non Justifiée',NULL,'2022-04-20 - 2022-04-22'),(13,5,'Non Justifiée',NULL,'2022-04-12 - 2022-04-15'),(14,3,'Justifiée',NULL,'2022-05-26 - 2022-05-27'),(15,3,'Non Justifiée',NULL,'2022-05-23 - 2022-05-27'),(16,5,'Justifiée',NULL,'2022-04-06 - 2022-04-07'),(18,4,'Non Justifiée',NULL,'2022-05-26 - 2022-05-27');
/*!40000 ALTER TABLE `absence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emploi_du_temps`
--

DROP TABLE IF EXISTS `emploi_du_temps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emploi_du_temps` (
  `id_P` int NOT NULL,
  `nomP_P` varchar(45) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `nom_Pk` varchar(45) DEFAULT NULL,
  `prenom_Pk` varchar(45) DEFAULT NULL,
  UNIQUE KEY `id_P_UNIQUE` (`id_P`),
  KEY `nomP_P_idx` (`nomP_P`),
  KEY `nom_P_idx` (`nom_Pk`),
  KEY `prenom_P_idx` (`prenom_Pk`),
  KEY `nom_Pk_idx` (`nom_Pk`),
  KEY `prenom_Pk_idx` (`prenom_Pk`),
  CONSTRAINT `id_P` FOREIGN KEY (`id_P`) REFERENCES `personne` (`id`),
  CONSTRAINT `nom_Pk` FOREIGN KEY (`nom_Pk`) REFERENCES `personne` (`nom`),
  CONSTRAINT `nomP_P` FOREIGN KEY (`nomP_P`) REFERENCES `poste` (`nomP`),
  CONSTRAINT `prenom_Pk` FOREIGN KEY (`prenom_Pk`) REFERENCES `personne` (`prenom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emploi_du_temps`
--

LOCK TABLES `emploi_du_temps` WRITE;
/*!40000 ALTER TABLE `emploi_du_temps` DISABLE KEYS */;
INSERT INTO `emploi_du_temps` VALUES (2,'EP/SE',NULL,'zarkii','abdellah'),(3,'AC',NULL,'el imami','aymane'),(4,'AC',NULL,'elyousfi','mohamed'),(5,'EP/SE',NULL,'radi','yassin'),(6,'EP/SE',NULL,'aaa','gggg'),(7,'V.E',NULL,'kadar','khalil'),(9,'AC',NULL,'mmm','mehdi'),(10,'EP/SE',NULL,'hissi','brahim');
/*!40000 ALTER TABLE `emploi_du_temps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `idM` int NOT NULL,
  `contenu` varchar(200) NOT NULL,
  `objet` varchar(100) NOT NULL,
  PRIMARY KEY (`idM`),
  UNIQUE KEY `idM_UNIQUE` (`idM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (2,'<p>bonjour</p>','demande'),(3,'<p>demande de conger et confirmer</p>','reponse du demade de conger'),(5,'hhhhhhhhhhhhhhhhhhhhhh','demande de rapport '),(7,'date :2022/06/26 -> 2022/07/26 ','demande de conger '),(8,'<p>kkkmkmkmk</p>','demande');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messagee`
--

DROP TABLE IF EXISTS `messagee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messagee` (
  `idMe` int NOT NULL AUTO_INCREMENT,
  `dateE` varchar(100) NOT NULL,
  `contenu` varchar(200) NOT NULL,
  `nom_en` varchar(45) NOT NULL,
  `email_Me` varchar(100) NOT NULL,
  `prenom_en` varchar(45) NOT NULL,
  `objet` varchar(100) NOT NULL,
  PRIMARY KEY (`idMe`),
  KEY `nom_en_idx` (`nom_en`),
  KEY `prenom_en_idx` (`prenom_en`),
  KEY `email_Me_idx` (`email_Me`),
  CONSTRAINT `email_Me` FOREIGN KEY (`email_Me`) REFERENCES `personne` (`email`),
  CONSTRAINT `nom_en` FOREIGN KEY (`nom_en`) REFERENCES `personne` (`nom`),
  CONSTRAINT `prenom_en` FOREIGN KEY (`prenom_en`) REFERENCES `personne` (`prenom`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messagee`
--

LOCK TABLES `messagee` WRITE;
/*!40000 ALTER TABLE `messagee` DISABLE KEYS */;
INSERT INTO `messagee` VALUES (2,'2022/06/02 00:08:06','<p>bonjour</p>','zarki','abdellah@gmail.com','adam','demande'),(3,'2022/06/04 23:17:41','<p>demande de conger et confirmer</p>','zarki','mohamed@gmail.com','adam','reponse du demade de conger'),(4,'2022/06/05 00:26:46','<p>bonjourrr</p>','zarki','mohamed@gmail.com','adam','demande'),(5,'2022/06/10 16:00:42','hhhhhhhhhhhhhhhhhhhhhh','zarki','yassin@gmail.com','adam','demande de rapport '),(6,'2022/06/11 17:51:21','date .........................','elyousfi','mohamed@gmail.com','mohamed','demande de conger '),(7,'2022/06/11 17:53:08','date :2022/06/26 -> 2022/07/26 ','elyousfi','adam@gmail.com','mohamed','demande de conger '),(8,'2022/06/24 09:02:06','<p>kkkmkmkmk</p>','zarki','khalil@gmail.com','adam','demande'),(9,'2022/06/24 16:36:32','<p>kkkkkkkkkkkkkkkkkkkkk</p>','zarki','mohamed@gmail.com','adam','demande');
/*!40000 ALTER TABLE `messagee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messager`
--

DROP TABLE IF EXISTS `messager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messager` (
  `id_E` int NOT NULL,
  `dateE` varchar(100) NOT NULL,
  `idM_E` int NOT NULL,
  `email_Mr` varchar(45) NOT NULL,
  UNIQUE KEY `id_E_UNIQUE` (`id_E`),
  KEY `email_Mr_idx` (`email_Mr`),
  CONSTRAINT `email_Mr` FOREIGN KEY (`email_Mr`) REFERENCES `personne` (`email`),
  CONSTRAINT `id_E` FOREIGN KEY (`id_E`) REFERENCES `personne` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messager`
--

LOCK TABLES `messager` WRITE;
/*!40000 ALTER TABLE `messager` DISABLE KEYS */;
/*!40000 ALTER TABLE `messager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personne` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `salaire` varchar(45) NOT NULL,
  `numtel` varchar(10) NOT NULL,
  PRIMARY KEY (`id`,`nom`,`prenom`,`email`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `numtel_UNIQUE` (`numtel`),
  UNIQUE KEY `nom_UNIQUE` (`nom`),
  UNIQUE KEY `prenom_UNIQUE` (`prenom`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (1,'zarki','adam','adam@gmail.com','2002','temara','admin',NULL,'5000','0611111111'),(2,'zarkii','abdellah','abdellah@gmail.com','1961','meknes','employe',NULL,'50000','0600005543'),(3,'el imami','aymane','aymane@gmail.com','2004','meknes','employe',NULL,'4000','0666554477'),(4,'elyousfi','mohamed','mohamed@gmail.com','2000','nador','employe',NULL,'7000','0655887744'),(5,'radi','yassin','yassin@gmail.com','2003','temara','employe',NULL,'5000','0655885588'),(6,'aaa','gggg','hhh@gmail.com','123','meknes','employe',NULL,'40000','0655554477'),(7,'kadar','khalil','khalil@gmail.com','2002','meknes','employe',NULL,'40000','0655448899'),(9,'mmm','mehdi','mehdi@gmail.com','2002','temara','employe',NULL,'5000','0623154547'),(10,'hissi','brahim','brahim@gmail.com','2002','meknes','employe',NULL,'40000','0625487961');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poste`
--

DROP TABLE IF EXISTS `poste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poste` (
  `nomP` varchar(45) NOT NULL,
  `nbrD` int NOT NULL,
  PRIMARY KEY (`nomP`),
  UNIQUE KEY `nomP_UNIQUE` (`nomP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poste`
--

LOCK TABLES `poste` WRITE;
/*!40000 ALTER TABLE `poste` DISABLE KEYS */;
INSERT INTO `poste` VALUES ('AC',3),('AE',1),('ARE',1),('EP/SE',4),('T.O',1),('V.E',1);
/*!40000 ALTER TABLE `poste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retard`
--

DROP TABLE IF EXISTS `retard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retard` (
  `idR` int NOT NULL AUTO_INCREMENT,
  `id_Re` int NOT NULL,
  `natureR` varchar(45) NOT NULL,
  `nbrR` int DEFAULT NULL,
  `dateR` varchar(100) NOT NULL,
  PRIMARY KEY (`idR`),
  UNIQUE KEY `idR_UNIQUE` (`idR`),
  KEY `id_Re_idx` (`id_Re`),
  CONSTRAINT `id_Re` FOREIGN KEY (`id_Re`) REFERENCES `personne` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retard`
--

LOCK TABLES `retard` WRITE;
/*!40000 ALTER TABLE `retard` DISABLE KEYS */;
INSERT INTO `retard` VALUES (1,4,'Justifiée',NULL,'05/11/2022 05:42:14 PM'),(2,2,'Non Justifiée',NULL,'05/11/2022 05:58:01 PM'),(3,3,'Justifiée',NULL,'05/11/2022 05:58:14 PM'),(5,4,'Justifiée',NULL,'05/11/2022 06:06:02 PM'),(6,4,'Justifiée',NULL,'05/11/2022 06:27:33 PM'),(7,5,'Justifiée',NULL,'05/13/2022 03:56:51 PM'),(8,5,'Justifiée',NULL,'05/11/2022 05:58:14 PM');
/*!40000 ALTER TABLE `retard` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-26  1:33:24
