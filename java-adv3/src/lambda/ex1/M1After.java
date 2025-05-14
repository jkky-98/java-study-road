package lambda.ex1;

public class M1After {

    public static void main(String[] args) {
        greet(() -> System.out.println("Good Morning!"));
        greet(() -> System.out.println("Good Afternoon!"));
        greet(() -> System.out.println("Good Evening!"));
    }

    public static void greet(Greeting greeting) {
        System.out.println("=== 시작 ===");
        greeting.sayHello();
        System.out.println("=== 끝 ===");
    }

    interface Greeting {
        void sayHello();
    }
}
