package com.football.common.model.log;

import com.football.common.constant.Constant;
import com.football.common.util.DateCommon;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 18-Jun-18
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(value = {"startTime", "endTime"},
        allowGetters = true)
public class LogBase {
    private Long logId;
    private String method;
    private String startTime;
    private String endTime;
    private String status;
    private Long duration;
    private Map<String, Object> request;
    private Map<String, Object> response;

    public LogBase(Long logId, String method, Date startTime, Date endTime, String status, Map<String, Object> request, Map<String, Object> response) {
        this.logId = logId;
        this.method = method;
        this.startTime = DateCommon.convertDateToStringByPattern(startTime, Constant.DATE.FORMAT.FULL_DATE_SSS);
        this.endTime = DateCommon.convertDateToStringByPattern(endTime, Constant.DATE.FORMAT.FULL_DATE_SSS);
        this.duration = endTime.getTime() - startTime.getTime();
        this.status = status;
        this.request = request;
        this.response = response;
    }

    public LogBase() {
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }
}
