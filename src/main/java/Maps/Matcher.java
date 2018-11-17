package Maps;
import Model.Entities;

import java.util.List;
import java.util.Map;

public class Matcher {
    public static final int MAX_DISTANCE = 10; // in miles

    public static Map<Entities.Driver, List<Entities.Rider>> findClusters() {
        //TODO: @Alex call maps api to get clusters;
        return null;
    }

    public static List<Entities.Rider> findOrder(Entities.Driver, Entities.Rider, Entities.Event destination) {
        //TODO: @Alex call maps api to find ordering
        return null;
    }
}
