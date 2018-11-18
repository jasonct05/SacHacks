package Model;

import java.time.LocalDateTime;

public class User {
    public String userName;
    public String userId;
    public String description;
    public Location location; //kings oriented stuff
    public LocalDateTime pickupTimeFrame;

    public User(String userName, String userId, String shortDescription, Location location, LocalDateTime pickupTimeFrame) {
        this.userName = userName;
        this.userId = userId;
        this.description = shortDescription;
        this.location = location;
        this.pickupTimeFrame = pickupTimeFrame;
    }

    @Override
    public String toString() {
        return this.userName;
    }
}
