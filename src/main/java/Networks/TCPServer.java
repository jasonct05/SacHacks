package Networks;

import lombok.extern.java.Log;

import java.net.ServerSocket;

@Log
public class TCPServer {
    private static final int PORT_NUMBER = 4022;

    private static ServerSocket socket;

    public static ServerSocket getTCPServerSocket() {
        return getTCPServerSocket(TCPServer.PORT_NUMBER);
    }

    public static ServerSocket getTCPServerSocket(int port) {
        if (socket == null) {
            try {
                socket = new ServerSocket(port);
            } catch (Exception e) {
                log.fine("Unable to initialize socket");
            }
        }

        return socket;
    }
}
