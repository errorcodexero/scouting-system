USE scouting_test;
/* SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_high_scores') AS at_id, tm.team_id,

 FLOOR(FLOOR(min_balls_collected + (max_balls_collected - min_balls_collected) * ((RAND()+RAND()+RAND()+RAND())/4))
	* high_goal_accuracy * high_goal_ball_pct)
    AS tele_high_goal
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;

INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_high_scores') AS at_id,

 FLOOR(FLOOR(min_balls_collected + (max_balls_collected - min_balls_collected) * ((RAND()+RAND()+RAND()+RAND())/4))
	* high_goal_accuracy * high_goal_ball_pct)
    AS tele_high_goal
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;


INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_high_missed') AS at_id,

 FLOOR(FLOOR(min_balls_collected + (max_balls_collected - min_balls_collected) * ((RAND()+RAND()+RAND()+RAND())/4))
	* (1 - high_goal_accuracy) * high_goal_ball_pct)
    AS tele_high_missed
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;

INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_low_dumps') AS at_id,

 FLOOR(FLOOR(min_balls_collected + (max_balls_collected - min_balls_collected) * ((RAND()+RAND()+RAND()+RAND())/4))
	* low_goal_accuracy * (1 - high_goal_ball_pct))
   AS tele_low_goal
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;



INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_gear_delivered') AS at_id,

 FLOOR(FLOOR(min_gears_collected + (max_gears_collected - min_gears_collected) * ((RAND()+RAND()+RAND()+RAND())/4))
	* gear_placed_accuracy)
    AS tele_gear_delivered
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;



INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'tele_did_climb') AS at_id,

IF(RAND() <= hang_pct, 1 , 0)
    AS tele_did_climb
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;


INSERT INTO team_match_action
(team_match_id, action_type_id, quantity)
SELECT tm._id, (SELECT _id FROM action_type WHERE `name` = 'auto_baseline_crossed') AS at_id,

IF(RAND() <= auto_movement_pct, 1 , 0)
    AS auto_baseline_crossed
FROM team_match tm
JOIN factors f ON tm.team_id = f.team_id
;
 */
SELECT * FROM team_match_action;