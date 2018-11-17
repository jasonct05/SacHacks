package Model;

import lombok.Data;

import java.util.ArrayList;
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

    public boolean addRiver(Entities.Rider r) {
        this.riderList.add(r);
        return true;
    }

    public Map<Entities.Driver, List<Entities.Rider>> matchRiderAndDriver() {
        // TODO: Workout some matching algorithm
        return null;
    }
}

