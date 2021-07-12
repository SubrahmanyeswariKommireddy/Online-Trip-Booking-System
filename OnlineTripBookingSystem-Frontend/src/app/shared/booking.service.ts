import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { User } from "../models/User";
import { Observable } from 'rxjs';
import { Booking } from "../models/Booking"
import { BusBooking } from "../models/BusBooking";
import { Customer } from "../models/Customer";

@Injectable({
  providedIn: 'root'
})

export class BookingService {
  user!: User;
  private baseUrl = 'http://localhost:9999'

  constructor(
    private httpClient: HttpClient
  ) { }

  addBooking(id:string,booking:BusBooking) : Observable<Customer>{
  return <Observable<Customer>>this.httpClient.post(this.baseUrl+ "/addBusBooking?id=" +id,booking);
  }

  getBookingByCustomerId(id:string):Observable<BusBooking[]>{
  return <Observable<BusBooking[]>>this.httpClient.get(this.baseUrl + "/getCustomerBooking?id="+id);
  }

  getAllBookings():Observable<BusBooking[]>{
    return <Observable<BusBooking[]>>this.httpClient.get(this.baseUrl + "/getAllBookings")
  }
 
}
