create or replace view
strategy_program_extract
as
select event_name, team_name, team_number
	, count(distinct if(score>0, match_number, null)) as matches_played
    , avg(`team_match_action_result`.`score`) as avg_alliance_score
    , avg(`team_match_action_result`.`opp_score`) as avg_opp_score
    , sum(`team_match_action_result`.`qp`) total_qp
    , sum(`team_match_action_result`.`wins`) total_wins
    , sum(`team_match_action_result`.`draws`) total_draws
    , sum(`team_match_action_result`.`losses`) total_losses
    , avg(`team_match_action_result`.`tele_high_score`) avg_tele_high_kpa
    , avg(`team_match_action_result`.`tele_low_score`) avg_tele_low_kpa
    , avg(`team_match_action_result`.`tele_high_score_points`) avg_tele_high_points
    , avg(`team_match_action_result`.`tele_low_score_points`) avg_tele_low_points
    , avg(`team_match_action_result`.`tele_fuel_bin_triggered`) avg_tele_fuel_bin_releases
    , avg(`team_match_action_result`.`tele_gear_delivered`) avg_tele_gear_hangs
    , avg(`team_match_action_result`.`tele_loading_station_trip`) avg_tele_loads
    , avg(`team_match_action_result`.`tele_try_climb_flag`) avg_climb_trys
    , avg(`team_match_action_result`.`tele_did_climb_flag`) avg_climb_non_score
    , avg(`team_match_action_result`.`tele_triggered_pressure_pad`) avg_climb_success
    , avg(`team_match_action_result`.`auto_baseline_crossed`) avg_auto_line_crosses
    , avg(`team_match_action_result`.`auto_low_dump`) avg_auto_low_dump
    , avg(`team_match_action_result`.`auto_high_scores`) avg_auto_high_kpa
    , avg(`team_match_action_result`.`auto_high_score_points`) avg_auto_high_points
    , avg(`team_match_action_result`.`auto_high_missed`) avg_auto_high_misses
    , avg(`team_match_action_result`.`auto_gear_delivered`) avg_auto_gear_hangs
    , avg(`team_match_action_result`.`auto_fuel_bin_triggered`) avg_auto_fuel_bin_releases
    , avg(`team_match_action_result`.`tele_played_defensively`) avg_matches_played_defense
    , avg(`team_match_action_result`.`breakdown`) avg_matches_broke_down
    , avg(`team_match_action_result`.`disconnect`) avg_matches_disconnected
from team_match_action_result
group by 1,2;