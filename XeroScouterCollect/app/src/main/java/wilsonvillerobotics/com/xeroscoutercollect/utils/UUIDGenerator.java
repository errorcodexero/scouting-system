package wilsonvillerobotics.com.xeroscoutercollect.utils;

/**
 * Created by Luke Puppo on 12/18/2016.
 */

import java.util.UUID;

public class UUIDGenerator {
    private static UUID id;
    public UUIDGenerator(){
    }
    public static UUID generateUUID(){
        id = UUID.randomUUID();
        return id;
    }
}
