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
INSERT INTO `action_type` VALUES (1,'auto_baseline_crossed','Auto Baseline Cross','Auto',5,0,0,0,'N','Crossing'),(2,'auto_low_dump','Auto Low Boiler Score','Auto',0.333,0,0,0,'N','Fuel Scoring'),(3,'auto_high_scores','Auto High Boiler Score','Auto',1,0,0,0,'N','Fuel Scoring'),(4,'auto_high_missed','Auto High Boiler Misses','Auto',0,0,0,0,'N','Fuel Scoring'),(5,'auto_gear_delivered','Auto Gear Delivered','Auto',0,0,0,0,'N','Gears'),(6,'auto_fuel_bin_triggered','Auto Fuel Bin Triggered','Auto',0,0,0,0,'N','Fuel Bin'),(7,'tele_low_dumps','Teleop Low Dumps','Teleop',0.111,0,0,0,'N','Fuel Scoring'),(8,'tele_high_scores','Teleop High Scores','Teleop',0.333,0,0,0,'N','Fuel Scoring'),(9,'tele_high_missed','Teleop High Missed','Teleop',0,0,0,0,'N','Fuel Scoring'),(10,'tele_gear_delivered','Teleop Gears Delivered','Teleop',0,0,0,0,'N','Gear'),(11,'tele_fuel_bin_triggered','Teleop Fuel Bin Delivered','Teleop',0,0,0,0,'N','Fuel Scoring'),(12,'tele_loading_station_trip','Teleop Loading Station Trip','Teleop',0,0,0,0,'N','Loading'),(13,'tele_try_climb','Teleop Try Climb','Teleop',0,0,0,0,'N','Climbing'),(14,'tele_did_climb','Teleop Did Climb','Teleop',0,0,0,0,'N','Climbing'),(15,'tele_tiggered_pressure_pad','Pressure Pad Triggered On Climb','Teleop',50,0,0,0,'0','Climbing'),(16,'tele_played_defensively','Teleop Played Defensively','Teleop',0,0,0,0,'N','Defense'),(17,'breakdown','No description',NULL,0,0,0,0,'N','Uncategorized'),(18,'disconnect','No description',NULL,0,0,0,0,'N','Uncategorized');
/*!40000 ALTER TABLE `action_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'TBA_1','BunnyBots2016','BunnyBots2016','Exhibition','PNW',2016,50,'Catlin Gabel','A'),(2,NULL,'Wilsonville Event',NULL,'District','PNW',2017,2,'Wilsonville',NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,2,NULL,'Qualification',NULL,1,NULL,17,20,22,0,0,0,0,0,31,2,38,0,0,0,0,0,'',''),(2,2,NULL,'Qualification',NULL,2,NULL,34,29,30,0,0,0,0,0,45,42,37,0,0,0,0,0,'',''),(3,2,NULL,'Qualification',NULL,3,NULL,14,26,28,0,0,0,0,0,4,43,35,0,0,0,0,0,'',''),(4,2,NULL,'Qualification',NULL,4,NULL,36,23,29,0,0,0,0,0,32,9,35,0,0,0,0,0,'',''),(5,2,NULL,'Qualification',NULL,5,NULL,3,27,44,0,0,0,0,0,5,18,6,0,0,0,0,0,'','');
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'2471',NULL,NULL,'Team Mean Machine',NULL,'Brush Prarie','WA','USA',NULL,NULL,NULL,NULL,'Holononic',3,6,'C++',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2521',NULL,NULL,'SERT',NULL,'Eugene','OR','USA',NULL,NULL,NULL,NULL,'H-Drive',5,5,'C++',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2550',NULL,NULL,'Skynet',NULL,'Oregon City','OR','USA',NULL,2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'2811',NULL,NULL,'StormBots',NULL,'Vancouver','WA','USA',NULL,2008,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'2915',NULL,NULL,'Pandamonium',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'2990',NULL,NULL,'Hotwire',NULL,'Aumsville','OR','USA',NULL,2011,NULL,NULL,'NA',NULL,NULL,'NA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'955','TBA955',NULL,'CV Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'997','TBA997',NULL,'Spartan Robotics',NULL,'Corvallis','OR','USA',NULL,2002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'1432','TBA1432',NULL,'Metal Beavers',NULL,'Portland','OR','USA',NULL,2004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'1540A','TBA1540A',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'1540B','TBA1540B',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'1540C','TBA1540C',NULL,'Flaming Chickens',NULL,'Portland','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'1571','TBA1571',NULL,'CALibrate',NULL,'Gresham','OR','USA',NULL,2005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'2374','TBA2374',NULL,'CrusaderBots',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'2411','TBA2411',NULL,'Rebel @lliance',NULL,'Portland','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'2635','TBA2635',NULL,'Lake Monsters',NULL,'Lake Oswego','OR','USA',NULL,2008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'2733','TBA2733',NULL,'Pigmice',NULL,'Portland','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2898','TBA2898',NULL,'Flying Hedgehogs',NULL,'Beaverton','OR','USA',NULL,2009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'3131','TBA3131',NULL,'Gladstone Gladiators',NULL,'Gladstone','OR','USA',NULL,2010,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'3636','TBA3636',NULL,'General Robotics',NULL,'Portland','OR','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'3674','TBA3674',NULL,'4-H CloverBots',NULL,'Battle Ground','WA','USA',NULL,2011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'4043','TBA4043',NULL,'NerdHerd',NULL,'McMinnville','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'4051','TBA4051',NULL,'Sabin-Sharks',NULL,'Portland','OR','USA',NULL,2012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'4692','TBA4692',NULL,'Metal Mallards',NULL,'Toutle','WA','USA',NULL,2013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'5977','TBA5977',NULL,'Rosemary Rebels',NULL,'Portland','OR','USA',NULL,2016,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'6456','TBA6456',NULL,'Wolfpack',NULL,'Boring','OR','USA',NULL,2017,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'568',NULL,NULL,'Nerds of the North',NULL,'Anchorage','AK','USA',NULL,2001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'753',NULL,NULL,'High Desert Droids',NULL,'Bend','OR','USA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'847',NULL,NULL,'PHRED',NULL,'Philomath','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'957',NULL,NULL,'SWARM',NULL,'Albany','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,'1359',NULL,NULL,'Scalawags',NULL,'Lebanon','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,'1425',NULL,NULL,'Error Code Xero',NULL,'Wilsonville','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,'1540',NULL,NULL,'Flaming Chickens',NULL,'Portland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'3024',NULL,NULL,'My Favorite Team',NULL,'Ashland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'3574',NULL,NULL,'HIGH TEKERZ',NULL,'Burien','WA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'3673',NULL,NULL,'C.Y.B.O.R.G. Seagulls',NULL,'Seaside','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,'3711',NULL,NULL,'Iron Mustang',NULL,'Trout Lake','WA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,'4057',NULL,NULL,'Steampunk',NULL,'Klamath Falls','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'6445',NULL,NULL,'CTEC Robotics',NULL,'Salem','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,'5975',NULL,NULL,'Beta Blues',NULL,'Portland','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'5970',NULL,NULL,'Beavertronics',NULL,'Beaverton','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'4125',NULL,NULL,'Confidential',NULL,'Umatilla','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'6696',NULL,NULL,'Cardinal Dynamics',NULL,'Corbett','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'5085',NULL,NULL,'LakerBots',NULL,'Blachly','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'1510',NULL,NULL,'Wildcats',NULL,'Beaverton','OR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
/*!40000 ALTER TABLE `team_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_match_action`
--

LOCK TABLES `team_match_action` WRITE;
/*!40000 ALTER TABLE `team_match_action` DISABLE KEYS */;
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

--
-- Dumping routines for database 'scouting'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 20:09:25
