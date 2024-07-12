package task.easy.melody2920;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        List<Integer> list = new ArrayList<>();
        List<Integer> listValid = new ArrayList<>();
        for (String string : s1) {
            int i = Integer.parseInt(string);
            list.add(i);
            listValid.add(i);
        }

        Collections.sort(list);

        while (true) {
            if (list.equals(listValid)) {
                System.out.println("ascending");
                break;
            }

            Collections.reverse(list);
            if (list.equals(listValid)) {
                System.out.println("descending");
                break;
            }

            System.out.println("mixed");
            break;
        }

    }
}
