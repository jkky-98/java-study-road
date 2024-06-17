package collection.compare.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardComparator implements Comparator<Card> {
    Map<String, Integer> shapeRank = Map.of("spade", 1,  "hart", 2,  "diamond", 3,  "clover" ,4 );


    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getNumber() != o1.getNumber()) {
            return Integer.compare(o1.getNumber(), o2.getNumber());
        } else {
            return Integer.compare(shapeRank.get(o1.getShape()), shapeRank.get(o2.getShape()));
        }
    }
}
