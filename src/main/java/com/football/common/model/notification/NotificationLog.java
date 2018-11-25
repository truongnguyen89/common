package com.football.common.model.notification;

import com.football.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 17-Oct-18
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.NOTIFICATION_LOG)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE.SQ_NOTIFICATION_LOG)
    @SequenceGenerator(schema = Constant.SCHEMA.ENOTIFICATION, name = Constant.SEQUENCE.SQ_NOTIFICATION_LOG, sequenceName = Constant.SEQUENCE.SQ_NOTIFICATION_LOG, allocationSize = 1)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_queue_id")
    private Long queueId;
    @Column(name = "s_onesignal_id")
    private String onesignalId;
    @Column(name = "n_recipients")
    private Integer recipients;
    @Column(name = "s_response_code")
    private String responseCode;
    @Column(name = "s_description")
    private String description;
    @Column(name = "d_created_at")
    @JsonFormat(pattern = Constant.DATE.FORMAT.FULL_DATE_SSS)
    private Date createdAt;
    @Column(name = "n_duration")
    private Long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getOnesignalId() {
        return onesignalId;
    }

    public void setOnesignalId(String onesignalId) {
        this.onesignalId = onesignalId;
    }

    public Integer getRecipients() {
        return recipients;
    }

    public void setRecipients(Integer recipients) {
        this.recipients = recipients;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
