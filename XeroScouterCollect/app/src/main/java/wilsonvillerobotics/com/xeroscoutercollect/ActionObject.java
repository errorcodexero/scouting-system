package wilsonvillerobotics.com.xeroscoutercollect;

/**
 * Created by nick on 11/1/16.
 */
public class ActionObject {

    private int decrementButtonId;
    private int incrementButtonId;
    private int textFieldId;
    private Integer actionCount;

    public ActionObject(int decrementButtonId, int incrementButtonId, int textFieldId, Integer actionCount) {
        this.decrementButtonId = decrementButtonId;
        this.incrementButtonId = incrementButtonId;
        this.textFieldId = textFieldId;
        this.actionCount = actionCount;
    }


    public Integer getActionCount() {
        return actionCount;
    }

    public void setActionCount(Integer actionCount) {
        this.actionCount = actionCount;
    }


    public int getTextFieldId() {
        return textFieldId;
    }

    public void setTextFieldId(int textFieldId) {
        this.textFieldId = textFieldId;
    }

    public int getIncrementButtonId() {
        return incrementButtonId;
    }

    public void setIncrementButtonId(int incrementButtonId) {
        this.incrementButtonId = incrementButtonId;
    }

    public int getDecrementButtonId() {
        return decrementButtonId;
    }

    public void setDecrementButtonId(int decrementButtonId) {
        this.decrementButtonId = decrementButtonId;
    }
    public void changeValue(boolean isDecrement) {
        actionCount += (isDecrement) ? -1 : 1;
    }
}