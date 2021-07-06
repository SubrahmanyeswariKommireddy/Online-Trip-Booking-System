import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Route } from "../models/Route";

@Injectable({
    providedIn: 'root'
  })
  
  export class RouteService {
      
    private baseUrl: string = 'http://localhost:9999';

    constructor(private httpClient: HttpClient) { }

    addRoute(route:Route) :Observable<Route>{
      return <Observable<Route>>this.httpClient.post(this.baseUrl + "/admin/addRoute",route)
    }
    

  }