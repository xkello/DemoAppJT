package com.example.kello_demo_app.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class VacationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Date of creation
    private LocalDate createdDate;

    // State of the request
    private String status;

    // Start - Date + part of the day?
    private LocalDate startDate;
    private String startPartOfDay;

    // End - Date + part of the day?
    private LocalDate endDate;
    private String endPartOfDay;

    // Days in total - will be calculated automatically?
    private BigDecimal days;

    // Approved
    private String approvedByManager;

    // Approved 2 - Probably someone higher than manager
    private String approvedByDirector;

    // Who made the request, felt right might delete later
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    // Same as user constructor. Stay safe
    protected VacationRequest() {
    }

    // Since we can choose user from dropdown, public constructor might be needed
    public VacationRequest(LocalDate createdDate,
                           String status,
                           LocalDate startDate,
                           String startPartOfDay,
                           LocalDate endDate,
                           String endPartOfDay,
                           BigDecimal days,
                           String approvedByManager,
                           String approvedByDirector,
                           User createdBy) {
        this.createdDate = createdDate;
        this.status = status;
        this.startDate = startDate;
        this.startPartOfDay = startPartOfDay;
        this.endDate = endDate;
        this.endPartOfDay = endPartOfDay;
        this.days = days;
        this.approvedByManager = approvedByManager;
        this.approvedByDirector = approvedByDirector;
        this.createdBy = createdBy;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStartPartOfDay() {
        return startPartOfDay;
    }

    public void setStartPartOfDay(String startPartOfDay) {
        this.startPartOfDay = startPartOfDay;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getEndPartOfDay() {
        return endPartOfDay;
    }

    public void setEndPartOfDay(String endPartOfDay) {
        this.endPartOfDay = endPartOfDay;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }

    public String getApprovedByManager() {
        return approvedByManager;
    }

    public void setApprovedByManager(String approvedByManager) {
        this.approvedByManager = approvedByManager;
    }

    public String getApprovedByDirector() {
        return approvedByDirector;
    }

    public void setApprovedByDirector(String approvedByDirector) {
        this.approvedByDirector = approvedByDirector;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
