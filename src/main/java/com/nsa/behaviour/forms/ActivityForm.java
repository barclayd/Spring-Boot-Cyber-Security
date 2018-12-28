package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Created by c1645238 on 21/11/2017.
 * Created to be able to handle post requests.
 * REF (Used): https://projectlombok.org/
 * REF: CM6213 Commercial Applications with Java Slides
 */
// This is created to pull the data from the html
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityForm {
    private Integer id;
    private String name;
    private String dsc;
    private String location;
    private Date schedule_date;

}
