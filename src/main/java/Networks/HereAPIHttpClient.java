package Networks;

import Model.Location;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HereAPIHttpClient {

    public static final String SIMPLE_ROUTE_URL = "https://route.api.here.com/routing/7.2/calculateroute.json";

    public static String HERE_API_APP_ID = "MX1s7TrrSy2Zc9dPuu3U";   // put app id here
    public static String HERE_API_APP_CODE = "xZizd8K9E0ZS8Rnn4J2rvA"; // put app code here

    public static final HttpClient httpclient = HttpClients.createDefault();

    public static String simpleRouteRequest(Location driverLocation, Location riderLocation){
        Map<String, String> param = new HashMap<>();
        param.put("waypoint0", "geo!" + driverLocation.latitude + "," + riderLocation.longtitude);
        param.put("waypoint1", "geo!" + driverLocation.latitude + "," + riderLocation.longtitude);
        param.put("waypoint1", "geo!" + driverLocation.latitude + "," + riderLocation.longtitude);
        param.put("mode", "fastest;car;traffic:disabled;");
        return mapsAPIRequestHelper(SIMPLE_ROUTE_URL, param);
    }

    private static String mapsAPIRequestHelper(String URL, Map<String, String> parameters) {
        try {
            System.out.println("begin url build");
            URIBuilder builder = new URIBuilder(URL);

            builder.addParameter("app_id", HERE_API_APP_ID);
            builder.addParameter("app_code", HERE_API_APP_CODE);

            for(String key : parameters.keySet()) {
                builder.addParameter(key, parameters.get(key));
            }

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);


            System.out.println("Sending Request");
            HttpResponse response = httpclient.execute(request);
            System.out.println("Received Response");

            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}