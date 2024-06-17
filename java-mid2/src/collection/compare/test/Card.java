package collection.compare.test;

public class Card implements Comparable<Card>{
    private final int number;
    private final String shape;

    public Card(int number, String shape) {
        this.number = number;
        this.shape = shape;
    }

    public int getNumber() {
        return number;
    }

    public String getShape() {
        return shape;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
