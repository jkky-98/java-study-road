package loop;

public class Prob3 {
    public static void main(String[] args) {
        int max = 3;
        int count = 0;
        int sum = 0;
        while (count <= max) {
            sum += count;
            count++;
        }
        System.out.println(sum);

        sum = 0;
        for (int i = 1; i <= max; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
