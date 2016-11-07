import os, sys
import re
import requests

import pymysql as mysql

import json

def main():
    try:
        response = requests.get('https://thebluealliance.com/api/v2/events/2016')

        db = mysql.connect(host='localhost', port=3306, user='django', passwd='D3@ThC0D3', db='scouting')

        cursor = db.cursor()

        j = json.loads(response.text)

        event_code = ""
        year = 0

        for i in range(0, 194):
            event_code = j[i]["event_code"]
            year = j[i]["year"]
            sql_insert = "INSERT INTO `event` (event_id, year_id) VALUES (%s, %d)"%('\"' + event_code + '\"', int(year))
            #print("INSERT INTO `event` (event_id, year_id) VALUES (%s, %d)"%(event_code, int(year)))

            cursor.execute(sql_insert)
        '''for k in range(0,14):
            response = requests.get('https://thebluealliance.com/api/v2/teams/%d'%(k))
            print(response.text)
            j = json.loads(response.text)

            for i in range(0, 500):
                if k != 0:
                    y = ((k-1) * 500) + i
                else:
                    y = i
                print(y)
                try:
                    team_number = j[y]["team_number"]
                    team_name = j[y]["name"]
                    if team_name == None:
                        sql_insert = "INSERT INTO `team` (team_id, team_name) VALUES (%d, unknown)"%team_number
                        #print(sql_insert)
                    elif team_number != None:
                        sql_insert = "INSERT INTO `team` (team_id, team_name) VALUES (%d, %s)"%(team_number, "\'" + team_name + "\'")
                        #print(sql_insert)
                    else:
                        continue
                    cursor.execute(sql_insert)
                #except IndexError:
                    #continue
                except:
                    print(" ")'''

        db.commit()
    except mysql.Error as e:
        print
        "MySQL Error [%d]: %s" % (e.args[0], e.args[1])
    except IndexError:
        print("Error")

if __name__ == "__main__":
    main()