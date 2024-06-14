package collection.map.test.cart;

import java.util.Objects;

public class Product {
    private String fluit;
    private int price;

    public Product(String fluit, int price) {
        this.fluit = fluit;
        this.price = price;
    }

    public String getFluit() {
        return fluit;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "fluit='" + fluit + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(fluit, product.fluit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fluit, price);
    }
}
