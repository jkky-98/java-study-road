package task.gold.bombstring9935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String bomb = br.readLine();
        Deque<Integer> removeQ = new ArrayDeque<>();

        String spaces = " ".repeat(bomb.length());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (string.contains(bomb)) {
            int start = string.indexOf(bomb);
            removeQ.clear();
            removeQ.offer(start);

            for (int i = start+bomb.length(); i < string.length(); i++) {
                if (string.charAt(i) == bomb.charAt(0)) {
                    if (string.startsWith(bomb, i)) {
                        removeQ.offer(i);
                    }
                }
            }
            int pollStart = 0;
            StringBuilder sbTmp = new StringBuilder();
            while (!removeQ.isEmpty()) {
                Integer poll = removeQ.poll();
                for (int i = pollStart; i < poll; i++) {
                    sbTmp.append(string.charAt(i));
                }
                if (removeQ.isEmpty() && poll+bomb.length() < string.length()) {
                    for (int i = poll+bomb.length(); i < string.length(); i++) {
                        sbTmp.append(string.charAt(i));
                    }
                    break;
                }
                pollStart = poll + bomb.length();
            }

            string = sbTmp.toString();
            System.out.println(string);

        }


        if (string.isEmpty()) {
            bw.write("FRULA");
        } else {
            bw.write(string);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
