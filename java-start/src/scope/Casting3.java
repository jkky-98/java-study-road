package scope;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647;
        long maxIntOver = 2147483648L;
        int intValue = 0;

        intValue = (int) maxIntValue;
        System.out.println(intValue);

        intValue = (int) maxIntOver;
        System.out.println(intValue); // int의 범위를 넘어섬.
        // 오버플로우 (int의 첫 시작으로 돌아감 - 원형 큐 느낌?)

    }
}
