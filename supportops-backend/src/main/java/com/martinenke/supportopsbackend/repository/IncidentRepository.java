package com.martinenke.supportopsbackend.repository;

import com.martinenke.supportopsbackend.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}