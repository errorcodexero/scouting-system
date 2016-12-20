package wilsonvillerobotics.com.xeroscoutercollect.models;

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

    public Integer getRed1Score() {
        return red1Score;
    }

    public void setRed1Score(Integer red1Score) {
        this.red1Score = red1Score;
    }

    public Integer getRed2Score() {
        return red2Score;
    }

    public void setRed2Score(Integer red2Score) {
        this.red2Score = red2Score;
    }

    public Integer getRed3Score() {
        return red3Score;
    }

    public void setRed3Score(Integer red3Score) {
        this.red3Score = red3Score;
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

    public Integer getBlue1Score() {
        return blue1Score;
    }

    public void setBlue1Score(Integer blue1Score) {
        this.blue1Score = blue1Score;
    }

    public Integer getBlue2Score() {
        return blue2Score;
    }

    public void setBlue2Score(Integer blue2Score) {
        this.blue2Score = blue2Score;
    }

    public Integer getBlue3Score() {
        return blue3Score;
    }

    public void setBlue3Score(Integer blue3Score) {
        this.blue3Score = blue3Score;
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

    private Integer red1Score;
    private Integer red2Score;
    private Integer red3Score;

    private Integer redAutoScore;
    private Integer redFoulPoints;
    private Integer redTeleopScore;
    private Integer redTotalScore;
    private Integer redQp;

    private Integer blue1Score;
    private Integer blue2Score;
    private Integer blue3Score;

    private Integer blueAutoScore;
    private Integer blueFoulPoints;
    private Integer blueTeleopScore;
    private Integer blueTotalScore;
    private Integer blueQp;

    private String matchWinner;
    private String driverComments;

    public static String getAllMatches(int eventId) {

        return ("SELECT * FROM `" + MatchContract.MatchEntry.TABLE_NAME + "` WHERE " + MatchContract.MatchEntry.COLUMN_NAME_EVENT_ID + "=" + eventId + " ORDER BY _id ASC;");

    }
}
