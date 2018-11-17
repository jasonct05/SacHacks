package Model;

import Maps.Matcher;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BatchingModel {
    private List<Entities.Driver> driverList;
    private List<Entities.Rider> riderList;
    private Entities.Event event;

    public BatchingModel(Entities.Event event) {
        this.driverList = new ArrayList<Entities.Driver>();
        this.riderList = new ArrayList<Entities.Rider>();

        this.event = event;
    }

    public boolean addDriver(Entities.Driver d) {
        this.driverList.add(d);
        return true;
    }

    public boolean addRider(Entities.Rider r) {
        this.riderList.add(r);
        return true;
    }

    /**
     * @return  Map who's key is the driver, and the value is the list of passengers
     *          in ORDER of pickup
     */
    public Map<Entities.Driver, List<Entities.Rider>> matchRiderAndDriver() {
        Map<Entities.Driver, List<Entities.Rider>> matchedWithoutOrder = Matcher.findClusters(this.driverList, this.riderList);

        // findOrder
        Map<Entities.Driver, List<Entities.Rider>> matchedWithOrder = new HashMap<Entities.Driver, List<Entities.Rider>>();
        for (Entities.Driver d : matchedWithOrder.keySet()) {
            matchedWithOrder.put(d, Matcher.findOrder(d, matchedWithOrder.get(d), this.event));
        }

        // return map
        return matchedWithOrder;
    }
}

