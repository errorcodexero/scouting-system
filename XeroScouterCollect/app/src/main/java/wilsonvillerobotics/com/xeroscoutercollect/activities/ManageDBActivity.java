package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;

public class ManageDBActivity extends Activity implements View.OnClickListener {
    private XMLParser parser;
    private String fileName = "xmlTestData.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_db);
        parser = new XMLParser(getApplicationContext());
        File file = new File(this.getFilesDir(), fileName);
        String string = "<DATA>\n" +
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


                /*
                "<?xml version=\"1.0\"?>\n" +
                "<P>\n" +
                "    <Content>\n" +
                "        <id>1016576</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>KUALA LUMPUR</placeOfBirth>\n" +
                "    </Content>\n" +
                "    <Content>\n" +
                "        <id>1016620</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>SINGAPORE</placeOfBirth>\n" +
                "    </Content>\n" +
                "    <Content>\n" +
                "        <id>1020907</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>SINGAPORE</placeOfBirth>\n" +
                "    </Content>\n" +
                "</P>";*/
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, this.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_import)) {
            parser.parseXML(getFilesDir() + "/" + fileName);
            Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_LONG).show();
        }
    }
}
