package com.nsa.behaviour.controllers;

import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import com.nsa.behaviour.SpringBootApp;
import com.nsa.behaviour.entities.*;
import com.nsa.behaviour.forms.*;
import com.nsa.behaviour.objects.ActionEvent;
import com.nsa.behaviour.objects.CalendarEvent;
import com.nsa.behaviour.repositories.*;
import com.nsa.behaviour.services.BarChartService;
import com.nsa.behaviour.services.LoginAttemptsService;
import com.nsa.behaviour.services.FeelingService;
import com.nsa.behaviour.services.PasswordHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 * http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
 */

@RestController
public class PatientRestController {


    private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);
    Logger ErrorLogger = LoggerFactory.getLogger("ErrorLog");


    String salt = PasswordHashService.getSalt(20);

    Integer attempts =0;

    // Creation of repositories.

    @Autowired
    private ActivityRepository ActivityRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private FeelingRepository feelingRepo;

    @Autowired
    private ActionLogRepositoryJpa actionRepo;

    @Autowired
    private GpRepository gpRepo;

    @Autowired
    private FeelingService feelingService;

    @Autowired
    BarChartService barChartService;

    @Autowired
    private RecaptchaValidator recaptchaValidator;


    @RequestMapping(path = "/activity/create/", method = RequestMethod.POST)
    public Integer createActivity(ActivityForm aForm, HttpServletRequest req, HttpServletResponse res) {
        // Declaring the time form set so if form is sent null it assumes
        // Activity is starting now.
        Date date_set = new Date();

        // Creates activity according to the data came from the request.

        Activity tempActivity = new Activity(aForm.getName(), aForm.getDsc(),
                aForm.getLocation());

        // As id is generated in the db we commit it to the db and create a
        // new activity with details within the db.
        ActivityRepo.saveAndFlush(tempActivity);
        System.out.println(tempActivity.getId());
        Activity currentActivity = ActivityRepo.findActivityById(tempActivity.getId());

        // This piece needs to be updated as there is no current patients
        // it assumes that patient 1 is doing the whole changes.
        // Gets the session variable to add to the related patient.
        String theID = req.getSession().getAttribute("theId").toString();
        Patient currentPatient = patientRepo.findPatientById(Integer.parseInt(theID));


        // If date data is submitted it sets the new date data to that.
        if (aForm.getSchedule_date() != null) {
            date_set = aForm.getSchedule_date();

        }

        // Schedule entity created and then saved to the db.
        Scheduled theSchedule = new Scheduled(date_set,
                false);

        theSchedule.setActivity(currentActivity);

        theSchedule.setPatient(currentPatient);

        scheduleRepo.saveAndFlush(theSchedule);

//           Scheduled activity's id is returned to the user.
        return theSchedule.getId();
//          return 10;


    }

//    @RequestMapping(path = "/signup/create/", method = RequestMethod.POST)
//    public Integer createSignup(SignupForm aForm, HttpServletRequest req, HttpServletResponse res) {
//
//
//        // Creates new patient according to the data came from the request.
//
//        Patient tempPatient = new Patient(aForm.getPatient_id(), aForm.getNhs_no(), aForm.getDepression_level(), aForm.getPassword());
//
//        // As id is generated in the db we commit it to the db and create a
//        // new activity with details within the db.
//        patientRepo.saveAndFlush(tempPatient);
//        System.out.println(tempPatient.getId());
//
////           Scheduled activity's id is returned to the user.
//        return 10;
////          return 10;
//
//
//    }


    // Path used to get Scheduled activities related to an ID.
    @RequestMapping(path = "api/{id}/ScheduledActivities")
    public ArrayList<CalendarEvent> listOfScheduledForId(@PathVariable Optional<String> id,HttpServletRequest req) {

        // Creates the required variables.
        List<Scheduled> usersActivityList;
        ArrayList<CalendarEvent> calendarEvents;

        calendarEvents = new ArrayList<>();

        // Gets the session variable to show only related data.
        String theID = req.getSession().getAttribute("theId").toString();


        // finds the list of scheduled activities for specific client ordered by date.
        usersActivityList = scheduleRepo.findScheduledsByPatientOrderByDateDesc(
                patientRepo.findPatientById(Integer.parseInt(theID)));

        // to combine content of two objects, uses a new class that is created.
        for (Scheduled singleSchedule : usersActivityList) {

            // to get activity details gets all the creates activity object that is related to
            // specific schedule.
            Activity tempActivity = singleSchedule.getActivity();

            // using schedule and activity creates a new object and puts that into a list.

            // Used example created by Ortomala Lokni:
            // https://stackoverflow.com/questions/9474121/i-want-to-get-year-month-day-etc-from-java-date-to-compare-with-gregorian-cal
            // To get the day.


            // Creates a current time variable so activities set to current month is get.
            LocalDate localDate = singleSchedule.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Date currentDateTime = new Date();
            LocalDate currentDate = currentDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // End of date reference

            // Checks if the activities scheduled to current month.
            if (currentDate.getMonth() == localDate.getMonth()) {

                // Makes sure activity is not done.
                if (singleSchedule.getCondition() == false) {
                    CalendarEvent tempEvent = new CalendarEvent(tempActivity.getName(),
                            tempActivity.getLocation(), singleSchedule.getDate().toString(),
                            localDate.getDayOfMonth(), singleSchedule.getId());

                    calendarEvents.add(tempEvent);
                }
            }

        }

        // Created special list is returned as JSON.
        return calendarEvents;

    }


    // Inspired from the discussion:
    // https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data
    @RequestMapping(path = "/schedule/edit/submit", method = RequestMethod.POST)
    public String updateSchedule(RescheduleForm aForm, HttpServletRequest req, HttpServletResponse res) {

        Scheduled scheduledToEdit = scheduleRepo.findScheduledById(aForm.getSchedule_id());
        scheduledToEdit.setDate(aForm.getSchedule_date());
        scheduleRepo.saveAndFlush(scheduledToEdit);

        return "Scheduled to: " + aForm.getSchedule_date().toString();
    }


    // @Transactional annotation is Based Discussion:
    // https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
    //How it works:
    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html
    @Transactional
    @RequestMapping(path = "/schedule/delete/{id}")
    public String updateSchedule(@PathVariable Optional<String> id) {

        scheduleRepo.deleteScheduledById(Integer.parseInt(id.get()));

        return "Schedule deleted.";
    }


    // Marks activity with specific id as done.
    @RequestMapping(path = "/scheduled/done/{id}")
    public String doneScheduled(@PathVariable Optional<String> id) {

        Scheduled scheduledDone = scheduleRepo.findScheduledById(Integer.parseInt(id.get()));
        scheduledDone.setCondition(true);

        scheduleRepo.saveAndFlush(scheduledDone);
        return "Activity is marked as done.";
    }


    // Returns schedule of a specific person.
    @RequestMapping(path = "/api/schedule/data/{id}")
    public Scheduled scheduleData(@PathVariable Optional<String> id) {
        Scheduled requestedSchedule = scheduleRepo.findScheduledById(Integer.parseInt(id.get()));

        return requestedSchedule;
    }


    @RequestMapping(path = "/mood/create/", method = RequestMethod.POST)
    public String createFeeling(MoodForm form, HttpServletRequest req, HttpServletResponse res) {

        // converting the value in slider (which is  a string) to a Long,
        Long longValue = Long.parseLong(form.getSliderValue());
        // Creating a new feelingLog object to send to the db, populating it with the values in form
        FeelingLog newFeelingLog = new FeelingLog(longValue, form.getDateInputted(), form.getComment());
        // find the patient with id 1 to assign it to the new feelingLog (**this will change when we use sessions**)

        // Gets the session variable to add to the related patient.
        String theID = req.getSession().getAttribute("theId").toString();
        Patient patient2 = patientRepo.findPatientById(Integer.parseInt(theID));

        // find the activity  with id 2 to assign it to the new feelingLog (**this will change when we use sessions**)
        Activity activity2 = ActivityRepo.findActivityById(2);
        // assigning the patient to the new feelingLog
        newFeelingLog.setPatient(patient2);
        // assigning the activity to the new feelingLog
        newFeelingLog.setActivity(activity2);

        // Saving to the database
       feelingRepo.saveAndFlush(newFeelingLog);


        return "All Done\n " +
                "your Mood Changed has been Saved\n" +
                "Thank You";
    }


    // Returns actions of specific user in Desc order of date.
    @RequestMapping(path = "/api/actions/{id}")
    public List<ActionEvent> actionLogList(@PathVariable Optional<String> id) {
        Patient currentPatient = patientRepo.findPatientById(Integer.parseInt(id.get()));

        List<ActionLog> actions = actionRepo.findActionLogByPatientOrderByChangeDateDesc(currentPatient);
        ArrayList<ActionEvent> actionEvents = new ArrayList<>();

        for (ActionLog action : actions) {
            actionEvents.add(new ActionEvent(action.getChangeMade(),action.getChangeDate().toString()));

        }
        return actionEvents;
    }


//    Adapted from Carl Jones' work on BetterBuyBoot branch 8

    @RequestMapping(path = "/newPatient/", method = RequestMethod.POST) //handles POST requests to /newPatient
    public void newPatientForm(PatientForm bForm, HttpServletRequest req, HttpServletResponse res) {
        System.out.println("Product Form sent " + bForm);

        String patientPassword = bForm.getPassword();
        String securedPassword = PasswordHashService.generateSecurePassword(patientPassword, salt);

        System.out.println("Encrypted password: "+ securedPassword);
        System.out.println("Salt value = " + salt);
        // Gets the session variable to show only related data.
        String theID = req.getSession().getAttribute("theId").toString();

        Gp myGP = gpRepo.findGpById(Integer.parseInt(theID));

        Patient newPatient = new Patient(bForm.getNhs_number(), bForm.getDepression_level(), securedPassword);
        newPatient.setGp(myGP);

        System.out.println("Product Entity = " + newPatient);
        patientRepo.saveAndFlush(newPatient);

        try {
            res.sendRedirect("/patient/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // Returns a list of patients related to a specific patient.
    @RequestMapping(path = "/api/{id}/patients/")
    public List<Patient> patientList(@PathVariable Optional<String> id, HttpServletRequest req) {

        // Gets the session variable to show only related data.
        String theID = req.getSession().getAttribute("theId").toString();

        // Uses session variable to pull all the data about required patient.
        Gp currentGp = gpRepo.findGpById(Integer.parseInt(theID));
        List<Patient> currentPatients = patientRepo.findPatientsByGp(currentGp);

        return currentPatients;
    }
    // For the logins
    // Sessions is based on: https://stackoverflow.com/questions/18791645/how-to-use-session-attributes-in-spring-mvc
    // Answer by: Ali.Mojtehedy on Sep 13 '13 at 21:35
    // Path used to login gps.
    @RequestMapping(path = "/gp/login/", method = RequestMethod.POST)
    public void gpLogin(GpLoginForm aForm, HttpServletRequest req, HttpServletResponse res) {
        ValidationResult result = recaptchaValidator.validate(req);
        Gp requiredGp = gpRepo.findGpByEmail(aForm.getGp_username());

        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String ip = request.getRemoteAddr();

        System.out.println(ip);




        LoginAttemptsService.map.put(ip, attempts);

        while (LoginAttemptsService.map.get(ip) < 5) {

            // Checks if password matches for the right user.
            System.out.println(requiredGp.getPassword());
            if ((requiredGp.getPassword().equals(aForm.getGp_password())) && (result.isSuccess())) {


                System.out.println("Successful");
                // Sets the id of the GP as the session variable.
                req.getSession().setAttribute("theId", requiredGp.getId());

                //Reset incorrect login attempts to 0
                System.out.println("Incorrect login attempts reset to 0 after successful login attempt");
                attempts = 0;

                // Redirects to list of patients page.
                try {
                    res.sendRedirect("/patient/list/");
                    log.info("Login was successful with GP ID: {} and password {} at {} from location {}", aForm.getGp_username(), aForm.getGp_password(), sdf.format(date), ip);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // If fails redirects to login.
            } else {
//            map.put(ip, map.get(ip) + 1);
//            System.out.println(map.get(ip));

                System.out.println("Previous number of incorrect login attempts");
                System.out.println(LoginAttemptsService.map.put(ip, attempts));
                System.out.println("New number of incorrect login attempts");
                attempts += 1;
                LoginAttemptsService.map.put(ip, (LoginAttemptsService.map.get(ip)+1));
                System.out.println(LoginAttemptsService.map.get(ip));
                System.out.println(LoginAttemptsService.map.keySet());
                ErrorLogger.error("Failed login attempt with GP ID: {} and password: {} at {} from location {}", aForm.getGp_username(), aForm.getGp_password(), sdf.format(date), ip);
                throw new java.lang.RuntimeException("Bad login");


//            try {
//                //res.sendRedirect("/login");
//            } catch (IOException e) {
//                e.printStackTrace();
//                ErrorLogger.error("Failed login attempt with GP ID: {} and password: {} at {} from location {}", aForm.getGp_username(), aForm.getGp_password(), sdf.format(date), ip);
//            }


            }

        }

        //Debugging tool - identify number of logins attempted per user
        throw new java.lang.RuntimeException("IP address blocked. Maximum number of login attempts exceeded");

        }

    // Path used to login patients.
    @RequestMapping(path = "/patient/login/", method = RequestMethod.POST)
    public void patientLogin(PatientLoginForm aForm, HttpServletRequest req, HttpServletResponse res) {
        Patient requiredPatient = patientRepo.findPatientByNshNo(Integer.parseInt(aForm.getPatient_username()));

        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String ip = request.getRemoteAddr();

  /*      //Check valid encryption of password
        String providedPassword = requiredPatient.getPassword();
        //Check against database stored password
        String securePassword =aForm.getPatient_password();
        System.out.println(securePassword);
        //Manually test Salt Value used
        String currentSalt = "HDcxPp4VvbDXWO0Gl0O0";
        //Check if passwords match
        boolean passwordMatch = PasswordHashService.verifyUserPassword(providedPassword, securePassword, currentSalt);
        if(passwordMatch) {
            System.out.println("The following password has been successfully verified: " + providedPassword);
        }else{
            System.out.println("Provided password is incorrect");
        }

*/

        // Checks if the username and password inputted matches.
        System.out.println(requiredPatient.getPassword());
        if (requiredPatient.getPassword().equals(aForm.getPatient_password())) {

            // Sets the id of the patient as the session variable.
            req.getSession().setAttribute("theId",requiredPatient.getId());



            // Redirects user to the scheduled page.
            try {
                log.info("Login was successful with Patient NHS Number: {} and password {} at {} from location {}", aForm.getPatient_username(), aForm.getPatient_password(), sdf.format(date), ip);
                res.sendRedirect("/scheduled/");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // If fails redirects to login.
        } else {
            ErrorLogger.error("Failed login attempt with Patient NHS Number: {} and password: {} at {} from location {}", aForm.getPatient_username(), aForm.getPatient_password(), sdf.format(date), ip);
            try {
                res.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    // Path used to logout.
    @RequestMapping(path = "/logout")
    public void logout(HttpServletRequest req, HttpServletResponse res) {

        // Cleans the session.
        // Based on: https://stackoverflow.com/questions/10036187/java-servlet-session-cleanup-httpservletrequest
        req.getSession().invalidate();


        // Redirects to the login page.
        try {
            res.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/api/logged/moodTime/patient/{id}")
    public HashMap getTimeForCharts(@PathVariable String id) {

        int number = Integer.parseInt(id);

//      //  Gets the session variable to show only related data.
//                String theID = req.getSession().getAttribute("theId").toString();

        Patient patient = patientRepo.findPatientById(number);
        List<FeelingLog> feelingLogList  = feelingService.getLogsFor(patient);

        HashMap result = feelingService.ConvertTimesForCharts(feelingLogList);
        return result;
    }

    @RequestMapping(path = "/api/feelingLogs/patient/{id}")
    public List<FeelingLog> getPatientFeelingLogs(@PathVariable String id) {

        int number = Integer.parseInt(id);
        Patient patient = patientRepo.findOne(number);



        return feelingService.getLogsFor(patient);
    }


    @RequestMapping(path = "/api/GET/barchart/data/{id}")
    public BarChart barChartTest(@PathVariable String id){
       Integer numId = Integer.parseInt(id);
     BarChart result = barChartService.getBarChartInfo(numId);
       return result;
    }

//    @RequestMapping("/log")
//      public String longtest(@RequestParam("ProductID") Integer ProductID){
//
//        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
////        log.error("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
////        log.warn("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
////        log.info("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
////        log.debug("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
//
//        if (ProductID ==1 || ProductID == 2){
//            log.error("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
//
//            ErrorLogger.error("Non-existing product with ID {} was accessed.", ProductID);
//            throw new RuntimeException("Exception occured");
//        }else{
//            log.info("Product with ID {} was viewed on {}", ProductID, sdf.format(date));
//            return "Product " + ProductID;
//        }
//
//    }

}

