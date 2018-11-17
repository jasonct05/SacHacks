package Networks;

import java.net.ServerSocket;

public class TCPServer {
    private static final int PORT_NUMBER = 4022;

    private static ServerSocket socket;

    public static ServerSocket getTCPServerSocket() {
        if (socket == null) {
            try {
                socket = new ServerSocket(TCPServer.PORT_NUMBER);
            } catch (Exception e) {
                // Error
            }
        }

        return socket;
    }
}
