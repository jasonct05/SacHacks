import Maps.Matcher;
import Mocks.BatchingModelInitializer;
import Mocks.DriverAndRiderMock;

public class Main {
    public static void main(String[] args){
        Model.BatchingModel bm = BatchingModelInitializer.initializeEventModel();
        // dummy code
        DriverAndRiderMock.populateBatchingModel(bm);
        try {
            bm.matchRiderAndDriver();
        } catch(Exception e) {

        }
        /*
        // TODO: Set up connections singleton here
        ServerSocket ss = Networks.TCPServer.getTCPServerSocket();
        while (true) {
            // if receive connection on tcp port
            try (
                    Socket clientSocket = ss.accept();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
            ) {
                String json = "", inputLine;
                while ((inputLine = in.readLine()) != null) {
                    json += inputLine;
                    System.out.println(inputLine);
                }
                if(JSONParser.isDriver(json)) {
                    bm.addDriver(JSONParser.parseDriver(json));
                }else{
                    bm.addRider(JSONParser.parseRider(json));
                }
            } catch (Exception e){

            }
                // establish new thread
                // update model...

            // if cutoff time
                // call model matching algorithm
        }
        */

    }

    public static boolean receiveUserDetails() {
        return true;
    }
}
