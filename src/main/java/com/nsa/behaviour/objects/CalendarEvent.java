package com.nsa.behaviour.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by c1645238 on 23/11/2017.
 *
 * Used: https://projectlombok.org/
 */
@Data
@AllArgsConstructor
public class CalendarEvent {
    private String name;
    private String location;
    private String scheduleDate;
    private Integer scheduleDay;
    private Integer scheduleId;
}