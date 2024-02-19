import { Injectable } from '@angular/core';

const TOKEN = 'I_token';
const USERID = 'I_user';
const USERROLE = 'I_role';

@Injectable({
  providedIn: 'root',
})
export class LocalStorageService {
  constructor() {}

  saveUserId(userId: any) {
    localStorage.removeItem(USERID);
    localStorage.setItem(USERID, userId);
  }

  saveUserRole(role: any) {
    localStorage.removeItem(USERROLE);
    localStorage.setItem(USERROLE, role);
  }

  saveToken(token: any) {
    localStorage.removeItem(TOKEN);
    localStorage.setItem(TOKEN, token);
  }

  static getToken(): string | null {
    return localStorage.getItem(TOKEN);
  }

  static hasToken(): boolean {
    return !(this.getToken() === null);
  }

  static isUserLoggedIn(): boolean {
    if (this.getToken() === null) return false;

    const role: string = this.getUserRole();

    return role === 'USER';
  }

  static isAdminLoggedIn(): boolean {
    if (this.getToken() === null) return false;

    const role: string = this.getUserRole();
    return role === 'ADMIN';
  }

  static getUserRole(): string {
    const user = localStorage.getItem(USERROLE);

    if (user === null) {
      return '';
    }

    return user;
  }

  static signOut() {
    localStorage.removeItem(TOKEN);
    localStorage.removeItem(USERID);
    localStorage.removeItem(USERROLE);
  }
}
