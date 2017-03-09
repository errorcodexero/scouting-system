CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vw_team_match_action` AS
    SELECT 
        `tma`.`_id` AS `team_match_action_id`,
        `tma`.`team_match_id` AS `team_match_id`,
        `tm`.`team_id` AS `team_id`,
        `tm`.`match_id` AS `match_id`,
        `m`.`match_number` AS `match_number`,
        `tma`.`action_type_id` AS `action_type_id`,
        `tma`.`quantity` AS `quantity`,
        `tma`.`start_time` AS `start_time`,
        `tma`.`end_time` AS `end_time`,
        `tma`.`object_count` AS `object_count`,
        `at`.`name` AS `action_name`,
        `at`.`description` AS `action_description`,
        `at`.`match_phase` AS `match_phase`,
        `at`.`points` AS `points`,
        `at`.`opponent_points` AS `opponent_points`,
        `at`.`qual_points` AS `qual_points`,
        `at`.`foul_points` AS `foul_points`,
        `at`.`coop_flag` AS `coop_flag`,
        `at`.`category` AS `category`
    FROM
        (((`action_type` `at`
        JOIN `team_match_action` `tma` ON ((`at`.`_id` = `tma`.`action_type_id`)))
        JOIN `team_match` `tm` ON ((`tm`.`_id` = `tma`.`team_match_id`)))
        JOIN `match` `m` ON ((`tm`.`match_id` = `m`.`_id`)))