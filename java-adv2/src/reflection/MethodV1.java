package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("===== methods() ====");
        Method[] methods = helloClass.getMethods();

        for (Method method : methods) {
            System.out.println("method = " + method); // 퍼블릭만 보여줌
        }

        System.out.println("===== declared methods() ====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod); //
            // 내가 선언한 것들만
        }


    }
}
