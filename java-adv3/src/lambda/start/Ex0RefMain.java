package lambda.start;

public class Ex0RefMain {
    public static void helloJava() {
        helloLambda("Java");
    }
    public static void helloSpring() {
        helloLambda("Spring");
    }
    public static void main(String[] args) {
        helloJava();
        helloSpring();
    }

    public static void helloLambda(String message) {
        System.out.println("프로그램 시작");
        System.out.println("Hello " + message);
        System.out.println("프로그램 종료");
    }
}
