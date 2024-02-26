import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/services/storage-service/local-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  isUserLoggedIn: boolean = LocalStorageService.isUserLoggedIn();
  isAdminLoggedIn: boolean = LocalStorageService.isAdminLoggedIn();

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event.constructor.name === 'NavigationEnd') {
        this.isUserLoggedIn = LocalStorageService.isUserLoggedIn();
        this.isAdminLoggedIn = LocalStorageService.isAdminLoggedIn();
      }
    });
  }

  logOut() {
    LocalStorageService.signOut();
    this.router.navigateByUrl('/login');
  }
}
