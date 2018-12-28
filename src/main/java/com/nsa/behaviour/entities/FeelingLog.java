package com.nsa.behaviour.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


// Changed the class because JPA was giving stack overflow error due to referencing between feeling_log and activity
// it was creating an infinite loop of references.

//@JsonIgnore -- tried this didnt work
//@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table (name = "feeling_log")
public class FeelingLog {
    @Id
    @Getter
    @Setter
    @Column(name = "feeling_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Getter
    @Setter
    @Column(name = "feeling_in_num_format")
    Long feelingNumber;

    @Getter
    @Setter
    @Column(name = "date_inputted")
    Date dateInputted;

    @Getter
    @Setter
    @Column(name = "comment")
    String comment;


    @ManyToOne
    @Setter
    @JoinColumn(name = "patient_patient_id")
    Patient patient;

    // Wrong field name.

    @ManyToOne
    @Setter
    @JoinColumn(name = "activity_activity_id")
    Activity activity;


    public FeelingLog(Long feelingNumber, java.util.Date dateInputted, String comment) {
        this.feelingNumber = feelingNumber;
        this.dateInputted = dateInputted;
        this.comment = comment;
    }
}

