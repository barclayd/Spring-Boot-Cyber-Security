package com.nsa.behaviour.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Created by c1662491 on 12/12/2017.
 */

//@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarChart {
    private String activityName;
    private int feelingLevelBefore;
    private int feelingLevelAfter;


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getFeelingLevelBefore() {
        return feelingLevelBefore;
    }

    public void setFeelingLevelBefore(int feelingLevelBefore) {
        this.feelingLevelBefore = feelingLevelBefore;
    }

    public int getFeelingLevelAfter() {
        return feelingLevelAfter;
    }

    public void setFeelingLevelAfter(int feelingLevelAfter) {
        this.feelingLevelAfter = feelingLevelAfter;
    }
}

