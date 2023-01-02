package com.clinicadminservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor_appointment")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    private String patientName;
    //@NotBlank
    private String status;

    private String reason;

    //@Column(nullable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@CreatedDate
    //@JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    //@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    //@LastModifiedDate
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
