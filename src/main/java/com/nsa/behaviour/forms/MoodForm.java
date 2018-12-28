package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by c1662491 on 11/24/2017.
 *
 * Had to take out @Data because it makes getters a setters for all variables
 * but in the Controller if we only ask for a few variables (not all of them in the object)
 * we get the error message
 *
 * "This application has no explicit mapping for /error, so you are seeing this as a fallback.

 Sat Nov 25 17:40:06 GMT 2017
 There was an unexpected error (type=Bad Request, status=400).
 Validation failed for object='moodForm'. Error count: 1

 */


@AllArgsConstructor
@NoArgsConstructor
public class MoodForm {
    private Integer id;
    private String sliderValue;
    private Date dateInputted;
    private String comment;


    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getSliderValue() {
        return sliderValue;
    }

    public void setSliderValue(String sliderValue) {
        this.sliderValue = sliderValue;
    }

    public Date getDateInputted() {
        return dateInputted;
    }

    public void setDateInputted(Date dateInputted) {
        this.dateInputted = dateInputted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

