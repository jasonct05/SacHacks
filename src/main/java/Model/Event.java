package Model;

import java.time.LocalDateTime;

public class Event {
    public String eventName;
    public LocalDateTime eventDate;

    public Event(String en, LocalDateTime eventDate) {
        this.eventName = en;
        this.eventDate = eventDate;
    }
}
