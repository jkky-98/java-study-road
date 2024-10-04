package org.hellojpa;

import org.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member.Builder()
                    .name("hello")
                    .build();

            em.persist(member);

            Order order = new Order();
            order.setMember(member);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);
            em.persist(order);

            em.flush();
            em.clear();

            Order findOrder = em.find(Order.class, order.getId());

            em.remove(findOrder);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("예외 발생");
        } finally {
            em.close();
        }

        emf.close();
    }
}
