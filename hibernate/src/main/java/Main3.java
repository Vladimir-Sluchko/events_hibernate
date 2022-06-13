import dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");



        EntityManager entityManager = sessionFactory.createEntityManager();
        Event event = entityManager.find(Event.class, 1l);
        event.setTitle("Новый тайтл");
        entityManager.getTransaction().begin();
        entityManager.persist(event);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
