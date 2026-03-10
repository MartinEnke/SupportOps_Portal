package com.martinenke.supportopsbackend.service;

import com.martinenke.supportopsbackend.dto.IncidentRequestDto;
import com.martinenke.supportopsbackend.dto.IncidentResponseDto;
import com.martinenke.supportopsbackend.exception.ResourceNotFoundException;
import com.martinenke.supportopsbackend.model.Incident;
import com.martinenke.supportopsbackend.model.IncidentPriority;
import com.martinenke.supportopsbackend.model.IncidentStatus;
import com.martinenke.supportopsbackend.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<IncidentResponseDto> getAllIncidents(IncidentStatus status, IncidentPriority priority) {
        List<Incident> incidents;

        if (status != null && priority != null) {
            incidents = incidentRepository.findByStatusAndPriority(status, priority);
        } else if (status != null) {
            incidents = incidentRepository.findByStatus(status);
        } else if (priority != null) {
            incidents = incidentRepository.findByPriority(priority);
        } else {
            incidents = incidentRepository.findAll();
        }

        return incidents.stream()
                .map(this::toResponseDto)
                .toList();
    }

    public IncidentResponseDto getIncidentById(Long id) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident with id " + id + " not found."));
        return toResponseDto(incident);
    }

    public IncidentResponseDto createIncident(IncidentRequestDto dto) {
        Incident incident = new Incident();
        applyDtoToEntity(dto, incident);
        Incident savedIncident = incidentRepository.save(incident);
        return toResponseDto(savedIncident);
    }

    public IncidentResponseDto updateIncident(Long id, IncidentRequestDto dto) {
        Incident existingIncident = incidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident with id " + id + " not found."));

        applyDtoToEntity(dto, existingIncident);
        Incident updatedIncident = incidentRepository.save(existingIncident);
        return toResponseDto(updatedIncident);
    }

    public void deleteIncident(Long id) {
        Incident existingIncident = incidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident with id " + id + " not found."));
        incidentRepository.delete(existingIncident);
    }

    private void applyDtoToEntity(IncidentRequestDto dto, Incident incident) {
        incident.setTitle(dto.getTitle());
        incident.setDescription(dto.getDescription());
        incident.setCustomerName(dto.getCustomerName());
        incident.setAffectedSystem(dto.getAffectedSystem());
        incident.setPriority(dto.getPriority());
        incident.setStatus(dto.getStatus());
        incident.setAssignedTo(dto.getAssignedTo());
    }

    private IncidentResponseDto toResponseDto(Incident incident) {
        return new IncidentResponseDto(
                incident.getId(),
                incident.getTitle(),
                incident.getDescription(),
                incident.getCustomerName(),
                incident.getAffectedSystem(),
                incident.getPriority(),
                incident.getStatus(),
                incident.getAssignedTo(),
                incident.getCreatedAt(),
                incident.getUpdatedAt()
        );
    }
}