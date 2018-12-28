package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.Patient;
import com.nsa.behaviour.entities.Scheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 */
public interface ScheduleRepository extends JpaRepository<Scheduled, Integer> {
    public List<Scheduled> findScheduledsById(Integer id);
    public List<Scheduled> findScheduledsByPatient(Patient inPatient);
    public List<Scheduled> findScheduledsByPatientOrderByDateDesc(Patient inPatient);
    public Scheduled findScheduledById(Integer id);
    public void deleteScheduledById(Integer inId);
}
