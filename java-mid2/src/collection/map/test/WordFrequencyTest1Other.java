package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1Other {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] textArray = text.split(" ");

        Map<String, Integer> fluitMap = new HashMap<>();

        for (String fluit : textArray) {
            fluitMap.put(fluit, fluitMap.getOrDefault(fluit, 0) + 1);

        }

        System.out.println(fluitMap);
    }
}
