package Model;

import java.time.LocalDateTime;

public class Rider extends User {

    public Rider(String un, String uid, String sd, String ld, LocalDateTime pickupTimeFrame) {
        super(un, uid, sd, ld, pickupTimeFrame);
    }
}
