import Mocks.BatchingModelInitializer;
import Mocks.DriverAndRiderMock;
import Model.BatchingModel;
import Model.Driver;
import Model.Rider;
import Networks.JSONGenerateHelper;
import Networks.JSONParserHelper;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static Networks.JSONParserHelper.parseRequestType;

public class HTTPServer {
    public static final int PORT_NUMBER = 8500;

    public static Model.BatchingModel bm = BatchingModelInitializer.initializeEventModel();
    public static void main(String[] args) throws IOException {
        // remove me for primer
        DriverAndRiderMock.populateBatchingModel(bm);
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT_NUMBER), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(HTTPServer::handleRequest);
        server.start();
        System.out.println("server started");
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        JSONObject jsonBody = convertJsonBody(exchange);

        // get request type
        JSONParserHelper.RequestType requestType = parseRequestType(jsonBody);

        // call appropriate methods
        String response = "Received Request";
        System.out.println("----------");
        System.out.println("Received Request for " + requestType);
        if (requestType == (JSONParserHelper.RequestType.ADD_DRIVER_REQUEST)) {
            Driver d = JSONParserHelper.parseDriver(jsonBody);
            System.out.println("driver received " + d);
            bm.addDriver(d);
        } else if (requestType == (JSONParserHelper.RequestType.ADD_RIDER_REQUEST)) {
            Rider r = JSONParserHelper.parseRider(jsonBody);
            System.out.println("rider received " + r);
            bm.addRider(r);
        } else if (requestType == (JSONParserHelper.RequestType.TRIGGER_MATCHER_ALGORITHM)) {
            bm.matchRiderAndDriver();
        } else if (requestType == (JSONParserHelper.RequestType.MATCH_REQUEST)) {
            String userId = JSONParserHelper.parseMatchRequest(jsonBody);
            Pair<Driver, List<Rider>> route = bm.getRoute(userId);
            JSONObject jsonResponse = JSONGenerateHelper.generateRequestReply(route);
            response = jsonResponse.toString();
        }

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println("Processed Request for " + requestType);
        System.out.println("----------");
    }

    private static JSONObject convertJsonBody(HttpExchange exchange) {
        InputStream iostream = exchange.getRequestBody();
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject)jsonParser.parse(
                    new InputStreamReader(iostream, "UTF-8"));

            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}