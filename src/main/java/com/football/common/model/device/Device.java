package com.football.common.model.device;

import com.football.common.constant.Constant;
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
@Table(name = Constant.TABLE.DEVICE)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE.SQ_DEVICE)
    @SequenceGenerator(schema = Constant.SCHEMA.ENOTIFICATION, name = Constant.SEQUENCE.SQ_DEVICE, sequenceName = Constant.SEQUENCE.SQ_DEVICE, allocationSize = 1)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "s_onesignal_id")
    private String onesignalId;
    @Column(name = "n_device_type")
    private Integer deviceType;
    @Column(name = "s_email_auth_hash")
    private String emailAuthHash;
    @Column(name = "s_language")
    private String language;
    @Column(name = "N_TIMEZONE")
    private Integer timezone;
    @Column(name = "s_game_version")
    private String gameVersion;
    @Column(name = "s_device_model")
    private String deviceModel;
    @Column(name = "s_device_os")
    private String deviceOs;
    @Column(name = "s_ad_id")
    private String adId;
    @Column(name = "s_sdk")
    private String sdk;
    @Column(name = "n_session_count")
    private Integer sessionCount;
    @Column(name = "s_tags")
    private String tags;
    @Column(name = "n_amount_spent")
    private Long amountSpent;
    @Column(name = "n_play_time")
    private Integer playTime;
    @Column(name = "n_notification_types")
    private Integer notificationTypes;
    @Column(name = "n_long")
    private Long nlong;
    @Column(name = "n_lat")
    private Integer nlat;
    @Column(name = "s_country")
    private String country;
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

    public String getOnesignalId() {
        return onesignalId;
    }

    public void setOnesignalId(String onesignalId) {
        this.onesignalId = onesignalId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getEmailAuthHash() {
        return emailAuthHash;
    }

    public void setEmailAuthHash(String emailAuthHash) {
        this.emailAuthHash = emailAuthHash;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public Integer getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(Integer sessionCount) {
        this.sessionCount = sessionCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(Long amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Integer getNotificationTypes() {
        return notificationTypes;
    }

    public void setNotificationTypes(Integer notificationTypes) {
        this.notificationTypes = notificationTypes;
    }

    public Long getNlong() {
        return nlong;
    }

    public void setNlong(Long nlong) {
        this.nlong = nlong;
    }

    public Integer getNlat() {
        return nlat;
    }

    public void setNlat(Integer nlat) {
        this.nlat = nlat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
