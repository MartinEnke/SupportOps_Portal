package com.martinenke.supportopsbackend.dto;

import com.martinenke.supportopsbackend.model.IncidentPriority;
import com.martinenke.supportopsbackend.model.IncidentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IncidentRequestDto {

    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title must not exceed 255 characters.")
    private String title;

    @NotBlank(message = "Description is required.")
    @Size(max = 2000, message = "Description must not exceed 2000 characters.")
    private String description;

    @NotBlank(message = "Customer name is required.")
    @Size(max = 255, message = "Customer name must not exceed 255 characters.")
    private String customerName;

    @NotBlank(message = "Affected system is required.")
    @Size(max = 255, message = "Affected system must not exceed 255 characters.")
    private String affectedSystem;

    @NotNull(message = "Priority is required.")
    private IncidentPriority priority;

    @NotNull(message = "Status is required.")
    private IncidentStatus status;

    @NotBlank(message = "Assignee is required.")
    @Size(max = 255, message = "Assignee must not exceed 255 characters.")
    private String assignedTo;

    public IncidentRequestDto() {
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
}