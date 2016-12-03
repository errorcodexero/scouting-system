package wilsonvillerobotics.com.xeroscoutercollect.models;

import junit.framework.Test;

import java.util.ArrayList;

/**
 * Created by Luke on 12/1/2016.
 */

public class TeamMatchModel {
    private String matchNumber;
    private ArrayList<String> teamList;
    private String team1Number;
    private String team2Number;
    private String team3Number;
    private String team4Number;
    private String team5Number;
    private String team6Number;


    public TeamMatchModel(String matchNumb, String team1, String team2, String team3,
                          String team4, String team5, String team6){
        matchNumber = matchNumb;
        team1Number = team1;
        team2Number = team2;
        team3Number = team3;
        team4Number = team4;
        team5Number = team5;
        team6Number = team6;
        teamList = new ArrayList<String>();
        updateArrayList();

    }

    private void updateArrayList() {
        teamList.add(team1Number);
        teamList.add(team2Number);
        teamList.add(team3Number);
        teamList.add(team4Number);
        teamList.add(team5Number);
        teamList.add(team6Number);
    }

    public String getMatchNumber(){
        return matchNumber;
    }
    public String getTeamNumber(int k){
        return teamList.get(k);
    }
}
