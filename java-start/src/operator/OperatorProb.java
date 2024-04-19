package operator;

public class OperatorProb {
    public static void main(String[] args) {
        // prob.1
        int num1, num2, num3;
        num1 = 10;
        num2 = 20;
        num3 = 30;
        int sum = num1 + num2 + num3;
        int avg = sum / 3;
        System.out.println(avg);
        System.out.println(sum);

        // prob.2
        double val1 = 1.5;
        double val2 = 2.5;
        double val3 = 3.5;

        double sum_d = val1 + val2 + val3;
        double avg_d = sum_d / 3;

        System.out.println(sum_d);
        System.out.println(avg_d);

        // prob.3
        int score = 80;
        boolean score_a = 80 <= score && 100 >= score;
        System.out.println(score_a);
    }

}
