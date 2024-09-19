package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 하나의 회원이 여러 상품 주문 // 연관관계 주인 -> Order // mappedBy를 통해 읽기 전용이 되는것.
    private List<Order> orders = new ArrayList<>();

}
