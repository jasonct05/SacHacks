package Maps;
import Model.Driver;
import Model.Location;
import Model.Rider;


import Networks.HereAPIHttpClient;
import Networks.JSONParser;


import java.util.*;

public class Matcher {
    public static final double MAX_DISTANCE = 6900; // in miles

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
                System.out.println("finding distance from " + r.location + " to " + d.location);
                String simpleRouteJSONResponse = HereAPIHttpClient.simpleRouteRequest(r.location, d.location);
                double distance = JSONParser.findDistanceFromSimpleRouteRequest(simpleRouteJSONResponse);
                System.out.println("distance from driver " + d.userName + " to " + r.userName + " is " + distance + " m");
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
        Map<Driver, Set<Rider>> optimized = new HashMap<>();

        for (Driver d: lDriver) {
            optimized.put(d, new HashSet<>());
        }

        for (Rider r : driverRiderMappingInRegion.keySet()) {
            Set<Driver> drivers = driverRiderMappingInRegion.get(r);

            //get first driver
            Driver currDriver = null;
            for (Driver d : drivers) {
                if (d.availableSeats > 0) {
                    currDriver = d;
                }
            }

            if (currDriver == null) {
                System.out.println(r.userName + " takes the bus");
                continue;
            }
            
            int capacity = currDriver.availableSeats;

            //see if there is driver with more capacity;
            for (Driver d : drivers) {
                if (d.availableSeats == 0 || d.equals(currDriver)) {
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

    public static List<Rider> findOrder(Driver start, Set<Rider> riders) {
        List<Rider> order = new ArrayList<>();
        Location currentLocation = start.location;
        while (!riders.isEmpty()) {
            Rider closestRider = null;
            double min = Integer.MAX_VALUE;

            //find all distances
            for (Rider r : riders) {
                String routeResponse = HereAPIHttpClient.simpleRouteRequest(currentLocation, r.location);
                double distance = JSONParser.findDistanceFromSimpleRouteRequest(routeResponse);
                if (distance < min) {
                    min = distance;
                    closestRider = r;
                }
            }

            //add closest rider to order
            order.add(closestRider);
            //remove closest rider from rider set;
            riders.remove(closestRider);
            //set new start;
            currentLocation = closestRider.location;
        }

        return order;
    }
}
