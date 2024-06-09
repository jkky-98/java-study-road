package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayEx1 {
    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};
        ArrayList<Integer> scores = new ArrayList<>();
        for (int student : students) {
            scores.add(student);
        }

        int total = 0;

        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
        }

        double average = (double) total / scores.size();
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
