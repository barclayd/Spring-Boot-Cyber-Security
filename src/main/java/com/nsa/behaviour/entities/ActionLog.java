package com.nsa.behaviour.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table (name = "action_log")
public class ActionLog {

    @Id
    @Getter
    @Setter
    @Column(name = "action_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Getter
    @Setter
    @Column(name = "change_made")
    String changeMade;

    @Getter
    @Setter
    @Column(name = "change_date")
    Date changeDate;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    Patient patient;

    public ActionLog(String changeMade, Date changeDate) {
        this.changeMade = changeMade;
        this.changeDate = changeDate;
    }
}

