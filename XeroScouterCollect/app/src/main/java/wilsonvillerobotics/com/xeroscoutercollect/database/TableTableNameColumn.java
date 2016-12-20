package wilsonvillerobotics.com.xeroscoutercollect.database;

import java.util.function.Function;

import wilsonvillerobotics.com.xeroscoutercollect.activities.ManageDBActivity;

/**
 * Created by nick on 12/6/16.
 */

public class TableTableNameColumn extends TableColumn<ManageDBActivity.TABLE_NAME> {
    public TableTableNameColumn(String k, Function func){
        super(k, func);
    }
    public TableTableNameColumn(String k){
        super(k);
    }

}
