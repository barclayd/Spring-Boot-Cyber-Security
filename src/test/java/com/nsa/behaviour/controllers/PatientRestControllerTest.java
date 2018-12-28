//package com.nsa.behaviour.controllers;
//
//import com.nsa.behaviour.entities.Activity;
//import com.nsa.behaviour.entities.Gp;
//import com.nsa.behaviour.entities.Patient;
//import com.nsa.behaviour.entities.Scheduled;
//import com.nsa.behaviour.repositories.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by c1645238 on 26/11/2017.
// *
// * Inspired and based on examples available at: https://spring.io/guides/gs/testing-web/
// *
// */
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(PatientRestController.class)
//public class PatientRestControllerTest {
//
//    @Autowired
//    private MockMvc controller;
//
//    @MockBean
//    private PatientRepository patientRepo;
//
//    @MockBean
//    private ActivityRepository activityRepo;
//
//    @MockBean
//    private FeelingRepository feelingRepo;
//
//    @MockBean
//    private ScheduleRepository scheduleRepo;
//
//    @MockBean
//    private ActionLogRepositoryJpa actionLogRepo;
//
//    @MockBean
//    private GpRepository gpRepo;
//
//    @Test
//    public void doesReturnScheduleData() throws Exception {
//        Patient testPatient = patientRepo.findPatientById(1);
//        Activity testActivity = activityRepo.findActivityById(1);
//
//        Scheduled testSchedule = new Scheduled(new Date(28/01/2017),false);
//        testSchedule.setPatient(testPatient);
//        testSchedule.setActivity(testActivity);
//        testSchedule.setId(20000);
//
//        Integer testId = testSchedule.getId();
//
//        when(scheduleRepo.findScheduledById(testId))
//                .thenReturn(testSchedule);
//
//        System.out.println(testId);
//
//        controller.perform(get("/api/schedule/data/" + testId.toString()))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString(
//                        "{\"id\":20000,\"date\":0,\"condition\":false,\"activity\":null}"
//                )));
//    }
//
//    @Test
//    public void doesReturnPatientData() throws Exception {
//        Gp theGp = new Gp("Test Person", "Line 1", "Line 2",
//                "Line 3", "City Line", "the Postcode",
//                "5555","5511","testmail@com.test","Test type",
//                "Testing","password");
//
//        Patient testPatient = new Patient(1111,10,"passtest");
//
//        testPatient.setGp(theGp);
//
//        theGp.setId(20000);
//        Integer testId = theGp.getId();
//
//        ArrayList<Patient> testPatientList = new ArrayList<>();
//        testPatientList.add(testPatient);
//
//        when(gpRepo.findGpById(theGp.getId()))
//                .thenReturn(theGp);
//
//        when(patientRepo.findPatientsByGp(theGp))
//                .thenReturn(testPatientList);
//
//        System.out.println(testPatientList.toString());
//
//        controller.perform(get("/api/"+testId.toString()+"/patients/"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString(
//                        "[{\"id\":null,\"nshNo\":1111,\"depressionLevel\":10,\"password\":\"passtest\"}]"
//                )));
//    }
//
//}