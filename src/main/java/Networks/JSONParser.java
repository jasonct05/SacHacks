package Networks;

import Model.Driver;
import Model.Location;
import Model.Rider;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * This class is in charge of two things, parsing
 */
public class JSONParser {

    private static org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

    /**
     * CODE BELOW IS JSON PARSER UTILITIES FOR FRONTEND COMMUNICATION
     */

    enum RequestType {
        ADD_DRIVER_REQUEST, ADD_RIDER_REQUEST, MATCH_REQUEST, INVALID_REQUEST;
    }

    public static RequestType parseRequestType(String json) {
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            String requestType = (String) jsonObject.get("requestType");

            if (requestType.equals("driver")) {
                return RequestType.ADD_DRIVER_REQUEST;
            } else if (requestType.equals("rider")) {
                return RequestType.ADD_RIDER_REQUEST;
            } else if (requestType.equals("match")) {
                return RequestType.MATCH_REQUEST;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return RequestType.INVALID_REQUEST;
    }

    public static Rider parseRider(String json) {
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            return new Rider(
                    (String) jsonObject.get("userName"),
                    (String) jsonObject.get("userId"),
                    (String) jsonObject.get("description"),
                    new Location (Double.parseDouble((String) jsonObject.get("latitude")), Double.parseDouble((String) jsonObject.get("longitude"))),
                    LocalDateTime.of(2018, 11, 21, 15, 00));
        } catch (ParseException e) {
            System.out.println(e);
        }

        // should not go here
        return null;
    }

    public static Driver parseDriver(String json) {
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            return new Driver(
                    (String) jsonObject.get("userName"),
                    (String) jsonObject.get("userId"),
                    (String) jsonObject.get("description"),
                    new Location(Double.parseDouble((String) jsonObject.get("latitude")), Double.parseDouble((String) jsonObject.get("longitude"))),
                    LocalDateTime.of(2018, 11, 21, 15, 00),
                    Integer.parseInt((String) jsonObject.get("maxSeats")),
                    Integer.parseInt((String) jsonObject.get("availableSeats")),
                    (String) jsonObject.get("pickupLocation")
            );
        } catch (ParseException e) {
            System.out.println(e);
        }

        // should not go here
        return null;
    }

    /**
     * CODE BELOW IS JSON PARSER UTILITIES FOR HERE API
     */
    public static double findDistanceFromSimpleRouteRequest(String s) {
        try {
            JSONObject jo = (JSONObject) parser.parse(s);
            jo = (JSONObject) jo.get("response");
            JSONArray routeArray = ((JSONArray) jo.get("route"));

            Iterator routeIterator = routeArray.iterator();
            JSONObject result = (JSONObject) routeIterator.next();
            result = (JSONObject) result.get("summary");
            return ((Number) result.get("distance")).doubleValue();

        } catch (Exception e) {
            System.out.println(e);
        }

        return -1; // not found
    }
}
