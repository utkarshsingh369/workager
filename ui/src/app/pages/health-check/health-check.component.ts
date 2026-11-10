import { Component, OnInit } from '@angular/core';
import { BACKEND_SERVICES } from '../../const/health/backend-services';

@Component({
  imports: [],
  selector: 'app-health-check',
  styleUrl: './health-check.component.scss',
  templateUrl: './health-check.component.html'
})
export class HealthCheckComponent implements OnInit {
  services = BACKEND_SERVICES;

  ngOnInit(): void {
    this.services.forEach((service) => {
      const url = `http://${service.domain}:${service.port}${service.path}`;
      fetch(url)
        .then((response) => {
          if (response.ok) {
            service.status = 'UP';
          } else {
            service.status = 'DOWN';
          }
          service.lastChecked = new Date();
        })
        .catch(() => {
          service.status = 'DOWN';
          service.lastChecked = new Date();
        });
    });
  }
}
