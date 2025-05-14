package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain3 {

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println("add.apply() = " + add.apply(1,2));

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply() = " + sub.apply(1,2));

        MyFunction mul = getOperation("mul");
        System.out.println("mul.apply() = " + mul.apply(1,2));
    }

    // 람다를 반환하는 메서드
    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (int a, int b) -> a + b;
            case "sub":
                return (int a, int b) -> a - b;
            default:
                return (int a, int b) -> 0;
        }
    }
}
