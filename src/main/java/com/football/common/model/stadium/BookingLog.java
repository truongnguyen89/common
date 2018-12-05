package com.football.common.model.stadium;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Constant.TABLE.BOOKING_LOG)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class BookingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_booking_id")
    private Long bookingId;
    @Column(name = "n_user_id")
    private Long userId;
    @Column(name = "s_reason")
    private String reason;
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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
