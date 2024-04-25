package class1.ref;

public class MeChag {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("before : " + a);
        get20(a);
        System.out.println("after : " + a);

    }

    static void get20(int x) {
        x = 20;
    }
}
