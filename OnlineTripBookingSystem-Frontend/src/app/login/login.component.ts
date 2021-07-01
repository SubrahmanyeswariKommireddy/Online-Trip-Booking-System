import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

export class JwtResponse{

  jwtToken!:string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  email:string = '';
  password:string = '';
  userType:string = '';
  invalidLogin:boolean = false;
  response!:JwtResponse;
  loginForm!: FormGroup;

  constructor(private router: Router,
    private loginService: LoginService) { }

  ngOnInit() {
    
  }

  checkLogin() {
    (this.loginService.authenticate(this.email, this.password, this.userType).subscribe(
      data => {
        console.log(data)
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
      }
    )
    );
  }

  setValues(data:any){
    console.log("in set values",data)
    sessionStorage.setItem('email',this.email);
        sessionStorage.setItem('token',data.token);
      console.log('data set')
  }
}