package collection.set;

import java.util.Arrays;

public class HashStart4 {

    static final int CAPACITY = 10;

    static int hashIndex(int value) {
       return value % CAPACITY;
    }
    public static void main(String[] args) {
        System.out.println("hashIndex() = " + hashIndex(1));
        System.out.println("hashIndex() = " + hashIndex(2));
        System.out.println("hashIndex() = " + hashIndex(5));
        System.out.println("hashIndex() = " + hashIndex(8));
        System.out.println("hashIndex() = " + hashIndex(14));
        System.out.println("hashIndex() = " + hashIndex(99));

        Integer[] inputArray = new Integer[CAPACITY];
        add(inputArray ,1);
        add(inputArray ,2);
        add(inputArray ,5);
        add(inputArray ,8);
        add(inputArray ,14);
        add(inputArray ,99);
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 14;
        int hashIndex = hashIndex(searchValue);
        Integer result = inputArray[hashIndex];
        System.out.println(result);

    }

    private static void add(Integer[] inputArray, int value) {
        int hashIndex = hashIndex(value);
        inputArray[hashIndex] = value;
    }
}
