package task.gold.bombstring9935;
// 46%
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static boolean atLeast = true;
    static int pointer = 0;
    static boolean checking = false;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().toCharArray();

        char[] bomb = br.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> removeStack = new ArrayDeque<>();

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_pointer = bomb.length - 1;

        for (int k = 0; k < chars.length+1; k++) {

            if (pointer > max_pointer) {

                if (!removeStack.isEmpty()) {
                    System.out.println("맨 마지막 여기 아님?");
                    char last = removeStack.getLast();
                    for (int i = 0; i < bomb.length; i++) {
                        if (bomb[i] == last) {
                            pointer = i;
                            break;
                        }
                    }
                } else {
                    pointer = 0;
                }
            }
            char ch = chars[k];
            stack.push(ch);
            if (pointer <= max_pointer) {
                char bombItem = bomb[pointer];
                if (ch == bombItem) {
                    removeStack.offer(ch);
                    pointer++;
                } else if (ch == bomb[0]) {
                    pointer = 0;
                    removeStack.offer(ch);
                    pointer++;
                } else {
                    for (int i = 0; i < removeStack.size(); i++) {
                        stack.push(removeStack.poll());
                    }
                    pointer = 0;
                }
            }
            System.out.println("ch : " + ch);
            System.out.println("pointer = " + pointer);
        }
        System.out.println(stack);


        sb = new StringBuilder();
        while(!stack.isEmpty()) {
            char s = stack.pollLast();
            sb.append(s);
        }
        String subStrings = sb.toString();
        if (!atLeast) {
            if (subStrings.isEmpty()) {
                bw.write("FRULA");
            } else {
                bw.write(subStrings);
            }
            bw.flush();
            bw.close();
            br.close();
        } else {
            chars = subStrings.toCharArray();
        }



    }
}
