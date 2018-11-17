package Model;

import lombok.Data;

import java.util.ArrayList;
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

    public boolean addRiver(Rider r) {
        this.riderList.add(r);
        return true;
    }

    public Map<Driver, List<Rider>> matchRiderAndDriver() {
        // TODO: Workout some matching algorithm
    }

    
}

