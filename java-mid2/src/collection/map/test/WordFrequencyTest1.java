package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] textArray = text.split(" ");

        Map<String, Integer> fluitMap = new HashMap<>();

        for (String fluit : textArray) {
            if (fluitMap.containsKey(fluit)) {
                fluitMap.replace(fluit, fluitMap.get(fluit) + 1);
            }
            fluitMap.putIfAbsent(fluit, 1);

        }

        System.out.println(fluitMap);
    }
}
