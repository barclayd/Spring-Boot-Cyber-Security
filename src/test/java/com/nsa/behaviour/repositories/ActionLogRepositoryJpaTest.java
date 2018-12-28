//package com.nsa.behaviour.repositories;
//
//import com.nsa.behaviour.entities.ActionLog;
//import com.nsa.behaviour.entities.Activity;
//import com.nsa.behaviour.entities.Patient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.sql.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by c1645238 on 27/11/2017.
// *
// * To learn about testing used lecture content of CM6213 Commercial Applications with Java's example
// * https://gitlab.cs.cf.ac.uk/scmcj1/BetterBuyBoot/tree/6-testing-repository
// *
// */
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ActionLogRepositoryJpaTest {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ActionLogRepositoryJpa actionRepo;
//
//    @Autowired
//    private PatientRepository patientRepo;
//
//    @Test
//    public void findActionLogByPatientOrderByChangeDateDesc() throws Exception {
//        Patient testPatient = patientRepo.findPatientById(2);
//        ActionLog testAction = new ActionLog("Test", new Date(27/11/2020));
//
//        testAction.setPatient(testPatient);
//
//        this.entityManager.persist(testAction);
//
//        List<ActionLog> testReturns = actionRepo.findActionLogByPatientOrderByChangeDateDesc(testPatient);
//
//        assertEquals(testAction, testReturns.get(1));
//
//    }
//
//}