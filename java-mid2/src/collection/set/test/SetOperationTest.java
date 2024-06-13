package collection.set.test;

import java.util.*;

public class SetOperationTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(List.of(3,4,5,6,7));

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + Arrays.toString(union.toArray()));

        Set<Integer> diff = new HashSet<>();
        Iterator<Integer> iterator = set1.iterator();

        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (set2.contains(item)) {
                diff.add(item);
            }
        }
        System.out.println("교집합: " + Arrays.toString(diff.toArray()));

        Iterator<Integer> iterator1 = set2.iterator();
        while (iterator1.hasNext()) {
            set1.remove(iterator1.next());
        }
        System.out.println("차집합: " + Arrays.toString(set1.toArray()));
    }
}
