package com.football.common.model.param;

import com.football.common.constant.Constant;
import com.football.common.util.JsonCommon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
@Entity
@Table(name = Constant.TABLE.PARAM)
@EntityListeners(AuditingEntityListener.class)
public class Param {
    @Id
    @GeneratedValue
    private ParamKey paramKey;

    @Column(name = "s_value", nullable = false)
    private String value;
    @Column(name = "s_name", nullable = true)
    private String name;
    @Column(name = "s_value_alt", nullable = true)
    private String valueAlt;
    @Column(name = "b_status", nullable = false)
    private Integer status;

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

    public String getValueAlt() {
        return valueAlt;
    }

    public void setValueAlt(String valueAlt) {
        this.valueAlt = valueAlt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return JsonCommon.objectToJsonNotNull(this);
    }
}
