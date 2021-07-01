import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private baseUrl: string = 'http://localhost:9999';

  constructor(private httpClient: HttpClient) { }

  public createUser(user: any) {

            return this.httpClient.post<User>(`${this.baseUrl}/register`, user);
        }
}


