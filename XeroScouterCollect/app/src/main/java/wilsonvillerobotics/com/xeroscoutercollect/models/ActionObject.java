package wilsonvillerobotics.com.xeroscoutercollect.models;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by nick on 11/1/16.
 */
public class ActionObject implements Serializable {

    private int decrementButtonId;
    private int incrementButtonId;
    private int textFieldId;
    private int textFieldValueId;
    private int actionCount;

    public ActionObject() {
    }
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
            out.defaultWriteObject();
    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
            in.defaultReadObject();
    }
    private void readObjectNoData()
            throws ObjectStreamException {

    }

    public ActionObject(int decrementButtonId, int incrementButtonId, int textFieldId, int textFieldValueId, int actionCount) {
        this.decrementButtonId = decrementButtonId;
        this.incrementButtonId = incrementButtonId;
        this.textFieldValueId = textFieldValueId;
        this.textFieldId = textFieldId;
        this.actionCount = actionCount;
    }


    public int getActionCount() {
        return actionCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public int getTextFieldValueId() {
        return textFieldValueId;
    }

    public void setTextFieldValueId(int textFieldValueId) {
        this.textFieldValueId = textFieldValueId;
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
