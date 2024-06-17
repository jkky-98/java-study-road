package collection.compare.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> deck = new ArrayList<>();
    private final List<String> shapeList = List.of("spade", "hart", "diamond", "clover");

    public CardDeck() {
        initDeck();
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card pop() {
        return deck.remove(0);
    }

    public void initDeck() {
        for (String shape : shapeList) {
            for (int i = 1; i < 14; i++) {
                deck.add(new Card(i, shape));
            }
        }
    }

    public int size() {
        return deck.size();
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "deck=" + deck +
                ", shapeList=" + shapeList +
                '}';
    }
}
