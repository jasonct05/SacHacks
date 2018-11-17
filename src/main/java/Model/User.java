package Model;

import lombok.Data;

import java.time.LocalDateTime;

public class User {
    public final String userName;
    public final String userId;
    public final String shortDescription;
    public final String longDescription; //kings oriented stuff
    public final LocalDateTime pickupTimeFrame;

    public User(String un, String uid, String sd, String ld, LocalDateTime pickupTimeFrame) {
        this.userName = un;
        this.userId = uid;
        this.shortDescription = sd;
        this.longDescription = ld;
        this.pickupTimeFrame = pickupTimeFrame;
    }
}
