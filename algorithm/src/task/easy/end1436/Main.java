package task.easy.end1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int loopNumber = 665;
        while (count != N) {
            loopNumber++;
            if (String.valueOf(loopNumber).contains("666")) {
                count++;
            }

        }
        System.out.println(loopNumber);
    }
}
