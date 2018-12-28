package com.nsa.behaviour.services;

import com.nsa.behaviour.entities.FeelingLog;
import com.nsa.behaviour.entities.Patient;
import com.nsa.behaviour.repositories.FeelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by c1662491 on 12/5/2017.
 */
@Service
public class FeelingServiceImp implements FeelingService {

    private FeelingRepository feelingRepo;
    private SimpleDateFormat sdf;
    private String dateAsString;
    private ArrayList<String> dateChartList;
    private HashMap dateLevelMap;

    @Autowired
    public FeelingServiceImp(FeelingRepository aRepo) {
        feelingRepo = aRepo;
    }


    @Override
    public List<FeelingLog> getLogsFor(Patient patient) {
        List<FeelingLog> feelingLogList  = feelingRepo.findAllByPatient(patient);
        return feelingLogList;
    }




    @Override
    public List<FeelingLog> getFeelinglogs() {

        return feelingRepo.findAll();
    }

    @Override
    public FeelingLog getFeelingLog(Integer id) {
        return feelingRepo.findFeelingLogById(id);
    }

    @Override
    public HashMap ConvertTimesForCharts(List<FeelingLog> list) {
        dateLevelMap = new HashMap();
        sdf = new SimpleDateFormat("dd:hh:mm");

        for (FeelingLog f : list){
            dateAsString = sdf.format(f.getDateInputted());
            dateLevelMap.put(dateAsString, f.getFeelingNumber());
        }
        return dateLevelMap;
    }

    @Override
    public void saveToDb(FeelingLog newFeelingLog) {
        feelingRepo.saveAndFlush(newFeelingLog);
    }


}