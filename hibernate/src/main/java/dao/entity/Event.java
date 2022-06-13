package dao.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDateTime;

@Entity
@Table(name = "events", schema = "hibernate")
public class Event {

    private Long id;
    private String title;
    private LocalDateTime dtEvent;

    public Event() {
    }

    public Event(String title, LocalDateTime dtEvent) {
        this.title = title;
        this.dtEvent = dtEvent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(LocalDateTime dtEvent) {
        this.dtEvent = dtEvent;
    }
}
