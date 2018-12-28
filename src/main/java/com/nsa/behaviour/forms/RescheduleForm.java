package com.nsa.behaviour.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by c1645238 on 24/11/2017.
 * Created to be able to handle post requests.
 * REF (Used): https://projectlombok.org/
 * REF: CM6213 Commercial Applications with Java Slides
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RescheduleForm {
    private Integer schedule_id;
    private Date schedule_date;
}
