package Networks;

import Model.Driver;
import Model.Rider;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JSONGenerateHelper {
    public static JSONObject generateRequestReply(Pair<Driver, List<Rider>> route) {
        JSONObject obj = new JSONObject();
        obj.put("driver", generateDriver(route.getKey()));

        JSONArray list = new JSONArray();
        for (Rider r : route.getValue()) {
            list.add(generateRider(r));
        }
        obj.put("riders", list);
        return obj;
    }

    public static JSONObject generateDriver(Driver driver) {
        JSONObject obj = new JSONObject();
        obj.put("user_name", driver.userName);
        obj.put("user_id", driver.userId);
        obj.put("lat", driver.location.latitude);
        obj.put("lon", driver.location.longitude);
        obj.put("from_time", "15:00");
        obj.put("to_time", "17:00");
        obj.put("rendezvous", driver.meetupLocation);
        obj.put("seat_available", driver.maxSeats);
        return obj;

    }

    public static JSONObject generateRider(Rider rider) {
        JSONObject obj = new JSONObject();
        obj.put("user_name", rider.userName);
        obj.put("user_id", rider.userId);
        obj.put("lat", rider.location.latitude);
        obj.put("lon", rider.location.longitude);
        obj.put("from_time", "15:00");
        obj.put("to_time", "17:00");
        return obj;
    }

}
