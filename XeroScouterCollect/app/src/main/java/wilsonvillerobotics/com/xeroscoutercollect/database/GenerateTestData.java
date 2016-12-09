package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.ActionsEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract.EventEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract.MatchEntry;
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
        /*
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
        */

        //generateFile(fileName,data);
        generateFile(fileName, ActionsEntry.testData);
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
                "\t\t<_id>14251</_id>\n" +
                "\t\t<tba_team_key>TBA1425A</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Error Code Xero</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Wilsonvillle</city>\n" +
                "\t\t<state_code>OR</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&#39;Building Robots, Building People&#39;</motto>\n" +
                "\t\t<rookie_year>2004</rookie_year>\n" +
                "\t\t<robot_name>Dash</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>Holononic</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>3</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>6</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>C++</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>14252</_id>\n" +
                "\t\t<tba_team_key>TBA1425B</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Error Code Xero</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Wilsonville</city>\n" +
                "\t\t<state_code>OR</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&#39;Building Robots, Building People&#39;</motto>\n" +
                "\t\t<rookie_year>2004</rookie_year>\n" +
                "\t\t<robot_name>Hammy</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>H-Drive</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>5</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>5</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>C++</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>24711</_id>\n" +
                "\t\t<tba_team_key>TBA2471A</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Team Mean Machine</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Camas</city>\n" +
                "\t\t<state_code>WA</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&quot;24 hours a day, 7 days a week, 1 build season&quot;</motto>\n" +
                "\t\t<rookie_year>2008</rookie_year>\n" +
                "\t\t<robot_name>NULL</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>NA</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>-1</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>-1</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>NA</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>24712</_id>\n" +
                "\t\t<tba_team_key>TBA2471B</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Team Mean Machine</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Camas</city>\n" +
                "\t\t<state_code>WA</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&quot;24 hours a day, 7 days a week, 1 build season&quot;</motto>\n" +
                "\t\t<rookie_year>2008</rookie_year>\n" +
                "\t\t<robot_name>NULL</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>NA</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>-1</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>-1</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>NA</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>37111</_id>\n" +
                "\t\t<tba_team_key>TBA3711A</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Iron Mustangs</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Trout Lake</city>\n" +
                "\t\t<state_code>WA</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&quot;Do great things&quot;</motto>\n" +
                "\t\t<rookie_year>2011</rookie_year>\n" +
                "\t\t<robot_name>NULL</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>NA</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>-1</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>-1</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>NA</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>37112</_id>\n" +
                "\t\t<tba_team_key>TBA3711B</tba_team_key>\n" +
                "\t\t<long_name>NULL</long_name>\n" +
                "\t\t<name>Iron Mustangs</name>\n" +
                "\t\t<logo_file_location>NULL</logo_file_location>\n" +
                "\t\t<city>Trout Lake</city>\n" +
                "\t\t<state_code>WA</state_code>\n" +
                "\t\t<country>USA</country>\n" +
                "\t\t<motto>&quot;Do great things&quot;</motto>\n" +
                "\t\t<rookie_year>2011</rookie_year>\n" +
                "\t\t<robot_name>NULL</robot_name>\n" +
                "\t\t<robot_picture_file_location>NULL</robot_picture_file_location>\n" +
                "\t\t<robot_drive_type>NA</robot_drive_type>\n" +
                "\t\t<robot_wheel_count>-1</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>-1</robot_drive_motor_count>\n" +
                "\t\t<robot_software_language>NA</robot_software_language>\n" +
                "\t\t<robot_description>NULL</robot_description>\n" +
                "\t\t<pit_scout_comments>NULL</pit_scout_comments>\n" +
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
                "\t\t<team_id>14251</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>1</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">2</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<team_id>14252</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>2</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">3</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<team_id>24711</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>3</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">4</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<team_id>24712</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Red</alliance>\n" +
                "\t\t<position>1</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">5</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<team_id>37111</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Red</alliance>\n" +
                "\t\t<position>2</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<" + TeamMatchEntry.COLUMN_NAME_ID + ">6</" + TeamMatchEntry.COLUMN_NAME_ID + ">\n" +
                "\t\t<team_id>37112</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Red</alliance>\n" +
                "\t\t<position>3</position>\n" +
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
