package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/23/2017.
 */
public class ScheduledTest {

    private Scheduled scheduled;
    private Activity activity;
    private Patient patient;
    private Date date;

    @Before
    public void setUp() throws Exception {
        date = new java.util.Date(21/1/2018);
        patient = new Patient(4, 6, "patient2");
        activity = new Activity("Running", "Go Running in the park for a hour", "Park");
        scheduled = new Scheduled(date, false);
    }

    @Test
    public void getId() throws Exception {
        scheduled.setId(1);
        assertTrue(scheduled.getId() == 1);
    }

    @Test
    public void getDate() throws Exception {
         assertTrue(scheduled.getDate() == date);
    }

    @Test
    public void getCondition() throws Exception {
        assertTrue(scheduled.getCondition() == false);
    }

    @Test
    public void getActivity() throws Exception {
        scheduled.setActivity(activity);
        assertTrue(scheduled.getActivity() == activity);
    }

    @Test
    public void setId() throws Exception {
        scheduled.setId(12);
        assertTrue(scheduled.getId() == 12);
    }

    @Test
    public void setDate() throws Exception {
        java.sql.Date date2 = new java.sql.Date(2018,8,6);
        scheduled.setDate(date2);
        assertTrue(scheduled.getDate() == date2);
    }

    @Test
    public void setCondition() throws Exception {
        scheduled.setCondition(true);
        assertTrue(scheduled.getCondition() == true);
    }

    @Test
    public void setActivity() throws Exception {
        Activity activity101 = new Activity("Dancing", "Go Dancing all night with your friends", "Park");

        scheduled.setActivity(activity101);
        assertTrue(scheduled.getActivity() == activity101);
    }

}