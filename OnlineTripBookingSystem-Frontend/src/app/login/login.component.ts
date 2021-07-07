import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

export class JwtResponse {
  jwtToken!: string;
  id!: number;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  userType: string = '';
  invalidLogin: boolean = false;
  response!: JwtResponse;

  constructor(private router: Router,
    private loginservice: LoginService) { }

  ngOnInit() {

  }

  checkLogin() {
    var userType = sessionStorage.getItem('userType');

    (this.loginservice.authenticate(this.email, this.password, this.userType).subscribe(
      data => {
        console.log(data)
        if (userType == "ADMIN") {
          this.router.navigate(['/admin'])

        }
        else if (userType == "CUSTOMER") {
          this.router.navigate([''])
        }
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
      }
    )
    );
  }

  setValues(data: any) {
    console.log("in set values", data)
    sessionStorage.setItem('email', this.email);
    sessionStorage.setItem('token', data.token);
    sessionStorage.setItem('userType', this.userType);
    sessionStorage.setItem('id', data.id)
    console.log('data set')
  }
}