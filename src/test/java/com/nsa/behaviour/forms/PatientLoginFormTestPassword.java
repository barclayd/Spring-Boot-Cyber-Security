package com.nsa.behaviour.forms;

import org.junit.Test;

import static org.junit.Assert.*;


public class PatientLoginFormTestPassword {

    //Testing sample patient login details
    PatientLoginForm testPatientLoginForm = new PatientLoginForm("159", "password");

    //Test to see if details match
    @Test
    public void canGetPatient_password() throws Exception {
        assertEquals(testPatientLoginForm.getPatient_password(), "password");
    }

    //Testing validations on password
    @Test
    public void canSetPatient_password() throws Exception {
        testPatientLoginForm.setPatient_password("admin");
        assertEquals(testPatientLoginForm.getPatient_password(), "admin");
    }

}
