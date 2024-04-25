package class1.ref;

public class DataChange {
    public static void main(String[] args) {
        Data temp1 = new Data();
        Data temp2 = temp1;

        temp1.value = 10;

        System.out.println("temp1값 : " + temp1.value + " temp2값 : " + temp2.value);

        temp1.value = 201;
        System.out.println("temp1값 : " + temp1.value + " temp2값 : " + temp2.value);

        temp2.value = 300;
        System.out.println("temp1값 : " + temp1.value + " temp2값 : " + temp2.value);

    }
}
