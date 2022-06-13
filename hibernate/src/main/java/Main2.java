import dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");

        Event event1 = new Event("Our very first event!", LocalDateTime.now());
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(event1);

        Event event2 = new Event("A follow up event", LocalDateTime.now());

        entityManager.persist(event2);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(event1.getId());
        System.out.println(event2.getId());

    }
}
