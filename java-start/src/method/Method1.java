package method;

public class Method1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum = add(a, b);
        System.out.println(sum);
    }

    public static int add(int a, int b) {
        System.out.println(a + "+" + b + " 연산 수행");
        int sum = a + b;
        return sum;
    }
}
