import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router: Router,
    private authService: LoginService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const userType = route.data.userType;
    if (this.authService.isUserLoggedIn()) {
      const currentUser = sessionStorage.getItem('userType');
      if (userType && userType.indexOf(currentUser) === -1) {
        this.router.navigate(['404']);
        return false;
      }
      return true;
    }

    // if (this.authService.isUserLoggedIn())
    //   return true;

    this.router.navigate(['login']);
    return false;

  }

}