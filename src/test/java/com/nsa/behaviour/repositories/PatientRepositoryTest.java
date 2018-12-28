//package com.nsa.behaviour.repositories;
//
//import com.nsa.behaviour.entities.Gp;
//import com.nsa.behaviour.entities.Patient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
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
//public class PatientRepositoryTest {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private GpRepository gpRepo;
//
//    @Autowired
//    private PatientRepository patientRepo;
//
//    @Test
//    public void canFindPatientById() throws Exception {
//        Gp testGp = gpRepo.findGpById(1);
//        Patient testPatient = new Patient(90001,1,"testpass");
//
//        testPatient.setGp(testGp);
//        entityManager.persist(testPatient);
//
//        Integer testPatientId = testPatient.getId();
//        System.out.println(testPatientId);
//
//        Patient testPatientReturned = patientRepo.findPatientById(testPatientId);
//        assertEquals(testPatient,testPatientReturned);
//
//    }
//
//    @Test
//    public void canFindPatientByGp() throws Exception {
//        Gp testGp = gpRepo.findGpById(1);
//        Patient testPatient = new Patient(90001,1,"testpass");
//
//        testPatient.setGp(testGp);
//        entityManager.persist(testPatient);
//
//        Integer testPatientId = testPatient.getId();
//        System.out.println(testPatientId);
//
//        List<Patient> testPatientReturned = patientRepo.findPatientsByGp(testGp);
//        assertEquals(testPatient,testPatientReturned.get(1));
//
//    }
//}