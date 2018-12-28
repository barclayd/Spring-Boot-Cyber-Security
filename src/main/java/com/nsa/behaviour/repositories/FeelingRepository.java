package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.FeelingLog;
import com.nsa.behaviour.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 */
public interface FeelingRepository extends JpaRepository<FeelingLog, Integer> {
    public List<FeelingLog> findFeelingLogsById(Integer id);
    public List<FeelingLog> findAll();
    public List<FeelingLog> findAllByPatient(Patient patient);
    public FeelingLog findFeelingLogById(Integer id);
    
}
