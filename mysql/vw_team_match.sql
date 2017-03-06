create or replace view vw_team_match
as

select
e.`name` as event_name,
short_name as event_short_name,
event_type,
event_district,
`year`,
`week`,
location,
event_id,
comp_level,
set_number,
match_number,
`status`,
red_1_team_id,
red_2_team_id,
red_3_team_id,
red_auto_score,
red_teleop_score,
red_total_score,
red_qp,
red_foul_points,
blue_1_team_id,
blue_2_team_id,
blue_3_team_id,
blue_auto_score,
blue_teleop_score,
blue_total_score,
blue_qp,
blue_foul_points,
winner,
m.drive_team_comments,
tm._id as team_match_id,
team_id,
match_id,
alliance,
`position`,
scout_name,
team_number,
long_name as team_long_name,
t.`name` as team_name,
fuel_container_volume
from `event` e
join `match` m
	on e._id = m.event_id
join team_match tm
	on m._id = tm.match_id
join team t
	on tm.team_id = t._id
;