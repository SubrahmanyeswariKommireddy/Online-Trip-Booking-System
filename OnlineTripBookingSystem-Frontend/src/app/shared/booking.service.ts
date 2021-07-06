import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { User } from "../models/User";
import { Observable } from 'rxjs';
import {Booking} from "../models/Booking"

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
    addBooking(booking: Booking): Observable<Booking> {
        return <Observable<Booking>>this.httpClient.post(this.baseUrl + "/customer/addBooking", booking)
      }



}
  