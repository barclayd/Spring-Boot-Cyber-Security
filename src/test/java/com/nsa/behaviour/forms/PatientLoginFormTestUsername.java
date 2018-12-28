package com.nsa.behaviour.forms;

import org.junit.Test;

import static org.junit.Assert.*;


public class PatientLoginFormTestUsername {

    //Testing sample patient login details
    PatientLoginForm testPatientLoginForm = new PatientLoginForm("159", "password");

    @Test
    public void canGetPatient_username() throws Exception {
        assertEquals(testPatientLoginForm.getPatient_username(), "159");
    }

    //Check of validation on acceptable input for NHS number
    @Test
    public void canSetPatient_username() throws Exception {
        testPatientLoginForm.setPatient_username("123123");
        assertEquals(testPatientLoginForm.getPatient_username(), "123123");
    }

}
