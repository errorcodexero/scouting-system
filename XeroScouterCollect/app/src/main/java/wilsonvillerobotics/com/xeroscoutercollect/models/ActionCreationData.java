package wilsonvillerobotics.com.xeroscoutercollect.models;

/**
 * Created by nick on 1/27/18.
 */

public class ActionCreationData {
    private Boolean isDecrement;
    public Integer action_id;

    public ActionCreationData(Boolean isDecrement, Integer action_id) {
        this.isDecrement = isDecrement;
        this.action_id = action_id;
    }

    public Boolean getDecrement() {
        return isDecrement;
    }

    public void setDecrement(Boolean decrement) {
        isDecrement = decrement;
    }

    public Integer getAction_id() {
        return action_id;
    }

    public void setAction_id(Integer action_id) {
        this.action_id = action_id;
    }
}