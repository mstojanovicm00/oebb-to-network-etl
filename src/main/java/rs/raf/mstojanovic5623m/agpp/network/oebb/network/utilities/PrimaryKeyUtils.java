package rs.raf.mstojanovic5623m.agpp.network.oebb.network.utilities;

import java.util.HashMap;
import java.util.Map;

public class PrimaryKeyUtils {

    private static final Map<String, Integer> lastIds = new HashMap<>();

    public static int generateNextKey(String classId) {
        int lastId = lastIds.getOrDefault(classId, 0);
        lastIds.put(classId, ++lastId);
        return lastId;
    }

    private PrimaryKeyUtils() {}

}
