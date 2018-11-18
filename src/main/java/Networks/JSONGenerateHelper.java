package Networks;

import Model.Driver;
import Model.Rider;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.List;

public class JSONGenerateHelper {
    public static JSONObject generateRequestReply(Pair<Driver, List<Rider>> route) {
        // TODO @Stef: implement this format should look like this
        /**
         * {
         "driver": {
         "user_name": "ryan efendy",
         "user_id": "67890",
         "lat": "30",
         "lon": "40",
         "from_time": "15:00",
         "to_time": "17:00",
         "rendezvous": "gate 1",
         "seat_available": "3"
         },

         "riders": [
         {
         "user_name": "first person",
         "user_id": "67890",
         "lat": "30",
         "lon": "40",
         "from_time": "15:00",
         "to_time": "17:00",
         "rendezvous": "gate 1",
         "seat_available": "3"
         },
         {
         "user_name": "second person",
         "user_id": "67890",
         "lat": "30",
         "lon": "40",
         "from_time": "15:00",
         "to_time": "17:00",
         "rendezvous": "gate 1",
         "seat_available": "3"
         }
         ]
         }
         */
        return null;
    }
}
