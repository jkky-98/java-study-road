package condition;

public class condOp2 {
    public static void main(String[] args) {
        int age = 18;
        // 삼항 연산자
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println(status);
    }
}
