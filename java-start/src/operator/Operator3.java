package operator;
// 연산자 우선순위
public class Operator3 {
    public static void main(String[] args) {
        int sum1 = 1 + 2 * 3; // 읽을 때 인간이 우선순위 계산 필요함.
        System.out.println(sum1);

        int sum1Good = 1 + (2 * 3); // 읽을 때 생각 필요 없음
        System.out.println(sum1Good);

        int sum2 = (1 + 2) * 3;
        System.out.println(sum2);

        // 연산자 우선순위가 자동적으로 정해지더라도 괄호를 명시적으로 잘 사용해주자.
        // 코드 가독성이 올라가기 때문!
    }
}
/*
    1. 상식선에서 우선순위를 사용하자.
    2. 애매하면 괄호를 사용하자.
 */