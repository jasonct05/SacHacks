package Networks;

/**
 * This class is in charge of two things, parsing
 */
public class JSONParser {
   //input is JSON file from Ryan.
   //output is User
    public static boolean isDriver(String json) {
        return true;
    }

    public static Model.Driver parseDriver(String json) {
        return new Model.Driver("","", "", "",null, 0, 0, "anywhere");
    }
    public static Model.Rider parseRider(String json) {
        return new Model.Rider("","", "", "",null);
    }
}
