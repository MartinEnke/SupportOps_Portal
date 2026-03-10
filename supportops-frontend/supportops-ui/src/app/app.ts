import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IncidentService } from './services/incident.service';
import { Incident } from './models/incident.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  private incidentService = inject(IncidentService);

  incidents: Incident[] = [];
  loading = true;
  error = '';

  ngOnInit(): void {
    this.incidentService.getIncidents().subscribe({
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
}