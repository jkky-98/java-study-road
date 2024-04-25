package class1.ref;

public class MeChag2 {
    public static void main(String[] args) {
        Data itemA = new Data();
        itemA.value = 10;
        System.out.println("before : " + itemA.value);
        get20(itemA);
        System.out.println("after : " + itemA.value);

    }
    static void get20(Data d) {
        d.value = 20;
    }
}
