package wilsonvillerobotics.com.xeroscoutercollect;

import java.util.ArrayList;

/**
 * Created by nick on 10/29/16.
 */
public class TeamMatch extends Match {

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
