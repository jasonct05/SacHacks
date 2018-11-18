package Mocks;

import Model.BatchingModel;
import Model.Driver;
import Model.Location;
import Model.Rider;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class DriverAndRiderMock {
    public static Set<Driver> createMockDriverSet() {
        Set<Driver> s = new HashSet<>();
        s.add(new Driver(
                "Ryan Efendy",
                "1",
                "Hi I am a sacramento kings fan",
                new Location(38.6511, -121.3467),
                LocalDateTime.of(2018, 11, 21, 15, 00),
                4,
                4,
                "Outside the Stadium"
            ));
        return s;
    }

    public static Set<Rider> createMockRiderSet() {
        Set<Rider> s = new HashSet<>();
        s.add(new Rider(
                "Jason Tan",
                "2",
                "Hi I am a sacramento kings fan",
                new Location(38.6751, -121.3909),
                LocalDateTime.of(2018, 11, 21, 15, 00)
        ));
        s.add(new Rider(
                "Stefan Layanto",
                "3",
                "Hi I am not a sacramento kings fan",
                new Location(38.6393, -121.3797),
                LocalDateTime.of(2018, 11, 21, 15, 00)
        ));
        return s;
    }

    public static boolean populateBatchingModel(BatchingModel bm) {
        Set<Rider> sr = createMockRiderSet();
        Set<Driver> sd = createMockDriverSet();

        for(Rider r : sr ) {
            bm.addRider(r);
        }

        for (Driver d : sd) {
            bm.addDriver(d);
        }

        return true;
    }
}