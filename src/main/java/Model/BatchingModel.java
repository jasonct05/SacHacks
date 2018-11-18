package Model;

import Maps.Matcher;

import java.util.*;

public class BatchingModel {
    private Set<Driver> driverList;
    private Set<Rider> riderList;
    private Event event;

    public BatchingModel(Event event) {
        this.driverList = new HashSet<Driver>();
        this.riderList = new HashSet<Rider>();

        this.event = event;
    }

    public boolean addDriver(Driver d) {
        this.driverList.add(d);
        return true;
    }

    public boolean addRider(Rider r) {
        this.riderList.add(r);
        return true;
    }

    /**
     * @return  Map who's key is the driver, and the value is the list of passengers
     *          in ORDER of pickup
     */
    public Map<Driver, List<Rider>> matchRiderAndDriver() {
        // Step 1: Find all riders in the same region as drivers
        Map<Rider, Set<Driver>> driverToPotentialRiderMapping = Matcher.findRidersInRegion(this.driverList, new HashSet<Rider>(this.riderList));

        // Step 2: Match riders to drivers
        Map<Driver, Set<Rider>> driverToRiderUnorderedMapping = Matcher.findClusters(driverToPotentialRiderMapping, this.driverList);

        // Step 3: Find final matches
        Map<Driver, List<Rider>> driverToRiderOrderedMapping = new HashMap<>();
        for(Driver d : this.driverList) {
            driverToRiderOrderedMapping.put(d, Matcher.findOrder(d, driverToRiderUnorderedMapping.get(d)));
        }
        return driverToRiderOrderedMapping;
    }
}

