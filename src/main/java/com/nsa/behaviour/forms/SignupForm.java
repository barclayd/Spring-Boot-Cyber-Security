package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by c1673342 on 06/05/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupForm {

        private Integer patient_id;
        private Integer nhs_no;
        private Integer depression_level;
        private Integer gp_id;
        private String password;

    }
