import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
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

  getIncidents(status?: string, priority?: string) {

  let params: any = {};

  if (status) {
    params.status = status;
  }

  if (priority) {
    params.priority = priority;
  }

  return this.http.get<Incident[]>(this.apiUrl, { params });
}

  createIncident(payload: CreateIncidentPayload): Observable<Incident> {
    return this.http.post<Incident>(this.apiUrl, payload);
  }
}