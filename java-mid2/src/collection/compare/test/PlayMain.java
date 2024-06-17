package collection.compare.test;

public class PlayMain {

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        CardDeck deck = new CardDeck();
        player1.setMyDeck(deck, 5);
        player2.setMyDeck(deck, 5);

        player1.showMyDeck();
        player2.showMyDeck();

        showBu(player1, player2);

    }

    private static void showBu(Player player1, Player player2) {
        if (player1.scoreMyDeck() > player2.scoreMyDeck()) {
            System.out.println("player1 승리");
        } else if(player1.scoreMyDeck() == player2.scoreMyDeck()) {
            System.out.println("무승부요!");
        } else {
            System.out.println("player2 승리");
        }
    }
}
