package com.nsa.behaviour.configuration;

/**
 * Created by c1673342 on 09/05/2018.
 */
;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorDetails {

    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    private String message;
    private String details;




    public ErrorDetails(String timestamp, String message, String details) {
        super();
        this.timeStamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getTimeStamp() {
        return "Error occured at " + timeStamp;
    }

    public String getMessage() {
        return "This is the error: " +message;
    }

    public String getDetails() {
        return "The server details are: " +details;
    }

}
