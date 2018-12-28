package com.nsa.behaviour.entities;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by c1662491 on 11/22/2017.
 */
public class GpTest {
  private Gp gp;
  private List<Patient> patientList;


  @Before
    public void setUp() throws Exception {

      patientList = new ArrayList<Patient>();

      Patient patient2 = new Patient(4, 6, "patient2");
      patientList.add(patient2);

      gp = new Gp("Dr Who", "17 Yellow Lane", "Flat 0U", "Wales", "Cardiff", "CF67 3PA",
              "07765477986", "5000000", "who@dr.com", "Physio",
              "Children", "Password123");                                                                                      //      date = new Date(2017,12,24);
////                                                                         feelingLog1 = new FeelingLog(1, 60L, date, "Fun", patient1, activity1);
////      patientList.add(patient2);      feelingLog1 = new FeelingLog(2, 30L,  date, "trying to get back into it", patient1, activity1);
////         feelingLogList.add(feelingLog1);
////         feelingLogList.add(feelingLog2);
////        activity1 = new Activity(1, "Running", "Go Running in the park for a hour", "Park", feelingLogList, scheduledList);
////
////        scheduled1 = new Scheduled(1, date,  false, patient1, activity1);
////        scheduled1 = new Scheduled(2, date,  false, patient1, activity2);
////        scheduledList.add(scheduled1);
////        scheduledList.add(scheduled2);
////
////        actionLog1 = new ActionLog(1, "Plus by 10", date, patient1);
////        actionLog2 = new ActionLog(2, "minus by 7", date, patient1);
////        actionLogList.add(actionLog1);
////        actionLogList.add(actionLog2);
////
////        gp = new Gp(1, "Dr Who", "17 Yellow Lane", "Flat 0U", "Wales", "Cardiff", "CF67 3PA",
////                "07765477986", "5000000", "who@dr.com", "Physio",
////                "Children", "Password123", patientList);
////
////        patient1 = new Patient(1,9L, 10L, gp, "user123", scheduledList, actionLogList, feelingLogList);
////        patient2 = new Patient( 2, 4L, 6L, gp, "patient2", null, null, null);
////        patientList.add(patient1);
////        patientList.add(patient2);
  }


      @Test
      public void getId () throws Exception {
          gp.setId(1);
          assertTrue(gp.getId() == 1);
      }


    @Test
    public void getName() throws Exception{
        assertTrue(gp.getName() == "Dr Who");
    }


    @Test
    public void getAddressLine1() throws Exception {
       assertTrue(gp.getAddressLine1() == "17 Yellow Lane");
    }

    @Test
    public void getAddressLine2() throws Exception {
         assertTrue(gp.getAddressLine2() == "Flat 0U");
    }

    @Test
    public void getAddressLine3() throws Exception {
        assertTrue(gp.getAddressLine3() == "Wales");
    }

    @Test
    public void getCity() throws Exception {
        assertTrue(gp.getCity() == "Cardiff");
    }

    @Test
    public void getPostcode() throws Exception {
        assertTrue(gp.getPostcode() == "CF67 3PA");
    }

    @Test
    public void getTelephone() throws Exception {
        assertTrue(gp.getTelephone() == "07765477986");
    }

    @Test
    public void getFax() throws Exception {
        assertTrue(gp.getFax() == "5000000");
    }

    @Test
    public void getEmail() throws Exception {
        assertTrue(gp.email == "who@dr.com");
    }

    @Test
    public void getPractiseType() throws Exception {
        assertTrue(gp.practiseType == "Physio");
    }

    @Test
    public void getSpecialInterest() throws Exception {
        assertTrue(gp.getSpecialInterest() == "Children");
    }

    @Test
    public void getPassword() throws Exception {
        assertTrue(gp.getPassword() == "Password123");
    }

    @Test
    public void setId() throws Exception {
      gp.setId(3);
      assertTrue(gp.getId() == 3);
    }

    @Test
    public void setName() throws Exception {
      gp.setName("Bob");
      assertTrue(gp.getName() == "Bob");
    }

    @Test
    public void setAddressLine1() throws Exception {
      gp.setAddressLine1("newString");
      assertTrue(gp.getAddressLine1() == "newString");
    }

    @Test
    public void setAddressLine2() throws Exception {
        gp.setAddressLine2("newString");
        assertTrue(gp.getAddressLine2() == "newString");
    }

    @Test
    public void setAddressLine3() throws Exception {
        gp.setAddressLine3("newString");
        assertTrue(gp.getAddressLine3() == "newString");
    }

    @Test
    public void setCity() throws Exception {
        gp.setCity("newString");
        assertTrue(gp.city == "newString");
    }

    @Test
    public void setPostcode() throws Exception {
        gp.setPostcode("newString");
        assertTrue(gp.postcode == "newString");
    }

    @Test
    public void setTelephone() throws Exception {
      gp.setTelephone("newString");
      assertTrue(gp.getTelephone() == "newString");
    }

    @Test
    public void setFax() throws Exception {
      gp.setFax("newString");
      assertTrue(gp.getFax() == "newString");

    }

    @Test
    public void setEmail() throws Exception {
      gp.setEmail("newString");
      assertTrue(gp.getEmail() == "newString");
    }

    @Test
    public void setPractiseType() throws Exception {
        gp.setPractiseType("newString");
        assertTrue(gp.getPractiseType() == "newString");
    }

    @Test
    public void setSpecialInterest() throws Exception {
        gp.setSpecialInterest("newString");
        assertTrue(gp.getSpecialInterest() == "newString");
    }
    @Test
    public void setPassword() throws Exception {
        gp.setPassword("newString");
        assertTrue(gp.getPassword() == "newString");
    }

}