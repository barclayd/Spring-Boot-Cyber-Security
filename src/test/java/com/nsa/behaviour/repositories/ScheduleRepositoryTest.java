//package com.nsa.behaviour.repositories;
//
//import com.nsa.behaviour.entities.Activity;
//import com.nsa.behaviour.entities.Patient;
//import com.nsa.behaviour.entities.Scheduled;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// *
// * Created by c1645238 on 26/11/2017.
// *
// * To learn about testing used lecture content of CM6213 Commercial Applications with Java's example
// * https://gitlab.cs.cf.ac.uk/scmcj1/BetterBuyBoot/tree/6-testing-repository
// *
// */
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ScheduleRepositoryTest {
//
//    @Autowired
//    private ScheduleRepository schRepo;
//
//    @Autowired
//    private PatientRepository patientRepo;
//
//    @Autowired
//    private ActivityRepository activityRepo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//
//    @Test
//    public void canFindScheduledById() throws Exception {
//        Patient testPatient = patientRepo.findPatientById(1);
//        Activity testActivity = activityRepo.findActivityById(1);
//
//        Scheduled testSchedule = new Scheduled(new Date(28/01/2017),false);
//        testSchedule.setPatient(testPatient);
//        testSchedule.setActivity(testActivity);
//
//        this.entityManager.persist(testSchedule);
//
//        Integer theID = testSchedule.getId();
//
//        Scheduled testScheduled = schRepo.findScheduledById(theID);
//        assertEquals(testScheduled, testSchedule);
//    }
//
//}