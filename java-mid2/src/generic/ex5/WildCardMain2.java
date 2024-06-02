package generic.ex5;

import generic.animal.Cat;
import generic.animal.Dog;

public class WildCardMain2 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
    }
}
