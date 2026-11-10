import { Component, inject } from '@angular/core';
import { AuthService } from '../../service/auth/auth.service';
import { RouterLink } from '@angular/router';

@Component({
  imports: [RouterLink],
  selector: 'app-login',
  styleUrl: './login.component.scss',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  readonly authService = inject(AuthService);

  login(event: SubmitEvent): void {
    event.preventDefault();
    this.authService.login();
  }
}
