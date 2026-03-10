import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Incident } from '../models/incident.model';

export interface CreateIncidentPayload {
  title: string;
  description: string;
  customerName: string;
  affectedSystem: string;
  priority: 'LOW' | 'MEDIUM' | 'HIGH' | 'CRITICAL';
  status: 'OPEN' | 'IN_PROGRESS' | 'WAITING' | 'RESOLVED' | 'CLOSED';
  assignedTo: string;
}

@Injectable({
  providedIn: 'root'
})
export class IncidentService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/incidents';

  getIncidents(): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.apiUrl);
  }

  createIncident(payload: CreateIncidentPayload): Observable<Incident> {
    return this.http.post<Incident>(this.apiUrl, payload);
  }
}