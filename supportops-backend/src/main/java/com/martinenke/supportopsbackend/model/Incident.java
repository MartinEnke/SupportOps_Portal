package com.martinenke.supportopsbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title must not exceed 255 characters.")
    private String title;

    @NotBlank(message = "Description is required.")
    @Size(max = 2000, message = "Description must not exceed 2000 characters.")
    @Column(length = 2000)
    private String description;

    @NotBlank(message = "Customer name is required.")
    @Size(max = 255, message = "Customer name must not exceed 255 characters.")
    private String customerName;

    @NotBlank(message = "Affected system is required.")
    @Size(max = 255, message = "Affected system must not exceed 255 characters.")
    private String affectedSystem;

    @NotNull(message = "Priority is required.")
    @Enumerated(EnumType.STRING)
    private IncidentPriority priority;

    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    @NotBlank(message = "Assignee is required.")
@Size(max = 255, message = "Assignee must not exceed 255 characters.")
private String assignedTo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Incident() {
    }

    public Incident(String title, String description, String customerName, String affectedSystem,
                    IncidentPriority priority, IncidentStatus status, String assignedTo,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = IncidentStatus.OPEN;
        }

        if (this.priority == null) {
            this.priority = IncidentPriority.MEDIUM;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAffectedSystem() {
        return affectedSystem;
    }

    public void setAffectedSystem(String affectedSystem) {
        this.affectedSystem = affectedSystem;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public void setPriority(IncidentPriority priority) {
        this.priority = priority;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}