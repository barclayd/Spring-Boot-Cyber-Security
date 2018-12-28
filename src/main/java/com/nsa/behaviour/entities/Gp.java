package com.nsa.behaviour.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

import java.util.List;


// Changed the class because JPA was giving stack overflow error due to referencing between patient and gp
// it was creating an infinite loop of references.
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "gp")
@NoArgsConstructor
public class Gp {
    @Id
    @Getter
    @Setter
    @Column(name = "gp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Getter
    @Setter
    @Column(name = "name")
    String name;

    @Getter
    @Setter
    @Column(name = "address_line_1")
    String addressLine1;

    @Getter
    @Setter
    @Column(name = "address_line_2")
    String addressLine2;

    @Getter
    @Setter
    @Column(name = "address_line_3")
    String addressLine3;

    @Getter
    @Setter
    @Column(name = "city")
    String city;

    @Getter
    @Setter
    @Column(name = "postcode")
    String postcode;

    @Getter
    @Setter
    @Column(name = "telephone")
    String telephone;

    @Getter
    @Setter
    @Column(name = "fax")
    String fax;

    @Getter
    @Setter
    @Column(name = "email")
    String email;

    @Getter
    @Setter
    @Column(name = "practise_type")
    String practiseType;

    @Getter
    @Setter
    @Column(name = "special_interest")
    String specialInterest;

    @Getter
    @Setter
    @Column(name = "password")
    String password;

    @JsonIgnore
    @OneToMany(mappedBy = "gp")
    List<Patient> patients;


    public Gp(String name, String addressLine1, String addressLine2, String addressLine3, String city, String postcode, String telephone, String fax, String email, String practiseType, String specialInterest, String password) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.postcode = postcode;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.practiseType = practiseType;
        this.specialInterest = specialInterest;
        this.password = password;
    }
}


