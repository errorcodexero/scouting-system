package wilsonvillerobotics.com.xeroscoutercollect.models;

import android.content.res.Resources;

import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by nick on 10/29/16.
 */
public class ActionList {

    /*static void updateActionList() {

    }*/


    public static HashMap<Integer, Action> actionList = new HashMap<Integer, Action>() {
        {
            put(30, new Action(30, Resources.getSystem().getString(R.string.action_30)));
            put(31, new Action(31, Resources.getSystem().getString(R.string.action_31)));
            put(32, new Action(32, Resources.getSystem().getString(R.string.action_32)));
            put(33, new Action(33, Resources.getSystem().getString(R.string.action_33)));
            put(34, new Action(34, Resources.getSystem().getString(R.string.action_34)));
            put(35, new Action(35, Resources.getSystem().getString(R.string.action_35)));
            put(36, new Action(36, Resources.getSystem().getString(R.string.action_36)));
            put(37, new Action(37, Resources.getSystem().getString(R.string.action_37)));
            put(38, new Action(38, Resources.getSystem().getString(R.string.action_38)));
            put(39, new Action(39, Resources.getSystem().getString(R.string.action_39)));
            put(40, new Action(40, Resources.getSystem().getString(R.string.action_40)));
            put(41, new Action(41, Resources.getSystem().getString(R.string.action_41)));
            put(42, new Action(42, Resources.getSystem().getString(R.string.action_42)));
            put(43, new Action(43, Resources.getSystem().getString(R.string.action_43)));
            put(44, new Action(44, Resources.getSystem().getString(R.string.action_44)));
            put(45, new Action(45, Resources.getSystem().getString(R.string.action_45)));
            put(46, new Action(46, Resources.getSystem().getString(R.string.action_46)));
        }

    };

}
