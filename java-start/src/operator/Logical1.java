package operator;

public class Logical1 {
    public static void main(String[] args) {
        System.out.println(true && true);
        System.out.println(true || true);
        System.out.println(true != false);

        boolean a = true;
        boolean b = false;

        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(a != b);
        System.out.println(!a);
        System.out.println(!b);

        int c = 15;
        boolean result = c > 10 && c < 20;
        System.out.println(result);

    }

}
