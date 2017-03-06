create or replace view vw_team_match_action
as
select 
	tma._id as team_match_action_id,
	team_match_id,
    team_id,
    match_id,
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
;