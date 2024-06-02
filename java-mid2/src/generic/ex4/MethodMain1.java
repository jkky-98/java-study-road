package generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i); // casting needed

        // type argument
        System.out.println("명시적 타입 인자 전달");
        Integer integer = GenericMethod.<Integer>genericMethod(i);
        System.out.println("integer = " + integer);

        Integer integer1 = GenericMethod.<Integer>numberMethod(10);
        System.out.println("integer1 = " + integer1);
        Double v = GenericMethod.<Double>numberMethod(10.1);
        System.out.println("v = " + v);

    }
}
