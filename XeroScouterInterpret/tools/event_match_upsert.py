import requests
import pymysql as mysql
import json
import numpy

log = open("C:\logs\pylog.txt",'a')


def main():
    
    log.write("\nBegin Script\n" )
    
    db = mysql.connect(host='localhost', port=3306, user='root', passwd='root', db='scouting')
    cursor = db.cursor()
    
    # get the event id for the desired event we will be '2017orore'
    tba_event_key = '2017orore'
    sql = 'select _id from `event` where tba_event_key = %s'
    cursor.execute(sql % ('"' + tba_event_key + '"'))
    event_id = cursor.fetchone()
    event_id = event_id[0] 
    
    url = 'https://thebluealliance.com/api/v2/event/' + tba_event_key + '/matches'
    url_parm = {'X-TBA-App-Id':'frc1425:scouting:v06'}
    response = requests.get(url, params = url_parm)
    j_matches = json.loads(response.text)
    log.write("\nNumber of matches to upsert %d \n"%(len(j_matches)))
    try:
        for i in range (0,len(j_matches)):
            log.write("\nIteration %d \n"%(i))
            print('iteration '+ str(i))
            match_number = j_matches[i]["match_number"]
            tba_match_key = j_matches[i]["key"]
            comp_level = j_matches[i]["comp_level"]
            set_number = j_matches[i]["set_number"]
            print ('match number ' + str(match_number))
            
            # get red and blue alliance team numbers out of json
            r_team_nbr = []
            b_team_nbr = []
            
            for k in range (0,3):
                r_team_nbr.insert(k, j_matches[i]["alliances"]["red"]["teams"][k][3:])
                b_team_nbr.insert(k, j_matches[i]["alliances"]["blue"]["teams"][k][3:])
                
            # check whether this match is already there
            sql = 'select _id from `match` where match_number = ' + str(match_number) + ' and event_id = ' + str(event_id) + ' and comp_level = \"' + comp_level + '\" and set_number = ' + str(set_number)         
            cursor.execute(sql)
            match_id = cursor.fetchone()  
            if match_id :
                match_id = match_id[0]
                # write update later
                sql = 'update'
                print(sql)
                log.write(sql)
            else:
                # get scouting database team ids
                print('insert')
                log.write('insert')
                sql = 'select _id, team_number from team where team_number in(%s, %s, %s, %s, %s, %s)'%(
                    r_team_nbr[0], r_team_nbr[1], r_team_nbr[2], b_team_nbr[0], b_team_nbr[1], b_team_nbr[2])
                cursor.execute(sql)
                team_mx = numpy.array(cursor.fetchall())
                r_team_id = []
                b_team_id = []
                
                for k in range(0,3):
                    print(k)
                    ref = numpy.where(team_mx==r_team_nbr[k])[0][0]
                    r_team_id.insert(k, team_mx[ref][0])
                    ref = numpy.where(team_mx==b_team_nbr[k])[0][0]
                    b_team_id.insert(k, team_mx[ref][0])
    
                # print(r1_team_id)
                # insert new records
                sql = 'insert into `match` (event_id, tba_match_key, comp_level, set_number, \
                                            match_number, red_1_team_id, red_2_team_id, red_3_team_id, \
                                            blue_1_team_id, blue_2_team_id, blue_3_team_id) \
                                    values (%d, \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")'%(
                                    event_id, tba_match_key, comp_level, set_number, match_number,
                                    r_team_id[0], r_team_id[1], r_team_id[2], b_team_id[0], b_team_id[1], b_team_id[2])
                cursor.execute(sql)
                # insert into team_match
    except:
        db.commit()
        cursor.close()
        db.close()
        raise
    # insert into team_match where on records yet exist
    db.commit()
    sql = 'insert into team_match (match_id, team_id, alliance, position) \
	(select _id, red_1_team_id, \"red\", 1 \
    from `match` m1 \
    where not exists (select _id from team_match tm where m1._id = tm.match_id) \
    ) \
    union  \
	(select _id, red_2_team_id, \"red\", 2 \
    from `match` m2 \
    where not exists (select _id from team_match tm where m2._id = tm.match_id) \
    ) \
    union \
	(select _id, red_3_team_id, \"red\", 3 \
    from `match` m3 \
    where not exists (select _id from team_match tm where m3._id = tm.match_id) \
    ) \
    union \
	(select _id, blue_1_team_id, \"blue\", 1 \
    from `match` m4 \
    where not exists (select _id from team_match tm where m4._id = tm.match_id) \
    ) \
    union \
 	(select _id, blue_2_team_id, \"blue\", 2  \
    from `match` m5\
    where not exists (select _id from team_match tm where m5._id = tm.match_id) \
    ) \
    union \
	(select _id, blue_3_team_id, \"blue\", 3  \
    from `match` m6 \
    where not exists (select _id from team_match tm where m6._id = tm.match_id) \
    ) '
    cursor.execute(sql)    
    db.commit()
    cursor.close()
    db.close()    
    log.write("Script Complete\n")
    log.close()  
if __name__ == "__main__":
    main()
