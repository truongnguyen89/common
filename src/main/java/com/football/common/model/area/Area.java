package com.football.common.model.area;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 26-Nov-18
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.AREA)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_city_provincial_id")
    private Long cityProvincialId;
    @Column(name = "n_county_district_id")
    private Long countyDistrictId;
    @Column(name = "n_commune_id")
    private Long communeId;
    @Column(name = "n_type")
    private Integer type;
    @Column(name = "n_open_weather_id")
    private Long openWeatherId;
    @Column(name = "n_status")
    private Integer status;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    @Transient
    private String cityProvincialCode;
    @Transient
    private String cityProvincialName;
    @Transient
    private String countyDistrictCode;
    @Transient
    private String countyDistrictName;
    @Transient
    private String communeCode;
    @Transient
    private String communeName;
    @Transient
    private String communeType;

    public String getCityProvincialCode() {
        return cityProvincialCode;
    }

    public void setCityProvincialCode(String cityProvincialCode) {
        this.cityProvincialCode = cityProvincialCode;
    }

    public String getCityProvincialName() {
        return cityProvincialName;
    }

    public void setCityProvincialName(String cityProvincialName) {
        this.cityProvincialName = cityProvincialName;
    }

    public String getCountyDistrictCode() {
        return countyDistrictCode;
    }

    public void setCountyDistrictCode(String countyDistrictCode) {
        this.countyDistrictCode = countyDistrictCode;
    }

    public String getCountyDistrictName() {
        return countyDistrictName;
    }

    public void setCountyDistrictName(String countyDistrictName) {
        this.countyDistrictName = countyDistrictName;
    }

    public String getCommuneCode() {
        return communeCode;
    }

    public void setCommuneCode(String communeCode) {
        this.communeCode = communeCode;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getCommuneType() {
        return communeType;
    }

    public void setCommuneType(String communeType) {
        this.communeType = communeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityProvincialId() {
        return cityProvincialId;
    }

    public void setCityProvincialId(Long cityProvincialId) {
        this.cityProvincialId = cityProvincialId;
    }

    public Long getCountyDistrictId() {
        return countyDistrictId;
    }

    public void setCountyDistrictId(Long countyDistrictId) {
        this.countyDistrictId = countyDistrictId;
    }

    public Long getCommuneId() {
        return communeId;
    }

    public void setCommuneId(Long communeId) {
        this.communeId = communeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOpenWeatherId() {
        return openWeatherId;
    }

    public void setOpenWeatherId(Long openWeatherId) {
        this.openWeatherId = openWeatherId;
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
