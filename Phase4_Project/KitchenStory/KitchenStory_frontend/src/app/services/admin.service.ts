import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Admin } from '../models/admin';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private getUrl: string = 'http://localhost:8080/admin/login';
  private adminValidated: boolean;
  constructor(private _httpClient: HttpClient) {}

  validateAdmin(admin: Admin): Observable<Admin> {
    return this._httpClient.post<Admin>(this.getUrl, admin);
  }
}
