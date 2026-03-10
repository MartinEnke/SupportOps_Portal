export interface Incident {
  id: number;
  title: string;
  description: string;
  customerName: string;
  affectedSystem: string;
  priority: 'LOW' | 'MEDIUM' | 'HIGH' | 'CRITICAL';
  status: 'OPEN' | 'IN_PROGRESS' | 'WAITING' | 'RESOLVED' | 'CLOSED';
  assignedTo: string;
  createdAt: string;
  updatedAt: string;
}