package task.easy.charAndString27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int index = Integer.parseInt(br.readLine());

        char c = name.charAt(index-1);

        System.out.println(c);

    }
}
