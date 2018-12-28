package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.ActionLog;
import com.nsa.behaviour.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * Created by c1645238 on 27/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 *
 */
public interface ActionLogRepositoryJpa extends JpaRepository<ActionLog, Integer> {
    public List<ActionLog> findActionLogByPatientOrderByChangeDateDesc(Patient inPatient);
}
