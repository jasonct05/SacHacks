package Maps;
import Model.Driver;
import Model.Rider;


import Networks.HereAPIHttpClient;
import Networks.JSONParser;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;


import java.util.*;

public class Matcher {
    public static final int MAX_DISTANCE = 10; // in miles

    public static Map<Rider, Set<Driver>> findRidersInRegion(Set<Driver> lDriver, Set<Rider> lRider) {
        // initialize
        Map<Rider, Set<Driver>> result = new HashMap<>();
        for(Rider d : lRider) {
            result.put(d, new HashSet<>());
        }

        // find distance between all riders and drivers in the event.
        // shitty O(n^2) alg but fuck it
        for(Rider r : lRider) {
            for (Driver d : lDriver) {
                String simpleRouteJSONResponse = HereAPIHttpClient.simpleRouteRequest(r.location, d.location);
                double distance = JSONParser.findDistanceFromSimpleRouteRequest(simpleRouteJSONResponse);
                if (distance <= MAX_DISTANCE) {
                    Set<Driver> driversInArea = result.get(r);
                    driversInArea.add(d);
                    result.put(r, driversInArea);
                }
            }
        }

       return result;
    }

    public static Map<Driver, Set<Rider>> findClusters(Map<Rider, Set<Driver>> driverRiderMappingInRegion, Set<Driver> lDriver) {
        //TODO: @Alex call maps api to get clusters;
        return null;
    }

    public static List<Rider> findOrder(Map<Driver, Set<Rider>> driverToRiderUnorderedMapping) {
        //TODO: @Alex call maps api to find ordering
        return null;
    }
}
