package Networks;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URI;

public class HereAPIHttpClient {

    public static final String SIMPLE_ROUTE_URL = "https://route.api.here.com/routing/7.2/calculateroute.json";

    public static String HERE_API_APP_ID = "MX1s7TrrSy2Zc9dPuu3U";   // put app id here
    public static String HERE_API_APP_CODE = "xZizd8K9E0ZS8Rnn4J2rvA"; // put app code here

    public static String URL_PARAMETERS = "app_id=MX1s7TrrSy2Zc9dPuu3U&app_code=xZizd8K9E0ZS8Rnn4J2rvA&waypoint0=geo!52.5,13.4&waypoint1=geo!52.5,13.45&mode=fastest;car;traffic:disabled;";

    public static final HttpClient httpclient = HttpClients.createDefault();

    public static void simpleRouteRequest(String startLocation, String endLocation){
        mapsAPIRequestHelper(SIMPLE_ROUTE_URL, URL_PARAMETERS);
    }

    private static String mapsAPIRequestHelper(String URL, String urlParameters) {
        try {
            System.out.println("begin url build");
            URIBuilder builder = new URIBuilder(URL);

            builder.addParameter("app_id", "MX1s7TrrSy2Zc9dPuu3U");
            builder.addParameter("app_code", "xZizd8K9E0ZS8Rnn4J2rvA");
            builder.addParameter("waypoint0", "geo!52.5,13.4");
            builder.addParameter("waypoint1", "geo!52.5,13.45");
            builder.addParameter("mode", "fastest;car;traffic:disabled;");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);


            System.out.println("Sending Request");
            HttpResponse response = httpclient.execute(request);
            System.out.println("Received Response");

            HttpEntity entity = response.getEntity();

            System.out.println(EntityUtils.toString(entity));

            return EntityUtils.toString(entity);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}