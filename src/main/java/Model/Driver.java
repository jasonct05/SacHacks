package Model;

import lombok.Data;

public class Driver extends User {
    public final int maxSeats;
    public final int availableSeats;
    public final String meetupLocation;

    public Driver() {
        super();
    }
}
