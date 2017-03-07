drop view team_match_action_result;
drop view vw_team_match_action;

create or replace view vw_team_match_action
as
select 
	tma._id as team_match_action_id,
	team_match_id,
    team_id,
    match_id,
    match_number,
	action_type_id,
	quantity,
	start_time,
	end_time,
	object_count,
	at.`name` as action_name,
	description as action_description,
	match_phase,
	points,
	opponent_points,
	qual_points,
	foul_points,
	coop_flag,
	category
from action_type `at`
join team_match_action tma
	on at._id = tma.action_type_id
join team_match tm
	on tm._id = tma.team_match_id
join `match` m
	on tm.match_id = m._id
-- order by match_id, team_id
;

create or replace view vw_team_match_action_pivot
as
select tma.team_match_id
	, tma.match_number
	, tma.team_id
	, tma.match_id
    , sum(if (tma.action_name = 'tele_high_scores', tma.quantity, 0)) as tele_high_score
    , sum(if (tma.action_name = 'tele_low_dumps',tma.quantity, 0)) as tele_low_score
	, sum(if (tma.action_name = 'tele_high_scores', tma.quantity * tma.points, 0)) as tele_high_score_points
    , sum(if (tma.action_name = 'tele_low_dumps', tma.quantity * tma.points, 0)) as tele_low_score_points
    , sum(if (tma.action_name = 'tele_fuel_bin_triggered',tma.quantity, 0)) as tele_fuel_bin_triggered
    , sum(if (tma.action_name = 'tele_gear_delivered',tma.quantity, 0)) as tele_gear_delivered
    , sum(if (tma.action_name = 'tele_loading_station_trip',tma.quantity, 0)) as tele_loading_station_trip
    , sum(if (tma.action_name = 'tele_try_climb',tma.quantity, 0)) as tele_try_climb_flag
    , sum(if (tma.action_name = 'tele_did_climb',tma.quantity, 0)) as tele_did_climb_flag
    , sum(if (tma.action_name = 'tele_triggered_pressure_pad',tma.quantity, 0)) as tele_triggered_pressure_pad
    , sum(if (tma.action_name = 'auto_baseline_crossed',tma.quantity, 0)) as auto_baseline_crossed
    , sum(if (tma.action_name = 'auto_low_dump',tma.quantity, 0)) as auto_low_dump
    , sum(if (tma.action_name = 'auto_high_scores',tma.quantity, 0)) as auto_high_scores
    , sum(if (tma.action_name = 'auto_high_scores',tma.quantity * tma.points, 0)) as auto_high_score_points
    , sum(if (tma.action_name = 'auto_high_missed',tma.quantity, 0)) as auto_high_missed
    , sum(if (tma.action_name = 'auto_gear_delivered',tma.quantity, 0)) as auto_gear_delivered
    , sum(if (tma.action_name = 'auto_fuel_bin_triggered',tma.quantity, 0)) as auto_fuel_bin_triggered
    , sum(if (tma.action_name = 'tele_played_defensively',tma.quantity, 0)) as tele_played_defensively
    , sum(if (tma.action_name = 'breakdown',tma.quantity, 0)) as breakdown
    , sum(if (tma.action_name = 'disconnect',tma.quantity, 0)) as disconnect
from vw_team_match_action tma
group by 1
-- order by match_id, team_id
;    

create or replace view team_match_action_result
as
select tm.event_name
    , tm.team_name
    , tm.alliance
    , tm.position
    , (select count(*) from vw_team_match a where a.match_number < tmap.match_number and team_id = tmap.team_id) + 1 as team_match_seq
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
	, tmap.*
from  vw_team_match as tm
join vw_team_match_action_pivot tmap 
	 on tmap.team_match_id = tm.team_match_id
-- order by match_id, team_id
;

select * from team_match_action_result order by match_id, team_id;


