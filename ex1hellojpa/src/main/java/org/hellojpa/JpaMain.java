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

            Movie movie = new Movie();
            movie.setName("IronMan3");
            movie.setPrice(15000);
            movie.setStockQuantity(10);
            movie.setActor("Robert");
            movie.setDirector("봉준호");

            em.persist(movie);

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
