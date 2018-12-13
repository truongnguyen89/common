package com.football.common.model.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 13-Dec-18
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.WEATHER_LOCAL)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class WeatherLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_open_weather_id")
    private Long openWeatherId;
    @Column(name = "s_name")
    private String name;
    @Column(name = "s_country")
    private String country;
    @Column(name = "s_longitude")
    private String longitude;
    @Column(name = "s_latitude")
    private String latitude;
    @Column(name = "n_status")
    private Integer status;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOpenWeatherId() {
        return openWeatherId;
    }

    public void setOpenWeatherId(Long openWeatherId) {
        this.openWeatherId = openWeatherId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public WeatherLocal(Long openWeatherId, String country, String longitude, String latitude) {
        this.openWeatherId = openWeatherId;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.status = Constant.STATUS_OBJECT.ACTIVE;
    }

    public WeatherLocal() {
    }
}
