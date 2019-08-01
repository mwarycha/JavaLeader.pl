package controllers;

import model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Start {

    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userPU");
        em = emf.createEntityManager();
        createAndSaveSampleUsers(em);
        em.close();
    }

    public static void createAndSaveSampleUsers(EntityManager entityManager) {

        User james = new User("james", "spring");
        User alice = new User("alice", "li");
        User tom   = new User("tom", "guim");

        em.getTransaction().begin();
            entityManager.persist(james);
            entityManager.persist(alice);
            entityManager.persist(tom);
        em.getTransaction().commit();

    }
}
