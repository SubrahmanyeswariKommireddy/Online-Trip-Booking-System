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
    return <Observable<Bus[]>>this.httpClient.get(this.baseUrl + "/admin/getBuses")
  }
}

