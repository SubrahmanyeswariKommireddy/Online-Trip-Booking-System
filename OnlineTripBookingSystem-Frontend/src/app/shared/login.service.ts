import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
// import { JwtResponse } from '../login/login.component';

export class User {

  email: string = '';
  password: string = '';
  userType: string = '';
  constructor(
    public status: string,
  ) { }

}

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
  }
}