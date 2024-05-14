-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: alan-08-05
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `integracao_dados`
--

DROP TABLE IF EXISTS `integracao_dados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integracao_dados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `genero` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `midia` varchar(200) NOT NULL,
  `tipo_midia` varchar(50) NOT NULL,
  `classificacao` varchar(50) NOT NULL,
  `participante` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integracao_dados`
--

LOCK TABLES `integracao_dados` WRITE;
/*!40000 ALTER TABLE `integracao_dados` DISABLE KEYS */;
INSERT INTO `integracao_dados` VALUES (1,'Ação','Filme','Matrix','DVD','14 anos','Keanu Reeves'),(2,'Comédia','Vídeo','Charlie Bit My Finger','Online','Livre','Charlie e Harry Davies-Carr'),(3,'Pop','Música','Shape of You','MP3','Livre','Ed Sheeran'),(4,'Aventura','Filme','Indiana Jones','Blu-ray','12 anos','Harrison Ford'),(5,'Drama','Filme','Titanic','DVD','12 anos','Leonardo DiCaprio'),(6,'Animação','Filme','Toy Story','Blu-ray','Livre','Tom Hanks'),(7,'Suspense','Filme','O Sexto Sentido','DVD','14 anos','Bruce Willis'),(8,'Documentário','Vídeo','Planet Earth','Streaming','Livre','David Attenborough'),(9,'Rock','Música','Bohemian Rhapsody','MP3','Livre','Queen'),(10,'Comédia Romântica','Filme','Simplesmente Amor','DVD','12 anos','Hugh Grant'),(11,'Eletrônica','Música','Strobe','MP3','Livre','deadmau5'),(12,'Ficção Científica','Filme','Blade Runner','Blu-ray','14 anos','Harrison Ford'),(13,'Pop','Música','Uptown Funk','MP3','Livre','Mark Ronson ft. Bruno Mars'),(14,'Terror','Filme','O Iluminado','DVD','16 anos','Jack Nicholson'),(15,'Hip Hop','Música','Lose Yourself','MP3','Livre','Eminem'),(16,'Fantasia','Filme','O Senhor dos Anéis: A Sociedade do Anel','Blu-ray','12 anos','Elijah Wood'),(17,'Jazz','Música','Take Five','MP3','Livre','Dave Brubeck Quartet'),(18,'Romance','Filme','Orgulho e Preconceito','DVD','Livre','Keira Knightley'),(19,'Clássica','Música','Ave Maria','MP3','Livre','Andrea Bocelli'),(20,'Ação','Filme','Mad Max: Estrada da Fúria','Blu-ray','16 anos','Tom Hardy'),(21,'Reggae','Música','No Woman, No Cry','MP3','Livre','Bob Marley'),(22,'Animação','Filme','Procurando Nemo','DVD','Livre','Albert Brooks'),(23,'Country','Música','Ring of Fire','MP3','Livre','Johnny Cash'),(24,'Drama','Filme','Clube da Luta','Blu-ray','18 anos','Brad Pitt'),(25,'Pop','Música','Happy','MP3','Livre','Pharrell Williams'),(26,'Suspense','Filme','Psicose','DVD','16 anos','Anthony Perkins'),(27,'Eletrônica','Música','Levels','MP3','Livre','Avicii'),(28,'Ficção Científica','Filme','Interestelar','Blu-ray','12 anos','Matthew McConaughey'),(29,'Pop','Música','Billie Jean','MP3','Livre','Michael Jackson'),(30,'Terror','Filme','O Exorcista','DVD','18 anos','Linda Blair'),(31,'Hip Hop','Música','Sicko Mode','MP3','Livre','Travis Scott'),(32,'Teste1','Teste1','Teste1','Teste1','Teste1','Teste1'),(33,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(34,'Teste3','Teste3','Teste3','Teste3','Teste3','Teste3'),(35,'Teste','Teste','Teste','Teste','Teste','Teste'),(36,'Teste1','Teste1','Teste1','Teste1','Teste1','Teste1'),(37,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(38,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(39,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(40,'Teste','Teste','Teste','Teste','Teste','Teste'),(41,'Teste1','Teste1','Teste1','Teste1','Teste1','Teste1'),(42,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(43,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2'),(44,'Teste2','Teste2','Teste2','Teste2','Teste2','Teste2232323');
/*!40000 ALTER TABLE `integracao_dados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 19:23:58
