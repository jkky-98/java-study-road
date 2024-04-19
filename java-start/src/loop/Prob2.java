package loop;

public class Prob2 {
    public static void main(String[] args) {
        for (int i=2; i <= 2*10; i=i+2) {
            System.out.println(i);
        }
        int count = 0;
        int num = 0;
        while (count < 10) {
            count++;
            num += 2;
            System.out.println(num);

        }

    }
}
