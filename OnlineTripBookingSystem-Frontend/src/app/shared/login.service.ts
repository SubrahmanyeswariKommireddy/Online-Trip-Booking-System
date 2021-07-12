import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  user!: User;
  private baseUrl = 'http://localhost:9999'

  constructor(
    private httpClient: HttpClient
  ) {
  }

  authenticate(email: any, password: any, userType: any): Observable<any> {

    console.log('in authentication service authenticate method', email)
    return this.httpClient.post<any>(`${this.baseUrl}/authenticate`, { email, password, userType })
      .pipe(map(
        userData => {
          sessionStorage.setItem('email', email);
          let tokenStr = 'Bearer ' + userData.token;
          sessionStorage.setItem('token', tokenStr);
          sessionStorage.setItem('userType',userType);
          sessionStorage.setItem('id',userData.id);
        
          
          return userData;
        }
      ));
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('email')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('email')
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('userType')
    sessionStorage.removeItem('id')
  }
}