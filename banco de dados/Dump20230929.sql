CREATE DATABASE  IF NOT EXISTS `projeto_revisao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projeto_revisao`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto_revisao
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
-- Dumping data for table `log_tarefa`
--

LOCK TABLES `log_tarefa` WRITE;
/*!40000 ALTER TABLE `log_tarefa` DISABLE KEYS */;
INSERT INTO `log_tarefa` VALUES (1,1,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 07:47:11'),(2,1,'LISTADO','Uma tarefa foi listada','2023-09-29 07:47:14'),(3,1,'LISTADO','Uma tarefa foi listada','2023-09-29 08:07:29'),(4,1,'DELETADO','Uma tarefa foi deletada','2023-09-29 08:23:40'),(5,2,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 08:40:40'),(6,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:40:41'),(7,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:40:41'),(8,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:44:20'),(9,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:44:20'),(10,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:44:58'),(11,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:44:58'),(12,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:45:17'),(13,2,'LISTADO','Uma tarefa foi listada','2023-09-29 08:45:17'),(14,3,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 08:59:56'),(15,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:00'),(16,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:00'),(17,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:00'),(18,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:00'),(19,4,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 09:00:38'),(20,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(21,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(22,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(23,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(24,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(25,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:00:40'),(26,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(27,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(28,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(29,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(30,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(31,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:03:47'),(32,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(33,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(34,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(35,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(36,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(37,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:04:45'),(38,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:29:40'),(39,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:29:40'),(40,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:29:40'),(41,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:54:18'),(42,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:54:18'),(43,4,'LISTADO','Uma tarefa foi listada','2023-09-29 09:54:18'),(44,4,'DELETADO','Uma tarefa foi deletada','2023-09-29 09:54:36'),(45,2,'LISTADO','Uma tarefa foi listada','2023-09-29 09:54:38'),(46,3,'LISTADO','Uma tarefa foi listada','2023-09-29 09:54:38'),(47,2,'DELETADO','Uma tarefa foi deletada','2023-09-29 09:54:50'),(48,3,'DELETADO','Uma tarefa foi deletada','2023-09-29 09:54:52'),(49,5,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 09:55:28'),(50,5,'LISTADO','Uma tarefa foi listada','2023-09-29 09:55:40'),(51,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:01:59'),(52,6,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 10:03:27'),(53,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:03:36'),(54,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:03:36'),(55,7,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 10:34:02'),(56,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:34:04'),(57,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:34:04'),(58,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:34:04'),(59,8,'ADICIONADO','Uma tarefa foi adicionada','2023-09-29 10:40:57'),(60,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:40:59'),(61,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:40:59'),(62,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:40:59'),(63,8,'LISTADO','Uma tarefa foi listada','2023-09-29 10:40:59'),(64,8,'ALTERADO','Uma tarefa foi alterada','2023-09-29 10:41:10'),(65,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:41:13'),(66,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:41:13'),(67,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:41:13'),(68,8,'LISTADO','Uma tarefa foi listada','2023-09-29 10:41:13'),(69,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:17'),(70,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:17'),(71,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:17'),(72,8,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:17'),(73,8,'FINALIZADO','Uma tarefa foi finalizada','2023-09-29 10:42:22'),(74,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:25'),(75,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:25'),(76,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:25'),(77,8,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:25'),(78,8,'DELETADO','Uma tarefa foi deletada','2023-09-29 10:42:30'),(79,5,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:33'),(80,6,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:33'),(81,7,'LISTADO','Uma tarefa foi listada','2023-09-29 10:42:33');
/*!40000 ALTER TABLE `log_tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (5,'estudar','java','C'),(6,'dormir','8 horas','A'),(7,'estudar coisas','estudar javinha','C');
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-29 10:58:39
