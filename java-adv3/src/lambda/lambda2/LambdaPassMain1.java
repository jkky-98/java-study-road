package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain1 {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("add.apply(a,b) = " + add.apply(1, 2));
        System.out.println("sub.apply(a,b) = " + sub.apply(1, 2));

        MyFunction cal = add;
        System.out.println("cal(add).apply(a,b) = " + cal.apply(1, 2));

        cal = sub;
        System.out.println("cal(sub).apply(a,b) = " + cal.apply(1, 2));
    }
}
