package class1.ex;

public class Account {
    int balance;
    String name;

    Account(String name) {
        this(50, name);
    }

    Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    void deposit(int amount) {
        balance += amount;
        status();
    }
    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("출금 불가");
            status();
        } else {
            int money = balance - amount;
            balance -= amount;
            System.out.println("출금 했습니다. : " + money);
            status();
        }
    }
    void status() {
        System.out.println("현재 잔액 : " + balance);
    }
}
