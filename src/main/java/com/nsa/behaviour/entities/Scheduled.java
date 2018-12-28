package com.nsa.behaviour.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table (name = "scheduled")
public class Scheduled {

    // Changed the class because JPA was giving stack overflow error due to referencing between scheduled and activity
    // it was creating an infinite loop of references.

    @Id
    @Getter
    @Setter
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    // Changed because JPA was giving type Errors.
    @Getter
    @Setter
    @Column(name = "sch_date")
    Date date;

    @Getter
    @Setter
    @Column(name = "event_condition")
    Boolean condition;

    @Setter
    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    Patient patient;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "activity_activity_id")
    Activity activity;

    public Scheduled(Date date, Boolean condition) {
        this.date = date;
        this.condition = condition;
    }
}

