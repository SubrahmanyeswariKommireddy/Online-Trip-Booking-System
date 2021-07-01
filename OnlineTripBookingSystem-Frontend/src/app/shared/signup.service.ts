import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignupComponent } from '../signup/signup.component';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private baseUrl: string = 'http://localhost:9999';

  constructor(private http: HttpClient) { }

  addSignupDetail(signUp: SignupComponent): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, signUp)
  }
}