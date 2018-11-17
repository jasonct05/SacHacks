package Model;

import lombok.Data;

import java.util.Date;

public class Entities {

    @Data
    public class User {
        public final String userName;
        public final String userId;
        public final String shortDescription;
        public final String longDescription; //kings oriented stuff
        public final Date pickupTimeFrame;
    }

    @Data
    public class Driver extends User {
        public final int maxSeats;
        public final int availableSeats;
        public final String meetupLocation;
    }

    @Data
    public class Rider extends User {
    }

    @Data
    public class Event {
        public final String eventName;
        public final Date eventDate;
    }
}