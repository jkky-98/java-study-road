package scope;

public class Casting4 {
    public static void main(String[] args) {
        double div2 = 3 / 2;
        System.out.println(div2);

        double div3 = 3.0 / 2;
        System.out.println(div3);

        double div4 = (double) 3 / 2;
        System.out.println(div4);

        int a = 3;
        int b = 2;
        double div5 = (double) a / b;
        System.out.println(div5);
    }
    // 같은 타입끼리의 계산은 같은 타입의 결과를 낸다.
    // 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.
}
