package com.nsa.behaviour.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

// Changed the class because JPA was giving stack overflow error due to referencing between patient and gp
// it was creating an infinite loop of references.
@Entity
@EqualsAndHashCode
@Table (name = "patient")
@NoArgsConstructor
public class Patient {

    @Id
    @Getter
    @Setter
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // nsh changed to nhs.
    @Getter
    @Setter
    @Column(name = "nhs_no")
    Integer nshNo;

    @Getter
    @Setter
    @Column(name = "depression_level")
    Integer depressionLevel;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gp_id")
    Gp gp;

    @Getter
    @Setter
    @Column(name = "password")
    String password;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    List<Scheduled> scheduleds;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    List<ActionLog> actionLogs;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    List<FeelingLog> feelingLogs;

    public Patient(Integer nshNo, Integer depressionLevel, String password) {
        this.nshNo = nshNo;
        this.depressionLevel = depressionLevel;
        this.password = password;
    }
}

