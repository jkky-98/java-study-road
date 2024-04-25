package method;

public class MethodValue1 {
    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("호출전 :" + num1);
        changeNumber(num1);
        System.out.println("호출후 :" + num1);
    }
    public static void changeNumber(int num2) {
        System.out.println("변경전 :" + num2);
        num2 = num2 * 2;
        System.out.println("변경후 :" + num2);
    }
}
