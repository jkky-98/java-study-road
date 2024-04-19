package condition;

public class if4 {
    public static void main(String[] args) {
        int age = 9;
        int itemPrice = 130000;
        int pay = itemPrice;

        if (age <= 10) {
            pay -= 1000;
        }
        if (itemPrice > 10000) {
            pay -= 1000;
        }
        System.out.println(pay);
    }
}
