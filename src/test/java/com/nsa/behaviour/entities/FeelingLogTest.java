package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/23/2017.
 */
public class FeelingLogTest {

    private FeelingLog feelingLog;

    private Date date;


    @Before
    public void setUp() throws Exception {
        date =  new Date(2017, 12, 23);
        feelingLog = new FeelingLog(30L,  date, "trying to get back into it");
    }

    @Test
    public void getId() throws Exception {
        feelingLog.setId(2);
        assertTrue(feelingLog.getId() == 2);
    }

    @Test
    public void getFeelingNumber() throws Exception {
        assertTrue(feelingLog.getFeelingNumber() == 30L);
    }

    @Test
    public void getDateInputted() throws Exception {
        assertTrue(feelingLog.getDateInputted() == date);
    }

    @Test
    public void getComment() throws Exception {
        assertTrue(feelingLog.getComment() == "trying to get back into it");
    }

    @Test
    public void setId() throws Exception {
        feelingLog.setId(101);
        assertTrue(feelingLog.getId() == 101);
    }

    @Test
    public void setFeelingNumber() throws Exception {
        feelingLog.setFeelingNumber(11L);
        assertTrue(feelingLog.getFeelingNumber() == 11L);
    }

    @Test
    public void setDateInputted() throws Exception {
        java.sql.Date date2 = new java.sql.Date(2018,8,6);
        feelingLog.setDateInputted(date2);
        assertTrue(feelingLog.getDateInputted() == date2);
    }

    @Test
    public void setComment() throws Exception {
        feelingLog.setComment("Test");
        assertTrue(feelingLog.getComment() == "Test");
    }

}