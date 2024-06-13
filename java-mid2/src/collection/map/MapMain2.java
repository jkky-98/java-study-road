package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain2 {

    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA" , 90);
        studentMap.put("studentA" , 60);

        System.out.println(studentMap);

        System.out.println(studentMap.containsKey("studentB"));

        studentMap.remove("studentA");

        System.out.println(studentMap);

    }
}
