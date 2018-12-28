package com.nsa.behaviour.services;

import com.nsa.behaviour.entities.FeelingLog;
import com.nsa.behaviour.entities.Patient;
import java.util.HashMap;
import java.util.List;

public interface FeelingService {

    public List<FeelingLog> getLogsFor(Patient patient);
    public List<FeelingLog> getFeelinglogs();
    public FeelingLog getFeelingLog(Integer id);

    public HashMap ConvertTimesForCharts(List<FeelingLog> list);

    public void saveToDb(FeelingLog newFeelingLog);
}