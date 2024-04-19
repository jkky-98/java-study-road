package operator;

public class Operator5 {
    public static void main(String[] args) {
        int a = 0;

        a = a + 1;
        System.out.println(a);
        a = a + 1;
        System.out.println(a);

        ++a;
        System.out.println(a);
        ++a;
        System.out.println(a);
        // a = a + 1 == ++ a

        int b = 1;
        int c = 0;

        // 전위 증감 연산자 사용
        c = ++b; // b의 값을 먼저 증가시키고, 그 결과를 c에 대입
        System.out.println("c = " + c);

        // 후위 증감 연산자 사용
        a = 1;
        b = 0;

        b = a++; // b에 a를 넣고, a를 증가시킨다.
        System.out.println("a = " + a + " b = " + b);

    }
}
