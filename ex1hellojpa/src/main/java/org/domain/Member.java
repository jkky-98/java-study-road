package org.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Locker locker;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


    public static class Builder {
        private Long id;
        private Address address;
        private List<Order> orders = new ArrayList<>();
        private String name;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(Address address) {
            this.address= address;
            return this;
        }

        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Member build() {
            Member member = new Member();
            member.id = this.id;
            member.address = this.address;
            member.orders = this.orders;
            member.name = this.name;
            return member;
        }
    }

    protected Member() {
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
