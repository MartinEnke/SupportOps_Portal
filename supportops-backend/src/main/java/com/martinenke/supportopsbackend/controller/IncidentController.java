package com.martinenke.supportopsbackend.controller;

import com.martinenke.supportopsbackend.dto.IncidentRequestDto;
import com.martinenke.supportopsbackend.dto.IncidentResponseDto;
import com.martinenke.supportopsbackend.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public List<IncidentResponseDto> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public IncidentResponseDto getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id);
    }

    @PostMapping
    public IncidentResponseDto createIncident(@Valid @RequestBody IncidentRequestDto incidentRequestDto) {
        return incidentService.createIncident(incidentRequestDto);
    }

    @PutMapping("/{id}")
    public IncidentResponseDto updateIncident(@PathVariable Long id,
                                              @Valid @RequestBody IncidentRequestDto incidentRequestDto) {
        return incidentService.updateIncident(id, incidentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
    }
}