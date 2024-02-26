import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { LocalStorageService } from 'src/app/services/storage-service/local-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  validateForm: FormGroup = new FormGroup({});

  constructor(private authService: AuthService, private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  login() {
    this.authService.login(this.validateForm.get(['username'])?.value, this.validateForm.get(['password'])?.value).subscribe({
      next: (_) => {
        if (LocalStorageService.isAdminLoggedIn()) {
          this.router.navigateByUrl('/admin/dashboard');
        } else if (LocalStorageService.isUserLoggedIn()) {
          this.router.navigateByUrl('/user/dashboard');
        }
      },
      error: (error) => {
        console.log({ error });
      },
    });
  }
}
