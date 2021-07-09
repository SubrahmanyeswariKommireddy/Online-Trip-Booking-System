import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Admin } from "../models/Admin";
import { Customer } from "../models/Customer";
import { User } from "../models/User";

@Injectable({
  providedIn: 'root'
})

export class UserService {
  oldPassword: string = '';
  newPassword: string = '';

  private baseUrl: string = 'http://localhost:9999';

  constructor(private httpClient: HttpClient) { }

  updateCustomer(customer: Customer): Observable<Customer> {

    return <Observable<Customer>>this.httpClient.patch(this.baseUrl + "/updateCustomer", customer)
  }

  getCustomerById(id: number): Observable<Customer> {

    return <Observable<Customer>>this.httpClient.get(this.baseUrl + "/getCustomer/" + id)
  }

  getAdminById(id: number): Observable<Admin> {

    return <Observable<Admin>>this.httpClient.get(this.baseUrl + "/getAdmin/" + id)
  }

  updateAdmin(admin: Admin): Observable<Admin> {

    return <Observable<Admin>>this.httpClient.patch(this.baseUrl + "/updateAdmin", admin)
  }

  updatePassword(newPassword: string,user: User): Observable<User> {
    
    return <Observable<User>>this.httpClient.patch(this.baseUrl + "/updatePassword?newPassword="+newPassword,user)
  }
  
}