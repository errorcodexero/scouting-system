-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: scouting
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Dumping data for table `action_type`
--

LOCK TABLES `action_type` WRITE;
/*!40000 ALTER TABLE `action_type` DISABLE KEYS */;
INSERT INTO `action_type` VALUES (1,'Auto Line Crossed','Auto Line Crossed','Auto',4,0,0,0,'N','Crossing'),(2,'Auto Bunnies Picked-up','Auto Bunnies Picked-up','Auto',0,0,0,0,'N','Bunny Handling'),(3,'Auto Bunnies Scored','Auto Bunnies Scored','Auto',15,0,0,0,'N','Bunny Handling'),(4,'Lines Crossed','Lines Crossed','Teleop',2,0,0,0,'N','Crossing'),(5,'Bunnies Deposited','Bunnies Scored','Teleop',0,0,0,0,'N','Bunny Handling'),(6,'Bunnies Picked-up','Bunnies Picked-up','Teleop',0,0,0,0,'N','Bunny Handling'),(7,'Bunnies Stolen','Bunnies Stolen','Teleop',0,0,0,0,'N','Bunny Handling'),(8,'Shots Hit','Shots Hit','Teleop',0,-5,0,0,'N','Shooting'),(9,'Shots Missed','Shots Missed','Teleop',0,0,0,0,'N','Shooting');
/*!40000 ALTER TABLE `action_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'TBA_1','BunnyBots2016','BunnyBots2016','Exhibition','PNW',2016,50,'Catlin Gabel','A');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,1,'TBA1_1','Q',1,1,'Scheduled',1,2,3,20,67,94,111,5,4,5,6,4,20,34,34,10,'Red','Dandy'),(2,1,'TBA1_2','Q',1,2,'Scheduled',1,3,5,19,50,69,94,0,2,4,6,4,36,50,49,10,'Red','Swell'),(3,1,'TBA1_3','Q',1,3,'Scheduled',2,3,4,12,58,70,70,0,1,5,6,23,57,80,115,0,'Blue','Fantastic'),(4,1,'TBA1_4','Q',1,4,'Scheduled',3,4,5,27,65,97,117,5,3,4,6,4,36,40,40,0,'Red','Great'),(5,1,'TBA1_5','Q',1,5,'Scheduled',1,6,4,8,60,68,68,0,2,5,3,12,51,68,68,5,'Draw','Incredible'),(6,1,'TBA1_6','Q',1,6,'Scheduled',3,6,2,8,48,66,66,10,1,4,5,23,59,72,105,0,'Blue','Extraordinary');
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'1425A','TBA1425A',NULL,'Error Code Xero',NULL,'Wilsonvillle','OR','USA','\'Building Robots, Building People\'',2004,'Dash',NULL,'Holononic',3,6,'C++',NULL,NULL),(2,'1425B','TBA1425B',NULL,'Error Code Xero',NULL,'Wilsonville','OR','USA','\'Building Robots, Building People\'',2004,'Hammy',NULL,'H-Drive',5,5,'C++',NULL,NULL),(3,'2471A','TBA2471A',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(4,'2471B','TBA2471B',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(5,'3711A','TBA3711A',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(6,'3711B','TBA3711B',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(7,'955','TBA955',NULL,'CV Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'997','TBA997',NULL,'Spartan Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'1432','TBA1432',NULL,'Metal Beavers',NULL,'Portland','OR','USA',NULL,2004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'1540A','TBA1540A',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'1540B','TBA1540B',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'1540C','TBA1540C',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'1571','TBA1571',NULL,'CALibrate',NULL,'Gresham','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'2374','TBA2374',NULL,'CrusaderBots',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'2411','TBA2411',NULL,'Rebel @lliance',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'2635','TBA2635',NULL,'Lake Monsters',NULL,'Lake Oswego','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'2733','TBA2733',NULL,'Pigmice',NULL,'Portland','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2898','TBA2898',NULL,'Flying Hedgehogs',NULL,'Beaverton','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'3131','TBA3131',NULL,'Gladstone Gladiators',NULL,'Gladstone','OR','USA',NULL,2010,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'3636','TBA3636',NULL,'General Robotics',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'3674','TBA3674',NULL,'4-H CloverBots',NULL,'Battle Ground','WA','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'4043','TBA4043',NULL,'NerdHerd',NULL,'McMinnville','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'4051','TBA4051',NULL,'Sabin-Sharks',NULL,'Portland','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'4692','TBA4692',NULL,'Metal Mallards',NULL,'Toutle','WA','USA',NULL,2013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'5977','TBA5977',NULL,'Rosemary Rebels',NULL,'Portland','OR','USA',NULL,2016,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'6456','TBA6456',NULL,'Wolfpack',NULL,'Boring','OR','USA',NULL,2017,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_event`
--

LOCK TABLES `team_event` WRITE;
/*!40000 ALTER TABLE `team_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_match`
--

LOCK TABLES `team_match` WRITE;
/*!40000 ALTER TABLE `team_match` DISABLE KEYS */;
INSERT INTO `team_match` VALUES (1,1,1,'Red',1,'Billy'),(2,2,1,'Red',2,'Fred'),(3,3,1,'Red',3,'Timmy'),(4,4,1,'Blue',1,'Igor'),(5,5,1,'Blue',2,'Chad'),(6,6,1,'Blue',3,'Gustaph'),(7,1,2,'Red',1,'Gimme Tendies'),(8,3,2,'Red',2,'Reeeeeee'),(9,5,2,'Red',3,'Luke\'s stale memes'),(10,2,2,'Blue',1,'Hugh Mungous'),(11,4,2,'Blue',2,'eleven squids in a trenchcoat'),(12,6,2,'Blue',3,'Trebuchet'),(13,2,3,'Red',1,'Trumpty Dumpty'),(14,3,3,'Red',2,'Data entry isn\'t fun'),(15,4,3,'Red',3,'Help'),(16,1,3,'Blue',1,'I\'ve'),(17,5,3,'Blue',2,'Been'),(18,6,3,'Blue',3,'Trapped'),(19,3,4,'Red',1,'In'),(20,4,4,'Red',2,'The'),(21,5,4,'Red',3,'Laptop!'),(22,1,4,'Blue',1,'Gimme'),(23,2,4,'Blue',2,'Gimme'),(24,6,4,'Blue',3,'Chicken'),(25,1,5,'Red',1,'Tendies'),(26,6,5,'Red',2,'Be'),(27,4,5,'Red',3,'They'),(28,2,5,'Blue',1,'Crispy'),(29,5,5,'Blue',2,'Or'),(30,3,5,'Blue',3,'From'),(31,3,6,'Red',1,'Wendy\'s'),(32,6,6,'Red',2,'Spend'),(33,2,6,'Red',3,'My'),(34,1,6,'Blue',1,'Hard-earned'),(35,4,6,'Blue',2,'Good-boy'),(36,5,6,'Blue',3,'Points');
/*!40000 ALTER TABLE `team_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_match_action`
--

LOCK TABLES `team_match_action` WRITE;
/*!40000 ALTER TABLE `team_match_action` DISABLE KEYS */;
INSERT INTO `team_match_action` VALUES (1,1,1,2,NULL,NULL,1),(2,2,1,2,NULL,NULL,1),(3,3,1,1,NULL,NULL,1),(4,1,2,1,NULL,NULL,1),(5,1,4,8,NULL,NULL,1),(6,2,4,14,NULL,NULL,1),(7,3,4,6,NULL,NULL,1),(8,1,5,1,NULL,NULL,1),(9,3,5,1,NULL,NULL,1),(10,3,6,1,NULL,NULL,1),(11,1,8,2,NULL,NULL,1),(12,1,9,3,NULL,NULL,1),(13,2,8,5,NULL,NULL,1),(14,2,9,13,NULL,NULL,1),(15,3,9,2,NULL,NULL,1),(16,4,1,1,NULL,NULL,1),(17,4,4,8,NULL,NULL,1),(18,5,4,10,NULL,NULL,1),(19,6,4,4,NULL,NULL,1),(20,6,5,1,NULL,NULL,1),(21,6,6,1,NULL,NULL,1),(22,6,7,1,NULL,NULL,1),(23,5,8,1,NULL,NULL,1),(24,5,9,1,NULL,NULL,1),(25,7,1,1,NULL,NULL,1),(26,7,2,1,NULL,NULL,1),(27,7,3,1,NULL,NULL,1),(28,7,4,10,NULL,NULL,1),(29,8,4,6,NULL,NULL,1),(30,9,4,9,NULL,NULL,1);
/*!40000 ALTER TABLE `team_match_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_old`
--

LOCK TABLES `team_old` WRITE;
/*!40000 ALTER TABLE `team_old` DISABLE KEYS */;
INSERT INTO `team_old` VALUES (14251,'1425A','TBA1425A',NULL,'Error Code Xero',NULL,'Wilsonvillle','OR','USA','\'Building Robots, Building People\'',2004,'Dash',NULL,'Holononic',3,6,'C++',NULL,NULL),(14252,'1425B','TBA1425B',NULL,'Error Code Xero',NULL,'Wilsonville','OR','USA','\'Building Robots, Building People\'',2004,'Hammy',NULL,'H-Drive',5,5,'C++',NULL,NULL),(24711,'2471A','TBA2471A',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(24712,'2471B','TBA2471B',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(37111,'3711A','TBA3711A',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(37112,'3711B','TBA3711B',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL);
/*!40000 ALTER TABLE `team_old` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-13 19:30:46
