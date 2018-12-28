//package com.nsa.behaviour.repositories;
//
//import com.nsa.behaviour.entities.Activity;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
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
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ActivityRepositoryTest {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ActivityRepository activityRepo;
//
//
//    @Test
//    public void canFindActivityById() throws Exception {
//        Activity testActivity = new Activity("Testing","Testing for fun", "NSA");
//        this.entityManager.persist(testActivity);
//        Integer activityID = testActivity.getId();
//
//        Activity testReturns = activityRepo.findActivityById(activityID);
//
//        assertEquals(testActivity, testReturns);
//    }
//
//}