package Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public final String userName;
    public final String userId;
    public final String shortDescription;
    public final String longDescription; //kings oriented stuff
    public final LocalDateTime pickupTimeFrame;
}
