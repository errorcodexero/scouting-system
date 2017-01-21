SELECT team_id,
SUM(IF(tm.alliance = 'blue', m.blue_qp, m.red_qp))
FROM `match` m JOIN team_match tm ON m._id = tm.match_id
GROUP BY tm.team_id