package collection.set.test;

import java.util.HashSet;
import java.util.Set;

public class RectangleTest {
    public static void main(String[] args) {
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(new Rectangle(10, 10));
        rectangleSet.add(new Rectangle(20, 20));
        rectangleSet.add(new Rectangle(20, 20));

        for (Rectangle rectangle : rectangleSet) {
            System.out.println("rectangle = " + rectangle);
        }
    }
}

// 최악의 경우 데이터가 몰릴 수 있다 ( O(1) -> O(n) )
// 데이터가 몰릴 경우 일정 수치를 넘길경우 자료구조를 트리구조로 바꾸어버린다.