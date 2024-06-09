package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {
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

        int total = 0;
        double avg;

        Object[] integersToArray = integers.toArray();
        for (Object object : integersToArray) {
            total += (int) object;
        }

        avg = (double) total / integers.size();
        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + avg);
    }
}
