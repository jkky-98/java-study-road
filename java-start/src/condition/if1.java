package condition;

public class if1 {
    public static void main(String[] args) {
        int age = 18;

        if (age >= 18) {
            System.out.println("성인입니다.");
        } else if (age < 18) {
            System.out.println("미성년자 입니다.");
        }
    }
}
