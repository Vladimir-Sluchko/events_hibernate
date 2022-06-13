import dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Event("dsknf",LocalDateTime.now()));
        entityManager.persist( new Event( "Our very first event!", LocalDateTime.now()));
        entityManager.persist( new Event( "A follow up event", LocalDateTime.now()));
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
        for ( Event event : result ) {
            System.out.println( "Event (" + event.getDtEvent() + ") : " + event.getTitle() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
