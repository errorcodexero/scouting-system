CREATE DATABASE  IF NOT EXISTS `firstteamscouter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `firstteamscouter`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: firstteamscouter
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `competition_data`
--

DROP TABLE IF EXISTS `competition_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competition_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) DEFAULT NULL,
  `competition_name` varchar(255) DEFAULT NULL,
  `competition_location` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `match_data`
--

DROP TABLE IF EXISTS `match_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) DEFAULT NULL,
  `competition_id` int(11) DEFAULT NULL,
  `match_time` varchar(255) DEFAULT NULL,
  `match_type` varchar(255) DEFAULT NULL,
  `match_number` int(11) DEFAULT NULL,
  `match_location` varchar(255) DEFAULT NULL,
  `red_team_one_id` int(11) DEFAULT NULL,
  `red_team_two_id` int(11) DEFAULT NULL,
  `red_team_three_id` int(11) DEFAULT NULL,
  `blue_team_one_id` int(11) DEFAULT NULL,
  `blue_team_two_id` int(11) DEFAULT NULL,
  `blue_team_three_id` int(11) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notes_data`
--

DROP TABLE IF EXISTS `notes_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notes_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) NOT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `note_type` varchar(20) DEFAULT NULL,
  `note_text` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`,`tablet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_data`
--

DROP TABLE IF EXISTS `picture_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) NOT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `picture_type` varchar(20) DEFAULT NULL,
  `picture_uri` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`,`tablet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pit_data`
--

DROP TABLE IF EXISTS `pit_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pit_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) DEFAULT NULL,
  `pit_info` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `robot_data`
--

DROP TABLE IF EXISTS `robot_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `robot_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `competition_id` int(11) DEFAULT NULL,
  `drive_train_type` varchar(20) DEFAULT NULL,
  `wheel_type` varchar(20) DEFAULT NULL,
  `number_of_wheels` int(11) DEFAULT NULL,
  `number_of_tote_stacks` int(11) DEFAULT NULL,
  `number_of_totes_per_stack` int(11) DEFAULT NULL,
  `number_of_cans_robot_can_handle` int(11) DEFAULT NULL,
  `robot_can_get_step_cans` char(5) DEFAULT NULL,
  `robot_can_put_totes_on_step` char(5) DEFAULT NULL,
  `robot_software_language` varchar(20) DEFAULT NULL,
  `tote_manipulator_type` varchar(20) DEFAULT NULL,
  `can_manipulator_type` varchar(20) DEFAULT NULL,
  `robot_drive_range` varchar(20) DEFAULT NULL,
  `team_does_coopertition` char(5) DEFAULT NULL,
  `robot_stacks_from` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_channel`
--

DROP TABLE IF EXISTS `sym_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_channel` (
  `channel_id` varchar(128) NOT NULL,
  `processing_order` int(11) NOT NULL DEFAULT '1',
  `max_batch_size` int(11) NOT NULL DEFAULT '1000',
  `max_batch_to_send` int(11) NOT NULL DEFAULT '60',
  `max_data_to_route` int(11) NOT NULL DEFAULT '100000',
  `extract_period_millis` int(11) NOT NULL DEFAULT '0',
  `enabled` smallint(6) NOT NULL DEFAULT '1',
  `use_old_data_to_route` smallint(6) NOT NULL DEFAULT '1',
  `use_row_data_to_route` smallint(6) NOT NULL DEFAULT '1',
  `use_pk_data_to_route` smallint(6) NOT NULL DEFAULT '1',
  `reload_flag` smallint(6) NOT NULL DEFAULT '0',
  `file_sync_flag` smallint(6) NOT NULL DEFAULT '0',
  `contains_big_lob` smallint(6) NOT NULL DEFAULT '0',
  `batch_algorithm` varchar(50) NOT NULL DEFAULT 'default',
  `data_loader_type` varchar(50) NOT NULL DEFAULT 'default',
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_conflict`
--

DROP TABLE IF EXISTS `sym_conflict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_conflict` (
  `conflict_id` varchar(50) NOT NULL,
  `source_node_group_id` varchar(50) NOT NULL,
  `target_node_group_id` varchar(50) NOT NULL,
  `target_channel_id` varchar(128) DEFAULT NULL,
  `target_catalog_name` varchar(255) DEFAULT NULL,
  `target_schema_name` varchar(255) DEFAULT NULL,
  `target_table_name` varchar(255) DEFAULT NULL,
  `detect_type` varchar(128) NOT NULL,
  `detect_expression` mediumtext,
  `resolve_type` varchar(128) NOT NULL,
  `ping_back` varchar(128) NOT NULL,
  `resolve_changes_only` smallint(6) DEFAULT '0',
  `resolve_row_only` smallint(6) DEFAULT '0',
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`conflict_id`),
  KEY `sym_fk_cf_2_grp_lnk` (`source_node_group_id`,`target_node_group_id`),
  CONSTRAINT `sym_fk_cf_2_grp_lnk` FOREIGN KEY (`source_node_group_id`, `target_node_group_id`) REFERENCES `sym_node_group_link` (`source_node_group_id`, `target_node_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_data`
--

DROP TABLE IF EXISTS `sym_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_data` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) NOT NULL,
  `event_type` char(1) NOT NULL,
  `row_data` mediumtext,
  `pk_data` mediumtext,
  `old_data` mediumtext,
  `trigger_hist_id` int(11) NOT NULL,
  `channel_id` varchar(128) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `source_node_id` varchar(50) DEFAULT NULL,
  `external_data` varchar(50) DEFAULT NULL,
  `node_list` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`data_id`),
  KEY `sym_idx_d_channel_id` (`data_id`,`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_data_event`
--

DROP TABLE IF EXISTS `sym_data_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_data_event` (
  `data_id` bigint(20) NOT NULL,
  `batch_id` bigint(20) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`data_id`,`batch_id`,`router_id`),
  KEY `sym_idx_de_batchid` (`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_data_gap`
--

DROP TABLE IF EXISTS `sym_data_gap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_data_gap` (
  `start_id` bigint(20) NOT NULL,
  `end_id` bigint(20) NOT NULL,
  `status` char(2) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update_hostname` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`start_id`,`end_id`),
  KEY `sym_idx_dg_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_extension`
--

DROP TABLE IF EXISTS `sym_extension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_extension` (
  `extension_id` varchar(50) NOT NULL,
  `extension_type` varchar(10) NOT NULL,
  `interface_name` varchar(255) DEFAULT NULL,
  `node_group_id` varchar(50) NOT NULL,
  `enabled` smallint(6) NOT NULL DEFAULT '1',
  `extension_order` int(11) NOT NULL DEFAULT '1',
  `extension_text` mediumtext,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`extension_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_extract_request`
--

DROP TABLE IF EXISTS `sym_extract_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_extract_request` (
  `request_id` bigint(20) NOT NULL,
  `node_id` varchar(50) NOT NULL,
  `status` char(2) DEFAULT NULL,
  `start_batch_id` bigint(20) NOT NULL,
  `end_batch_id` bigint(20) NOT NULL,
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_file_incoming`
--

DROP TABLE IF EXISTS `sym_file_incoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_file_incoming` (
  `relative_dir` varchar(255) NOT NULL,
  `file_name` varchar(128) NOT NULL,
  `last_event_type` char(1) NOT NULL,
  `node_id` varchar(50) NOT NULL,
  `file_modified_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`relative_dir`,`file_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_file_snapshot`
--

DROP TABLE IF EXISTS `sym_file_snapshot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_file_snapshot` (
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `relative_dir` varchar(255) NOT NULL,
  `file_name` varchar(128) NOT NULL,
  `channel_id` varchar(128) NOT NULL DEFAULT 'filesync',
  `reload_channel_id` varchar(128) NOT NULL DEFAULT 'filesync_reload',
  `last_event_type` char(1) NOT NULL,
  `crc32_checksum` bigint(20) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `file_modified_time` bigint(20) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`trigger_id`,`router_id`,`relative_dir`,`file_name`),
  KEY `sym_idx_f_snpsht_chid` (`reload_channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_file_trigger`
--

DROP TABLE IF EXISTS `sym_file_trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_file_trigger` (
  `trigger_id` varchar(128) NOT NULL,
  `channel_id` varchar(128) NOT NULL DEFAULT 'filesync',
  `reload_channel_id` varchar(128) NOT NULL DEFAULT 'filesync_reload',
  `base_dir` varchar(255) NOT NULL,
  `recurse` smallint(6) NOT NULL DEFAULT '1',
  `includes_files` varchar(255) DEFAULT NULL,
  `excludes_files` varchar(255) DEFAULT NULL,
  `sync_on_create` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_modified` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_delete` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_ctl_file` smallint(6) NOT NULL DEFAULT '0',
  `delete_after_sync` smallint(6) NOT NULL DEFAULT '0',
  `before_copy_script` mediumtext,
  `after_copy_script` mediumtext,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`trigger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_file_trigger_router`
--

DROP TABLE IF EXISTS `sym_file_trigger_router`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_file_trigger_router` (
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `enabled` smallint(6) NOT NULL DEFAULT '1',
  `initial_load_enabled` smallint(6) NOT NULL DEFAULT '1',
  `target_base_dir` varchar(255) DEFAULT NULL,
  `conflict_strategy` varchar(128) NOT NULL DEFAULT 'source_wins',
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`trigger_id`,`router_id`),
  KEY `sym_fk_ftr_2_rtr` (`router_id`),
  CONSTRAINT `sym_fk_ftr_2_ftrg` FOREIGN KEY (`trigger_id`) REFERENCES `sym_file_trigger` (`trigger_id`),
  CONSTRAINT `sym_fk_ftr_2_rtr` FOREIGN KEY (`router_id`) REFERENCES `sym_router` (`router_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_grouplet`
--

DROP TABLE IF EXISTS `sym_grouplet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_grouplet` (
  `grouplet_id` varchar(50) NOT NULL,
  `grouplet_link_policy` char(1) NOT NULL DEFAULT 'I',
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`grouplet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_grouplet_link`
--

DROP TABLE IF EXISTS `sym_grouplet_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_grouplet_link` (
  `grouplet_id` varchar(50) NOT NULL,
  `external_id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`grouplet_id`,`external_id`),
  CONSTRAINT `sym_fk_gpltlnk_2_gplt` FOREIGN KEY (`grouplet_id`) REFERENCES `sym_grouplet` (`grouplet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_incoming_batch`
--

DROP TABLE IF EXISTS `sym_incoming_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_incoming_batch` (
  `batch_id` bigint(20) NOT NULL,
  `node_id` varchar(50) NOT NULL,
  `channel_id` varchar(128) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `error_flag` smallint(6) DEFAULT '0',
  `network_millis` bigint(20) NOT NULL DEFAULT '0',
  `filter_millis` bigint(20) NOT NULL DEFAULT '0',
  `database_millis` bigint(20) NOT NULL DEFAULT '0',
  `failed_row_number` bigint(20) NOT NULL DEFAULT '0',
  `failed_line_number` bigint(20) NOT NULL DEFAULT '0',
  `byte_count` bigint(20) NOT NULL DEFAULT '0',
  `statement_count` bigint(20) NOT NULL DEFAULT '0',
  `fallback_insert_count` bigint(20) NOT NULL DEFAULT '0',
  `fallback_update_count` bigint(20) NOT NULL DEFAULT '0',
  `ignore_count` bigint(20) NOT NULL DEFAULT '0',
  `missing_delete_count` bigint(20) NOT NULL DEFAULT '0',
  `skip_count` bigint(20) NOT NULL DEFAULT '0',
  `sql_state` varchar(10) DEFAULT NULL,
  `sql_code` int(11) NOT NULL DEFAULT '0',
  `sql_message` mediumtext,
  `last_update_hostname` varchar(255) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`batch_id`,`node_id`),
  KEY `sym_idx_ib_time_status` (`create_time`,`status`),
  KEY `sym_idx_ib_in_error` (`error_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_incoming_error`
--

DROP TABLE IF EXISTS `sym_incoming_error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_incoming_error` (
  `batch_id` bigint(20) NOT NULL,
  `node_id` varchar(50) NOT NULL,
  `failed_row_number` bigint(20) NOT NULL,
  `failed_line_number` bigint(20) NOT NULL DEFAULT '0',
  `target_catalog_name` varchar(255) DEFAULT NULL,
  `target_schema_name` varchar(255) DEFAULT NULL,
  `target_table_name` varchar(255) NOT NULL,
  `event_type` char(1) NOT NULL,
  `binary_encoding` varchar(10) NOT NULL DEFAULT 'HEX',
  `column_names` mediumtext NOT NULL,
  `pk_column_names` mediumtext NOT NULL,
  `row_data` mediumtext,
  `old_data` mediumtext,
  `cur_data` mediumtext,
  `resolve_data` mediumtext,
  `resolve_ignore` smallint(6) DEFAULT '0',
  `conflict_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`batch_id`,`node_id`,`failed_row_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_load_filter`
--

DROP TABLE IF EXISTS `sym_load_filter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_load_filter` (
  `load_filter_id` varchar(50) NOT NULL,
  `load_filter_type` varchar(10) NOT NULL,
  `source_node_group_id` varchar(50) NOT NULL,
  `target_node_group_id` varchar(50) NOT NULL,
  `target_catalog_name` varchar(255) DEFAULT NULL,
  `target_schema_name` varchar(255) DEFAULT NULL,
  `target_table_name` varchar(255) DEFAULT NULL,
  `filter_on_update` smallint(6) NOT NULL DEFAULT '1',
  `filter_on_insert` smallint(6) NOT NULL DEFAULT '1',
  `filter_on_delete` smallint(6) NOT NULL DEFAULT '1',
  `before_write_script` mediumtext,
  `after_write_script` mediumtext,
  `batch_complete_script` mediumtext,
  `batch_commit_script` mediumtext,
  `batch_rollback_script` mediumtext,
  `handle_error_script` mediumtext,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `load_filter_order` int(11) NOT NULL DEFAULT '1',
  `fail_on_error` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`load_filter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_lock`
--

DROP TABLE IF EXISTS `sym_lock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_lock` (
  `lock_action` varchar(50) NOT NULL,
  `lock_type` varchar(50) NOT NULL,
  `locking_server_id` varchar(255) DEFAULT NULL,
  `lock_time` datetime DEFAULT NULL,
  `shared_count` int(11) NOT NULL DEFAULT '0',
  `shared_enable` int(11) NOT NULL DEFAULT '0',
  `last_lock_time` datetime DEFAULT NULL,
  `last_locking_server_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lock_action`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node`
--

DROP TABLE IF EXISTS `sym_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node` (
  `node_id` varchar(50) NOT NULL,
  `node_group_id` varchar(50) NOT NULL,
  `external_id` varchar(50) NOT NULL,
  `sync_enabled` smallint(6) DEFAULT '0',
  `sync_url` varchar(255) DEFAULT NULL,
  `schema_version` varchar(50) DEFAULT NULL,
  `symmetric_version` varchar(50) DEFAULT NULL,
  `database_type` varchar(50) DEFAULT NULL,
  `database_version` varchar(50) DEFAULT NULL,
  `heartbeat_time` datetime DEFAULT NULL,
  `timezone_offset` varchar(6) DEFAULT NULL,
  `batch_to_send_count` int(11) DEFAULT '0',
  `batch_in_error_count` int(11) DEFAULT '0',
  `created_at_node_id` varchar(50) DEFAULT NULL,
  `deployment_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_channel_ctl`
--

DROP TABLE IF EXISTS `sym_node_channel_ctl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_channel_ctl` (
  `node_id` varchar(50) NOT NULL,
  `channel_id` varchar(128) NOT NULL,
  `suspend_enabled` smallint(6) DEFAULT '0',
  `ignore_enabled` smallint(6) DEFAULT '0',
  `last_extract_time` datetime DEFAULT NULL,
  PRIMARY KEY (`node_id`,`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_communication`
--

DROP TABLE IF EXISTS `sym_node_communication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_communication` (
  `node_id` varchar(50) NOT NULL,
  `communication_type` varchar(10) NOT NULL,
  `lock_time` datetime DEFAULT NULL,
  `locking_server_id` varchar(255) DEFAULT NULL,
  `last_lock_time` datetime DEFAULT NULL,
  `last_lock_millis` bigint(20) DEFAULT '0',
  `success_count` bigint(20) DEFAULT '0',
  `fail_count` bigint(20) DEFAULT '0',
  `total_success_count` bigint(20) DEFAULT '0',
  `total_fail_count` bigint(20) DEFAULT '0',
  `total_success_millis` bigint(20) DEFAULT '0',
  `total_fail_millis` bigint(20) DEFAULT '0',
  PRIMARY KEY (`node_id`,`communication_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_group`
--

DROP TABLE IF EXISTS `sym_node_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_group` (
  `node_group_id` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`node_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_group_channel_wnd`
--

DROP TABLE IF EXISTS `sym_node_group_channel_wnd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_group_channel_wnd` (
  `node_group_id` varchar(50) NOT NULL,
  `channel_id` varchar(128) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `enabled` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`node_group_id`,`channel_id`,`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_group_link`
--

DROP TABLE IF EXISTS `sym_node_group_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_group_link` (
  `source_node_group_id` varchar(50) NOT NULL,
  `target_node_group_id` varchar(50) NOT NULL,
  `data_event_action` char(1) NOT NULL DEFAULT 'W',
  `sync_config_enabled` smallint(6) NOT NULL DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`source_node_group_id`,`target_node_group_id`),
  KEY `sym_fk_lnk_2_grp_tgt` (`target_node_group_id`),
  CONSTRAINT `sym_fk_lnk_2_grp_src` FOREIGN KEY (`source_node_group_id`) REFERENCES `sym_node_group` (`node_group_id`),
  CONSTRAINT `sym_fk_lnk_2_grp_tgt` FOREIGN KEY (`target_node_group_id`) REFERENCES `sym_node_group` (`node_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_host`
--

DROP TABLE IF EXISTS `sym_node_host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_host` (
  `node_id` varchar(50) NOT NULL,
  `host_name` varchar(60) NOT NULL,
  `ip_address` varchar(50) DEFAULT NULL,
  `os_user` varchar(50) DEFAULT NULL,
  `os_name` varchar(50) DEFAULT NULL,
  `os_arch` varchar(50) DEFAULT NULL,
  `os_version` varchar(50) DEFAULT NULL,
  `available_processors` int(11) DEFAULT '0',
  `free_memory_bytes` bigint(20) DEFAULT '0',
  `total_memory_bytes` bigint(20) DEFAULT '0',
  `max_memory_bytes` bigint(20) DEFAULT '0',
  `java_version` varchar(50) DEFAULT NULL,
  `java_vendor` varchar(255) DEFAULT NULL,
  `jdbc_version` varchar(255) DEFAULT NULL,
  `symmetric_version` varchar(50) DEFAULT NULL,
  `timezone_offset` varchar(6) DEFAULT NULL,
  `heartbeat_time` datetime DEFAULT NULL,
  `last_restart_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`node_id`,`host_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_host_channel_stats`
--

DROP TABLE IF EXISTS `sym_node_host_channel_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_host_channel_stats` (
  `node_id` varchar(50) NOT NULL,
  `host_name` varchar(60) NOT NULL,
  `channel_id` varchar(128) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `data_routed` bigint(20) DEFAULT '0',
  `data_unrouted` bigint(20) DEFAULT '0',
  `data_event_inserted` bigint(20) DEFAULT '0',
  `data_extracted` bigint(20) DEFAULT '0',
  `data_bytes_extracted` bigint(20) DEFAULT '0',
  `data_extracted_errors` bigint(20) DEFAULT '0',
  `data_bytes_sent` bigint(20) DEFAULT '0',
  `data_sent` bigint(20) DEFAULT '0',
  `data_sent_errors` bigint(20) DEFAULT '0',
  `data_loaded` bigint(20) DEFAULT '0',
  `data_bytes_loaded` bigint(20) DEFAULT '0',
  `data_loaded_errors` bigint(20) DEFAULT '0',
  PRIMARY KEY (`node_id`,`host_name`,`channel_id`,`start_time`,`end_time`),
  KEY `sym_idx_nd_hst_chnl_sts` (`node_id`,`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_host_job_stats`
--

DROP TABLE IF EXISTS `sym_node_host_job_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_host_job_stats` (
  `node_id` varchar(50) NOT NULL,
  `host_name` varchar(60) NOT NULL,
  `job_name` varchar(50) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `processed_count` bigint(20) DEFAULT '0',
  PRIMARY KEY (`node_id`,`host_name`,`job_name`,`start_time`,`end_time`),
  KEY `sym_idx_nd_hst_job` (`node_id`,`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_host_stats`
--

DROP TABLE IF EXISTS `sym_node_host_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_host_stats` (
  `node_id` varchar(50) NOT NULL,
  `host_name` varchar(60) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `restarted` bigint(20) NOT NULL DEFAULT '0',
  `nodes_pulled` bigint(20) DEFAULT '0',
  `total_nodes_pull_time` bigint(20) DEFAULT '0',
  `nodes_pushed` bigint(20) DEFAULT '0',
  `total_nodes_push_time` bigint(20) DEFAULT '0',
  `nodes_rejected` bigint(20) DEFAULT '0',
  `nodes_registered` bigint(20) DEFAULT '0',
  `nodes_loaded` bigint(20) DEFAULT '0',
  `nodes_disabled` bigint(20) DEFAULT '0',
  `purged_data_rows` bigint(20) DEFAULT '0',
  `purged_data_event_rows` bigint(20) DEFAULT '0',
  `purged_batch_outgoing_rows` bigint(20) DEFAULT '0',
  `purged_batch_incoming_rows` bigint(20) DEFAULT '0',
  `triggers_created_count` bigint(20) DEFAULT NULL,
  `triggers_rebuilt_count` bigint(20) DEFAULT NULL,
  `triggers_removed_count` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`node_id`,`host_name`,`start_time`,`end_time`),
  KEY `sym_idx_nd_hst_sts` (`node_id`,`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_identity`
--

DROP TABLE IF EXISTS `sym_node_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_identity` (
  `node_id` varchar(50) NOT NULL,
  PRIMARY KEY (`node_id`),
  CONSTRAINT `sym_fk_ident_2_node` FOREIGN KEY (`node_id`) REFERENCES `sym_node` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_node_security`
--

DROP TABLE IF EXISTS `sym_node_security`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_node_security` (
  `node_id` varchar(50) NOT NULL,
  `node_password` varchar(50) NOT NULL,
  `registration_enabled` smallint(6) DEFAULT '0',
  `registration_time` datetime DEFAULT NULL,
  `initial_load_enabled` smallint(6) DEFAULT '0',
  `initial_load_time` datetime DEFAULT NULL,
  `initial_load_id` bigint(20) DEFAULT NULL,
  `initial_load_create_by` varchar(255) DEFAULT NULL,
  `rev_initial_load_enabled` smallint(6) DEFAULT '0',
  `rev_initial_load_time` datetime DEFAULT NULL,
  `rev_initial_load_id` bigint(20) DEFAULT NULL,
  `rev_initial_load_create_by` varchar(255) DEFAULT NULL,
  `created_at_node_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`node_id`),
  CONSTRAINT `sym_fk_sec_2_node` FOREIGN KEY (`node_id`) REFERENCES `sym_node` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_outgoing_batch`
--

DROP TABLE IF EXISTS `sym_outgoing_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_outgoing_batch` (
  `batch_id` bigint(20) NOT NULL,
  `node_id` varchar(50) NOT NULL,
  `channel_id` varchar(128) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `load_id` bigint(20) DEFAULT NULL,
  `extract_job_flag` smallint(6) DEFAULT '0',
  `load_flag` smallint(6) DEFAULT '0',
  `error_flag` smallint(6) DEFAULT '0',
  `common_flag` smallint(6) DEFAULT '0',
  `ignore_count` bigint(20) NOT NULL DEFAULT '0',
  `byte_count` bigint(20) NOT NULL DEFAULT '0',
  `extract_count` bigint(20) NOT NULL DEFAULT '0',
  `sent_count` bigint(20) NOT NULL DEFAULT '0',
  `load_count` bigint(20) NOT NULL DEFAULT '0',
  `data_event_count` bigint(20) NOT NULL DEFAULT '0',
  `reload_event_count` bigint(20) NOT NULL DEFAULT '0',
  `insert_event_count` bigint(20) NOT NULL DEFAULT '0',
  `update_event_count` bigint(20) NOT NULL DEFAULT '0',
  `delete_event_count` bigint(20) NOT NULL DEFAULT '0',
  `other_event_count` bigint(20) NOT NULL DEFAULT '0',
  `router_millis` bigint(20) NOT NULL DEFAULT '0',
  `network_millis` bigint(20) NOT NULL DEFAULT '0',
  `filter_millis` bigint(20) NOT NULL DEFAULT '0',
  `load_millis` bigint(20) NOT NULL DEFAULT '0',
  `extract_millis` bigint(20) NOT NULL DEFAULT '0',
  `transform_extract_millis` bigint(20) NOT NULL DEFAULT '0',
  `transform_load_millis` bigint(20) NOT NULL DEFAULT '0',
  `total_extract_millis` bigint(20) NOT NULL DEFAULT '0',
  `total_load_millis` bigint(20) NOT NULL DEFAULT '0',
  `sql_state` varchar(10) DEFAULT NULL,
  `sql_code` int(11) NOT NULL DEFAULT '0',
  `sql_message` mediumtext,
  `failed_data_id` bigint(20) NOT NULL DEFAULT '0',
  `failed_line_number` bigint(20) NOT NULL DEFAULT '0',
  `last_update_hostname` varchar(255) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`batch_id`,`node_id`),
  KEY `sym_idx_ob_node_status` (`node_id`,`status`),
  KEY `sym_idx_ob_status` (`status`),
  KEY `sym_idx_ob_in_error` (`error_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_parameter`
--

DROP TABLE IF EXISTS `sym_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_parameter` (
  `external_id` varchar(50) NOT NULL,
  `node_group_id` varchar(50) NOT NULL,
  `param_key` varchar(80) NOT NULL,
  `param_value` mediumtext,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`external_id`,`node_group_id`,`param_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_registration_redirect`
--

DROP TABLE IF EXISTS `sym_registration_redirect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_registration_redirect` (
  `registrant_external_id` varchar(50) NOT NULL,
  `registration_node_id` varchar(50) NOT NULL,
  PRIMARY KEY (`registrant_external_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_registration_request`
--

DROP TABLE IF EXISTS `sym_registration_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_registration_request` (
  `node_group_id` varchar(50) NOT NULL,
  `external_id` varchar(50) NOT NULL,
  `status` char(2) NOT NULL,
  `host_name` varchar(60) NOT NULL,
  `ip_address` varchar(50) NOT NULL,
  `attempt_count` int(11) DEFAULT '0',
  `registered_node_id` varchar(50) DEFAULT NULL,
  `error_message` mediumtext,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`node_group_id`,`external_id`,`create_time`),
  KEY `sym_idx_reg_req_1` (`node_group_id`,`external_id`,`status`,`host_name`,`ip_address`),
  KEY `sym_idx_reg_req_2` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_router`
--

DROP TABLE IF EXISTS `sym_router`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_router` (
  `router_id` varchar(50) NOT NULL,
  `target_catalog_name` varchar(255) DEFAULT NULL,
  `target_schema_name` varchar(255) DEFAULT NULL,
  `target_table_name` varchar(255) DEFAULT NULL,
  `source_node_group_id` varchar(50) NOT NULL,
  `target_node_group_id` varchar(50) NOT NULL,
  `router_type` varchar(50) DEFAULT NULL,
  `router_expression` mediumtext,
  `sync_on_update` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_insert` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_delete` smallint(6) NOT NULL DEFAULT '1',
  `use_source_catalog_schema` smallint(6) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`router_id`),
  KEY `sym_fk_rt_2_grp_lnk` (`source_node_group_id`,`target_node_group_id`),
  CONSTRAINT `sym_fk_rt_2_grp_lnk` FOREIGN KEY (`source_node_group_id`, `target_node_group_id`) REFERENCES `sym_node_group_link` (`source_node_group_id`, `target_node_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_sequence`
--

DROP TABLE IF EXISTS `sym_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_sequence` (
  `sequence_name` varchar(50) NOT NULL,
  `current_value` bigint(20) NOT NULL DEFAULT '0',
  `increment_by` int(11) NOT NULL DEFAULT '1',
  `min_value` bigint(20) NOT NULL DEFAULT '1',
  `max_value` bigint(20) NOT NULL DEFAULT '9999999999',
  `cycle` smallint(6) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_table_reload_request`
--

DROP TABLE IF EXISTS `sym_table_reload_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_table_reload_request` (
  `target_node_id` varchar(50) NOT NULL,
  `source_node_id` varchar(50) NOT NULL,
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `reload_select` mediumtext,
  `reload_delete_stmt` mediumtext,
  `reload_enabled` smallint(6) DEFAULT '0',
  `reload_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`target_node_id`,`source_node_id`,`trigger_id`,`router_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_transform_column`
--

DROP TABLE IF EXISTS `sym_transform_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_transform_column` (
  `transform_id` varchar(50) NOT NULL,
  `include_on` char(1) NOT NULL DEFAULT '*',
  `target_column_name` varchar(128) NOT NULL,
  `source_column_name` varchar(128) DEFAULT NULL,
  `pk` smallint(6) DEFAULT '0',
  `transform_type` varchar(50) DEFAULT 'copy',
  `transform_expression` mediumtext,
  `transform_order` int(11) NOT NULL DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`transform_id`,`include_on`,`target_column_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_transform_table`
--

DROP TABLE IF EXISTS `sym_transform_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_transform_table` (
  `transform_id` varchar(50) NOT NULL,
  `source_node_group_id` varchar(50) NOT NULL,
  `target_node_group_id` varchar(50) NOT NULL,
  `transform_point` varchar(10) NOT NULL,
  `source_catalog_name` varchar(255) DEFAULT NULL,
  `source_schema_name` varchar(255) DEFAULT NULL,
  `source_table_name` varchar(255) NOT NULL,
  `target_catalog_name` varchar(255) DEFAULT NULL,
  `target_schema_name` varchar(255) DEFAULT NULL,
  `target_table_name` varchar(255) DEFAULT NULL,
  `update_first` smallint(6) DEFAULT '0',
  `delete_action` varchar(10) NOT NULL,
  `transform_order` int(11) NOT NULL DEFAULT '1',
  `column_policy` varchar(10) NOT NULL DEFAULT 'SPECIFIED',
  `create_time` datetime DEFAULT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`transform_id`,`source_node_group_id`,`target_node_group_id`),
  KEY `sym_fk_tt_2_grp_lnk` (`source_node_group_id`,`target_node_group_id`),
  CONSTRAINT `sym_fk_tt_2_grp_lnk` FOREIGN KEY (`source_node_group_id`, `target_node_group_id`) REFERENCES `sym_node_group_link` (`source_node_group_id`, `target_node_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_trigger`
--

DROP TABLE IF EXISTS `sym_trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_trigger` (
  `trigger_id` varchar(128) NOT NULL,
  `source_catalog_name` varchar(255) DEFAULT NULL,
  `source_schema_name` varchar(255) DEFAULT NULL,
  `source_table_name` varchar(255) NOT NULL,
  `channel_id` varchar(128) NOT NULL,
  `reload_channel_id` varchar(128) NOT NULL DEFAULT 'reload',
  `sync_on_update` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_insert` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_delete` smallint(6) NOT NULL DEFAULT '1',
  `sync_on_incoming_batch` smallint(6) NOT NULL DEFAULT '0',
  `name_for_update_trigger` varchar(255) DEFAULT NULL,
  `name_for_insert_trigger` varchar(255) DEFAULT NULL,
  `name_for_delete_trigger` varchar(255) DEFAULT NULL,
  `sync_on_update_condition` mediumtext,
  `sync_on_insert_condition` mediumtext,
  `sync_on_delete_condition` mediumtext,
  `custom_on_update_text` mediumtext,
  `custom_on_insert_text` mediumtext,
  `custom_on_delete_text` mediumtext,
  `external_select` mediumtext,
  `tx_id_expression` mediumtext,
  `channel_expression` mediumtext,
  `excluded_column_names` mediumtext,
  `sync_key_names` mediumtext,
  `use_stream_lobs` smallint(6) NOT NULL DEFAULT '0',
  `use_capture_lobs` smallint(6) NOT NULL DEFAULT '0',
  `use_capture_old_data` smallint(6) NOT NULL DEFAULT '1',
  `use_handle_key_updates` smallint(6) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`trigger_id`),
  KEY `sym_fk_trg_2_chnl` (`channel_id`),
  KEY `sym_fk_trg_2_rld_chnl` (`reload_channel_id`),
  CONSTRAINT `sym_fk_trg_2_chnl` FOREIGN KEY (`channel_id`) REFERENCES `sym_channel` (`channel_id`),
  CONSTRAINT `sym_fk_trg_2_rld_chnl` FOREIGN KEY (`reload_channel_id`) REFERENCES `sym_channel` (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_trigger_hist`
--

DROP TABLE IF EXISTS `sym_trigger_hist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_trigger_hist` (
  `trigger_hist_id` int(11) NOT NULL,
  `trigger_id` varchar(128) NOT NULL,
  `source_table_name` varchar(255) NOT NULL,
  `source_catalog_name` varchar(255) DEFAULT NULL,
  `source_schema_name` varchar(255) DEFAULT NULL,
  `name_for_update_trigger` varchar(255) DEFAULT NULL,
  `name_for_insert_trigger` varchar(255) DEFAULT NULL,
  `name_for_delete_trigger` varchar(255) DEFAULT NULL,
  `table_hash` bigint(20) NOT NULL DEFAULT '0',
  `trigger_row_hash` bigint(20) NOT NULL DEFAULT '0',
  `trigger_template_hash` bigint(20) NOT NULL DEFAULT '0',
  `column_names` mediumtext NOT NULL,
  `pk_column_names` mediumtext NOT NULL,
  `last_trigger_build_reason` char(1) NOT NULL,
  `error_message` mediumtext,
  `create_time` datetime NOT NULL,
  `inactive_time` datetime DEFAULT NULL,
  PRIMARY KEY (`trigger_hist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_trigger_router`
--

DROP TABLE IF EXISTS `sym_trigger_router`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_trigger_router` (
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `enabled` smallint(6) NOT NULL DEFAULT '1',
  `initial_load_order` int(11) NOT NULL DEFAULT '1',
  `initial_load_select` mediumtext,
  `initial_load_delete_stmt` mediumtext,
  `initial_load_batch_count` int(11) DEFAULT '1',
  `ping_back_enabled` smallint(6) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`trigger_id`,`router_id`),
  KEY `sym_fk_tr_2_rtr` (`router_id`),
  CONSTRAINT `sym_fk_tr_2_rtr` FOREIGN KEY (`router_id`) REFERENCES `sym_router` (`router_id`),
  CONSTRAINT `sym_fk_tr_2_trg` FOREIGN KEY (`trigger_id`) REFERENCES `sym_trigger` (`trigger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sym_trigger_router_grouplet`
--

DROP TABLE IF EXISTS `sym_trigger_router_grouplet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sym_trigger_router_grouplet` (
  `grouplet_id` varchar(50) NOT NULL,
  `trigger_id` varchar(128) NOT NULL,
  `router_id` varchar(50) NOT NULL,
  `applies_when` char(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_update_by` varchar(50) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  PRIMARY KEY (`grouplet_id`,`trigger_id`,`router_id`,`applies_when`),
  KEY `sym_fk_trgplt_2_tr` (`trigger_id`,`router_id`),
  CONSTRAINT `sym_fk_trgplt_2_gplt` FOREIGN KEY (`grouplet_id`) REFERENCES `sym_grouplet` (`grouplet_id`),
  CONSTRAINT `sym_fk_trgplt_2_tr` FOREIGN KEY (`trigger_id`, `router_id`) REFERENCES `sym_trigger_router` (`trigger_id`, `router_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_data`
--

DROP TABLE IF EXISTS `team_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_data` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) DEFAULT NULL,
  `team_number` int(11) DEFAULT NULL,
  `team_sub_number` int(11) DEFAULT NULL,
  `team_name` varchar(255) DEFAULT NULL,
  `team_city` varchar(255) DEFAULT NULL,
  `team_state` varchar(255) DEFAULT NULL,
  `num_team_members` int(11) DEFAULT NULL,
  `team_creation_year` int(11) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_match`
--

DROP TABLE IF EXISTS `team_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_match` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) NOT NULL DEFAULT '0',
  `team_id` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  `competition_id` int(11) DEFAULT NULL,
  `alliance_position` varchar(20) DEFAULT NULL,
  `broke_down` char(5) DEFAULT NULL,
  `no_move` char(5) DEFAULT NULL,
  `lost_connection` char(5) DEFAULT NULL,
  `starting_location` int(11) DEFAULT NULL,
  `starting_location_X` int(11) DEFAULT NULL,
  `starting_location_Y` int(11) DEFAULT NULL,
  `starting_location_on_field` varchar(255) DEFAULT NULL,
  `auto_totes_picked_up` int(11) DEFAULT NULL,
  `auto_totes_stacked` int(11) DEFAULT NULL,
  `auto_totes_scored` int(11) DEFAULT NULL,
  `auto_cans_picked_up` int(11) DEFAULT NULL,
  `auto_cans_scored` int(11) DEFAULT NULL,
  `auto_cans_pulled_from_step` int(11) DEFAULT NULL,
  `auto_mode_saved` varchar(5) DEFAULT NULL,
  `auto_final_location_X` int(11) DEFAULT NULL,
  `auto_final_location_Y` int(11) DEFAULT NULL,
  `auto_tote_1_location_X` int(11) DEFAULT NULL,
  `auto_tote_1_location_Y` int(11) DEFAULT NULL,
  `auto_tote_2_location_X` int(11) DEFAULT NULL,
  `auto_tote_2_location_Y` int(11) DEFAULT NULL,
  `auto_tote_3_location_X` int(11) DEFAULT NULL,
  `auto_tote_3_location_Y` int(11) DEFAULT NULL,
  `auto_can_1_location_X` int(11) DEFAULT NULL,
  `auto_can_1_location_Y` int(11) DEFAULT NULL,
  `auto_can_2_location_X` int(11) DEFAULT NULL,
  `auto_can_2_location_Y` int(11) DEFAULT NULL,
  `auto_can_3_location_X` int(11) DEFAULT NULL,
  `auto_can_3_location_Y` int(11) DEFAULT NULL,
  `auto_can_4_location_X` int(11) DEFAULT NULL,
  `auto_can_4_location_Y` int(11) DEFAULT NULL,
  `auto_can_5_location_X` int(11) DEFAULT NULL,
  `auto_can_5_location_Y` int(11) DEFAULT NULL,
  `auto_can_6_location_X` int(11) DEFAULT NULL,
  `auto_can_6_location_Y` int(11) DEFAULT NULL,
  `auto_can_7_location_X` int(11) DEFAULT NULL,
  `auto_can_7_location_Y` int(11) DEFAULT NULL,
  `auto_robot_visible` varchar(5) DEFAULT NULL,
  `auto_tote1_visible` varchar(5) DEFAULT NULL,
  `auto_tote2_visible` varchar(5) DEFAULT NULL,
  `auto_tote3_visible` varchar(5) DEFAULT NULL,
  `auto_can1_visible` varchar(5) DEFAULT NULL,
  `auto_can2_visible` varchar(5) DEFAULT NULL,
  `auto_can3_visible` varchar(5) DEFAULT NULL,
  `auto_can4_visible` varchar(5) DEFAULT NULL,
  `auto_can5_visible` varchar(5) DEFAULT NULL,
  `auto_can6_visible` varchar(5) DEFAULT NULL,
  `auto_can7_visible` varchar(5) DEFAULT NULL,
  `auto_robot_stack_list` varchar(255) DEFAULT NULL,
  `team_match_notes` varchar(255) DEFAULT NULL,
  `tote_stacker` varchar(5) DEFAULT NULL,
  `can_kinger` varchar(5) DEFAULT NULL,
  `cooperative` varchar(5) DEFAULT NULL,
  `noodler` varchar(5) DEFAULT NULL,
  `ni` varchar(5) DEFAULT NULL,
  `tote_control_inside_robot` varchar(5) DEFAULT NULL,
  `tote_control_fork_lift` varchar(5) DEFAULT NULL,
  `tote_control_handle_grabber` varchar(5) DEFAULT NULL,
  `tote_control_drop_alot` varchar(5) DEFAULT NULL,
  `tote_control_great_control` varchar(5) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`,`tablet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_match_transaction`
--

DROP TABLE IF EXISTS `team_match_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_match_transaction` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `tablet_id` int(11) NOT NULL DEFAULT '0',
  `team_id` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  `transaction_timestamp` varchar(16) DEFAULT NULL,
  `action_name` varchar(20) DEFAULT NULL,
  `action_phase` varchar(20) DEFAULT NULL,
  `action_start_location_name` varchar(20) DEFAULT NULL,
  `action_start_location_X` int(11) DEFAULT NULL,
  `action_start_location_Y` int(11) DEFAULT NULL,
  `action_end_location_name` varchar(20) DEFAULT NULL,
  `action_end_location_X` int(11) DEFAULT NULL,
  `action_end_location_Y` int(11) DEFAULT NULL,
  `element_types` varchar(255) DEFAULT NULL,
  `element_states` varchar(255) DEFAULT NULL,
  `ready_to_export` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`_id`,`tablet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'firstteamscouter'
--

--
-- Dumping routines for database 'firstteamscouter'
--
/*!50003 DROP FUNCTION IF EXISTS `sym_transaction_id_post_5_1_23` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`symmetric`@`%` FUNCTION `sym_transaction_id_post_5_1_23`() RETURNS varchar(50) CHARSET utf8
    READS SQL DATA
begin                                                                                                                          
    declare comm_value varchar(50);                                                                                             
    declare comm_cur cursor for select VARIABLE_VALUE from INFORMATION_SCHEMA.SESSION_STATUS where VARIABLE_NAME='COM_COMMIT';  
    open comm_cur;                                                                                                              
    fetch comm_cur into comm_value;                                                                                             
    close comm_cur;                                                                                                             
    return concat(concat(connection_id(), '.'), comm_value);                                                                    
 end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-07 21:36:41
