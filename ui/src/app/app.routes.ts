import { Routes } from '@angular/router';
import { HealthCheckComponent } from './pages/health-check/health-check.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactComponent } from './pages/contact/contact.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'health-check', component: HealthCheckComponent },
  { path: 'contact', component: ContactComponent }
];
