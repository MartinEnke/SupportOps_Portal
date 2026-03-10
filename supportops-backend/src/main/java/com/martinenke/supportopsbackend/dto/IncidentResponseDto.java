package com.martinenke.supportopsbackend.dto;

import com.martinenke.supportopsbackend.model.IncidentPriority;
import com.martinenke.supportopsbackend.model.IncidentStatus;

import java.time.LocalDateTime;

public class IncidentResponseDto {

    private Long id;
    private String title;
    private String description;
    private String customerName;
    private String affectedSystem;
    private IncidentPriority priority;
    private IncidentStatus status;
    private String assignedTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public IncidentResponseDto() {
    }

    public IncidentResponseDto(Long id, String title, String description, String customerName,
                               String affectedSystem, IncidentPriority priority, IncidentStatus status,
                               String assignedTo, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.customerName = customerName;
        this.affectedSystem = affectedSystem;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAffectedSystem() {
        return affectedSystem;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAffectedSystem(String affectedSystem) {
        this.affectedSystem = affectedSystem;
    }

    public void setPriority(IncidentPriority priority) {
        this.priority = priority;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}