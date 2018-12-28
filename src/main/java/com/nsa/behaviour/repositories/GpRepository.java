package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.Gp;
import com.nsa.behaviour.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by c1645238 on 26/11/2017.
 */
public interface GpRepository extends JpaRepository<Gp, Integer> {
    public Gp findGpById(Integer inId);
    public Gp findGpByEmail(String inEmail);
}
