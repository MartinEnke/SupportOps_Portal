import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Incident } from './models/incident.model';
import { IncidentService, CreateIncidentPayload } from './services/incident.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  private incidentService = inject(IncidentService);

  incidents: Incident[] = [];
  loading = true;
  error = '';
  submitError = '';
  submitting = false;

  selectedStatus = '';
  selectedPriority = '';

  statusOptions = ['OPEN', 'IN_PROGRESS', 'WAITING', 'RESOLVED', 'CLOSED'];
  priorityOptions = ['LOW', 'MEDIUM', 'HIGH', 'CRITICAL'];

  formData: CreateIncidentPayload = {
    title: '',
    description: '',
    customerName: '',
    affectedSystem: '',
    priority: 'MEDIUM',
    status: 'OPEN',
    assignedTo: ''
  };

  ngOnInit(): void {
    this.loadIncidents();
  }

  loadIncidents(): void {
    this.loading = true;
    this.error = '';

    this.incidentService
      .getIncidents(this.selectedStatus || undefined, this.selectedPriority || undefined)
      .subscribe({
        next: (data) => {
          this.incidents = data;
          this.loading = false;
        },
        error: () => {
          this.error = 'Failed to load incidents.';
          this.loading = false;
        }
      });
  }

  applyFilters(): void {
    this.loadIncidents();
  }

  resetFilters(): void {
  this.selectedStatus = undefined as any;
  this.selectedPriority = undefined as any;
  this.loadIncidents();
}

  onSubmit(): void {
    this.submitError = '';
    this.submitting = true;

    this.incidentService.createIncident(this.formData).subscribe({
      next: () => {
        this.resetForm();
        this.submitting = false;
        this.loadIncidents();
      },
      error: (err) => {
        this.submitting = false;

        if (err?.error?.message) {
          this.submitError = err.error.message;
        } else {
          this.submitError = 'Failed to create incident.';
        }
      }
    });
  }

  resetForm(): void {
    this.formData = {
      title: '',
      description: '',
      customerName: '',
      affectedSystem: '',
      priority: 'MEDIUM',
      status: 'OPEN',
      assignedTo: ''
    };
  }
}