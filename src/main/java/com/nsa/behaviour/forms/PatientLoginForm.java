package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by c1645238 on 08/12/2017.
 * Created to be able to handle post requests.
 * REF (Used): https://projectlombok.org/
 * REF: CM6213 Commercial Applications with Java Slides
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientLoginForm {
    private String patient_username;
    private String patient_password;
}
