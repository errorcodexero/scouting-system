package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by nick on 10/29/16.
 */
public class Match {


    protected ArrayList<Integer> blueAlliance;
    protected ArrayList<Integer> redAlliance;

    protected String team_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;

    protected int redRankingPoints;

    HashMap<String, String> actionPoints;

    public Match(HashMap<String,String> actionPoints) {

        this.actionPoints = actionPoints;
    }

    public Match(HashMap<String,String> actionPoints, String team_id) {

        this.actionPoints = actionPoints;
        this.team_id = team_id;

    }
    public HashMap<String, String> getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(HashMap<String, String> actionPoints) {
        this.actionPoints = actionPoints;
    }

    ArrayList<Integer> getBlueAlliance() {
        return blueAlliance;
    }
    ArrayList<Integer> getRedAlliance() {
        return redAlliance;
    }



}
