package lambda.ex1;

import lambda.Procedure;

public class M3MeasureTime {

    public static void main(String[] args) {
        measure(() -> {
            int sum = 0;
            for (int i = 1; i < 101; i++) {
                sum += i;
            }
            System.out.println("[1부터 100까지 합] 결과 : " + sum);
        });

        measure(() -> {
            
        });
    }

    public static void measure(Procedure p) {
        long startTime = System.currentTimeMillis();

        p.run();

        System.out.println("경과 시간 : " + (startTime - System.currentTimeMillis()));
    }
}
