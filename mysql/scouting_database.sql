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
-- Table structure for table `action_type`
--

DROP TABLE IF EXISTS `action_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_type` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT 'No Name',
  `description` varchar(2000) DEFAULT 'No description',
  `match_phase` varchar(45) DEFAULT NULL,
  `points` int(11) DEFAULT '0',
  `opponent_points` int(11) DEFAULT '0',
  `qual_points` int(11) DEFAULT '0',
  `foul_points` int(11) DEFAULT '0',
  `coop_flag` char(1) DEFAULT 'N',
  `category` varchar(255) DEFAULT 'Uncategorized',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_type`
--

LOCK TABLES `action_type` WRITE;
/*!40000 ALTER TABLE `action_type` DISABLE KEYS */;
INSERT INTO `action_type` VALUES (1,'Auto Line Crossed','Auto Line Crossed','Auto',4,0,0,0,'N','Crossing'),(2,'Auto Bunnies Picked-up','Auto Bunnies Picked-up','Auto',0,0,0,0,'N','Bunny Handling'),(3,'Auto Bunnies Scored','Auto Bunnies Scored','Auto',15,0,0,0,'N','Bunny Handling'),(4,'Lines Crossed','Lines Crossed','Teleop',2,0,0,0,'N','Crossing'),(5,'Bunnies Deposited','Bunnies Scored','Teleop',0,0,0,0,'N','Bunny Handling'),(6,'Bunnies Picked-up','Bunnies Picked-up','Teleop',0,0,0,0,'N','Bunny Handling'),(7,'Bunnies Stolen','Bunnies Stolen','Teleop',0,0,0,0,'N','Bunny Handling'),(8,'Shots Hit','Shots Hit','Teleop',0,-5,0,0,'N','Shooting'),(9,'Shots Missed','Shots Missed','Teleop',0,0,0,0,'N','Shooting');
/*!40000 ALTER TABLE `action_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tba_event_key` varchar(45) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `event_district` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `week` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `tba_event_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `idx_tba_event_key` (`tba_event_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'TBA_1','BunnyBots2016','BunnyBots2016','Exhibition','PNW',2016,50,'Catlin Gabel','A');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `tba_match_key` varchar(255) DEFAULT NULL,
  `comp_level` varchar(45) DEFAULT NULL COMMENT 'This is a code that indicates whether this is a qualifier, quarter final, semi final, or final match.',
  `set_number` int(11) DEFAULT NULL,
  `match_number` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT 'Status of match. Not started, complete, cancelled, delayed, etc.\n',
  `red_1_team_id` int(11) DEFAULT NULL,
  `red_2_team_id` int(11) DEFAULT NULL,
  `red_3_team_id` int(11) DEFAULT NULL,
  `red_auto_score` int(11) DEFAULT NULL,
  `red_teleop_score` int(11) DEFAULT NULL,
  `red_total_score` int(11) DEFAULT NULL,
  `red_qp` int(11) DEFAULT NULL,
  `red_foul_points` int(11) DEFAULT NULL,
  `blue_1_team_id` int(11) DEFAULT NULL,
  `blue_2_team_id` int(11) DEFAULT NULL,
  `blue_3_team_id` int(11) DEFAULT NULL,
  `blue_auto_score` int(11) DEFAULT NULL,
  `blue_teleop_score` int(11) DEFAULT NULL,
  `blue_total_score` int(11) DEFAULT NULL,
  `blue_qp` int(11) DEFAULT NULL,
  `blue_foul_points` int(11) DEFAULT NULL,
  `winner` varchar(45) DEFAULT NULL,
  `drive_team_comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_match_event_idx` (`event_id`),
  CONSTRAINT `fk_match_event` FOREIGN KEY (`event_id`) REFERENCES `event` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,1,'TBA1_1','Q',1,1,'Scheduled',14251,14252,24711,20,67,94,111,5,24712,37111,37112,4,20,34,34,10,'Red','Dandy'),(2,1,'TBA1_2','Q',1,2,'Scheduled',14251,24711,37111,19,50,69,94,0,14252,24712,37112,4,36,50,49,10,'Red','Swell'),(3,1,'TBA1_3','Q',1,3,'Scheduled',12452,24711,24712,12,58,70,70,0,14251,37111,37112,23,57,80,115,0,'Blue','Fantastic'),(4,1,'TBA1_4','Q',1,4,'Scheduled',24711,24712,37111,27,65,97,117,5,24711,24712,37112,4,36,40,40,0,'Red','Great'),(5,1,'TBA1_5','Q',1,5,'Scheduled',14251,37112,24712,8,60,68,68,0,14252,37111,24711,12,51,68,68,5,'Draw','Incredible'),(6,1,'TBA1_6','Q',1,6,'Scheduled',24711,37112,14252,8,48,66,66,10,14251,24711,37111,23,59,72,105,0,'Blue','Extraordinary');
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'The FRC team number. Example: 1425, 360, 4488',
  `team_number` varchar(25) DEFAULT NULL,
  `tba_team_key` varchar(45) DEFAULT NULL COMMENT 'This is the key used by The Blue Alliance website. This key is used when retreiving team data from the TBA API.',
  `long_name` varchar(255) DEFAULT NULL COMMENT 'Team name. Example: Error Code Xero, Flaming Chickens',
  `name` varchar(255) DEFAULT NULL,
  `logo_file_location` varchar(2000) DEFAULT NULL COMMENT 'The file location of a logo file. This could be a file path or a url.',
  `city` varchar(255) DEFAULT NULL,
  `state_code` varchar(45) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `motto` varchar(2000) DEFAULT NULL,
  `rookie_year` int(11) DEFAULT NULL,
  `robot_name` varchar(255) DEFAULT NULL,
  `robot_picture_file_location` varchar(2000) DEFAULT NULL COMMENT 'File path or url to robot picture',
  `robot_drive_type` varchar(45) DEFAULT NULL,
  `robot_wheel_count` int(11) DEFAULT NULL,
  `robot_drive_motor_count` int(11) DEFAULT NULL,
  `robot_software_language` varchar(45) DEFAULT NULL,
  `robot_description` varchar(2000) DEFAULT NULL,
  `pit_scout_comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `team_number_UNIQUE` (`team_number`),
  KEY `idx_tba_team_key` (`tba_team_key`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='This table contains FRC team data for a competition year. It includes information about their robot.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'1425A','TBA1425A',NULL,'Error Code Xero',NULL,'Wilsonvillle','OR','USA','\'Building Robots, Building People\'',2004,'Dash',NULL,'Holononic',3,6,'C++',NULL,NULL),(2,'1425B','TBA1425B',NULL,'Error Code Xero',NULL,'Wilsonville','OR','USA','\'Building Robots, Building People\'',2004,'Hammy',NULL,'H-Drive',5,5,'C++',NULL,NULL),(3,'2471A','TBA2471A',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(4,'2471B','TBA2471B',NULL,'Team Mean Machine',NULL,'Camas','WA','USA','\"24 hours a day, 7 days a week, 1 build season\"',2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(5,'3711A','TBA3711A',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(6,'3711B','TBA3711B',NULL,'Iron Mustangs',NULL,'Trout Lake','WA','USA','\"Do great things\"',2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL),(7,'955','TBA955',NULL,'CV Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'997','TBA997',NULL,'Spartan Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'1432','TBA1432',NULL,'Metal Beavers',NULL,'Portland','OR','USA',NULL,2004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'1540A','TBA1540A',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'1540B','TBA1540B',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'1540C','TBA1540C',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'1571','TBA1571',NULL,'CALibrate',NULL,'Gresham','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'2374','TBA2374',NULL,'CrusaderBots',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'2411','TBA2411',NULL,'Rebel @lliance',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'2635','TBA2635',NULL,'Lake Monsters',NULL,'Lake Oswego','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'2733','TBA2733',NULL,'Pigmice',NULL,'Portland','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2898','TBA2898',NULL,'Flying Hedgehogs',NULL,'Beaverton','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'3131','TBA3131',NULL,'Gladstone Gladiators',NULL,'Gladstone','OR','USA',NULL,2010,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'3636','TBA3636',NULL,'General Robotics',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'3674','TBA3674',NULL,'4-H CloverBots',NULL,'Battle Ground','WA','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'4043','TBA4043',NULL,'NerdHerd',NULL,'McMinnville','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'4051','TBA4051',NULL,'Sabin-Sharks',NULL,'Portland','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'4692','TBA4692',NULL,'Metal Mallards',NULL,'Toutle','WA','USA',NULL,2013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'5977','TBA5977',NULL,'Rosemary Rebels',NULL,'Portland','OR','USA',NULL,2016,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'6456','TBA6456',NULL,'Wolfpack',NULL,'Boring','OR','USA',NULL,2017,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_event`
--

DROP TABLE IF EXISTS `team_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_event` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `opr` float DEFAULT NULL,
  `dpr` float DEFAULT NULL,
  `fpr` float DEFAULT NULL,
  `ccwm` float DEFAULT NULL,
  `alliance_captain_flag` varchar(2) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `alliance_pick` int(11) DEFAULT NULL,
  `alliance_captain_team_id` int(11) DEFAULT NULL,
  `playoff_status` varchar(45) DEFAULT NULL,
  `dq_count` int(11) DEFAULT NULL,
  `win_count` int(11) DEFAULT NULL,
  `loss_count` int(11) DEFAULT NULL,
  `tie_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `team_event_id_UNIQUE` (`_id`),
  KEY `team_event_team_id_idx` (`team_id`),
  KEY `team_event_event_id_idx` (`event_id`),
  CONSTRAINT `team_event_event_id` FOREIGN KEY (`event_id`) REFERENCES `event` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `team_event_team_id` FOREIGN KEY (`team_id`) REFERENCES `team_old` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_event`
--

LOCK TABLES `team_event` WRITE;
/*!40000 ALTER TABLE `team_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_match`
--

DROP TABLE IF EXISTS `team_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_match` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `match_id` int(11) NOT NULL,
  `alliance` varchar(45) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `scout_name` varchar(255) DEFAULT NULL COMMENT 'Name of scouter or tablet_id',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_match`
--

LOCK TABLES `team_match` WRITE;
/*!40000 ALTER TABLE `team_match` DISABLE KEYS */;
INSERT INTO `team_match` VALUES (1,14251,1,'Blue',1,'Billy'),(2,14252,1,'Blue',2,'Fred'),(3,24711,1,'Blue',3,'Timmy'),(4,24712,1,'Red',1,'Igor'),(5,37111,1,'Red',2,'Chad'),(6,37112,1,'Red',3,'Gustaph');
/*!40000 ALTER TABLE `team_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_match_action`
--

DROP TABLE IF EXISTS `team_match_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_match_action` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_match_id` int(11) NOT NULL,
  `action_type_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `object_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_tma_team_match_idx` (`team_match_id`),
  KEY `fk_tma_action_type_idx` (`action_type_id`),
  CONSTRAINT `fk_tma_action_type` FOREIGN KEY (`action_type_id`) REFERENCES `action_type` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tma_team_match` FOREIGN KEY (`team_match_id`) REFERENCES `team_match` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_match_action`
--

LOCK TABLES `team_match_action` WRITE;
/*!40000 ALTER TABLE `team_match_action` DISABLE KEYS */;
INSERT INTO `team_match_action` VALUES (1,1,1,2,NULL,NULL,1),(2,2,1,2,NULL,NULL,1),(3,3,1,1,NULL,NULL,1),(4,1,2,1,NULL,NULL,1),(5,1,4,8,NULL,NULL,1),(6,2,4,14,NULL,NULL,1),(7,3,4,6,NULL,NULL,1),(8,1,5,1,NULL,NULL,1),(9,3,5,1,NULL,NULL,1),(10,3,6,1,NULL,NULL,1),(11,1,8,2,NULL,NULL,1),(12,1,9,3,NULL,NULL,1),(13,2,8,5,NULL,NULL,1),(14,2,9,13,NULL,NULL,1),(15,3,9,2,NULL,NULL,1),(16,4,1,1,NULL,NULL,1),(17,4,4,8,NULL,NULL,1),(18,5,4,10,NULL,NULL,1),(19,5,4,4,NULL,NULL,1),(20,6,5,1,NULL,NULL,1),(21,6,6,1,NULL,NULL,1),(22,6,7,1,NULL,NULL,1),(23,5,8,1,NULL,NULL,1),(24,5,9,1,NULL,NULL,0);
/*!40000 ALTER TABLE `team_match_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_old`
--

DROP TABLE IF EXISTS `team_old`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_old` (
  `_id` int(11) NOT NULL COMMENT 'The FRC team number. Example: 1425, 360, 4488',
  `team_number` varchar(25) DEFAULT NULL,
  `tba_team_key` varchar(45) DEFAULT NULL COMMENT 'This is the key used by The Blue Alliance website. This key is used when retreiving team data from the TBA API.',
  `long_name` varchar(255) DEFAULT NULL COMMENT 'Team name. Example: Error Code Xero, Flaming Chickens',
  `name` varchar(255) DEFAULT NULL,
  `logo_file_location` varchar(2000) DEFAULT NULL COMMENT 'The file location of a logo file. This could be a file path or a url.',
  `city` varchar(255) DEFAULT NULL,
  `state_code` varchar(45) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `motto` varchar(2000) DEFAULT NULL,
  `rookie_year` int(11) DEFAULT NULL,
  `robot_name` varchar(255) DEFAULT NULL,
  `robot_picture_file_location` varchar(2000) DEFAULT NULL COMMENT 'File path or url to robot picture',
  `robot_drive_type` varchar(45) DEFAULT NULL,
  `robot_wheel_count` int(11) DEFAULT NULL,
  `robot_drive_motor_count` int(11) DEFAULT NULL,
  `robot_software_language` varchar(45) DEFAULT NULL,
  `robot_description` varchar(2000) DEFAULT NULL,
  `pit_scout_comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `idx_tba_team_key` (`tba_team_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table contains FRC team data for a competition year. It includes information about their robot.';
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2016-12-10 10:51:09
