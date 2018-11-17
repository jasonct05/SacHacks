package Model;

import java.time.LocalDateTime;

public class Driver extends User {
    public int maxSeats;
    public int availableSeats;
    public String meetupLocation;

    public Driver(String un, String uid, String sd, String ld, LocalDateTime pickupTimeFrame,
                  int maxSeats, int availableSeats, String meetupLocation) {
        super(un, uid, sd, ld, pickupTimeFrame);
        this.maxSeats = maxSeats;
        this.availableSeats = availableSeats;
        this.meetupLocation = meetupLocation;
    }
}
