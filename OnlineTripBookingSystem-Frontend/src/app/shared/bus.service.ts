import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bus } from '../models/Bus';


@Injectable({
  providedIn: 'root'
})

export class BusService {
  private baseUrl: string = 'http://localhost:9999';

  constructor(private httpClient: HttpClient) { }

  getBuses(): Observable<Bus[]> {
    return <Observable<Bus[]>>this.httpClient.get(this.baseUrl + "/getBuses")
  }
  getBusById(id: number): Observable<Bus> {

    return <Observable<Bus>>this.httpClient.get(this.baseUrl + "/getBus/" + id)
  }
  addBus(bus: Bus): Observable<Bus> {
    return <Observable<Bus>>this.httpClient.post(this.baseUrl + "/travel/addBus", bus)
  }
  deleteBusById(id: number): Observable<Bus> {

    return <Observable<Bus>>this.httpClient.delete(this.baseUrl + "/bus/" + id)
  }
  updateBus(id: number, bus: Bus): Observable<Bus> {

    return <Observable<Bus>>this.httpClient.put(this.baseUrl + "/updateBus/" + id, bus)
  }
}

