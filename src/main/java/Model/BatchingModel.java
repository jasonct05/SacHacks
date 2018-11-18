package Model;

import Maps.Matcher;

import java.util.*;
import javafx.util.Pair;

public class BatchingModel {
    private Set<Driver> driverList;
    private Set<Rider> riderList;
    private Event event;

    private Map<Driver, List<Rider>> matchRoute;

    public BatchingModel(Event event) {
        this.driverList = new HashSet<Driver>();
        this.riderList = new HashSet<Rider>();

        this.event = event;
        this.matchRoute = null;
    }

    public boolean addDriver(Driver d) {
        this.driverList.add(d);
        return true;
    }

    public boolean addRider(Rider r) {
        this.riderList.add(r);
        return true;
    }

    public Map<Driver, List<Rider>> getMatchRoute() {
        return this.matchRoute;
    }

    /**
     * @return  Map who's key is the driver, and the value is the list of passengers
     *          in ORDER of pickup
     */
    public boolean matchRiderAndDriver() {
        // Step 1: Find all riders in the same region as drivers
        Map<Rider, Set<Driver>> driverToPotentialRiderMapping = Matcher.findRidersInRegion(this.driverList, new HashSet<Rider>(this.riderList));
        System.out.println("---- Processed step 1 ----");
        for (Rider r : driverToPotentialRiderMapping.keySet()) {
            System.out.println(r + " " + driverToPotentialRiderMapping.get(r));
        }

        // Step 2: Match riders to drivers
        Map<Driver, Set<Rider>> driverToRiderUnorderedMapping = Matcher.findClusters(driverToPotentialRiderMapping, this.driverList);
        System.out.println("---- Processed step 2 ----");
        for (Driver d : driverToRiderUnorderedMapping.keySet()) {
            System.out.println(d + " " + driverToRiderUnorderedMapping.get(d));
        }

        // Step 3: Find final matches
        Map<Driver, List<Rider>> driverToRiderOrderedMapping = new HashMap<>();
        for (Driver d : this.driverList) {
            driverToRiderOrderedMapping.put(d, Matcher.findOrder(d, driverToRiderUnorderedMapping.get(d)));
        }

        System.out.println("---- Processed step 3 ----");
        for (Driver d : driverToRiderOrderedMapping.keySet()) {
            System.out.println(d + " " + driverToRiderOrderedMapping.get(d));
        }

        this.matchRoute = driverToRiderOrderedMapping;
        return true;
    }

    public Pair<Driver, List<Rider>> getRoute(String id) {
        Driver currDriver = null;
        for (Driver d : matchRoute.keySet()) {
            if (d.userId.equals(id)) {
                currDriver = d;
                break;
            }
        }
        return new Pair<>(currDriver, matchRoute.get(currDriver));
    }
}

