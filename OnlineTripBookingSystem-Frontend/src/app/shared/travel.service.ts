import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Travel } from "../models/Travel";

@Injectable({
    providedIn: 'root'
  })
  
  export class TravelService {
      
    private baseUrl: string = 'http://localhost:9999';

    constructor(private httpClient: HttpClient) { }

    addTravel(travel:Travel) :Observable<Travel>{
      return <Observable<Travel>>this.httpClient.post(this.baseUrl + "/admin/addTravel",travel)
    }

    getTravels(): Observable<Travel[]> {
      return <Observable<Travel[]>>this.httpClient.get(this.baseUrl + "/admin/getTravels");
    }

    deleteTravelById(id: number): Observable<Travel> {

      return <Observable<Travel>>this.httpClient.delete(this.baseUrl + "/admin/deleteTravel/" + id)
    }

    getTravelById(travelId: number): Observable<Travel>{
      return <Observable<Travel>>this.httpClient.get(this.baseUrl + "/admin/getTravel/" + travelId);
    }

    // getBuses(): Observable<Bus[]> {

    //   return <Observable<Bus[]>>this.httpClient.get(this.baseUrl + "/getBuses")
    // }
  
    // getBusById(busId: number): Observable<Bus> {
  
    //   return <Observable<Bus>>this.httpClient.get(this.baseUrl + "/getBus/" + busId)
    // }

  }