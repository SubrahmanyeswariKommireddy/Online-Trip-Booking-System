import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from "rxjs/operators";

export class User{
    email:string = '';
    password:string = '';
    userType:string ='';
   
}
@Injectable({
    providedIn:'root'

})
export class LoginService {

    private baseUrl: string = 'http://localhost:9999';
    

    constructor(private httpClient: HttpClient) { } 
    authenticate(email: any, password: any, userType:any): Observable<any> {

        console.log('in authentication service authenticate method', email)
        // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
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





