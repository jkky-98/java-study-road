package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        ArrayList<Integer> integers = new ArrayList<>();

        while (true) {
            int intValue = scanner.nextInt();
            if (intValue == 0) {
                break;
            } else {
                integers.add(intValue);
            }
        }

        System.out.println("출력");
        System.out.println(Arrays.toString(integers.toArray()));

    }
}
