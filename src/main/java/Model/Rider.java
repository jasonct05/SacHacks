package Model;

import java.time.LocalDateTime;

public class Rider extends User {

    public Rider(String userName, String userId, String shortDescription, String longDescription, LocalDateTime pickupTimeFrame) {
        super(userName, userId, shortDescription, longDescription, pickupTimeFrame);
    }
}
