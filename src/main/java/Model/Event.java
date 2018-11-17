package Model;

import java.time.LocalDateTime;

public class Event {
    public String eventName;
    public LocalDateTime eventDate;

    public Event(String eventName, LocalDateTime eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }
}
