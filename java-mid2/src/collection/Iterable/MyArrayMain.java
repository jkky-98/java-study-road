package collection.Iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1,2,3,4});
        Iterator<Integer> iterator = myArray.iterator();

        while ( iterator.hasNext() ) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        System.out.println("For -each 사용"); // 이터레이터 구현해야 이걸 할 수 있음! for-each문
        for (Integer value : myArray) {
            System.out.println("value = " + value);
        }
    }
}
