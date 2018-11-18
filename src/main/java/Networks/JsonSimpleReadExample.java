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
        String json = "{\"Type\":\"rider\", \"userName\":\"Jason Tan\", \"userID\":\"1996\", \"shortDescription\":\"hat haaaair\", \"longDescription\":\"serious hat haaaaair\", \"localDateTime\":\"time\"}";
        parseRider(json);
        String json2 = "{\"Type\":\"driver\", \"userName\":\"Jason Tan\", \"userID\":\"1996\", \"shortDescription\":\"hat haaaair\", \"longDescription\":\"serious hat haaaaair\", \"localDateTime\":\"time\", \"maxSeats\":\"3\", \"availableSeats\":\"2\", \"pickupLocation\":\"Campus Teriyaki\"}";
        parseDriver(json2);
    }

    public static void parseRider(String json) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);//new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            String userName = (String) jsonObject.get("userName");
            System.out.println(userName);

            String userID = (String) jsonObject.get("userID");
            System.out.println(userID);

            String shortDescription = (String) jsonObject.get("shortDescription");
            System.out.println(shortDescription);

            String longDescription = (String) jsonObject.get("longDescription");
            System.out.println(longDescription);

            String localDateTime = (String) jsonObject.get("localDateTime");
            System.out.println(localDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseDriver(String json) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);//new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            String userName = (String) jsonObject.get("userName");
            System.out.println(userName);

            String userID = (String) jsonObject.get("userID");
            System.out.println(userID);

            String shortDescription = (String) jsonObject.get("shortDescription");
            System.out.println(shortDescription);

            String longDescription = (String) jsonObject.get("longDescription");
            System.out.println(longDescription);

            String localDateTime = (String) jsonObject.get("localDateTime");
            System.out.println(localDateTime);

            String maxSeats = (String) jsonObject.get("maxSeats");
            System.out.println(maxSeats);

            String availableSeats = (String) jsonObject.get("availableSeats");
            System.out.println(availableSeats);

            String pickupLocation = (String) jsonObject.get("pickupLocation");
            System.out.println(pickupLocation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
