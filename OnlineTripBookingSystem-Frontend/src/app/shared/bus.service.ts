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

  public getBuses() {
    return <Observable<Bus[]>>this.httpClient.get(this.baseUrl + "/customer/getBuses")
  }
  getBusById(id:number):Observable<Bus>{

    return <Observable<Bus>>this.httpClient.get(this.baseUrl+"/getBus/"+id)
}
  public addBus(bus:Bus) :Observable<Bus>{
    return <Observable<Bus>>this.httpClient.post(this.baseUrl + "/addBus",bus)
  }
  deleteBusById(id:number):Observable<Bus>{

    return <Observable<Bus>>this.httpClient.delete(this.baseUrl+"/getBus/"+id)
}
updateBus(id:number,bus:Bus):Observable<Bus>{

    return <Observable<Bus>>this.httpClient.put(this.baseUrl+"/udateBus/"+id,bus)
}
}

