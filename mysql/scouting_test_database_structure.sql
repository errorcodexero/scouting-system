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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
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
 1 AS `tele_gear_delivered`,
 1 AS `tele_low_score`,
 1 AS `tele_low_score_points`,
 1 AS `tele_did_climb_flag`,
 1 AS `auto_baseline_crossed_flag`*/;
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
 1 AS `auto_baseline_crossed_flag`*/;
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
) ENGINE=InnoDB AUTO_INCREMENT=433 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!50001 VIEW `team_match_action_result` AS select `tmr`.`team_id` AS `team_id`,`tmr`.`match_id` AS `match_id`,`tmr`.`alliance` AS `alliance`,`tmr`.`position` AS `position`,`tmr`.`test_id` AS `test_id`,`tmr`.`score` AS `score`,`tmr`.`opp_score` AS `opp_score`,`tmr`.`qp` AS `qp`,`tmr`.`result` AS `result`,`tmr`.`_id` AS `_id`,`tmr`.`wins` AS `wins`,`tmr`.`draws` AS `draws`,`tmr`.`losses` AS `losses`,`tmat`.`tele_high_score` AS `tele_high_score`,`tmat`.`tele_high_score_points` AS `tele_high_score_points`,`tmat`.`tele_gear_delivered` AS `tele_gear_delivered`,`tmat`.`tele_low_score` AS `tele_low_score`,`tmat`.`tele_low_score_points` AS `tele_low_score_points`,`tmat`.`tele_did_climb_flag` AS `tele_did_climb_flag`,`tmat`.`auto_baseline_crossed_flag` AS `auto_baseline_crossed_flag` from (`scouting_test`.`team_match_result` `tmr` join `scouting_test`.`team_match_action_transverse` `tmat` on(((`tmr`.`team_id` = `tmat`.`team_id`) and (`tmr`.`match_id` = `tmat`.`match_id`)))) */;
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
/*!50001 VIEW `team_match_action_transverse` AS select `tm`.`_id` AS `_id`,`tm`.`team_id` AS `team_id`,`tm`.`match_id` AS `match_id`,`tm`.`alliance` AS `alliance`,`tm`.`position` AS `position`,`tm`.`scout_name` AS `scout_name`,`thc`.`quantity` AS `tele_high_score`,floor((`thc`.`quantity` * `thc`.`points`)) AS `tele_high_score_points`,`tgd`.`quantity` AS `tele_gear_delivered`,`tls`.`quantity` AS `tele_low_score`,floor((`tls`.`quantity` * `tls`.`points`)) AS `tele_low_score_points`,`tdc`.`quantity` AS `tele_did_climb_flag`,`abc`.`quantity` AS `auto_baseline_crossed_flag` from (((((`scouting_test`.`team_match` `tm` left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting_test`.`team_match_action` `tma` join `scouting_test`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_high_scores')) `thc` on((`thc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting_test`.`team_match_action` `tma` join `scouting_test`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_gear_delivered')) `tgd` on((`tgd`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity`,`at`.`points` AS `points` from (`scouting_test`.`team_match_action` `tma` join `scouting_test`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_low_dumps')) `tls` on((`tls`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting_test`.`team_match_action` `tma` join `scouting_test`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'tele_did_climb')) `tdc` on((`tdc`.`team_match_id` = `tm`.`_id`))) left join (select `tma`.`team_match_id` AS `team_match_id`,`tma`.`quantity` AS `quantity` from (`scouting_test`.`team_match_action` `tma` join `scouting_test`.`action_type` `at` on((`tma`.`action_type_id` = `at`.`_id`))) where (`at`.`name` = 'auto_baseline_crossed')) `abc` on((`abc`.`team_match_id` = `tm`.`_id`))) */;
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

-- Dump completed on 2017-02-14 19:55:46
