package Model;

import lombok.Data;

import java.util.Date;

@Data
class User {
    public final String userName;
    public final String userId;
    public final String shortDescription;
    public final String longDescription;

    public final Date pickupTimeFrame;
}

@Data
class Driver extends User {
    public final int maxSeats;
    public final int availableSeats;
}

@Data
class Rider extends User {
}

@Data
class Event {
    public final String eventName;
    public final Date eventDate;
}