package com.nsa.behaviour.repositories;

import com.nsa.behaviour.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 */
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    public List<Activity> findAll();
    public Activity findActivityById(Integer id);
}
