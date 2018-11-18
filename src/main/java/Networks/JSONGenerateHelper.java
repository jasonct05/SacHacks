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
        // generate
    }

    public class JsonSimpleWriteExample {
        public static void main(String[] args) {
            JSONObject obj = new JSONObject();
            obj.put("name", "mkyong.com");
            obj.put("age", 100);

            JSONArray list = new JSONArray();
            list.add("msg 1");
            list.add("msg 2");
            list.add("msg 3");

            obj.put("messages", list);

            System.out.print(obj);
        }
    }
}
