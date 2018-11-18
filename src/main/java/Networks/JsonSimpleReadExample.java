package Networks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.midi.SysexMessage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonSimpleReadExample {

    public static void main(String[] args) {
        String json =  "{\"type\":\"rider\",\"userName\":\"Jason Tan\",\"userID\":\"1996\",\"description\":\"hat haaaair\",\"latitude\":\"serious hat haaaaair\",\"longitude\":\"blah\",\"pickupTimeFrame\":\"ASAFP\"}";
        parseRider(json);
        //String json2 = "{\"type\":\"rider\",\"userName\":\"Jason Tan\",\"userID\":\"1996\",\"description\":\"hat haaaair\",\"latitude\":\"serious hat haaaaair\",\"longitude\":\"blah\",\"pickupTimeFrame\":\"ASAFP\",\"maxSeats\":\"3\", \"pickupLocation\":\"Campus Teriyaki\"}";
        //parseDriver(json2);
    }

    public static void parseRider(String json) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);//new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);
            String type = (String) jsonObject.get("type");
            String userName = (String) jsonObject.get("userName");
            String userID = (String) jsonObject.get("userID");
            String description = (String) jsonObject.get("description");
            String latitude = (String) jsonObject.get("latitude");
            String longitude = (String) jsonObject.get("longitude");
            String pickupTimeFrame = (String) jsonObject.get("pickupTimeFrame");
            System.out.println(type + userName + userID + description + latitude + longitude + pickupTimeFrame + pickupTimeFrame);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseDriver(String json) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);//new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);
            String type = (String) jsonObject.get("type");
            String userName = (String) jsonObject.get("userName");
            String userID = (String) jsonObject.get("userID");
            String description = (String) jsonObject.get("description");
            String latitude = (String) jsonObject.get("latitude");
            String longitude = (String) jsonObject.get("longitude");
            String pickupTimeFrame = (String) jsonObject.get("pickupTimeFrame");
            int availableSeats = Integer.parseInt((String) jsonObject.get("availableSeats"));
            String pickupLocation = (String) jsonObject.get("pickupLocation");

            System.out.println(type + userName + userID + description + latitude + longitude + pickupTimeFrame + pickupTimeFrame + availableSeats + pickupLocation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
