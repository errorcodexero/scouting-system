package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.Activity;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nick on 10/29/16.
 */
public class ActionList {

    /*static void updateActionList() {

    }*/


    public static HashMap<Integer, Action> actionList = new HashMap<Integer, Action>() {
        {
            put(1, new Action(1, Resources.getSystem().getString(R.string.action_1)));
            put(2, new Action(2, Resources.getSystem().getString(R.string.action_2)));
            put(3, new Action(3, Resources.getSystem().getString(R.string.action_3)));
            put(4, new Action(4, Resources.getSystem().getString(R.string.action_4)));
            put(5, new Action(5, Resources.getSystem().getString(R.string.action_5)));
            put(6, new Action(6, Resources.getSystem().getString(R.string.action_6)));
            put(7, new Action(7, Resources.getSystem().getString(R.string.action_7)));
            put(8, new Action(8, Resources.getSystem().getString(R.string.action_8)));
            put(9, new Action(9, Resources.getSystem().getString(R.string.action_9)));
        };

    };

}
