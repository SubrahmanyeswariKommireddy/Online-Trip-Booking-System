import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { LoginService } from '../shared/login.service';

// export class JwtResponse{
//   jwtToken:string='';
// }
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // email:string = '';
  // password:string = '';
  // userType:string ='';
  // invalidLogin:boolean = false;
  // response!:JwtResponse

  // constructor(private loginService : LoginService, private router:Router) { }

  ngOnInit(): void {
  }
}