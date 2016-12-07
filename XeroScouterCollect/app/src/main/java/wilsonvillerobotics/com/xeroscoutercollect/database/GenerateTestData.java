package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

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
                "\t\t<_id>1</_id>\n" +
                "\t\t<name>Crossing</name>\n" +
                "\t\t<description>crossing</description>\n" +
                "\t\t<match_phase>teleop</match_phase>\n" +
                "\t\t<points>1</points>\n" +
                "\t\t<opponent_points>0</opponent_points>\n" +
                "\t\t<qual_points>0</qual_points>\n" +
                "\t\t<foul_points>0</foul_points>\n" +
                "\t\t<coop_flag>N</coop_flag>\n" +
                "\t\t<category>movement</category>\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
    }
    public void generateEvent(){
        String fileName = "event.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>1</_id>\n" +
                "\t\t<tba_event_key>TBA_1</tba_event_key>\n" +
                "\t\t<name>BunnyBots2016</name>\n" +
                "\t\t<short_name>BunnyBots2016</short_name>\n" +
                "\t\t<event_type>Exhibition</event_type>\n" +
                "\t\t<event_district>PNW</event_district>\n" +
                "\t\t<year>2016</year>\n" +
                "\t\t<week>50</week>\n" +
                "\t\t<location>Catlin Gabel</location>\n" +
                "\t\t<tba_event_code>A</tba_event_code>\n" +
                "\t</ROW>\n" +
                "</DATA>";

        generateFile(fileName,data);
    }
    public void generateMatch(){
        String fileName = "match.xml";
        String data ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>1</_id>\n" +
                "\t\t<event_id>1</event_id>\n" +
                "\t\t<tba_match_key>TBA1</tba_match_key>\n" +
                "\t\t<comp_level>Q</comp_level>\n" +
                "\t\t<set_number>Set 1</set_number>\n" +
                "\t\t<match_number>Q1</match_number>\n" +
                "\t\t<status>Scheduled</status>\n" +
                "\t\t<red_1_team_id>14251</red_1_team_id>\n" +
                "\t\t<red_2_team_id>14252</red_2_team_id>\n" +
                "\t\t<red_3_team_id>24711</red_3_team_id>\n" +
                "\t\t<red_auto_score>24712</red_auto_score>\n" +
                "\t\t<red_teleop_score>37111</red_teleop_score>\n" +
                "\t\t<red_total_score>37112</red_total_score>\n" +
                "\t\t<red_qp>1</red_qp>\n" +
                "\t\t<red_foul_points>1</red_foul_points>\n" +
                "\t\t<blue_1_team_id>1</blue_1_team_id>\n" +
                "\t\t<blue_2_team_id>1</blue_2_team_id>\n" +
                "\t\t<blue_3_team_id>1</blue_3_team_id>\n" +
                "\t\t<blue_auto_score>1</blue_auto_score>\n" +
                "\t\t<blue_teleop_score>1</blue_teleop_score>\n" +
                "\t\t<blue_total_score>1</blue_total_score>\n" +
                "\t\t<blue_qp>1</blue_qp>\n" +
                "\t\t<blue_foul_points>1</blue_foul_points>\n" +
                "\t\t<winner>1</winner>\n" +
                "\t\t<drive_team_comments>1</drive_team_comments>\n" +
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
                "\t\t<robot_wheel_count>NULL</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>NULL</robot_drive_motor_count>\n" +
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
                "\t\t<robot_wheel_count>NULL</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>NULL</robot_drive_motor_count>\n" +
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
                "\t\t<robot_wheel_count>NULL</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>NULL</robot_drive_motor_count>\n" +
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
                "\t\t<robot_wheel_count>NULL</robot_wheel_count>\n" +
                "\t\t<robot_drive_motor_count>NULL</robot_drive_motor_count>\n" +
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
                "\t\t<_id>1</_id>\n" +
                "\t\t<team_id>14251</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>1</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>2</_id>\n" +
                "\t\t<team_id>14252</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>2</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>3</_id>\n" +
                "\t\t<team_id>24711</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Blue</alliance>\n" +
                "\t\t<position>3</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>4</_id>\n" +
                "\t\t<team_id>24712</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Red</alliance>\n" +
                "\t\t<position>1</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>5</_id>\n" +
                "\t\t<team_id>37111</team_id>\n" +
                "\t\t<match_id>1</match_id>\n" +
                "\t\t<alliance>Red</alliance>\n" +
                "\t\t<position>2</position>\n" +
                "\t</ROW>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>6</_id>\n" +
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
