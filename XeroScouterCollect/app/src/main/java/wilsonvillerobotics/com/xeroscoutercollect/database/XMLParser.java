package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.content.res.XmlResourceParser;

import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;


/**
 * Created by Luke on 12/3/2016.
 */

public class XMLParser{
    private String xmlFilePath;
    private DatabaseHelper myDbHelper = null;
    private Context context;
    private String dataString = "No data was found";
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser myParser;



    public XMLParser(String filePath, Context c){
        xmlFilePath = filePath;
        context = c;
    }
    public XMLParser(Context c){
        this("", c);
    }


    //Create parser
    //Parse data
    //Return statement that has the data in the xml file ready to import into SQLlite db



    public void parseXML(){


    }
    private String readText(XmlPullParser parser) throws IOException,
            XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
    public void parseXML(String filePath) {
        xmlFilePath = filePath;
        parseXML();
    }

    public void parseMatchXml(){
        try {
            FileInputStream fileStream = new FileInputStream(xmlFilePath);
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(fileStream, null);

            //int event = myParser.getEventType();
            while (myParser.next() != XmlPullParser.END_TAG) {
                if (myParser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = myParser.getName();
                if (name.equals("Row")) {
                    String id = null, date = null, pob = null;
                    while (myParser.next() != XmlPullParser.END_TAG) {
                        if (myParser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        name = myParser.getName();
                        if (name.equals("id")) {
                            id = readText(myParser);
                        } else if (name.equals("date")) {
                            date = readText(myParser);
                        } else if (name.equals("placeOfBirth")) {
                            pob = readText(myParser);
                        }
                    }
                    //myDbHelper.insertData(id,date,pob);
                    Log.d(TAG, "parseXML: " + id + date + pob);
                }
            }
        }
        catch(Exception e) {e.printStackTrace();}
    }

//key value type

    public class TableColumn<E> {
        protected String key;
        protected E value;

        public TableColumn (String k, E v) {
            key = k;
            value = v;
        }
    }

    public class TableStringColumn extends TableColumn<String> {
        public TableStringColumn(String k, String v){
            super(k, v);
        }
    }

    public class TableIntegerColumn extends TableColumn<Integer> {
        public TableIntegerColumn(String k, Integer v){
            super(k, v);
        }
    }

/*
    public ArrayList<TableColumn> makeMatchList(){

        return matchList;
    }
    public ArrayList<TableColumn> makeEventList(){

        return eventList;
    }
    public ArrayList<TableColumn> makeActionTypeList(){

        return ActionTypeList;
    }
    public ArrayList<TableColumn> makeTeamMatchList(){

        return TeamMatchList;
    }
    public ArrayList<TableColumn> makeTeamList(){

        return teamList;
    }

*/
}

/*
//myDbHelper = DatabaseHelper.getInstance(context);
            //myDbHelper.open();
            while (myparser.next() != XmlPullParser.END_TAG) {
                if (myparser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = myparser.getName();
                if (name.equals("Content")) {
                    String id = null, date = null, pob = null;
                    while (myparser.next() != XmlPullParser.END_TAG) {
                        if (myparser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        name = myparser.getName();
                        if (name.equals("id")) {
                            id = readText(myparser);
                        } else if (name.equals("date")) {
                            date = readText(myparser);
                        } else if (name.equals("placeOfBirth")) {
                            pob = readText(myparser);
                        }
                    }
                    //myDbHelper.insertData(id,date,pob);
                    Log.d(TAG, "parseXML: " + id + date + pob);
                }
            }
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            /*if (myDbHelper != null) {
                myDbHelper.close();
            }
}
 */
