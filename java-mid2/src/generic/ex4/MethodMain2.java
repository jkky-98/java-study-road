package generic.ex4;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 100);

        AnimalMethod.checkup(dog); // type 추론 들어가는중
        AnimalMethod.checkup(cat);

        Dog targetDog = new Dog("큰 멍멍이", 250);
        Dog bigger = AnimalMethod.bigger(dog, targetDog);
        System.out.println("bigger = " + bigger);
    }
}
