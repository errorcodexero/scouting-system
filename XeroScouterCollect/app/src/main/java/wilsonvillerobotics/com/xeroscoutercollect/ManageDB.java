package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by nick on 11/5/16.
 */
public class ManageDB {

    protected String dbName;
    private boolean testDB;
    protected ArrayList<ActionObject> teamMatchData;

    //private SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);
    public ManageDB(){
        this("",false,new ArrayList<ActionObject>());
    }

    public ManageDB(String dbName, boolean testDB, ArrayList<ActionObject> teamMatchData) {
        this.dbName = dbName;
        this.testDB = testDB;
        this.teamMatchData = teamMatchData;
    }

    public void PostData() {

    }

}
