import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../models/User";

@Injectable({
    providedIn: 'root'
  })
  
  export class UserService {
      oldPassword:string='';
      newPassword:string='';

    private baseUrl: string = 'http://localhost:9999';

    constructor(private httpClient: HttpClient) { }

    updateUser(id:number,user:User):Observable<User>{

        return <Observable<User>>this.httpClient.put(this.baseUrl+"/updateCustomer/"+id,user)
    }
  
  
  }