package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 11/28/16.
 */
public class MatchXMLLoader {

    public static ArrayList<List> getMatchs(String xmlFilePath) {

        ArrayList<List> matchList = new ArrayList<>();
        XmlPullParser parser;
        FileInputStream file;

        try {
            parser = Xml.newPullParser();
            file = new FileInputStream(new File(xmlFilePath));

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //file.close();
        }


        return matchList;
    }

    public static ArrayList<List> getMatchs() {

        String xmlFilePath = "";

        ArrayList<List> matchList = new ArrayList<>();




        return matchList;
    }

}
