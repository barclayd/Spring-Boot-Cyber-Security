package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.Gp;
import com.nsa.behaviour.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public List<Patient> findAll();
    public Patient findPatientById(Integer id);
    public List<Patient> findPatientsByGp(Gp inGp);
    public Patient findPatientByNshNo(Integer inId);
}
