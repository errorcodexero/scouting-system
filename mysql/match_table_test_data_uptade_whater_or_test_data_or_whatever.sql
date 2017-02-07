SELECT * FROM scouting_test_3.`match`;

INSERT INTO `match` (_id, event_id, match_number)
SELECT DISTINCT match_id, '1', match_id FROM team_match;

UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET red_1_team_id = team_id WHERE team_match.`position` = 1 AND team_match.alliance = 'red';
    
UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET red_2_team_id = team_id WHERE team_match.`position` = 2 AND team_match.alliance = 'red';
    
UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET red_3_team_id = team_id WHERE team_match.`position` = 3 AND team_match.alliance = 'red';
    
UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET blue_1_team_id = team_id WHERE team_match.`position` = 1 AND team_match.alliance = 'blue';
    
UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET blue_2_team_id = team_id WHERE team_match.`position` = 2 AND team_match.alliance = 'blue';
    
UPDATE `match` INNER JOIN team_match ON team_match.match_id = `match`._id
	SET blue_3_team_id = team_id WHERE team_match.`position` = 3 AND team_match.alliance = 'blue';
    
--   */ 
 UPDATE `match` INNER JOIN (
SELECT match_id, 
FLOOR(SUM(tma.quantity * `at`.points)) AS p
,tm.alliance, `at`.match_phase
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
GROUP BY match_id, tm.alliance, `at`.match_phase
) AS t
ON `match`._id = t.match_id 
	SET `match`.red_auto_score = p WHERE t.alliance = 'red' and t.match_phase = 'auto';
    
    
UPDATE `match` INNER JOIN (
SELECT match_id, 
FLOOR(SUM(tma.quantity * `at`.points)) AS p
,tm.alliance, `at`.match_phase
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
GROUP BY match_id, tm.alliance, `at`.match_phase
) AS t
ON `match`._id = t.match_id 
	SET `match`.red_teleop_score = p WHERE t.alliance = 'red' and t.match_phase = 'teleop';
    

UPDATE `match` INNER JOIN (
SELECT match_id, 
FLOOR(SUM(tma.quantity * `at`.points)) AS p
,tm.alliance, `at`.match_phase
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
GROUP BY match_id, tm.alliance, `at`.match_phase
) AS t
ON `match`._id = t.match_id 
	SET `match`.blue_auto_score = p WHERE t.alliance = 'blue' and t.match_phase = 'auto';
    
    
UPDATE `match` INNER JOIN (
SELECT match_id, 
FLOOR(SUM(tma.quantity * `at`.points)) AS p
,tm.alliance, `at`.match_phase
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
GROUP BY match_id, tm.alliance, `at`.match_phase
) AS t
ON `match`._id = t.match_id 
	SET `match`.blue_teleop_score = p WHERE t.alliance = 'blue' and t.match_phase = 'teleop';
    
    
    
    
    
 UPDATE `match` INNER JOIN (
SELECT match_id, 
CASE WHEN SUM(tma.quantity) >= 12 THEN 160
WHEN SUM(tma.quantity) >=6 THEN 120
WHEN SUM(tma.quantity) >=2 THEN 80
ELSE 40 END AS rotor_points
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`.`name` = 'tele_gear_delivered'
GROUP BY match_id, tm.alliance) AS gp
ON `match`._id = gp.match_id
	SET `match`.red_teleop_score = `match`.red_teleop_score + gp.rotor_points
	WHERE gp.alliance = 'red';
    

UPDATE `match` INNER JOIN (
SELECT match_id, 
CASE WHEN SUM(tma.quantity) >= 12 THEN 160
WHEN SUM(tma.quantity) >=6 THEN 120
WHEN SUM(tma.quantity) >=2 THEN 80
ELSE 40 END AS rotor_points
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`.`name` = 'tele_gear_delivered'
GROUP BY match_id, tm.alliance) AS gp
ON `match`._id = gp.match_id
	SET `match`.blue_teleop_score = `match`.blue_teleop_score + gp.rotor_points
    WHERE gp.alliance = 'blue';
    
    

 UPDATE `match` SET red_total_score = red_auto_score + red_teleop_score, blue_total_score = blue_auto_score + blue_teleop_score;
 
 UPDATE `match` SET winner = IF(red_total_score > blue_total_score, 'red', IF(blue_total_score > red_total_score, 'blue', 'draw'));

 UPDATE `match` INNER JOIN (
SELECT match_id, 
IF(SUM(tma.quantity) >= 12 , 1,0) q
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`.`name` = 'tele_gear_delivered'
GROUP BY match_id, tm.alliance) AS gp
ON `match`._id = gp.match_id
	SET blue_qp = q
    WHERE gp.alliance = 'blue';
    

UPDATE `match` INNER JOIN (
SELECT match_id, 
IF(SUM(tma.quantity) >= 12 , 1,0) q
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`.`name` = 'tele_gear_delivered'
GROUP BY match_id, tm.alliance) AS gp
ON `match`._id = gp.match_id
	SET red_qp = q
    WHERE gp.alliance = 'red';
    



 UPDATE `match` INNER JOIN (
SELECT match_id, 
IF(FLOOR(SUM(tma.quantity * `at`.points)) >= 40, 1, 0) AS w
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`._id = 8 OR `at`._id = 9
GROUP BY match_id, tm.alliance, `at`.match_phase) AS k
ON `match`._id = k.match_id
	SET red_qp = red_qp + w
    WHERE k.alliance = 'red';
    
    
UPDATE `match` INNER JOIN (
SELECT match_id, 
IF(FLOOR(SUM(tma.quantity * `at`.points)) >= 40, 1, 0) AS w
,tm.alliance
FROM team_match_action AS tma JOIN team_match AS tm ON tma.team_match_id = tm._id JOIN action_type `at` ON tma.action_type_id = `at`._id
WHERE `at`._id = 8 OR `at`._id = 9
GROUP BY match_id, tm.alliance, `at`.match_phase) AS k
ON `match`._id = k.match_id
	SET blue_qp = blue_qp + w
    WHERE k.alliance = 'blue';
    
    
    
    
    
 UPDATE `match`
SET red_qp = red_qp + 
IF(winner = 'red',2,IF(winner = 'draw', 1,0));

UPDATE `match`
SET blue_qp = blue_qp + 
IF(winner = 'blue',2,IF(winner = 'draw', 1,0));
