package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/23/2017.
 */
public class PatientTest {
    private Patient patient;
    private Scheduled scheduled;
    private ActionLog actionLog;
    private FeelingLog feelingLog;
    private ArrayList<Scheduled> scheduleds;
    private ArrayList<ActionLog> actionLogs;
    private ArrayList<FeelingLog> feelingLogs;

    @Before
    public void setUp() throws Exception {
        scheduled = new Scheduled(new Date(21/1/2018), false);
        scheduleds = new ArrayList<>();
        scheduleds.add(scheduled);

        actionLog = new ActionLog("Plus by 10",new Date(21/1/2018));
        actionLogs = new ArrayList<>();
        actionLogs.add(actionLog);

        feelingLog = new FeelingLog(30L,  new Date(21/01/2018), "trying to get back into it");
        feelingLogs = new ArrayList<>();
        feelingLogs.add(feelingLog);

        patient= new Patient(2, 6, "patient2");

    }

    @Test
    public void getId() throws Exception {
        patient.setId(2);
        assertTrue(patient.getId() == 2);
    }

    @Test
    public void getNshNo() throws Exception {
        assertTrue(patient.getNshNo() == 2);
    }

    @Test
    public void getDepressionLevel() throws Exception {
        assertTrue(patient.getDepressionLevel() == 6);
    }

    @Test
    public void getPassword() throws Exception {
        assertTrue(patient.getPassword() == "patient2");
    }

    @Test
    public void setId() throws Exception {
        patient.setId(300);
        assertTrue(patient.getId() == 300);
    }

    @Test
    public void setNshNo() throws Exception {
        patient.setNshNo(11);
        assertTrue(patient.getNshNo() == 11);
    }

    @Test
    public void setDepressionLevel() throws Exception {
        patient.setDepressionLevel(3);
        assertTrue(patient.getDepressionLevel() == 3);
    }

    @Test
    public void setPassword() throws Exception {
        patient.setPassword("test");
        assertTrue(patient.getPassword() == "test");
    }

}