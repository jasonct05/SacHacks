package Networks;

import Model.Driver;
import Model.Location;
import Model.Rider;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * This class is in charge of two things, parsing
 */
public class JSONParserHelper {

    private static org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

    /**
     * CODE BELOW IS JSON PARSER UTILITIES FOR FRONTEND COMMUNICATION
     */

    public enum RequestType {
        ADD_DRIVER_REQUEST, ADD_RIDER_REQUEST, MATCH_REQUEST, INVALID_REQUEST, TRIGGER_MATCHER_ALGORITHM;
    }

    public static RequestType parseRequestType(JSONObject jsonObject) {
        try {
            String requestType = (String) jsonObject.get("type");

            if (requestType.equals("driver")) {
                return RequestType.ADD_DRIVER_REQUEST;
            } else if (requestType.equals("rider")) {
                return RequestType.ADD_RIDER_REQUEST;
            } else if (requestType.equals("match")) {
                return RequestType.MATCH_REQUEST;
            } else if (requestType.equals("trigger")) {
                return RequestType.TRIGGER_MATCHER_ALGORITHM;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return RequestType.INVALID_REQUEST;
    }

    public static Rider parseRider(JSONObject jsonObject) {
        return new Rider(
                (String) jsonObject.get("user_name"),
                (String) jsonObject.get("user_id"),
                (String) jsonObject.get("description"),
                new Location (Double.parseDouble((String) jsonObject.get("lat")), Double.parseDouble((String) jsonObject.get("lon"))),
                    LocalDateTime.of(2018, 11, 21, 15, 00));
    }

    public static Driver parseDriver(JSONObject jsonObject) {
        return new Driver(
                (String) jsonObject.get("user_name"),
                (String) jsonObject.get("user_id"),
                (String) jsonObject.get("description"),
                new Location(Double.parseDouble((String) jsonObject.get("lat")), Double.parseDouble((String) jsonObject.get("lon"))),
                LocalDateTime.of(2018, 11, 21, 15, 00),
                Integer.parseInt((String) jsonObject.get("seat_available")),
                Integer.parseInt((String) jsonObject.get("seat_available")),
                (String) jsonObject.get("rendezvous")
        );
    }

    public static String parseMatchRequest(JSONObject jsonObject) {
        return (String) jsonObject.get("user_name");
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
