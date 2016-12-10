package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.ActionsEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract.EventEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract.MatchEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract.TeamMatchEntry;

import static wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.ActionsEntry;

/**
 * Created by Luke Puppo on 12/6/2016.
 */

public class GenerateTestData {
private Context c;
    public GenerateTestData(Context cont){
        c = cont;
    }

    public void generateActions(){
        String fileName = "action_type.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ID + ">1</" + ActionsEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_NAME + ">Crossing</" + ActionsEntry.COLUMN_NAME_ACTION_NAME + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_DESCRIPTION + ">crossing</" + ActionsEntry.COLUMN_NAME_ACTION_DESCRIPTION + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_MATCH_PHASE + ">teleop</" + ActionsEntry.COLUMN_NAME_ACTION_MATCH_PHASE + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_POINTS + ">1</" + ActionsEntry.COLUMN_NAME_ACTION_POINTS + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_OPPONENT_POINTS + ">0</" + ActionsEntry.COLUMN_NAME_ACTION_OPPONENT_POINTS + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_QUAL_POINTS + ">0</" + ActionsEntry.COLUMN_NAME_ACTION_QUAL_POINTS + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_FOUL_POINTS + ">0</" + ActionsEntry.COLUMN_NAME_ACTION_FOUL_POINTS + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_COOP_FLAG + ">N</" + ActionsEntry.COLUMN_NAME_ACTION_COOP_FLAG + ">\n" +
                "\t\t<" + ActionsEntry.COLUMN_NAME_ACTION_CATEGORY + ">movement</" + ActionsEntry.COLUMN_NAME_ACTION_CATEGORY + ">\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
        //generateFile(fileName, ActionsEntry.testData);
    }
    public void generateEvent(){
        String fileName = "event.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_ID + ">1</" + EventEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_TBA_EVENT_KEY + ">TBA_1</" + EventEntry.COLUMN_NAME_TBA_EVENT_KEY + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_NAME + ">BunnyBots2016</" + EventEntry.COLUMN_NAME_EVENT_NAME + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_SHORT_NAME + ">BunnyBots2016</" + EventEntry.COLUMN_NAME_EVENT_SHORT_NAME + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_TYPE + ">Exhibition</" + EventEntry.COLUMN_NAME_EVENT_TYPE + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_DISTRICT + ">PNW</" + EventEntry.COLUMN_NAME_EVENT_DISTRICT + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_YEAR + ">2016</" + EventEntry.COLUMN_NAME_EVENT_YEAR + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_WEEK + ">50</" + EventEntry.COLUMN_NAME_EVENT_WEEK + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_EVENT_LOCATION + ">Catlin Gabel</" + EventEntry.COLUMN_NAME_EVENT_LOCATION + ">\n" +
                "\t\t<" + EventEntry.COLUMN_NAME_TBA_EVENT_CODE + ">A</" + EventEntry.COLUMN_NAME_TBA_EVENT_CODE + ">\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
    }
    public void generateMatch(){
        String fileName = "match.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_ID + ">1</" + MatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_EVENT_ID + ">1</" + MatchEntry.COLUMN_NAME_EVENT_ID + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_TBA_MATCH_KEY + ">TBA1</" + MatchEntry.COLUMN_NAME_TBA_MATCH_KEY + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_MATCH_COMP_LEVEL + ">Q</" + MatchEntry.COLUMN_NAME_MATCH_COMP_LEVEL + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_MATCH_SET_NUMBER + ">Set 1</" + MatchEntry.COLUMN_NAME_MATCH_SET_NUMBER + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_MATCH_NUMBER + ">Q1</" + MatchEntry.COLUMN_NAME_MATCH_NUMBER + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_MATCH_STATUS + ">Scheduled</" + MatchEntry.COLUMN_NAME_MATCH_STATUS + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_1 + ">14251</" + MatchEntry.COLUMN_NAME_RED_1 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_2 + ">14252</" + MatchEntry.COLUMN_NAME_RED_2 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_3 + ">24711</" + MatchEntry.COLUMN_NAME_RED_3 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_AUTO_SCORE + ">24712</" + MatchEntry.COLUMN_NAME_RED_AUTO_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_TELEOP_SCORE + ">37111</" + MatchEntry.COLUMN_NAME_RED_TELEOP_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_TOTAL_SCORE + ">37112</" + MatchEntry.COLUMN_NAME_RED_TOTAL_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_QP + ">1</" + MatchEntry.COLUMN_NAME_RED_QP + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_RED_FOUL_POINTS + ">1</" + MatchEntry.COLUMN_NAME_RED_FOUL_POINTS + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_1 + ">1</" + MatchEntry.COLUMN_NAME_BLUE_1 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_2 + ">1</" + MatchEntry.COLUMN_NAME_BLUE_2 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_3 + ">1</" + MatchEntry.COLUMN_NAME_BLUE_3 + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_AUTO_SCORE + ">1</" + MatchEntry.COLUMN_NAME_BLUE_AUTO_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_TELEOP_SCORE + ">1</" + MatchEntry.COLUMN_NAME_BLUE_TELEOP_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_TOTAL_SCORE + ">1</" + MatchEntry.COLUMN_NAME_BLUE_TOTAL_SCORE + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_QP + ">1</" + MatchEntry.COLUMN_NAME_BLUE_QP + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_BLUE_FOUL_POINTS + ">1</" + MatchEntry.COLUMN_NAME_BLUE_FOUL_POINTS + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_MATCH_WINNER + ">1</" + MatchEntry.COLUMN_NAME_MATCH_WINNER + ">\n" +
                "\t\t<" + MatchEntry.COLUMN_NAME_DRIVE_TEAM_COMMENTS + ">1</" + MatchEntry.COLUMN_NAME_DRIVE_TEAM_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
    }
    public void generateTeam(){
        String fileName = "team.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14251</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14252</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14253</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14254</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14255</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ID + ">14256</" + TeamContract.TeamEntry.COLUMN_NAME_ID + "\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">TBA1425A</" + TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">Error Code Xero</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">Wilsonvillle</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">OR</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">USA</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">&#39;Building Robots, Building People&#39;</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">2004</" + TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">Dash</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">Holononic</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">3</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">6</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">C++</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION + ">\n" +
                "\t\t<" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">NULL</" + TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS + ">\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
    }
    public void generateTeamMatch(){
        String fileName = "team_match.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14251</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Blue</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">1</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">2</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14252</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Blue</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">2</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">3</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14253</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Blue</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">3</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">4</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14254</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Red</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">1</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">5</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14255</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Red</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">2</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">6</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">14256</" + TeamMatchEntry.COLUMN_NAME_TEAM_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">1</" + TeamMatchEntry.COLUMN_NAME_MATCH_ID + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">Red</" + TeamMatchEntry.COLUMN_NAME_ALLIANCE + ">\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_POSITION + ">3</" + TeamMatchEntry.COLUMN_NAME_POSITION + ">\n" +
                "\t</ROW>";

        generateFile(fileName,data);
    }
    public void generateAllData(){
        generateActions();
        generateEvent();
        generateMatch();
        generateTeam();
        generateTeamMatch();
    }

    public void generateFile(String fileName, String data){
        File f = new File(c.getFilesDir(),fileName);

        FileOutputStream outputStream;

        try {
            outputStream = c.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
