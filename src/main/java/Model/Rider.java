package Model;

import java.time.LocalDateTime;

public class Rider extends User {

    public Rider(String userName, String userId, String shortDescription, Location location, LocalDateTime pickupTimeFrame) {
        super(userName, userId, shortDescription, location, pickupTimeFrame);
    }
}
