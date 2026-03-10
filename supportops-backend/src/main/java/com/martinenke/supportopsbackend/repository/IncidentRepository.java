package com.martinenke.supportopsbackend.repository;

import com.martinenke.supportopsbackend.model.Incident;
import com.martinenke.supportopsbackend.model.IncidentPriority;
import com.martinenke.supportopsbackend.model.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByStatus(IncidentStatus status);

    List<Incident> findByPriority(IncidentPriority priority);

    List<Incident> findByStatusAndPriority(IncidentStatus status, IncidentPriority priority);
}