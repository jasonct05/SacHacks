import Mocks.BatchingModelInitializer;

import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        Model.BatchingModel bm = BatchingModelInitializer.initializeEventModel();

        // TODO: Set up connections singleton here
        ServerSocket ss = Networks.TCPServer.getTCPServerSocket();
        while (true) {
            // if receive connection on tcp port
                // establish new thread
                // update model...

            // if cutoff time
                // call model matching algorithm
        }

    }
}
