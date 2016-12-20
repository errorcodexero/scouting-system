import os, sys
import re
import requests

import pymysql as mysql

import json

def is_ascii(s):
    return all(ord(c) < 128 for c in s)

def get_events(cursor, j):
            event_code = ""
            year = 0

            for i in range(0, 194):
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
                #sql_insert = "INSERT INTO `scouting`.`event` (tba_event_code, year) VALUES (%s, %d)"%(event_code, int(year))
                print(sql_insert)
                cursor.execute(sql_insert)

def get_teams(cursor, j):
    for k in range(0,14):
        response = requests.get('https://thebluealliance.com/api/v2/teams/%d'%(k))
        print('https://thebluealliance.com/api/v2/teams/%d'%(k))
        j = json.loads(response.text)

        for i in range (0, 500):
            current_team_number = ((k * 500) + i ) if k != 0 else i

            try:
                team_number = j[i]["team_number"]
                team_name = j[i]["name"]
                team_key = j[i]["key"]
                if team_name == None:

                    sql_insert = "INSERT INTO `scouting`.`team` (team_id, long_name, tba_team_key) VALUES (%d, \"unknown\", %s)"%(team_number, '\"' + team_key + '\"')
                    print(sql_insert)
                elif team_number != None:
                    if len(team_name) >= 255:
                        team_name = "too long"
                    sql_insert = "INSERT INTO `scouting`.`team` (team_id, long_name, tba_team_key) VALUES (%d, %s, %s)"%(team_number, ( json.dumps(team_name) if is_ascii(team_name) else '\"Foreign Names Not Supported\"'), '\"' + team_key + '\"')
                    print(sql_insert)
                else:
                    continue
                cursor.execute(sql_insert)
            except IndexError:
                print("Team with index %d does not exist on ttps://thebluealliance.com/api/v2/teams/%d"%(i, k))
                continue
            except KeyError:
                continue



def main():
    try:
        response = requests.get('https://thebluealliance.com/api/v2/events/2016')

        db = mysql.connect(host='localhost', port=3306, user='django', passwd='deathcode', db='scouting')

        cursor = db.cursor()
        j = json.loads(response.text)

        get_events(cursor, j)
        get_teams(cursor, j)

        cursor.close()
        db.commit()
    except mysql.Error as e:
        print
        "MySQL Error [%d]: %s" % (e.args[0], e.args[1])
    except IndexError:
        print("Error")

if __name__ == "__main__":
    main()
