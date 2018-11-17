package Maps;
import Model.Driver;
import Model.Event;
import Model.Rider;

import java.util.*;

public class Matcher {
    public static final int MAX_DISTANCE = 10; // in miles

    public static Map<Driver, Set<Rider>> findRidersInRegion(List<Driver> lDriver, List<Rider> lRider) {
        // initialize
        Map<Driver, Set<Rider>> result = new HashMap<>();
        for(Driver d : lDriver) {
            result.put(d, new HashSet<>());
        }

        // shitty O(n^2) alg but fuck it
        for(Rider r : lRider) {
            for ()
        }
       return null;
    }

    public static Map<Driver, List<Rider>> findClusters(Map<Driver, Set<Rider>> driverRiderMappingInRegion) {
        //TODO: @Alex call maps api to get clusters;
        return null;
    }

    public static List<Rider> findOrder(Driver driver, List<Rider> lRider, Event destination) {
        //TODO: @Alex call maps api to find ordering
        return null;
    }
}
