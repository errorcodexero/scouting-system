create or replace view team_match_action_result
as
select tma.event_name
	, tm.team_id
	,  tm.team_number
	, tm.match_id
    , tm.team_name
    , tm.alliance
    , tm.position
    , (select count(*) from vw_team_match a where a.match_number < tma.match_number and team_id = tma.team_id) + 1 as team_match_seq
	, case tm.alliance
	  when 'red' then tm.red_total_score
	  when 'blue' then tm.blue_total_score
      end as score
	, case tm.alliance 
	  when 'red' then tm.blue_total_score
	  when 'blue' then tm.red_total_score
      end as opp_score
	, case tm.alliance
	  when 'red' then tm.red_qp
	  when 'blue' then tm.blue_qp
      end as qp
	, case
	  when tm.winner = 'draw' then 'draw'
	  when tm.winner = tm.alliance then 'win'
      else 'loss'
      end as result
    , if (tm.winner = tm.alliance, 1, 0) as wins  
	, if (tm.winner = 'draw', 1, 0) as draws
	, if (tm.winner <> tm.alliance and tm.winner <> 'draw', 1, 0) as losses
    , case tm.alliance
	  when 'blue' then tm.blue_total_score
	  when 'red' then tm.red_total_score
      end as match_total_score
    , case tm.alliance
	  when 'blue' then tm.blue_auto_score
	  when 'red' then tm.red_auto_score
      end as match_auto_score
    , case tm.alliance
	  when 'blue' then tm.blue_teleop_score
	  when 'red' then tm.red_teleop_score
      end as match_teleop_score
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
from  vw_team_match as tm
join 
(

	select tm2.team_match_id
        , tm2.event_name
        , tm2.match_number
		, tm2.team_id
		, tm2.match_id
        , tma2.action_name
        , sum(tma2.quantity) as quantity
        , floor(sum(tma2.quantity*tma2.points)) as points
     from vw_team_match tm2
     join vw_team_match_action tma2
      on tm2.match_id = tma2.match_id
     group by 1,2,3,4,5,6
     ) as tma
	 on tma.team_match_id = tm.team_match_id
group by tm.team_id, tm.match_id
order by match_id, team_number
;