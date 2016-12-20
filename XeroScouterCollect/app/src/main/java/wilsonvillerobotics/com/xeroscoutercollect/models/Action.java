package wilsonvillerobotics.com.xeroscoutercollect.models;

import android.app.Activity;

/**
 * Created by nick on 10/29/16.
 */
public class Action {

    protected final String name;
    protected final int id;

    public Action(int newID, String newName) {
        name = newName;
        id = newID;
    }

    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }
}
