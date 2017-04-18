CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `strategy_program_extract` AS
    SELECT 
        `team_match_action_result`.`event_name` AS `event_name`,
        `team_match_action_result`.`team_name` AS `team_name`,
        `team_match_action_result`.`team_number` AS `team_number`,
        COUNT(DISTINCT IF((`team_match_action_result`.`score` > 0),
                `team_match_action_result`.`match_number`,
                NULL)) AS `matches_played`,
        AVG(`team_match_action_result`.`score`) AS `avg_alliance_score`,
        AVG(`team_match_action_result`.`opp_score`) AS `avg_opp_score`,
        SUM(`team_match_action_result`.`qp`) AS `total_qp`,
        SUM(`team_match_action_result`.`wins`) AS `total_wins`,
        SUM(`team_match_action_result`.`draws`) AS `total_draws`,
        SUM(`team_match_action_result`.`losses`) AS `total_losses`,
        AVG(`team_match_action_result`.`tele_high_score`) AS `avg_tele_high_fuel`,
        AVG(`team_match_action_result`.`tele_low_score`) AS `avg_tele_low_fuel`,
        AVG(`team_match_action_result`.`tele_high_score_points`) AS `avg_tele_high_kpa`,
        AVG(`team_match_action_result`.`tele_low_score_points`) AS `avg_tele_low_kpa`,
        AVG(`team_match_action_result`.`tele_fuel_bin_triggered`) AS `avg_tele_fuel_bin_releases`,
        AVG(`team_match_action_result`.`tele_gear_delivered`) AS `avg_tele_gear_hangs`,
        AVG(`team_match_action_result`.`tele_loading_station_trip`) AS `avg_tele_loads`,
        AVG(`team_match_action_result`.`tele_try_climb_flag`) AS `avg_climb_trys`,
        AVG(`team_match_action_result`.`tele_did_climb_flag`) AS `avg_climb_non_score`,
        AVG(`team_match_action_result`.`tele_triggered_pressure_pad`) AS `avg_climb_success`,
        AVG(`team_match_action_result`.`auto_baseline_crossed`) AS `avg_auto_line_crosses`,
        AVG(`team_match_action_result`.`auto_low_dump`) AS `avg_auto_low_dump`,
        AVG(`team_match_action_result`.`auto_high_scores`) AS `avg_auto_high_fuel`,
        AVG(`team_match_action_result`.`auto_high_score_points`) AS `avg_auto_high_kpa`,
        AVG(`team_match_action_result`.`auto_high_missed`) AS `avg_auto_high_misses`,
        AVG(`team_match_action_result`.`auto_gear_delivered`) AS `avg_auto_gear_hangs`,
        AVG(`team_match_action_result`.`auto_fuel_bin_triggered`) AS `avg_auto_fuel_bin_releases`,
        AVG(`team_match_action_result`.`tele_played_defensively`) AS `avg_matches_played_defense`,
        AVG(`team_match_action_result`.`breakdown`) AS `avg_matches_broke_down`,
        AVG(`team_match_action_result`.`disconnect`) AS `avg_matches_disconnected`,
        AVG(`team_match_action_result`.`tele_climb_time_seconds`) AS `avg_tele_climb_time_seconds`
    FROM
        `team_match_action_result`
    GROUP BY `team_match_action_result`.`event_name` , `team_match_action_result`.`team_name`