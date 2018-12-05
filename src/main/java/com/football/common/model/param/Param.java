package com.football.common.model.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import com.football.common.util.JsonCommon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
@Entity
@Table(name = Constant.TABLE.PARAM)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Param {
    @Id
    @GeneratedValue
    private ParamKey paramKey;

    @Column(name = "s_value", nullable = false)
    private String value;
    @Column(name = "s_name", nullable = true)
    private String name;
    @Column(name = "n_status", nullable = false)
    private Integer status;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    public ParamKey getParamKey() {
        return paramKey;
    }

    public void setParamKey(ParamKey paramKey) {
        this.paramKey = paramKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return JsonCommon.objectToJsonNotNull(this);
    }
}
