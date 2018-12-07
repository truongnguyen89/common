package com.football.common.model.email;

import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.util.JsonCommon;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 26-Sep-18
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.EMAIL)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "s_from_adress")
    private String fromAdress;
    @Column(name = "s_to_adress")
    private String toAdress;
    @Column(name = "s_cc_adress")
    private String ccAdress;
    @Column(name = "s_subject")
    private String subject;
    @Column(name = "s_message")
    private String message;
    @Column(name = "s_file_name")
    private String fileName;
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

    public String getFromAdress() {
        return fromAdress;
    }

    public void setFromAdress(String fromAdress) {
        this.fromAdress = fromAdress;
    }

    public String getToAdress() {
        return toAdress;
    }

    public void setToAdress(String toAdress) {
        this.toAdress = toAdress;
    }

    public String getCcAdress() {
        return ccAdress;
    }

    public void setCcAdress(String ccAdress) {
        this.ccAdress = ccAdress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Email(String fromAdress, String toAdress, String subject, String message, Integer status, Date createdAt) {
        this.fromAdress = fromAdress;
        this.toAdress = toAdress;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Email(String toAdress, String subject, String message) {
        this.fromAdress = Cache.getValueParamFromCache(Constant.PARAMS.TYPE.EMAIL, Constant.PARAMS.CODE.FROM_MAIL_DEFAUL);
        this.toAdress = toAdress;
        this.subject = subject;
        this.message = message;
        this.status = Constant.EMAIL.STATUS.NEW;
        this.createdAt = new Date();
    }

    public Email() {
    }

    @Override
    public String toString(){
        return JsonCommon.objectToJsonNotNull(this);
    }
}
