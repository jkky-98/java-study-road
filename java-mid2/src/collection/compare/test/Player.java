package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> playerDeck = new ArrayList<>();

    public void setMyDeck(CardDeck deck, int count) {
        for (int i = 0; i < count; i++) {
            playerDeck.add(deck.pop());
        }
    }

    public int scoreMyDeck() {
        int sum = 0;
        for (Card card : playerDeck) {
            sum += card.getNumber();
        }
        return sum;
    }

    public void showMyDeck() {
        playerDeck.sort(new CardComparator());
        System.out.print("[");
        for (Card card : playerDeck) {
            System.out.print(card.getNumber()+"("+card.getShape()+"), ");
        }
        System.out.println("], 합계: "+scoreMyDeck());
        System.out.println(" ");
    }
}
