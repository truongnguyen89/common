package com.football.common.model.param;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class ParamKey implements Serializable {
    @Column(name = "s_type", nullable = false)
    private String type;
    @Column(name = "s_code", nullable = false)
    private String code;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParamKey(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public ParamKey() {
    }
}
