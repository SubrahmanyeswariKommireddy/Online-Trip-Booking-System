import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import { HttpClientService } from './httpclient.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(){}
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    if (sessionStorage.getItem('email') && sessionStorage.getItem('userType') && sessionStorage.getItem('token')) {
        req = req.clone({
          setHeaders: {
            Authorization: sessionStorage.getItem('token')!
          }
        })
      }
  
      return next.handle(req);
}}