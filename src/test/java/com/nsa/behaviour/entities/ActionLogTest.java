package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/23/2017.
 */
public class ActionLogTest {

    private ActionLog actionLog;
    private Patient patient2;

    private Date date;

    @Before
    public void setUp() throws Exception {

        patient2 = new Patient(4,6,"patient2");

        date =  new Date(2017);

        actionLog = new ActionLog("Plus by 10", date);

    }

    @Test
    public void getId() throws Exception {
        actionLog.setId(1);
        assertTrue(actionLog.getId() == 1);
    }

    @Test
    public void getChangeMade() throws Exception {
        assertTrue(actionLog.getChangeMade() == "Plus by 10");
    }

    @Test
    public void getChangeDate() throws Exception {
        assertTrue(actionLog.getChangeDate() == date);
    }


    @Test
    public void setId() throws Exception {
        actionLog.setId(11);
        assertTrue(actionLog.getId() == 11);
    }

    @Test
    public void setChangeMade() throws Exception {
        actionLog.setChangeMade("minus by 5");
        assertTrue(actionLog.getChangeMade() == "minus by 5");
    }

    @Test
    public void setChangeDate() throws Exception {
        java.sql.Date date2 = new java.sql.Date(2018,8,6);
        actionLog.setChangeDate(date2);
        assertTrue(actionLog.getChangeDate() == date2);
    }


}