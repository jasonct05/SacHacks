package Model;

import java.time.LocalDateTime;

public class Driver extends User {
    public int maxSeats;
    public int availableSeats;
    public String meetupLocation;

    public Driver(String userName, String userId, String shortDescription, Location location, LocalDateTime pickupTimeFrame,
                  int maxSeats, int availableSeats, String meetupLocation) {
        super(userName, userId, shortDescription, location, pickupTimeFrame);
        this.maxSeats = maxSeats;
        this.availableSeats = availableSeats;
        this.meetupLocation = meetupLocation;
    }
}
