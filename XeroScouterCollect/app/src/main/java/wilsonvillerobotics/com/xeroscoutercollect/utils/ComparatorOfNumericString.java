package wilsonvillerobotics.com.xeroscoutercollect.utils;

import java.util.Comparator;

/**
 * Created by Luke on 3/10/2017.
 */
public class ComparatorOfNumericString implements Comparator<String>{

    public int compare(String string1, String string2) {
        // TODO Auto-generated method stub
        return Integer.parseInt(string1)-Integer.parseInt(string2);
    }
}