package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonKeyValueSum1Other {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);


        Set<String> keySet1 = map1.keySet();
        Set<String> keySet2 = map2.keySet();

        Map<String, Integer> SumMap = new HashMap<>();

        for (String s : keySet2) {
            boolean contains = keySet1.contains(s);
            if (contains) {
                Integer value1 = map1.get(s);
                Integer value2 = map2.get(s);

                SumMap.put(s, value1 + value2);
            }
        }

        System.out.println("SumMap = " + SumMap);

    }
}
