package Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    public final String eventName;
    public final LocalDateTime eventDate;
}
