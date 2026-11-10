import { inject, Service, signal } from '@angular/core';
import { Router } from '@angular/router';

@Service()
export class AuthService {
  isLoggedIn = signal(false);
  router = inject(Router);

  login() {
    this.isLoggedIn.set(true);
    this.router.navigate(['/']);
  }

  logout() {
    this.isLoggedIn.set(false);
  }
}
