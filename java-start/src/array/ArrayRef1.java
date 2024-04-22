package array;

public class ArrayRef1 {
    public static void main(String[] args) {
        // 배열을 담을 수 있는 변수를 선언한다.
        int[] students;
        // new : 새로 생성한다는 뜻
        // int[5] int형 변수 5개를 다룰 수 있는 배열을 새로 만들겠다.
        // 배열 생성시 내부 값을 자동으로 0으로 초기화한다.
        // 숫자는 0, boolean은 false, String은 null로
        students = new int[5];

        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);

    }
}
