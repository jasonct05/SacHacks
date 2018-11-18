package Maps;
import Model.Driver;
import Model.Rider;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;


import java.util.*;

public class Matcher {
    public static final double MAX_DISTANCE = 4.20; // in miles

    public static Map<Rider, Set<Driver>> findRidersInRegion(Set<Driver> lDriver, Set<Rider> lRider) {
        // initialize
        Map<Rider, Set<Driver>> result = new HashMap<>();
        for(Rider r : lRider) {
            result.put(r, new HashSet<>());
        }

        // find distance between all riders and drivers in the event.
        // shitty O(n^2) alg but fuck it
        for(Rider r : lRider) {
            for (Driver d : lDriver) {
                double distance = callapi(r, d);
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
        Map<Driver, Set<Rider>> optimized = new HashMap<>();
        for (Driver d: lDriver) {
            optimized.put(d, new HashSet<>());
        }
        for (Rider r : driverRiderMappingInRegion.keySet()) {
            Set<Driver> drivers = driverRiderMappingInRegion.get(r);

            //get driver
            Driver currDriver = drivers.iterator().next();
            int capacity = currDriver.availableSeats;

            //see if there is driver with more capacity;
            for (Driver d : drivers) {
                if (d.availableSeats == 0) {
                    continue;
                }
                if (d.availableSeats > capacity) {
                    currDriver = d;
                    capacity = d.availableSeats;
                }
            }
            //add rider to driver with most capacity
            optimized.get(currDriver).add(r);
            currDriver.availableSeats--;
        }
        return optimized;
    }

    public static List<Rider> findOrder(Map<Driver, Set<Rider>> driverToRiderUnorderedMapping) {
        //TODO: @Alex call maps api to find ordering

        //request one to many matrix routing
        return null;
    }
}
