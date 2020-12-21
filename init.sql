/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `game_night` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `game_night`;
DROP TABLE IF EXISTS `game_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_groups` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `game_groups` WRITE;
/*!40000 ALTER TABLE `game_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_groups` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_api_id` varchar(255) DEFAULT NULL,
  `game_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `group_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_games` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `votes` int DEFAULT NULL,
  `games_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeiu9deobpv4id4jijp3dw0bxr` (`games_id`),
  KEY `FK6m3k1wxcpyayy4ye0cas3w1ma` (`group_id`),
  CONSTRAINT `FK6m3k1wxcpyayy4ye0cas3w1ma` FOREIGN KEY (`group_id`) REFERENCES `game_groups` (`id`),
  CONSTRAINT `FKeiu9deobpv4id4jijp3dw0bxr` FOREIGN KEY (`games_id`) REFERENCES `games` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `group_games` WRITE;
/*!40000 ALTER TABLE `group_games` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_games` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `user_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_games` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `games_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaqaf62djrbi9xpe094nbt4it4` (`games_id`),
  KEY `FKk85sd2rb5dpiuekcoyucllpm4` (`user_id`),
  CONSTRAINT `FKaqaf62djrbi9xpe094nbt4it4` FOREIGN KEY (`games_id`) REFERENCES `games` (`id`),
  CONSTRAINT `FKk85sd2rb5dpiuekcoyucllpm4` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `user_games` WRITE;
/*!40000 ALTER TABLE `user_games` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_games` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `group_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqj309bjy5r884tbs1nkhrb1ta` (`group_id`),
  KEY `FKd37bs5u9hvbwljup24b2hin2b` (`user_id`),
  CONSTRAINT `FKd37bs5u9hvbwljup24b2hin2b` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKqj309bjy5r884tbs1nkhrb1ta` FOREIGN KEY (`group_id`) REFERENCES `game_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `user_groups` WRITE;
/*!40000 ALTER TABLE `user_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_groups` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `user_wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_wishlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `games_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm2iw34uvauh2hcwt7dneb2cmv` (`games_id`),
  KEY `FKxfiwf0ov64o4j979puogxloy` (`user_id`),
  CONSTRAINT `FKm2iw34uvauh2hcwt7dneb2cmv` FOREIGN KEY (`games_id`) REFERENCES `games` (`id`),
  CONSTRAINT `FKxfiwf0ov64o4j979puogxloy` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `user_wishlist` WRITE;
/*!40000 ALTER TABLE `user_wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_wishlist` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO game_groups (name, description) VALUES ('Friday Night Fun', 'The Best Friday Group');
INSERT INTO game_groups (name, description) VALUES ('Sunday Funday', 'Board games and Sports? Whats better!');
INSERT INTO game_groups (name, description) VALUES ('Saturday Showdown', 'Where its western games only!');

INSERT INTO games (game_api_id, game_name) VALUES ('OIXt3DmJU0', 'Catan');
INSERT INTO games (game_api_id, game_name) VALUES ('T5lx9elSDt', 'Love Letter');
INSERT INTO games (game_api_id, game_name) VALUES ('jYcMsxI5zP', 'Horrified');
INSERT INTO games (game_api_id, game_name) VALUES ('fG5Ax8PA7n', 'Monopoly');
INSERT INTO games (game_api_id, game_name) VALUES ('WVgc4bUL8N', 'Clue');
INSERT INTO games (game_api_id, game_name) VALUES ('6FmFeux5xH', 'Pandemic');
INSERT INTO games (game_api_id, game_name) VALUES ('3Qx47A4K8M', 'Rummikub');
INSERT INTO games (game_api_id, game_name) VALUES ('5e5qeOvkp3', 'Elder Sign');
INSERT INTO games (game_api_id, game_name) VALUES ('OCv0s54FtD', 'The Game of Life');
INSERT INTO games (game_api_id, game_name) VALUES ('hQLfeykeLS', 'Phase 10');
INSERT INTO games (game_api_id, game_name) VALUES ('FVKaz7JhBO', 'Cosmic Encounter');
INSERT INTO games (game_api_id, game_name) VALUES ('5tnoVda0AY', 'Twilight Imperium: Fourth Edition');

INSERT INTO users (email, password, username) VALUES ('rob@us.af.mil', 'MyPassword', 'Rob');
INSERT INTO users (email, password, username) VALUES ('peter@us.af.mil', 'MyPassword2', 'Peter');
INSERT INTO users (email, password, username) VALUES ('ben@us.af.mil', 'MyPassword3', 'Ben');
INSERT INTO users (email, password, username) VALUES ('donna@us.af.mil', 'MyPassword4', 'Donna');
INSERT INTO users (email, password, username) VALUES ('dameon@us.af.mil', 'MyPassword5', 'Dameon');

INSERT INTO user_groups (group_id, user_id) VALUES (1, 1);
INSERT INTO user_groups (group_id, user_id) VALUES (1, 2);
INSERT INTO user_groups (group_id, user_id) VALUES (2, 3);
INSERT INTO user_groups (group_id, user_id) VALUES (2, 4);
INSERT INTO user_groups (group_id, user_id) VALUES (3, 5);

INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (5, 1);

INSERT INTO user_games (games_id, user_id) VALUES (1, 1);
INSERT INTO user_games (games_id, user_id) VALUES (2, 1);
INSERT INTO user_games (games_id, user_id) VALUES (3, 2);
INSERT INTO user_games (games_id, user_id) VALUES (4, 2);
INSERT INTO user_games (games_id, user_id) VALUES (6, 3);
INSERT INTO user_games (games_id, user_id) VALUES (8, 3);
INSERT INTO user_games (games_id, user_id) VALUES (9, 4);
INSERT INTO user_games (games_id, user_id) VALUES (10, 4);
INSERT INTO user_games (games_id, user_id) VALUES (11, 5);
INSERT INTO user_games (games_id, user_id) VALUES (12, 5);

INSERT INTO group_games (votes, games_id, group_id) VALUES (1, 1, 1);
INSERT INTO group_games (votes, games_id, group_id) VALUES (1, 4, 2);
INSERT INTO group_games (votes, games_id, group_id) VALUES (1, 10, 3);

INSERT INTO user_wishlist (games_id, user_id) VALUES (5, 2);
INSERT INTO user_wishlist (games_id, user_id) VALUES (7, 4);


