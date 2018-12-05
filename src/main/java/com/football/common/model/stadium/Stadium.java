package com.football.common.model.stadium;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import com.football.common.util.StringCommon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 26-Nov-18
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.STADIUM)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "s_address")
    private String address;
    @Column(name = "s_email")
    private String email;
    @Column(name = "s_phone")
    private String phone;
    @Column(name = "s_longitude")
    private String longitude;
    @Column(name = "s_latitude")
    private String latitude;
    @Column(name = "n_count_sub_stadium")
    private Integer countSubStadium;
    @Column(name = "n_type")
    private Integer type;
    @Column(name = "n_status")
    private Integer status;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    @Transient
    private List<SubStadium> subStadiumList;

    @Transient
    private String[] arrPhone;

    public List<SubStadium> getSubStadiumList() {
        return subStadiumList;
    }

    public void setSubStadiumList(List<SubStadium> subStadiumList) {
        this.subStadiumList = subStadiumList;
    }

    public String[] getArrPhone() {
        if (!StringCommon.isNullOrBlank(this.phone))
            return this.phone.split(";");
        else
            return arrPhone;
    }

    public void setArrPhone(String phone) {
        this.phone = phone;
        if (!StringCommon.isNullOrBlank(phone)) {
            this.arrPhone = phone.split(";");
        }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getCountSubStadium() {
        return countSubStadium;
    }

    public void setCountSubStadium(Integer countSubStadium) {
        this.countSubStadium = countSubStadium;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
