CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vw_team_match` AS
    SELECT 
        `e`.`name` AS `event_name`,
        `e`.`short_name` AS `event_short_name`,
        `e`.`event_type` AS `event_type`,
        `e`.`event_district` AS `event_district`,
        `e`.`year` AS `year`,
        `e`.`week` AS `week`,
        `e`.`location` AS `location`,
        `m`.`event_id` AS `event_id`,
        `m`.`comp_level` AS `comp_level`,
        `m`.`set_number` AS `set_number`,
        `m`.`match_number` AS `match_number`,
        `m`.`status` AS `status`,
        `m`.`red_1_team_id` AS `red_1_team_id`,
        `m`.`red_2_team_id` AS `red_2_team_id`,
        `m`.`red_3_team_id` AS `red_3_team_id`,
        `m`.`red_auto_score` AS `red_auto_score`,
        `m`.`red_teleop_score` AS `red_teleop_score`,
        `m`.`red_total_score` AS `red_total_score`,
        `m`.`red_qp` AS `red_qp`,
        `m`.`red_foul_points` AS `red_foul_points`,
        `m`.`blue_1_team_id` AS `blue_1_team_id`,
        `m`.`blue_2_team_id` AS `blue_2_team_id`,
        `m`.`blue_3_team_id` AS `blue_3_team_id`,
        `m`.`blue_auto_score` AS `blue_auto_score`,
        `m`.`blue_teleop_score` AS `blue_teleop_score`,
        `m`.`blue_total_score` AS `blue_total_score`,
        `m`.`blue_qp` AS `blue_qp`,
        `m`.`blue_foul_points` AS `blue_foul_points`,
        `m`.`winner` AS `winner`,
        `m`.`drive_team_comments` AS `drive_team_comments`,
        `tm`.`_id` AS `team_match_id`,
        `tm`.`team_id` AS `team_id`,
        `tm`.`match_id` AS `match_id`,
        `tm`.`alliance` AS `alliance`,
        `tm`.`position` AS `position`,
        `tm`.`scout_name` AS `scout_name`,
        `t`.`team_number` AS `team_number`,
        `t`.`long_name` AS `team_long_name`,
        `t`.`name` AS `team_name`,
        `t`.`fuel_container_volume` AS `fuel_container_volume`
    FROM
        (((`event` `e`
        JOIN `match` `m` ON ((`e`.`_id` = `m`.`event_id`)))
        JOIN `team_match` `tm` ON ((`m`.`_id` = `tm`.`match_id`)))
        JOIN `team` `t` ON ((`tm`.`team_id` = `t`.`_id`)))