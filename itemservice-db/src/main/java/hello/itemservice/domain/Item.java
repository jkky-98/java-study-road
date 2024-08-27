package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item") // 객체명과 같이 쓴다면 생략가능
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;
    @Column(name = "price") // 필드명이랑 같을 경우 생략가능
    private Integer price;
    @Column(name = "quantity")
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
