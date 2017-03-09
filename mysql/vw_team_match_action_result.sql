CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `team_match_action_result` AS
    SELECT 
        `tm`.`event_name` AS `event_name`,
        `tm`.`team_name` AS `team_name`,
        `tm`.`team_number` AS `team_number`,
        `tm`.`alliance` AS `alliance`,
        `tm`.`position` AS `position`,
        ((SELECT 
                COUNT(0)
            FROM
                `vw_team_match` `a`
            WHERE
                ((`a`.`match_number` < `tmap`.`match_number`)
                    AND (`a`.`team_id` = `tmap`.`team_id`))) + 1) AS `team_match_seq`,
        (CASE `tm`.`alliance`
            WHEN 'red' THEN `tm`.`red_total_score`
            WHEN 'blue' THEN `tm`.`blue_total_score`
        END) AS `score`,
        (CASE `tm`.`alliance`
            WHEN 'red' THEN `tm`.`blue_total_score`
            WHEN 'blue' THEN `tm`.`red_total_score`
        END) AS `opp_score`,
        (CASE `tm`.`alliance`
            WHEN 'red' THEN `tm`.`red_qp`
            WHEN 'blue' THEN `tm`.`blue_qp`
        END) AS `qp`,
        (CASE
            WHEN (`tm`.`winner` = 'draw') THEN 'draw'
            WHEN (`tm`.`winner` = `tm`.`alliance`) THEN 'win'
            ELSE 'loss'
        END) AS `result`,
        IF((`tm`.`winner` = `tm`.`alliance`),
            1,
            0) AS `wins`,
        IF((`tm`.`winner` = 'draw'), 1, 0) AS `draws`,
        IF(((`tm`.`winner` <> `tm`.`alliance`)
                AND (`tm`.`winner` <> 'draw')),
            1,
            0) AS `losses`,
        (CASE `tm`.`alliance`
            WHEN 'blue' THEN `tm`.`blue_total_score`
            WHEN 'red' THEN `tm`.`red_total_score`
        END) AS `match_total_score`,
        (CASE `tm`.`alliance`
            WHEN 'blue' THEN `tm`.`blue_auto_score`
            WHEN 'red' THEN `tm`.`red_auto_score`
        END) AS `match_auto_score`,
        (CASE `tm`.`alliance`
            WHEN 'blue' THEN `tm`.`blue_teleop_score`
            WHEN 'red' THEN `tm`.`red_teleop_score`
        END) AS `match_teleop_score`,
        `tmap`.`team_match_id` AS `team_match_id`,
        `tmap`.`match_number` AS `match_number`,
        `tmap`.`team_id` AS `team_id`,
        `tmap`.`match_id` AS `match_id`,
        `tmap`.`tele_high_score` AS `tele_high_score`,
        `tmap`.`tele_low_score` AS `tele_low_score`,
        `tmap`.`tele_high_score_points` AS `tele_high_score_points`,
        `tmap`.`tele_low_score_points` AS `tele_low_score_points`,
        `tmap`.`tele_fuel_bin_triggered` AS `tele_fuel_bin_triggered`,
        `tmap`.`tele_gear_delivered` AS `tele_gear_delivered`,
        `tmap`.`tele_loading_station_trip` AS `tele_loading_station_trip`,
        `tmap`.`tele_try_climb_flag` AS `tele_try_climb_flag`,
        `tmap`.`tele_did_climb_flag` AS `tele_did_climb_flag`,
        `tmap`.`tele_triggered_pressure_pad` AS `tele_triggered_pressure_pad`,
        `tmap`.`auto_baseline_crossed` AS `auto_baseline_crossed`,
        `tmap`.`auto_low_dump` AS `auto_low_dump`,
        `tmap`.`auto_high_scores` AS `auto_high_scores`,
        `tmap`.`auto_high_score_points` AS `auto_high_score_points`,
        `tmap`.`auto_high_missed` AS `auto_high_missed`,
        `tmap`.`auto_gear_delivered` AS `auto_gear_delivered`,
        `tmap`.`auto_fuel_bin_triggered` AS `auto_fuel_bin_triggered`,
        `tmap`.`tele_played_defensively` AS `tele_played_defensively`,
        `tmap`.`breakdown` AS `breakdown`,
        `tmap`.`disconnect` AS `disconnect`
    FROM
        (`vw_team_match` `tm`
        JOIN `vw_team_match_action_pivot` `tmap` ON ((`tmap`.`team_match_id` = `tm`.`team_match_id`)))