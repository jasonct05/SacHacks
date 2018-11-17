package Networks;

import java.net.HttpURLConnection;
import java.net.URL;

public class HereAPIHttpClient {

    public static final String SIMPLE_ROUTE_URL = "https://route.api.here.com/routing/7.2/calculateroute.json";
    public static String HERE_API_APP_ID = ""   // put app id here
    public static String HERE_API_APP_CODE = "" // put app code here

    private static endSimpleRouteRequest(String startLocation, String endLocation) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(SIMPLE_ROUTE_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("app_id", HERE_API_APP_ID);
            connection.setRequestProperty("app_code", HERE_API_APP_CODE);
            connection.setRequestProperty("mode", "mode=fastest;car;traffic:disabled");
            


        }

    }
}

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }