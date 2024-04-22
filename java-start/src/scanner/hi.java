import java.util.*;
import java.util.stream.DoubleStream;

public class hi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        String[] arr_temp = sc.nextLine().split(" ");
        DoubleStream arr_stream = Arrays.stream(arr_temp).mapToDouble(Double::parseDouble);

        double max_item = arr_stream.max().getAsDouble();

        // 스트림을 다시 생성
        arr_stream = Arrays.stream(arr_temp).mapToDouble(Double::parseDouble);
        double[] arr = arr_stream.toArray();

        Arrays.parallelSetAll(arr, i -> (arr[i] / max_item * 100.0));
        double sum = Arrays.stream(arr).sum();
        double avg = sum / (double) n;

        System.out.println(avg);
    }
}
