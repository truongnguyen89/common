package com.football.common.model.log;

import com.football.common.constant.Constant;
import com.football.common.util.DateCommon;
import com.football.common.util.StringCommon;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 10-Jul-18
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = Constant.TABLE.LOG)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"startTime", "endTime"},
        allowGetters = true)
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE.SQ_LOG)
    @SequenceGenerator(schema = Constant.SCHEMA.ECPAY_LOG, name = Constant.SEQUENCE.SQ_LOG, sequenceName = Constant.SEQUENCE.SQ_LOG, allocationSize = 1)
    @Column(name = "n_id")
    private Long id;

    @Column(name = "n_log_id")
    private Long logId;
    @Column(name = "s_application")
    private String application;
    @Column(name = "s_method")
    private String method;
    @Column(name = "c_request")
    private String request;
    @Column(name = "c_response")
    private String response;
    @Column(name = "d_start_time")
    @JsonFormat(pattern = Constant.DATE.FORMAT.FULL_DATE_SSS)
    private Date startTime;
    @Column(name = "d_end_time")
    @JsonFormat(pattern = Constant.DATE.FORMAT.FULL_DATE_SSS)
    private Date endTime;
    @Column(name = "s_status")
    private String status;
    @Column(name = "n_duration")
    private Long duration;
    @Column(name = "s_log_path")
    private String logPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStartTime(String startTime) {
        if (!StringCommon.isNullOrBlank(startTime))
            this.startTime = DateCommon.convertStringToDateTime(startTime, Constant.DATE.FORMAT.FULL_DATE_SSS);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setEndTime(String endTime) {
        if (!StringCommon.isNullOrBlank(endTime))
            this.endTime = DateCommon.convertStringToDateTime(endTime, Constant.DATE.FORMAT.FULL_DATE_SSS);
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
}
