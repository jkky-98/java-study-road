package network.tcp.v6;

import java.net.ServerSocket;

import static util.MyLogger.log;

public class ShutdownHook implements Runnable {

    private final ServerSocket serverSocket;
    private final SessionManagerV6 sessionManager;

    public ShutdownHook(ServerSocket serverSocket, SessionManagerV6 sessionManager) {
        this.serverSocket = serverSocket;
        this.sessionManager = sessionManager;
    }

    @Override
    public void run() {
        log("shutdown hook started");
        try {
            sessionManager.closeAll();
            serverSocket.close();

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }
}
