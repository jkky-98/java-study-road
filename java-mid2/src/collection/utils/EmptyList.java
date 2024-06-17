package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmptyList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        List<Integer> list3 = Collections.emptyList();
        List<Integer> list4 = List.of();

        System.out.println("list3 = " + list3.getClass());
        System.out.println("list4 = " + list4.getClass());
    }
}
