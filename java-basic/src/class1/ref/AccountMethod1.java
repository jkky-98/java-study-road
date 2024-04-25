package class1.ref;

public class AccountMethod1 {
    public static void main(String[] args) {
        Account ac1 = createAccount("Poul", 800000, 84);

        Account ac2 = createAccount( "Kael", 490000, 119);

        Account[] acs = {ac1, ac2};

        for (Account ac : acs) {
            printAccount(ac);
        }
    }
    static Account createAccount(String name, int money, int stock) {
        Account ac = new Account();
        ac.name = name;
        ac.money = money;
        ac.stock = stock;
        return ac;
    }

    static void initAccount (Account ac, String name, int money, int stock) {
        ac.name = name;
        ac.money = money;
        ac.stock = stock;

    }
    static void printAccount(Account ac) {
        System.out.println("이름 : " + ac.name + " 현금 : " + ac.money + " 주식 수 : "+ac.stock);
    }
}

