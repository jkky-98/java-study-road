package loop;

public class Whilebreak1 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (true) {
            if (sum > 10) {
                System.out.println(i);
                System.out.println(sum);
                break;
            }
            i++;
            sum += i;

        }
    }
}
