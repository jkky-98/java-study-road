package loop;

public class WhileContinue1 {
    public static void main(String[] args) {
        int i = 0;

        while (i < 5) {
            i++;
            if (i == 3) {
                continue;
            } else {
                System.out.println(i);
            }
        }
    }
}
