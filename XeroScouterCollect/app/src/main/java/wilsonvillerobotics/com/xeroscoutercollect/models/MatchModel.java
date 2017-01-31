package wilsonvillerobotics.com.xeroscoutercollect.models;

import java.util.ArrayList;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;

/**
 * Created by nick on 12/1/16.
 */

public class MatchModel {

    private Integer id;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTbaMatchKey() {
        return tbaMatchKey;
    }

    public void setTbaMatchKey(String tbaMatchKey) {
        this.tbaMatchKey = tbaMatchKey;
    }

    public String getMatchCompLevel() {
        return matchCompLevel;
    }

    public void setMatchCompLevel(String matchCompLevel) {
        this.matchCompLevel = matchCompLevel;
    }

    public String getMatchSetNumber() {
        return matchSetNumber;
    }

    public void setMatchSetNumber(String matchSetNumber) {
        this.matchSetNumber = matchSetNumber;
    }

    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getRedAutoScore() {
        return redAutoScore;
    }

    public void setRedAutoScore(Integer redAutoScore) {
        this.redAutoScore = redAutoScore;
    }

    public Integer getRedFoulPoints() {
        return redFoulPoints;
    }

    public void setRedFoulPoints(Integer redFoulPoints) {
        this.redFoulPoints = redFoulPoints;
    }

    public Integer getRedTeleopScore() {
        return redTeleopScore;
    }

    public void setRedTeleopScore(Integer redTeleopScore) {
        this.redTeleopScore = redTeleopScore;
    }

    public Integer getRedTotalScore() {
        return redTotalScore;
    }

    public void setRedTotalScore(Integer redTotalScore) {
        this.redTotalScore = redTotalScore;
    }

    public Integer getRedQp() {
        return redQp;
    }

    public void setRedQp(Integer redQp) {
        this.redQp = redQp;
    }

    public Integer getBlueAutoScore() {
        return blueAutoScore;
    }

    public void setBlueAutoScore(Integer blueAutoScore) {
        this.blueAutoScore = blueAutoScore;
    }

    public Integer getBlueFoulPoints() {
        return blueFoulPoints;
    }

    public void setBlueFoulPoints(Integer blueFoulPoints) {
        this.blueFoulPoints = blueFoulPoints;
    }

    public Integer getBlueTeleopScore() {
        return blueTeleopScore;
    }

    public void setBlueTeleopScore(Integer blueTeleopScore) {
        this.blueTeleopScore = blueTeleopScore;
    }

    public String getRed1Id() {
        return red1Id;
    }

    public void setRed1Id(String red1Id) {
        this.red1Id = red1Id;
    }

    public String getRed2Id() {
        return red2Id;
    }

    public void setRed2Id(String red2Id) {
        this.red2Id = red2Id;
    }

    public String getRed3Id() {
        return red3Id;
    }

    public void setRed3Id(String red3Id) {
        this.red3Id = red3Id;
    }

    public String getBlue1Id() {
        return blue1Id;
    }

    public void setBlue1Id(String blue1Id) {
        this.blue1Id = blue1Id;
    }

    public String getBlue2Id() {
        return blue2Id;
    }

    public void setBlue2Id(String blue2Id) {
        this.blue2Id = blue2Id;
    }

    public String getBlue3Id() {
        return blue3Id;
    }

    public void setBlue3Id(String blue3Id) {
        this.blue3Id = blue3Id;
    }

    public Integer getBlueTotalScore() {
        return blueTotalScore;
    }

    public void setBlueTotalScore(Integer blueTotalScore) {
        this.blueTotalScore = blueTotalScore;
    }

    public Integer getBlueQp() {
        return blueQp;
    }

    public void setBlueQp(Integer blueQp) {
        this.blueQp = blueQp;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public MatchModel(String matchNumber, String red1Id, String red2Id, String red3Id, String blue1Id, String blue2Id, String blue3Id) {
        this.matchNumber = matchNumber;
        this.red1Id = red1Id;
        this.red2Id = red2Id;
        this.red3Id = red3Id;
        this.blue1Id = blue1Id;
        this.blue2Id = blue2Id;
        this.blue3Id = blue3Id;
    }

    public String getDriverComments() {
        return driverComments;
    }

    public void setDriverComments(String driverComments) {
        this.driverComments = driverComments;
    }

    private Integer eventId;
    private String tbaMatchKey;

    private String matchCompLevel;
    private String matchSetNumber;
    private String matchNumber;
    private String matchStatus;

    private String red1Id;
    private String red2Id;
    private String red3Id;

    private Integer redAutoScore;
    private Integer redFoulPoints;
    private Integer redTeleopScore;
    private Integer redTotalScore;
    private Integer redQp;

    private String blue1Id;
    private String blue2Id;
    private String blue3Id;

    private Integer blueAutoScore;
    private Integer blueFoulPoints;
    private Integer blueTeleopScore;
    private Integer blueTotalScore;
    private Integer blueQp;

    private String matchWinner;
    private String driverComments;


    public String getTeamNumber(int teamNumber) {

        String tempTeamString = "";

        switch (teamNumber) {

            case 1:
                tempTeamString =  red1Id;
                break;
            case 2:
                tempTeamString =  red2Id;
                break;
            case 3:
                tempTeamString =  red3Id;
                break;

            case 4:
                tempTeamString =  blue1Id;
                break;
            case 5:
                tempTeamString =  blue2Id;
                break;
            case 6:
                tempTeamString =  blue3Id;
                break;

            default:
                tempTeamString =  "No team Selected";
                break;


        }
        return tempTeamString;
    }


    public static String getAllMatches(int eventId) {

        return ("SELECT * FROM `" + MatchContract.MatchEntry.TABLE_NAME + "` WHERE " + MatchContract.MatchEntry.COLUMN_NAME_EVENT_ID + "=" + eventId + " ORDER BY _id ASC;");

    }
}
