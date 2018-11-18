package Networks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

/**
 * This class is in charge of two things, parsing
 */
public class JSONParser {

    private static org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

   //input is JSON file from Ryan.
   //output is User
    public static boolean isDriver(String json) {
        return true;
    }

    public static Model.Driver parseDriver(String json) {
        return null;
    }
    public static Model.Rider parseRider(String json) {
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
