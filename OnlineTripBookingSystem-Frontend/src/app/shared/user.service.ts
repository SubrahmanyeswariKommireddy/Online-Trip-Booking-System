import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Customer } from "../models/Customer";
import { User } from "../models/User";

@Injectable({
    providedIn: 'root'
  })
  
  export class UserService {
      oldPassword:string='';
      newPassword:string='';

    private baseUrl: string = 'http://localhost:9999';

    constructor(private httpClient: HttpClient) { }

    // updateUser(id:number,user:User):Observable<User>{

    //     return <Observable<User>>this.httpClient.put(this.baseUrl+"/updateCustomer/"+id,user)
    // }

    updateBus(id:number,customer:Customer):Observable<Customer>{

      return <Observable<Customer>>this.httpClient.put(this.baseUrl+"/udateCustomer/"+id,customer)
  }
//   updateSecurityAlert(id:number,securityAlert:SecurityAlert):Observable<SecurityAlert>{
 
//     return <Observable<SecurityAlert>>this.http.patch(this.baseUrl+"/admin/securityAlert/"+id,securityAlert)
// }
updateMobileNumber(id:number,customer:Customer):Observable<Customer>{
 
  return <Observable<Customer>>this.httpClient.patch(this.baseUrl+"/updateCustomerMobileNo/"+id,customer)
}
getCustomerById(id:number):Observable<Customer>{

  return <Observable<Customer>>this.httpClient.get(this.baseUrl+"/getCustomer/"+id)
}
  }