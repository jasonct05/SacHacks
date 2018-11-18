package Model;

import java.time.LocalDateTime;

public class Event {
    public String eventName;
    public LocalDateTime eventDate;
    public Location eventLocation;

    public Event(String eventName, LocalDateTime eventDate, Location eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;

    }
}
