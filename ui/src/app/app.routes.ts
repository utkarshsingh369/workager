import { Routes } from '@angular/router';
import { NavComponent } from './pages/nav/nav.component';
import { authGuard } from './service/auth/auth.guard';

export const routes: Routes = [
  {
    path: '',
    component: NavComponent,
    children: [
      {
        path: 'login',
        loadComponent: () => import('./pages/login/login.component').then((module) => module.LoginComponent)
      },
      {
        path: '',
        canActivateChild: [authGuard],
        children: [
          { path: '', redirectTo: 'home', pathMatch: 'full' },
          {
            path: 'home',
            loadComponent: () => import('./pages/home/home.component').then((module) => module.HomeComponent)
          },
          {
            path: 'health-check',
            loadComponent: () => import('./pages/health-check/health-check.component').then((module) => module.HealthCheckComponent)
          },
          {
            path: 'contact',
            loadComponent: () => import('./pages/contact/contact.component').then((module) => module.ContactComponent)
          }
        ]
      }
    ]
  }
];
