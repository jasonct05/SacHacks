package TestFramework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.midi.SysexMessage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import static Networks.JSONParser.parseRider;

public class JsonSimpleReadExample {

    public static void main(String[] args) {
        String json =  "{\"type\":\"rider\",\"userName\":\"Jason Tan\",\"userID\":\"1996\",\"description\":\"hat haaaair\",\"latitude\":\"serious hat haaaaair\",\"longitude\":\"blah\",\"pickupTimeFrame\":\"ASAFP\"}";
        parseRider(json);
    }
}
