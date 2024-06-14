package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product item, Integer count) {
        cartMap.put(item, count);
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        Set<Map.Entry<Product, Integer>> entries = cartMap.entrySet();

        for (Map.Entry<Product, Integer> entry : entries) {
            Product item = entry.getKey();
            Integer count = entry.getValue();

            System.out.println("상품: " + item.toString() + " 수량: " + count);
        }
    }

    public void minus(Product item, Integer count) {
        Integer countCurrent = cartMap.get(item);
        if ((countCurrent - count) >= 0) {
            Integer countNew = (countCurrent - count);
        } else {
            Integer countNew = 0;
        }

    }
}
