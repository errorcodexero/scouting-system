package wilsonvillerobotics.com.xeroscoutercollect.database;

import java.util.function.Function;

/**
 * Created by nick on 12/6/16.
 */

public class TableStringColumn extends TableColumn<String> {
    public TableStringColumn(String k, Function func){
        super(k, func);
    }
    public TableStringColumn(String k){
        super(k);
    }
}

