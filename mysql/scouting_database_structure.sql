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

-- Dump completed on 2017-02-28 19:22:37
