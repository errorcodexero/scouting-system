package wilsonvillerobotics.com.xeroscoutercollect.database;

import java.util.ArrayList;

/**
 * Created by nick on 10/29/16.
 */
public class TeamMatch {

    public Boolean isDefensive;
    public Boolean didBreakDown;
    public Boolean didRecover;

    public ArrayList<Integer> actionCount = new ArrayList<>(9);

    public TeamMatch() {
        for ( int i : actionCount) {
            actionCount.set(i, 0);
        }

    }
}
