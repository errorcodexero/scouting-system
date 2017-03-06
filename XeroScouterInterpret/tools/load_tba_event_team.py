import requests

import pymysql as mysql

import json

def is_ascii(s):
    return all(ord(c) < 128 for c in s)

def get_events(cursor, j):
            event_code = ""
            year = 0

            for i in range(0, len(j) ):
                event_code = j[i]["event_code"]
                year = j[i]["year"]
                tba_event_key = j[i]["key"]
                name = j[i]["name"]
                short_name = j[i]["short_name"]
                event_type = j[i]["event_type_string"]
                event_district = j[i]["event_district_string"]
                week = j[i]["week"]
                location = j[i]["location"]

                sql_insert = ""

                print(event_code)
                print(year)
                print(tba_event_key)
                print(name)
                print(short_name)
                print(event_type)
                print(event_district)
                print(week)
                print(location)

                if event_district == None:
                    if week != None:
                        sql_insert = "INSERT INTO `scouting`.`event` (tba_event_key, name, short_name, event_type, year ,week, location, tba_event_code) VALUES (%s, %s, %s, %s, %d, %d, %s, %s)"%('\"' + tba_event_key + '\"', '\"' + name + '\"', '\"' + short_name + '\"', '\"' + event_type + '\"', int(year), int(week), '\"' + location + '\"', '\"' + event_code + '\"')
                    else:
                        if short_name != None:
                            sql_insert = "INSERT INTO `scouting`.`event` (tba_event_key, name, short_name, event_type, year, location, tba_event_code) VALUES (%s, %s, %s, %s, %d, %s, %s)"%('\"' + tba_event_key + '\"', '\"' + name + '\"', '\"' + short_name + '\"', '\"' + event_type + '\"', int(year), '\"' + location + '\"', '\"' + event_code + '\"')
                        else:
                            sql_insert = "INSERT INTO `scouting`.`event` (tba_event_key, name, event_type, year, location, tba_event_code) VALUES (%s, %s, %s, %d, %s, %s)"%('\"' + tba_event_key + '\"', '\"' + name + '\"', '\"' + event_type + '\"', int(year), '\"' + location + '\"', '\"' + event_code + '\"')
                else:
                    sql_insert = "INSERT INTO `scouting`.`event` (tba_event_key, name, short_name, event_type, event_district, year, week, location, tba_event_code) VALUES (%s, %s, %s, %s, %s, %d, %d, %s, %s)"%('\"' + tba_event_key + '\"', '\"' + name + '\"', '\"' + short_name + '\"', '\"' + event_type + '\"', '\"' + event_district + '\"', int(year), int(week), '\"' + location + '\"', '\"' + event_code + '\"')
                #sql_insert = "INSERT INTO `scouting_steamworks`.`event` (tba_event_code, year) VALUES (%s, %d)"%(event_code, int(year))
                print(sql_insert)
                cursor.execute(sql_insert)

def get_teams(cursor):
    for k in range(0,14):
        response = requests.get('https://thebluealliance.com/api/v2/teams/%d'%(k))
        f.write("TBA Called for k ="+str(k)+"\n")
        print('Requested https://thebluealliance.com/api/v2/teams/%d'%(k))
        j = json.loads(response.text)
        f.write("Loaded json " + str(k) + "\n")
        
        for i in range (0, 499):
            #current_team_number = ((k * 500) + i ) if k != 0 else i
            f.write("Iteration "+str(k)+" "+str(i)+"\n")
            
            try:
                team_number = j[i]["team_number"]
                print("Team "+str(team_number)+"\n")
                f.write("Getting Team "+str(team_number)+"\n")  
                team_name = j[i]["name"]
                team_key = j[i]["key"]
                
                if team_name == None:
                    f.write("Team name is empty.")
                    sql_insert = "INSERT INTO `scouting`.`team` (team_number, long_name, tba_team_key) VALUES (%d, \"unknown\", %s)"%(team_number, '\"' + team_key + '\"')
                    #print(sql_insert)
                    
                else: 
                    f.write("Team name is not empty. Before  insert for team "+str(team_number)+"\n")
                    team_name = team_name[:255] #truncate team name to fit in database field
                    sql_insert = "INSERT INTO `scouting`.`team` (team_number, long_name, tba_team_key) VALUES (%d, %s, %s)"%(team_number, ( json.dumps(team_name) if is_ascii(team_name) else '\"Foreign Names Not Supported\"'), '\"' + team_key + '\"')
                    #print(sql_insert)

                f.write("Before  insert for team "+str(team_number)+"\n")
                #f.write(sql_insert+"\n")
                cursor.execute(sql_insert)
                f.write("After insert for team "+str(team_number)+"\n")
                
            except IndexError:
                print("Team with index %d does not exist on ttps://thebluealliance.com/api/v2/teams/%d"%(i, k))
                f.write("Team does not exists on "+str(k)+" "+str(i)+"\n")
                continue
            except KeyError:
                #f.write("KeyError\n")
                continue


f = open("C:\logs\pylog.txt",'a')
def main():
    f.write("\nBegin Script\n" )
    try:
        response = requests.get('https://thebluealliance.com/api/v2/events/2017')

        db = mysql.connect(host='localhost', port=3306, user='root', passwd='root', db='scouting')

        cursor = db.cursor()
        j = json.loads(response.text)
        f.write("Call Get Events\n")
        get_events(cursor, j)
        db.commit()
        f.write("Call Get Teams\n")
        #get_teams(cursor)
        db.commit()
        cursor.close()
        db.close()
    except mysql.Error as e:
        print
        "MySQL Error [%d]: %s" % (e.args[0], e.args[1])
    except IndexError:
        print("Error")
    f.write("Script Complete\n")
    f.close()
if __name__ == "__main__":
    main()
