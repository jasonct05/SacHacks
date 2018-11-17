package Maps;
import Model.Driver;
import Model.Event;
import Model.Rider;

import java.util.List;
import java.util.Map;

public class Matcher {
    public static final int MAX_DISTANCE = 10; // in miles

    public static Map<Driver, List<Rider>> findClusters(List<Driver> lDriver, List<Rider> lRider) {
        //TODO: @Alex call maps api to get clusters;
        return null;
    }

    public static List<Rider> findOrder(Driver driver, List<Rider> lRider, Event destination) {
        //TODO: @Alex call maps api to find ordering
        return null;
    }
}
