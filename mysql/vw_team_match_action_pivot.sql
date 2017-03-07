create or replace view vw_team_match_action_pivot
as;
select tma.team_match_id
	, tma.match_number
	, tma.team_id
	, tma.match_id
    , sum(if (tma.action_name = 'tele_high_scores', tma.quantity, 0)) as tele_high_score
    , sum(if (tma.action_name = 'tele_low_dumps',tma.quantity, 0)) as tele_low_score
	, sum(if (tma.action_name = 'tele_high_scores', tma.points, 0)) as tele_high_score_points
    , sum(if (tma.action_name = 'tele_low_dumps',tma.points, 0)) as tele_low_score_points
    , sum(if (tma.action_name = 'tele_fuel_bin_triggered',tma.quantity, 0)) as tele_fuel_bin_triggered
    , sum(if (tma.action_name = 'tele_gear_delivered',tma.quantity, 0)) as tele_gear_delivered
    , sum(if (tma.action_name = 'tele_loading_station_trip',tma.quantity, 0)) as tele_loading_station_trip
    , sum(if (tma.action_name = 'tele_try_climb',tma.quantity, 0)) as tele_try_climb_flag
    , sum(if (tma.action_name = 'tele_did_climb',tma.quantity, 0)) as tele_did_climb_flag
    , sum(if (tma.action_name = 'tele_triggered_pressure_pad',tma.quantity, 0)) as tele_triggered_pressure_pad
    , sum(if (tma.action_name = 'auto_baseline_crossed',tma.quantity, 0)) as auto_baseline_crossed
    , sum(if (tma.action_name = 'auto_low_dump',tma.quantity, 0)) as auto_low_dump
    , sum(if (tma.action_name = 'auto_high_scores',tma.quantity, 0)) as auto_high_scores
    , sum(if (tma.action_name = 'auto_high_scores',tma.points, 0)) as auto_high_score_points
    , sum(if (tma.action_name = 'auto_high_missed',tma.quantity, 0)) as auto_high_missed
    , sum(if (tma.action_name = 'auto_gear_delivered',tma.quantity, 0)) as auto_gear_delivered
    , sum(if (tma.action_name = 'auto_fuel_bin_triggered',tma.quantity, 0)) as auto_fuel_bin_triggered
    , sum(if (tma.action_name = 'tele_played_defensively',tma.quantity, 0)) as tele_played_defensively
    , sum(if (tma.action_name = 'breakdown',tma.quantity, 0)) as breakdown
    , sum(if (tma.action_name = 'disconnect',tma.quantity, 0)) as disconnect
from vw_team_match_action tma
group by 1
order by match_id, team_id
;    