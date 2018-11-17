package Model;

import Maps.Matcher;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BatchingModel {
    private List<Driver> driverList;
    private List<Rider> riderList;
    private Event event;

    public BatchingModel(Event event) {
        this.driverList = new ArrayList<Driver>();
        this.riderList = new ArrayList<Rider>();

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
        Map<Driver, List<Rider>> matchedWithoutOrder = Matcher.findClusters(this.driverList, this.riderList);

        // findOrder
        Map<Driver, List<Rider>> matchedWithOrder = new HashMap<Driver, List<Rider>>();
        for (Driver d : matchedWithOrder.keySet()) {
            matchedWithOrder.put(d, Matcher.findOrder(d, matchedWithOrder.get(d), this.event));
        }

        // return map
        return matchedWithOrder;
    }
}

