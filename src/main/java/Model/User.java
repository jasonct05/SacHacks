package Model;

import java.time.LocalDateTime;

public class User {
    public String userName;
    public String userId;
    public String shortDescription;
    public String longDescription; //kings oriented stuff
    public LocalDateTime pickupTimeFrame;

    public User(String un, String uid, String sd, String ld, LocalDateTime pickupTimeFrame) {
        this.userName = un;
        this.userId = uid;
        this.shortDescription = sd;
        this.longDescription = ld;
        this.pickupTimeFrame = pickupTimeFrame;
    }
}
