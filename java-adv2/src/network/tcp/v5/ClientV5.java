package network.tcp.v5;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV5 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {


        try (  Socket socket = new Socket("localhost", PORT);
               DataOutputStream output = new DataOutputStream(socket.getOutputStream());
               DataInputStream input = new DataInputStream(socket.getInputStream());) {

            Scanner sc = new Scanner(System.in);
            boolean endCondi = false;
            log("소켓 연결 시작");


            while (!endCondi) {
                System.out.println("1.서버로 메세지 보내기 | 2.종료");
                System.out.println("선택: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        output.writeUTF(sc.nextLine());
                        String received = input.readUTF();
                        log("서버로 부터 응답: " + received);
                        break;
                    case 2:
                        output.writeUTF("종료");
                        endCondi = true;
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 입력하셈요");
                }
            }
        } catch (IOException e) {
            log(e);
        }
    }

    private static void resourceEnd(DataOutputStream output, DataInputStream input, Socket socket) throws IOException {
        output.close();
        input.close();
        socket.close();
    }
}
