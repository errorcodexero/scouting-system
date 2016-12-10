package wilsonvillerobotics.com.xeroscoutercollect.database;

import java.util.function.Function;

import wilsonvillerobotics.com.xeroscoutercollect.activities.ManageDBActivity;

/**
 * Created by nick on 12/6/16.
 */

public class TableColumn<E> {
    protected String key;
    protected E value;

    public TableColumn (String k, Function<E, void> func) {
        key = k;
        setter = func;

    }


    public TableColumn (String k) {
        key = k;
        setter = null;
    }

    public void setValue(E v){
        value = v;
    }
    public E getValue() { return value; }
    @Override
    public String toString () { return String.valueOf(this.value); }
    public E getKey() { return (E) key; }
    public Function setter;
    public void exec(E setValue) {
        setter.apply(setValue);
    }


}
