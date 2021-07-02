import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
  
  export class RouteService {
      
    private baseUrl: string = 'http://localhost:9999';

    constructor(private httpClient: HttpClient) { }

    busBetweenValue(source: any,destination: any)
  {
    return this.httpClient.get(`${this.baseUrl}/admin/getRoute/${source}/${destination}`)   
  }


  }