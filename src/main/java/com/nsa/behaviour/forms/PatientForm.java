package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by c1528956 on 12/1/2017.
 * Created to be able to handle post requests.
 * REF (Used): https://projectlombok.org/
 * REF: CM6213 Commercial Applications with Java Slides
 */
// This form is created to pull the relevant data from the html page
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientForm {
    private Integer nhs_number;
    private Integer depression_level;
    private String password;

}

