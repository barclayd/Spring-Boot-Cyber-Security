package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/23/2017.
 */
public class ActivityTest {

    private Activity activity;
    Scheduled scheduled;
    FeelingLog feelingLog;
    ArrayList<Scheduled> scheduleds;
    ArrayList<FeelingLog> feelingLogs;

    @Before
    public void setUp() throws Exception {
        scheduled = new Scheduled(new Date(21/1/2018), false);
        scheduleds = new ArrayList<>();
        scheduleds.add(scheduled);

        feelingLog = new FeelingLog(30L, new Date(21/1/2018), "trying to get back into it");
        feelingLogs = new ArrayList<>();
        feelingLogs.add(feelingLog);

        activity = new Activity("Running", "Go Running in the park for a hour", "Park");
    }

    @Test
    public void getId() throws Exception {
        activity.setId(1);
        assertTrue(activity.getId() == 1);
    }

    @Test
    public void getName() throws Exception {
        assertTrue(activity.getName() == "Running");
    }

    @Test
    public void getDescription() throws Exception {
        assertTrue(activity.getDescription() == "Go Running in the park for a hour");
    }

    @Test
    public void getLocation() throws Exception {
        assertTrue(activity.getLocation() == "Park");
    }


    @Test
    public void setId() throws Exception {
        activity.setId(11);
        assertTrue(activity.getId() == 11);
    }

    @Test
    public void setName() throws Exception {
        activity.setName("Test");
        assertTrue(activity.getName() == "Test");
    }

    @Test
    public void setDescription() throws Exception {
        activity.setDescription("TestDes");
        assertTrue(activity.getDescription() == "TestDes");
    }

    @Test
    public void setLocation() throws Exception {
        activity.setLocation("TestLoc");
        assertTrue(activity.getLocation() == "TestLoc");
    }

}