package class1.ex;

public class AccountMain {
    public static void main(String[] args) {
        Account ac = new Account(0);
        ac.deposit(1000);
        ac.withdraw(800);
        ac.withdraw(300);
        ac.withdraw(200);
    }
}
