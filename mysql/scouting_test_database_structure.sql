-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: scouting_test
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `factors`
--

DROP TABLE IF EXISTS `factors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factors` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `min_balls_collected` int(11) DEFAULT NULL,
  `max_balls_collected` int(11) DEFAULT NULL,
  `high_goal_accuracy` float DEFAULT NULL,
  `high_goal_ball_pct` float DEFAULT NULL,
  `low_goal_accuracy` float DEFAULT NULL,
  `min_gears_collected` int(11) DEFAULT NULL,
  `max_gears_collected` int(11) DEFAULT NULL,
  `gear_placed_accuracy` float DEFAULT NULL,
  `hang_attempt_pct` float DEFAULT NULL,
  `hang_pct` float DEFAULT NULL,
  `auto_movement_pct` float DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_match_event_idx` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `match_elim`
--

DROP TABLE IF EXISTS `match_elim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match_elim` (
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
  KEY `fk_match_event_idx` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `random`
--

DROP TABLE IF EXISTS `random`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `random` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `Rand1` float DEFAULT NULL,
  `Rand2` float DEFAULT NULL,
  `Rand3` float DEFAULT NULL,
  `Rand4` float DEFAULT NULL,
  `Rand` float DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6913 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `can_collect_ground_fuel` int(11) DEFAULT NULL,
  `can_collect_feeder_fuel` int(11) DEFAULT NULL,
  `can_collect_hopper_fuel` int(11) DEFAULT NULL,
  `can_activate_hoppers` int(11) DEFAULT NULL,
  `can_score_fuel_low` int(11) DEFAULT NULL,
  `can_score_high_low` int(11) DEFAULT NULL,
  `can_collect_feeder_gears` int(11) DEFAULT NULL,
  `can_collect_ground_gears` int(11) DEFAULT NULL,
  `can_score_gears` int(11) DEFAULT NULL,
  `can_climb` int(11) DEFAULT NULL,
  `can_activate_touchpad` int(11) DEFAULT NULL,
  `uses_own_rope` int(11) DEFAULT NULL,
  `defensive` int(11) DEFAULT NULL,
  `max_fuel_capacity` int(11) DEFAULT NULL,
  `fuel_container_volume` float DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `team_number_UNIQUE` (`team_number`),
  KEY `idx_tba_team_key` (`tba_team_key`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='This table contains FRC team data for a competition year. It includes information about their robot.';
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `team_event_event_id_idx` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  PRIMARY KEY (`_id`),
  KEY `fk_team_match_team_idx` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=433 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `fk_tma_action_type_idx` (`action_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3067 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `team_match_action_result`
--

DROP TABLE IF EXISTS `team_match_action_result`;
/*!50001 DROP VIEW IF EXISTS `team_match_action_result`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `team_match_action_result` AS SELECT 
 1 AS `event_name`,
 1 AS `team_id`,
 1 AS `team_number`,
 1 AS `match_id`,
 1 AS `team_name`,
 1 AS `alliance`,
 1 AS `position`,
 1 AS `team_match_seq`,
 1 AS `score`,
 1 AS `opp_score`,
 1 AS `qp`,
 1 AS `result`,
 1 AS `wins`,
 1 AS `draws`,
 1 AS `losses`,
 1 AS `match_total_score`,
 1 AS `match_auto_score`,
 1 AS `match_teleop_score`,
 1 AS `tele_high_score`,
 1 AS `tele_low_score`,
 1 AS `tele_high_score_points`,
 1 AS `tele_low_score_points`,
 1 AS `tele_fuel_bin_triggered`,
 1 AS `tele_gear_delivered`,
 1 AS `tele_loading_station_trip`,
 1 AS `tele_try_climb_flag`,
 1 AS `tele_did_climb_flag`,
 1 AS `tele_triggered_pressure_pad`,
 1 AS `auto_baseline_crossed`,
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
-- Table structure for table `team_match_elim`
--

DROP TABLE IF EXISTS `team_match_elim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_match_elim` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `match_id` int(11) NOT NULL,
  `alliance` varchar(45) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `scout_name` varchar(255) DEFAULT NULL COMMENT 'Name of scouter or tablet_id',
  PRIMARY KEY (`_id`),
  KEY `fk_team_match_team_idx` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Temporary view structure for view `vw_team_match`
--

DROP TABLE IF EXISTS `vw_team_match`;
/*!50001 DROP VIEW IF EXISTS `vw_team_match`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_team_match` AS SELECT 
 1 AS `event_name`,
 1 AS `event_short_name`,
 1 AS `event_type`,
 1 AS `event_district`,
 1 AS `year`,
 1 AS `week`,
 1 AS `location`,
 1 AS `event_id`,
 1 AS `comp_level`,
 1 AS `set_number`,
 1 AS `match_number`,
 1 AS `status`,
 1 AS `red_1_team_id`,
 1 AS `red_2_team_id`,
 1 AS `red_3_team_id`,
 1 AS `red_auto_score`,
 1 AS `red_teleop_score`,
 1 AS `red_total_score`,
 1 AS `red_qp`,
 1 AS `red_foul_points`,
 1 AS `blue_1_team_id`,
 1 AS `blue_2_team_id`,
 1 AS `blue_3_team_id`,
 1 AS `blue_auto_score`,
 1 AS `blue_teleop_score`,
 1 AS `blue_total_score`,
 1 AS `blue_qp`,
 1 AS `blue_foul_points`,
 1 AS `winner`,
 1 AS `drive_team_comments`,
 1 AS `team_match_id`,
 1 AS `team_id`,
 1 AS `match_id`,
 1 AS `alliance`,
 1 AS `position`,
 1 AS `scout_name`,
 1 AS `team_number`,
 1 AS `team_long_name`,
 1 AS `team_name`,
 1 AS `fuel_container_volume`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_team_match_action`
--

DROP TABLE IF EXISTS `vw_team_match_action`;
/*!50001 DROP VIEW IF EXISTS `vw_team_match_action`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_team_match_action` AS SELECT 
 1 AS `team_match_action_id`,
 1 AS `team_match_id`,
 1 AS `team_id`,
 1 AS `match_id`,
 1 AS `action_type_id`,
 1 AS `quantity`,
 1 AS `start_time`,
 1 AS `end_time`,
 1 AS `object_count`,
 1 AS `action_name`,
 1 AS `action_description`,
 1 AS `match_phase`,
 1 AS `points`,
 1 AS `opponent_points`,
 1 AS `qual_points`,
 1 AS `foul_points`,
 1 AS `coop_flag`,
 1 AS `category`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'scouting_test'
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
/*!50001 VIEW `team_match_action_result` AS select `tma`.`event_name` AS `event_name`,`tm`.`team_id` AS `team_id`,`tm`.`team_number` AS `team_number`,`tm`.`match_id` AS `match_id`,`tm`.`team_name` AS `team_name`,`tm`.`alliance` AS `alliance`,`tm`.`position` AS `position`,((select count(0) from `scouting_test`.`vw_team_match` `a` where ((`a`.`match_number` < `tma`.`match_number`) and (`a`.`team_id` = `tma`.`team_id`))) + 1) AS `team_match_seq`,(case `tm`.`alliance` when 'red' then `tm`.`red_total_score` when 'blue' then `tm`.`blue_total_score` end) AS `score`,(case `tm`.`alliance` when 'red' then `tm`.`blue_total_score` when 'blue' then `tm`.`red_total_score` end) AS `opp_score`,(case `tm`.`alliance` when 'red' then `tm`.`red_qp` when 'blue' then `tm`.`blue_qp` end) AS `qp`,(case when (`tm`.`winner` = 'draw') then 'draw' when (`tm`.`winner` = `tm`.`alliance`) then 'win' else 'loss' end) AS `result`,if((`tm`.`winner` = `tm`.`alliance`),1,0) AS `wins`,if((`tm`.`winner` = 'draw'),1,0) AS `draws`,if(((`tm`.`winner` <> `tm`.`alliance`) and (`tm`.`winner` <> 'draw')),1,0) AS `losses`,(case `tm`.`alliance` when 'blue' then `tm`.`blue_total_score` when 'red' then `tm`.`red_total_score` end) AS `match_total_score`,(case `tm`.`alliance` when 'blue' then `tm`.`blue_auto_score` when 'red' then `tm`.`red_auto_score` end) AS `match_auto_score`,(case `tm`.`alliance` when 'blue' then `tm`.`blue_teleop_score` when 'red' then `tm`.`red_teleop_score` end) AS `match_teleop_score`,sum(if((`tma`.`action_name` = 'tele_high_scores'),`tma`.`quantity`,0)) AS `tele_high_score`,sum(if((`tma`.`action_name` = 'tele_low_dumps'),`tma`.`quantity`,0)) AS `tele_low_score`,sum(if((`tma`.`action_name` = 'tele_high_scores'),`tma`.`points`,0)) AS `tele_high_score_points`,sum(if((`tma`.`action_name` = 'tele_low_dumps'),`tma`.`points`,0)) AS `tele_low_score_points`,sum(if((`tma`.`action_name` = 'tele_fuel_bin_triggered'),`tma`.`quantity`,0)) AS `tele_fuel_bin_triggered`,sum(if((`tma`.`action_name` = 'tele_gear_delivered'),`tma`.`quantity`,0)) AS `tele_gear_delivered`,sum(if((`tma`.`action_name` = 'tele_loading_station_trip'),`tma`.`quantity`,0)) AS `tele_loading_station_trip`,sum(if((`tma`.`action_name` = 'tele_try_climb'),`tma`.`quantity`,0)) AS `tele_try_climb_flag`,sum(if((`tma`.`action_name` = 'tele_did_climb'),`tma`.`quantity`,0)) AS `tele_did_climb_flag`,sum(if((`tma`.`action_name` = 'tele_triggered_pressure_pad'),`tma`.`quantity`,0)) AS `tele_triggered_pressure_pad`,sum(if((`tma`.`action_name` = 'auto_baseline_crossed'),`tma`.`quantity`,0)) AS `auto_baseline_crossed`,sum(if((`tma`.`action_name` = 'auto_low_dump'),`tma`.`quantity`,0)) AS `auto_low_dump`,sum(if((`tma`.`action_name` = 'auto_high_scores'),`tma`.`quantity`,0)) AS `auto_high_scores`,sum(if((`tma`.`action_name` = 'auto_high_scores'),`tma`.`points`,0)) AS `auto_high_score_points`,sum(if((`tma`.`action_name` = 'auto_high_missed'),`tma`.`quantity`,0)) AS `auto_high_missed`,sum(if((`tma`.`action_name` = 'auto_gear_delivered'),`tma`.`quantity`,0)) AS `auto_gear_delivered`,sum(if((`tma`.`action_name` = 'auto_fuel_bin_triggered'),`tma`.`quantity`,0)) AS `auto_fuel_bin_triggered`,sum(if((`tma`.`action_name` = 'tele_played_defensively'),`tma`.`quantity`,0)) AS `tele_played_defensively`,sum(if((`tma`.`action_name` = 'breakdown'),`tma`.`quantity`,0)) AS `breakdown`,sum(if((`tma`.`action_name` = 'disconnect'),`tma`.`quantity`,0)) AS `disconnect` from (`scouting_test`.`vw_team_match` `tm` join (select `tm2`.`team_match_id` AS `team_match_id`,`tm2`.`event_name` AS `event_name`,`tm2`.`match_number` AS `match_number`,`tm2`.`team_id` AS `team_id`,`tm2`.`match_id` AS `match_id`,`tma2`.`action_name` AS `action_name`,sum(`tma2`.`quantity`) AS `quantity`,floor(sum((`tma2`.`quantity` * `tma2`.`points`))) AS `points` from (`scouting_test`.`vw_team_match` `tm2` join `scouting_test`.`vw_team_match_action` `tma2` on((`tm2`.`match_id` = `tma2`.`match_id`))) group by `tm2`.`team_match_id`,`tm2`.`event_name`,`tm2`.`match_number`,`tm2`.`team_id`,`tm2`.`match_id`,`tma2`.`action_name`) `tma` on((`tma`.`team_match_id` = `tm`.`team_match_id`))) group by `tm`.`team_id`,`tm`.`match_id` order by `tm`.`match_id`,`tm`.`team_number` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_team_match`
--

/*!50001 DROP VIEW IF EXISTS `vw_team_match`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_team_match` AS select `e`.`name` AS `event_name`,`e`.`short_name` AS `event_short_name`,`e`.`event_type` AS `event_type`,`e`.`event_district` AS `event_district`,`e`.`year` AS `year`,`e`.`week` AS `week`,`e`.`location` AS `location`,`m`.`event_id` AS `event_id`,`m`.`comp_level` AS `comp_level`,`m`.`set_number` AS `set_number`,`m`.`match_number` AS `match_number`,`m`.`status` AS `status`,`m`.`red_1_team_id` AS `red_1_team_id`,`m`.`red_2_team_id` AS `red_2_team_id`,`m`.`red_3_team_id` AS `red_3_team_id`,`m`.`red_auto_score` AS `red_auto_score`,`m`.`red_teleop_score` AS `red_teleop_score`,`m`.`red_total_score` AS `red_total_score`,`m`.`red_qp` AS `red_qp`,`m`.`red_foul_points` AS `red_foul_points`,`m`.`blue_1_team_id` AS `blue_1_team_id`,`m`.`blue_2_team_id` AS `blue_2_team_id`,`m`.`blue_3_team_id` AS `blue_3_team_id`,`m`.`blue_auto_score` AS `blue_auto_score`,`m`.`blue_teleop_score` AS `blue_teleop_score`,`m`.`blue_total_score` AS `blue_total_score`,`m`.`blue_qp` AS `blue_qp`,`m`.`blue_foul_points` AS `blue_foul_points`,`m`.`winner` AS `winner`,`m`.`drive_team_comments` AS `drive_team_comments`,`tm`.`_id` AS `team_match_id`,`tm`.`team_id` AS `team_id`,`tm`.`match_id` AS `match_id`,`tm`.`alliance` AS `alliance`,`tm`.`position` AS `position`,`tm`.`scout_name` AS `scout_name`,`t`.`team_number` AS `team_number`,`t`.`long_name` AS `team_long_name`,`t`.`name` AS `team_name`,`t`.`fuel_container_volume` AS `fuel_container_volume` from (((`event` `e` join `match` `m` on((`e`.`_id` = `m`.`event_id`))) join `team_match` `tm` on((`m`.`_id` = `tm`.`match_id`))) join `team` `t` on((`tm`.`team_id` = `t`.`_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_team_match_action`
--

/*!50001 DROP VIEW IF EXISTS `vw_team_match_action`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_team_match_action` AS select `tma`.`_id` AS `team_match_action_id`,`tma`.`team_match_id` AS `team_match_id`,`tm`.`team_id` AS `team_id`,`tm`.`match_id` AS `match_id`,`tma`.`action_type_id` AS `action_type_id`,`tma`.`quantity` AS `quantity`,`tma`.`start_time` AS `start_time`,`tma`.`end_time` AS `end_time`,`tma`.`object_count` AS `object_count`,`at`.`name` AS `action_name`,`at`.`description` AS `action_description`,`at`.`match_phase` AS `match_phase`,`at`.`points` AS `points`,`at`.`opponent_points` AS `opponent_points`,`at`.`qual_points` AS `qual_points`,`at`.`foul_points` AS `foul_points`,`at`.`coop_flag` AS `coop_flag`,`at`.`category` AS `category` from ((`action_type` `at` join `team_match_action` `tma` on((`at`.`_id` = `tma`.`action_type_id`))) join `team_match` `tm` on((`tm`.`_id` = `tma`.`team_match_id`))) */;
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

-- Dump completed on 2017-03-06 22:08:33
