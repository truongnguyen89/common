package com.football.common.model.notification;

import com.football.common.constant.Constant;
import com.football.common.model.device.AccountAppDevice;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 24-Sep-18
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.NOTIFICATION_QUEUE)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class NotificationQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE.SQ_NOTIFICATION_QUEUE)
    @SequenceGenerator(schema = Constant.SCHEMA.ENOTIFICATION, name = Constant.SEQUENCE.SQ_NOTIFICATION_QUEUE, sequenceName = Constant.SEQUENCE.SQ_NOTIFICATION_QUEUE, allocationSize = 1)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_notification_id")
    private Long notificationId;
    @Column(name = "n_account_app_device_id")
    private Long accountAppDeviceId;
    @Column(name = "n_status")
    private Integer status;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getAccountAppDeviceId() {
        return accountAppDeviceId;
    }

    public void setAccountAppDeviceId(Long accountAppDeviceId) {
        this.accountAppDeviceId = accountAppDeviceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Transient
    private Notification notification;
    @Transient
    private AccountAppDevice accountAppDevice;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public AccountAppDevice getAccountAppDevice() {
        return accountAppDevice;
    }

    public void setAccountAppDevice(AccountAppDevice accountAppDevice) {
        this.accountAppDevice = accountAppDevice;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
