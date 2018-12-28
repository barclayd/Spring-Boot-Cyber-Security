package com.nsa.behaviour.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
// Changed the class because JPA was giving stack overflow error due to referencing between feeling_log and activity
// it was creating an infinite loop of references.

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table (name = "activity")
public class Activity {
    @Id
    @Getter
    @Setter
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "activity")
    private List<FeelingLog> feelingLogs;

    // Stack overflow.
    @OneToMany(mappedBy = "activity")
    private List<Scheduled> schedules;

    public Activity(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }
}





