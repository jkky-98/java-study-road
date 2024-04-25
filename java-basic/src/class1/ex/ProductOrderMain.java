package class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder po1 = new ProductOrder();
        ProductOrder po2 = new ProductOrder();
        ProductOrder po3 = new ProductOrder();

        po1.productName = "아잔틱";
        po1.price = 500000;
        po1.quantity = 2;

        po2.productName = "릴리화이트";
        po2.price = 27000;
        po2.quantity = 1;

        po3.productName = "카푸치노";
        po3.price = 50000;
        po3.quantity = 2;

        ProductOrder[] pos = {po1, po2, po3};

        int sum = 0;

        for (int i=0; i < pos.length; i++) {
            System.out.println("상품명: " + pos[i].productName + ", 가격: " + pos[i].price + ", 수량: "+pos[i].quantity);
            sum += (pos[i].price * pos[i].quantity);
        }
        System.out.println("총 결제 금액: " + sum);
    }
}
