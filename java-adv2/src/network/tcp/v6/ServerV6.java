package network.tcp.v6;

import network.tcp.v4.SessionV4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        boolean endCondi = false;

        log("서버 시작");
        SessionManagerV6 sessionManager = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // ShutdownHook 등록
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook,
                "shutdown"));

        while (true) {
            Socket socket = serverSocket.accept(); // 실행시: 여기서 기다림
            log("소캣 연결: " + socket);

            SessionV6 session = new SessionV6(socket, new SessionManagerV6());
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
