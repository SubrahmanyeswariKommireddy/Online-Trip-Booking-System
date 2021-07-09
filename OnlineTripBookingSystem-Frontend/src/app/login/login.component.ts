import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';
import { ToastrService } from 'ngx-toastr';

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

  roleData: any[] = ['ADMIN','CUSTOMER']

  email: string = '';
  password: string = '';
  userType: string = '';
  invalidLogin: boolean = false;
  response!: JwtResponse;
  isValidFormSubmitted: boolean = false;

  constructor(private router: Router,
    private loginservice: LoginService, private toastr: ToastrService) { }

  ngOnInit() {

  }

  checkLogin() {
    var userType = sessionStorage.getItem('userType');
  //   this.isValidFormSubmitted = false;
  // if (form1.valid) {
  //   this.isValidFormSubmitted = true;
  // } else {
  //   return;
  // }

    (this.loginservice.authenticate(this.email, this.password, this.userType).subscribe(
      data => {
        this.toastr.success('Login Successful');
        if (userType == "ADMIN") {
          this.router.navigate(['/admin'])
        }
        else if (userType == "CUSTOMER") {
          this.router.navigate([''])
        }
        this.invalidLogin = false
      },
      error => {
        // if (this.email == "") {
        //   this.toastr.warning('Login Failed: Email is required');
        // }
        // else if (this.password == "") {
        //   this.toastr.warning('Login Failed: Password is required');
        // }
        // else if (this.userType == "") {
        //   this.toastr.warning('Login Failed: Usertype is required');
        // }
        // else {
        //   this.toastr.error('Login Failed: Invalid Credentials');
        // }
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