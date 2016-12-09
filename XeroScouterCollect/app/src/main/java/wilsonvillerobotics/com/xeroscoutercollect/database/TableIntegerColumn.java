package wilsonvillerobotics.com.xeroscoutercollect.database;

import java.util.function.Function;

/**
 * Created by nick on 12/6/16.
 */

public class TableIntegerColumn extends TableColumn<Integer> {
    public TableIntegerColumn(String k, Function func){
        super(k, func);
    }
    public TableIntegerColumn(String k){
        super(k);
    }

}
