package hello.itemservice.domain.item;

import lombok.Data;

@Data // 이건 사실 위험하다. 개터 세터 따로 쓰는 게 낫다.
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
