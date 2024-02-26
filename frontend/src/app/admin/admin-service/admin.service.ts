import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageService } from 'src/app/services/storage-service/local-storage.service';
import { environment } from 'src/environments/environments';

const BASIC_URL = environment['BASIC_URL'];

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor(private http: HttpClient) {}

  postCategory(categoryDTO: any): Observable<any> {
    return this.http.post<[]>(BASIC_URL + 'api/admin/category', categoryDTO, {
      headers: this.createAuthorizationHeader(),
    });
  }

  createAuthorizationHeader(): HttpHeaders {
    const authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set('Authorization', 'Bearer ' + LocalStorageService.getToken());
  }
}
