package com.nsa.behaviour.services;

import com.nsa.behaviour.entities.BarChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * --REF CODE: https://www.concretepage.com/spring/how-to-call-stored-function-in-spring-jdbc
 *
 */

@Service
public class BarChartService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall jdbcCallActivityName;
    private SimpleJdbcCall jdbcCallFeelingBefore;
    private SimpleJdbcCall jdbcCallFeelingAfter;



    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        this.jdbcCallActivityName = new SimpleJdbcCall(jdbcTemplate).withFunctionName("function_activity_name");
        this.jdbcCallFeelingBefore = new SimpleJdbcCall(jdbcTemplate).withFunctionName("function_feeling_before");
        this.jdbcCallFeelingAfter = new SimpleJdbcCall(jdbcTemplate).withFunctionName("function_feeling_after");
    }
    public BarChart getBarChartInfo(Integer patientId){

        SqlParameterSource in = new MapSqlParameterSource().addValue("v_patientID", patientId);
        String name = jdbcCallActivityName.executeFunction(String.class, in);
        Integer beforeLevel = jdbcCallFeelingBefore.executeFunction(Integer.class, in);
        Integer afterLevel = jdbcCallFeelingAfter.executeFunction(Integer.class, in);

        return new BarChart(name, beforeLevel, afterLevel);
    }

}