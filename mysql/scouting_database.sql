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
  `points` float DEFAULT '0',
  `opponent_points` int(11) DEFAULT '0',
  `qual_points` int(11) DEFAULT '0',
  `foul_points` int(11) DEFAULT '0',
  `coop_flag` char(1) DEFAULT 'N',
  `category` varchar(255) DEFAULT 'Uncategorized',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_type`
--

LOCK TABLES `action_type` WRITE;
/*!40000 ALTER TABLE `action_type` DISABLE KEYS */;
INSERT INTO `action_type` VALUES (1,'auto_baseline_crossed','Auto Baseline Cross','Auto',5,0,0,0,'N','Crossing'),(2,'auto_low_dump','Auto Low Boiler Score','Auto',0.333,0,0,0,'N','Fuel Scoring'),(3,'auto_high_scores','Auto High Boiler Score','Auto',1,0,0,0,'N','Fuel Scoring'),(4,'auto_high_missed','Auto High Boiler Misses','Auto',0,0,0,0,'N','Fuel Scoring'),(5,'auto_gear_delivered','Auto Gear Delivered','Auto',0,0,0,0,'N','Gears'),(6,'auto_fuel_bin_triggered','Auto Fuel Bin Triggered','Auto',0,0,0,0,'N','Fuel Bin'),(7,'tele_low_dumps','Teleop Low Dumps','Teleop',0.111,0,0,0,'N','Fuel Scoring'),(8,'tele_high_scores','Teleop High Scores','Teleop',0.333,0,0,0,'N','Fuel Scoring'),(9,'tele_high_missed','Teleop High Missed','Teleop',0,0,0,0,'N','Fuel Scoring'),(10,'tele_gear_delivered','Teleop Gears Delivered','Teleop',0,0,0,0,'N','Gear'),(11,'tele_fuel_bin_triggered','Teleop Fuel Bin Delivered','Teleop',0,0,0,0,'N','Fuel Scoring'),(12,'tele_loading_station_trip','Teleop Loading Station Trip','Teleop',0,0,0,0,'N','Loading'),(13,'tele_try_climb','Teleop Try Climb','Teleop',0,0,0,0,'N','Climbing'),(14,'tele_did_climb','Teleop Did Climb','Teleop',0,0,0,0,'N','Climbing'),(15,'tele_tiggered_pressure_pad','Pressure Pad Triggered On Climb','Teleop',50,0,0,0,'0','Climbing'),(16,'tele_played_defensively','Teleop Played Defensively','Teleop',0,0,0,0,'N','Defense'),(17,'breakdown','No description',NULL,0,0,0,0,'N','Uncategorized'),(18,'disconnect','No description',NULL,0,0,0,0,'N','Uncategorized');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'TBA_1','BunnyBots2016','BunnyBots2016','Exhibition','PNW',2016,50,'Catlin Gabel','A'),(2,NULL,'Wilsonville Event',NULL,'District','PNW',2017,2,'Wilsonville',NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
  `red_qp` float DEFAULT NULL,
  `red_foul_points` int(11) DEFAULT NULL,
  `blue_1_team_id` int(11) DEFAULT NULL,
  `blue_2_team_id` int(11) DEFAULT NULL,
  `blue_3_team_id` int(11) DEFAULT NULL,
  `blue_auto_score` int(11) DEFAULT NULL,
  `blue_teleop_score` int(11) DEFAULT NULL,
  `blue_total_score` int(11) DEFAULT NULL,
  `blue_qp` float DEFAULT NULL,
  `blue_foul_points` int(11) DEFAULT NULL,
  `winner` varchar(45) DEFAULT NULL,
  `drive_team_comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_match_event_idx` (`event_id`),
  CONSTRAINT `fk_match_event` FOREIGN KEY (`event_id`) REFERENCES `event` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,2,NULL,'Qualification',NULL,1,NULL,17,20,22,0,0,0,0,0,31,2,38,0,0,0,0,0,'',''),(2,2,NULL,'Qualification',NULL,2,NULL,34,29,30,0,0,0,0,0,45,42,37,0,0,0,0,0,'',''),(3,2,NULL,'Qualification',NULL,3,NULL,14,26,28,0,0,0,0,0,4,43,35,0,0,0,0,0,'',''),(4,2,NULL,'Qualification',NULL,4,NULL,36,23,29,0,0,0,0,0,32,9,35,0,0,0,0,0,'',''),(5,2,NULL,'Qualification',NULL,5,NULL,3,27,44,0,0,0,0,0,5,18,6,0,0,0,0,0,'','');
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `min_max_avg`
--

DROP TABLE IF EXISTS `min_max_avg`;
/*!50001 DROP VIEW IF EXISTS `min_max_avg`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `min_max_avg` AS SELECT 
 1 AS `team_number`,
 1 AS `name`,
 1 AS `MIN(tma.quantity)`,
 1 AS `MAX(tma.quantity)`,
 1 AS `AVG(tma.quantity)`*/;
SET character_set_client = @saved_cs_client;

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
  `robot_drive_base` varchar(45) DEFAULT NULL,
  `robot_wheel_count` int(11) DEFAULT NULL,
  `robot_drive_motor_count` int(11) DEFAULT NULL,
  `robot_software_language` varchar(45) DEFAULT NULL,
  `robot_description` varchar(2000) DEFAULT NULL,
  `pit_scout_comments` varchar(2000) DEFAULT NULL,
  `can_collect_ground_fuel` int(1) DEFAULT NULL,
  `can_collect_feeder_fuel` int(1) DEFAULT NULL,
  `can_collect_hopper_fuel` int(1) DEFAULT NULL,
  `can_activate_hoppers` int(1) DEFAULT NULL,
  `can_score_fuel_low` int(1) DEFAULT NULL,
  `can_score_fuel_high` int(1) DEFAULT NULL,
  `can_collect_feeder_gears` int(1) DEFAULT NULL,
  `can_collect_ground_gears` int(1) DEFAULT NULL,
  `can_score_gears` int(1) DEFAULT NULL,
  `can_drop_gear` int(1) DEFAULT NULL,
  `can_climb` int(1) DEFAULT NULL,
  `can_activate_touchpad` int(1) DEFAULT NULL,
  `uses_own_rope` int(1) DEFAULT NULL,
  `defensive` int(1) DEFAULT NULL,
  `max_fuel_capacity` int(11) DEFAULT NULL,
  `fuel_container_volume` float DEFAULT NULL,
  `cycle` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `team_number_UNIQUE` (`team_number`),
  KEY `idx_tba_team_key` (`tba_team_key`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='This table contains FRC team data for a competition year. It includes information about their robot.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'2471',NULL,NULL,'Team Mean Machine',NULL,'Brush Prarie','WA','USA',NULL,NULL,NULL,NULL,'Holononic',3,6,'C++',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2521',NULL,NULL,'SERT',NULL,'Eugene','OR','USA',NULL,NULL,NULL,NULL,'H-Drive',5,5,'C++',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2550',NULL,NULL,'Skynet',NULL,'Oregon City','OR','USA',NULL,2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'2811',NULL,NULL,'StormBots',NULL,'Vancouver','WA','USA',NULL,2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'2915',NULL,NULL,'Pandamonium',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'2990',NULL,NULL,'Hotwire',NULL,'Aumsville','OR','USA',NULL,2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'955','TBA955',NULL,'CV Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'997','TBA997',NULL,'Spartan Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'1432','TBA1432',NULL,'Metal Beavers',NULL,'Portland','OR','USA',NULL,2004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'1540A','TBA1540A',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'1540B','TBA1540B',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'1540C','TBA1540C',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'1571','TBA1571',NULL,'CALibrate',NULL,'Gresham','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'2374','TBA2374',NULL,'CrusaderBots',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'2411','TBA2411',NULL,'Rebel @lliance',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'2635','TBA2635',NULL,'Lake Monsters',NULL,'Lake Oswego','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'2733','TBA2733',NULL,'Pigmice',NULL,'Portland','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2898','TBA2898',NULL,'Flying Hedgehogs',NULL,'Beaverton','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'3131','TBA3131',NULL,'Gladstone Gladiators',NULL,'Gladstone','OR','USA',NULL,2010,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'3636','TBA3636',NULL,'General Robotics',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'3674','TBA3674',NULL,'4-H CloverBots',NULL,'Battle Ground','WA','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'4043','TBA4043',NULL,'NerdHerd',NULL,'McMinnville','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'4051','TBA4051',NULL,'Sabin-Sharks',NULL,'Portland','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'4692','TBA4692',NULL,'Metal Mallards',NULL,'Toutle','WA','USA',NULL,2013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'5977','TBA5977',NULL,'Rosemary Rebels',NULL,'Portland','OR','USA',NULL,2016,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'6456','TBA6456',NULL,'Wolfpack',NULL,'Boring','OR','USA',NULL,2017,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'568',NULL,NULL,'Nerds of the North',NULL,'Anchorage','AK','USA',NULL,2001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'753',NULL,NULL,'High Desert Droids',NULL,'Bend','OR','USA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'847',NULL,NULL,'PHRED',NULL,'Philomath','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'957',NULL,NULL,'SWARM',NULL,'Albany','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,'1359',NULL,NULL,'Scalawags',NULL,'Lebanon','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,'1425',NULL,NULL,'Error Code Xero',NULL,'Wilsonville','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,'1540',NULL,NULL,'Flaming Chickens',NULL,'Portland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'3024',NULL,NULL,'My Favorite Team',NULL,'Ashland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'3574',NULL,NULL,'HIGH TEKERZ',NULL,'Burien','WA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'3673',NULL,NULL,'C.Y.B.O.R.G. Seagulls',NULL,'Seaside','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,'3711',NULL,NULL,'Iron Mustang',NULL,'Trout Lake','WA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,'4057',NULL,NULL,'Steampunk',NULL,'Klamath Falls','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'6445',NULL,NULL,'CTEC Robotics',NULL,'Salem','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,'5975',NULL,NULL,'Beta Blues',NULL,'Portland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'5970',NULL,NULL,'Beavertronics',NULL,'Beaverton','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'4125',NULL,NULL,'Confidential',NULL,'Umatilla','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'6696',NULL,NULL,'Cardinal Dynamics',NULL,'Corbett','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'5085',NULL,NULL,'LakerBots',NULL,'Blachly','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'1510',NULL,NULL,'Wildcats',NULL,'Beaverton','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
  `alliance_captain_flag` int(1) DEFAULT NULL,
  `rank` int(3) DEFAULT NULL,
  `alliance_pick` int(1) DEFAULT NULL,
  `alliance_captain_team_id` int(11) DEFAULT NULL,
  `playoff_status` varchar(45) DEFAULT NULL,
  `dq_count` int(11) DEFAULT NULL,
  `win_count` int(11) DEFAULT NULL,
  `loss_count` int(11) DEFAULT NULL,
  `draw_count` int(11) DEFAULT NULL,
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
  `position` int(2) DEFAULT NULL,
  `scout_name` varchar(255) DEFAULT NULL COMMENT 'Name of scouter or tablet_id',
  `strategy_comments` varchar(2000) DEFAULT NULL,
  `robot_performance_comments` varchar(2000) DEFAULT NULL,
  `drive_team_comments` varchar(2000) DEFAULT NULL,
  `final_thoughts` varchar(2000) DEFAULT NULL,
  `drive_team_skill` int(2) DEFAULT NULL,
  `pre_match_cooperation` int(2) DEFAULT NULL,
  `in_match_cooperation` int(2) DEFAULT NULL,
  `scouting_data_quality` int(2) DEFAULT NULL,
  `gracious_professionalism` int(2) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_team_match_team_idx` (`team_id`),
  CONSTRAINT `fk_team_match_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_match`
--

LOCK TABLES `team_match` WRITE;
/*!40000 ALTER TABLE `team_match` DISABLE KEYS */;
INSERT INTO `team_match` VALUES (37,31,1,'Blue',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,2,1,'Blue',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,38,1,'Blue',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,17,1,'Red',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,20,1,'Red',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,22,1,'Red',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,45,2,'Blue',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,42,2,'Blue',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,37,2,'Blue',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,34,2,'Red',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,29,2,'Red',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,30,2,'Red',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,4,3,'Blue',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,43,3,'Blue',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,35,3,'Blue',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,14,3,'Red',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,26,3,'Red',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,28,3,'Red',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,32,4,'Blue',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,9,4,'Blue',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,35,4,'Blue',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,36,4,'Red',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,23,4,'Red',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,29,4,'Red',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,5,5,'Blue',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,18,5,'Blue',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,6,5,'Blue',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,3,5,'Red',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,27,5,'Red',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,44,5,'Red',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
  `tablet_uuid` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_tma_team_match_idx` (`team_match_id`),
  KEY `fk_tma_action_type_idx` (`action_type_id`),
  CONSTRAINT `fk_tma_action_type` FOREIGN KEY (`action_type_id`) REFERENCES `action_type` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tma_team_match` FOREIGN KEY (`team_match_id`) REFERENCES `team_match` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_match_action`
--

LOCK TABLES `team_match_action` WRITE;
/*!40000 ALTER TABLE `team_match_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_match_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `team_match_action_result`
--

DROP TABLE IF EXISTS `team_match_action_result`;
/*!50001 DROP VIEW IF EXISTS `team_match_action_result`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `team_match_action_result` AS SELECT 
 1 AS `team_id`,
 1 AS `match_id`,
 1 AS `alliance`,
 1 AS `position`,
 1 AS `test_id`,
 1 AS `score`,
 1 AS `opp_score`,
 1 AS `qp`,
 1 AS `result`,
 1 AS `_id`,
 1 AS `wins`,
 1 AS `draws`,
 1 AS `losses`,
 1 AS `tele_high_score`,
 1 AS `tele_high_score_points`,
 1 AS `tele_high_missed`,
 1 AS `tele_gear_delivered`,
 1 AS `tele_low_score`,
 1 AS `tele_low_score_points`,
 1 AS `tele_fuel_bin_triggered`,
 1 AS `tele_loading_station_trip`,
 1 AS `tele_try_climb`,
 1 AS `tele_did_climb_flag`,
 1 AS `tele_triggered_pressure_pad`,
 1 AS `auto_baseline_crossed_flag`,
 1 AS `auto_low_dump`,
 1 AS `auto_high_scores`,
 1 AS `auto_high_score_points`,
 1 AS `auto_high_missed`,
 1 AS `auto_gear_delivered`,
 1 AS `auto_fuel_bin_triggered`,
 1 AS `tele_played_defensively`,
 1 AS `breakdown`,
 1 AS `disconnect`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `team_match_action_transverse`
--

DROP TABLE IF EXISTS `team_match_action_transverse`;
/*!50001 DROP VIEW IF EXISTS `team_match_action_transverse`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `team_match_action_transverse` AS SELECT 
 1 AS `_id`,
 1 AS `team_id`,
 1 AS `match_id`,
 1 AS `alliance`,
 1 AS `position`,
 1 AS `scout_name`,
 1 AS `tele_high_score`,
 1 AS `tele_high_score_points`,
 1 AS `tele_gear_delivered`,
 1 AS `tele_low_score`,
 1 AS `tele_low_score_points`,
 1 AS `tele_did_climb_flag`,
 1 AS `auto_baseline_crossed_flag`,
 1 AS `auto_low_dump`,
 1 AS `auto_high_scores`,
 1 AS `auto_high_score_points`,
 1 AS `auto_high_missed`,
 1 AS `auto_gear_delivered`,
 1 AS `auto_fuel_bin_triggered`,
 1 AS `tele_high_missed`,
 1 AS `tele_fuel_bin_triggered`,
 1 AS `tele_loading_station_trip`,
 1 AS `tele_try_climb`,
 1 AS `tele_triggered_pressure_pad`,
 1 AS `tele_played_defensively`,
 1 AS `breakdown`,
 1 AS `disconnect`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `team_match_result`
--

DROP TABLE IF EXISTS `team_match_result`;
/*!50001 DROP VIEW IF EXISTS `team_match_result`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `team_match_result` AS SELECT 
 1 AS `team_id`,
 1 AS `match_id`,
 1 AS `alliance`,
 1 AS `position`,
 1 AS `test_id`,
 1 AS `score`,
 1 AS `opp_score`,
 1 AS `qp`,
 1 AS `result`,
 1 AS `_id`,
 1 AS `wins`,
 1 AS `draws`,
 1 AS `losses`*/;
SET character_set_client = @saved_cs_client;

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

--
-- Dumping routines for database 'scouting'
--

--
-- Final view structure for view `min_max_avg`
--

/*!50001 DROP VIEW IF EXISTS `min_max_avg`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `min_max_avg` AS select `t`.`team_number` AS `team_number`,`at`.`name` AS `name`,min(`tma`.`quantity`) AS `MIN(tma.quantity)`,max(`tma`.`quantity`) AS `MAX(tma.quantity)`,avg(`tma`.`quantity`) AS `AVG(tma.quantity)` from (((`team_match_action` `tma` join `team_match` `tm` on((`tma`.`team_match_id` = `tm`.`_id`))) join `team` `t` on((`tm`.`team_id` = `t`.`_id`))) join `action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) group by `t`.`team_number`,`at`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `team_match_action_result`
--

/*!50001 DROP VIEW IF EXISTS `team_match_action_result`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `team_match_action_result` AS select `tmr`.`team_id` AS `team_id`,`tmr`.`match_id` AS `match_id`,`tmr`.`alliance` AS `alliance`,`tmr`.`position` AS `position`,`tmr`.`test_id` AS `test_id`,`tmr`.`score` AS `score`,`tmr`.`opp_score` AS `opp_score`,`tmr`.`qp` AS `qp`,`tmr`.`result` AS `result`,`tmr`.`_id` AS `_id`,`tmr`.`wins` AS `wins`,`tmr`.`draws` AS `draws`,`tmr`.`losses` AS `losses`,`tmat`.`tele_high_score` AS `tele_high_score`,`tmat`.`tele_high_score_points` AS `tele_high_score_points`,`tmat`.`tele_high_missed` AS `tele_high_missed`,`tmat`.`tele_gear_delivered` AS `tele_gear_delivered`,`tmat`.`tele_low_score` AS `tele_low_score`,`tmat`.`tele_low_score_points` AS `tele_low_score_points`,`tmat`.`tele_fuel_bin_triggered` AS `tele_fuel_bin_triggered`,`tmat`.`tele_loading_station_trip` AS `tele_loading_station_trip`,`tmat`.`tele_try_climb` AS `tele_try_climb`,`tmat`.`tele_did_climb_flag` AS `tele_did_climb_flag`,`tmat`.`tele_triggered_pressure_pad` AS `tele_triggered_pressure_pad`,`tmat`.`auto_baseline_crossed_flag` AS `auto_baseline_crossed_flag`,`tmat`.`auto_low_dump` AS `auto_low_dump`,`tmat`.`auto_high_scores` AS `auto_high_scores`,`tmat`.`auto_high_score_points` AS `auto_high_score_points`,`tmat`.`auto_high_missed` AS `auto_high_missed`,`tmat`.`auto_gear_delivered` AS `auto_gear_delivered`,`tmat`.`auto_fuel_bin_triggered` AS `auto_fuel_bin_triggered`,`tmat`.`tele_played_defensively` AS `tele_played_defensively`,`tmat`.`breakdown` AS `breakdown`,`tmat`.`disconnect` AS `disconnect` from (`scouting`.`team_match_result` `tmr` join `scouting`.`team_match_action_transverse` `tmat` on(((`tmr`.`team_id` = `tmat`.`team_id`) and (`tmr`.`match_id` = `tmat`.`match_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `team_match_action_transverse`
--

/*!50001 DROP VIEW IF EXISTS `team_match_action_transverse`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `team_match_action_transverse` AS select `tm`.`_id` AS `_id`,`tm`.`team_id` AS `team_id`,`tm`.`match_id` AS `match_id`,`tm`.`alliance` AS `alliance`,`tm`.`position` AS `position`,`tm`.`scout_name` AS `scout_name`,`thc`.`quantity` AS `tele_high_score`,floor((`thc`.`quantity` * `thc`.`points`)) AS `tele_high_score_points`,`tgd`.`quantity` AS `tele_gear_delivered`,`tls`.`quantity` AS `tele_low_score`,floor((`tls`.`quantity` * `tls`.`points`)) AS `tele_low_score_points`,`tdc`.`quantity` AS `tele_did_climb_flag`,`abc`.`quantity` AS `auto_baseline_crossed_flag`,`ald`.`quantity` AS `auto_low_dump`,`ahs`.`quantity` AS `auto_high_scores`,floor((`ahs`.`quantity` * `ahs`.`points`)) AS `auto_high_score_points`,`ahm`.`quantity` AS `auto_high_missed`,`agd`.`quantity` AS `auto_gear_delivered`,`afbt`.`quantity` AS `auto_fuel_bin_triggered`,`thm`.`quantity` AS `tele_high_missed`,`tfbt`.`quantity` AS `tele_fuel_bin_triggered`,`tlst`.`quantity` AS `tele_loading_station_trip`,`ttc`.`quantity` AS `tele_try_climb`,`ttpp`.`quantity` AS `tele_triggered_pressure_pad`,`tpd`.`quantity` AS `tele_played_defensively`,`b`.`quantity` AS `breakdown`,`d`.`quantity` AS `disconnect` from ((((((((((((((((((`scouting`.`team_match` `tm` left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_high_scores')) `thc` on((`thc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_gear_delivered')) `tgd` on((`tgd`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_low_dumps')) `tls` on((`tls`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_did_climb')) `tdc` on((`tdc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_baseline_crossed')) `abc` on((`abc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_low_dump')) `ald` on((`ald`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_high_scores')) `ahs` on((`ahs`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_high_missed')) `ahm` on((`ahm`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_gear_delivered')) `agd` on((`agd`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_fuel_bin_triggered')) `afbt` on((`afbt`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_high_missed')) `thm` on((`thm`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_fuel_bin_triggered')) `tfbt` on((`tfbt`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_loading_station_trip')) `tlst` on((`tlst`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_try_climb')) `ttc` on((`ttc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_triggered_pressure_pad')) `ttpp` on((`ttpp`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_played_defensively')) `tpd` on((`tpd`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'breakdown')) `b` on((`b`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting`.`team_match_action` `tma` join `scouting`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'disconnect')) `d` on((`d`.`team_match_id` = `tm`.`_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `team_match_result`
--

/*!50001 DROP VIEW IF EXISTS `team_match_result`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `team_match_result` AS select `t`.`_id` AS `team_id`,`tm`.`match_id` AS `match_id`,`tm`.`alliance` AS `alliance`,`tm`.`position` AS `position`,if((`tm`.`alliance` = 'red'),if((`tm`.`position` = 1),`m`.`red_1_team_id`,if((`tm`.`position` = 2),`m`.`red_2_team_id`,if((`tm`.`position` = 3),`m`.`red_3_team_id`,0))),if((`tm`.`alliance` = 'blue'),if((`tm`.`position` = 1),`m`.`blue_1_team_id`,if((`tm`.`position` = 2),`m`.`blue_2_team_id`,if((`tm`.`position` = 3),`m`.`blue_3_team_id`,0))),0)) AS `test_id`,if((`tm`.`alliance` = 'red'),`m`.`red_total_score`,`m`.`blue_total_score`) AS `score`,if((`tm`.`alliance` = 'blue'),`m`.`red_total_score`,`m`.`blue_total_score`) AS `opp_score`,if((`tm`.`alliance` = 'red'),`m`.`red_qp`,`m`.`blue_qp`) AS `qp`,if((`m`.`winner` = 'draw'),'draw',if((`tm`.`alliance` = `m`.`winner`),'win','loss')) AS `result`,((`tm`.`team_id` * 100) + `tm`.`match_id`) AS `_id`,if((`m`.`winner` = `tm`.`alliance`),1,0) AS `wins`,if((`m`.`winner` = 'draw'),1,0) AS `draws`,if(((`tm`.`alliance` = 'red') and (`m`.`winner` = 'blue')),1,if(((`tm`.`alliance` = 'blue') and (`m`.`winner` = 'red')),1,0)) AS `losses` from ((`team` `t` join `team_match` `tm`) join `match` `m` on(((`t`.`_id` = `tm`.`team_id`) and (`tm`.`match_id` = `m`.`_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-28 19:21:55
